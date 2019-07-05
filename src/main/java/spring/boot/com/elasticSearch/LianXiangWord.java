package spring.boot.com.elasticSearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2019/2/28
 * @description: 联想词
 */
public class LianXiangWord {
    private static RestClient client;

    static {
        client=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
    }

    public static void main(String[] args) throws Exception {
//        LianXiangWorld("手机苹果",12);
//        SearchLianXiangWorld("手");
        SearchLianXiangWorld("手");
    }

    /**
     * 插入联想词
     * @param content
     * @param weight
     * @throws Exception
     */
    public static   void LianXiangWorld(String content, int weight) throws Exception {
        Map<String, String> params = Collections.emptyMap();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map.put("input", content);
        map.put("weight", weight);
        map2.put("content", map);
        String jsonString = Tool.map2Json(map2);
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response response = client.performRequest("POST", "/suggester_sku/doc", params, entity);
        System.out.println(response);
    }

    /**
     * 查看联想词
     * @throws Exception
     */
    @Test
    public void QueryLianXiangWorld() throws Exception {
        String method = "POST";
        String endpoint = "/suggester_sku/_search/";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);
        Response response = client.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 搜索联想词
     */
    public static void SearchLianXiangWorld(String text) throws IOException {
        Map<String, String> params = Collections.emptyMap();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map3.put("field", "content");
        map3.put("skip_duplicates", true);
        map3.put("field", 10);
        map2.put("prefix", text);
        map2.put("completion", map3);
        map1.put("my-suggest", map2);
        map.put("suggest", map1);
        String jsonString = Tool.map2Json(map);
        System.out.println(jsonString);
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response response = client.performRequest("GET", "/suggester_sku/doc/_search", params, entity);
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
    }


    /**
     * 初始化completion
     * @throws Exception
     */
    @Test
    public void CreateDocument()throws Exception{

        String method = "POST";
        String endpoint = "/suggester_sku/doc/_mapping";
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map.put("type", "completion");
        map2.put("content", map);
        map3.put("properties", map2);
        String jsonString = Tool.map2Json(map3);
        HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
        Response response = client.performRequest(method,endpoint,  Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
