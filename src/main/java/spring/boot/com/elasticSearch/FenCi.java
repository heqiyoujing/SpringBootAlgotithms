package spring.boot.com.elasticSearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;
import spring.boot.com.elasticSearch.model.UserModel;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2019/2/28
 * @description: 分词
 */
public class FenCi {

    private static RestClient client;

    static {
        client=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
    }

    /**
     * 分词
     * @throws IOException
     */
    @Test
    public void analyze() throws IOException {
        Map<String, String> params = Collections.emptyMap();
        Map<String, Object> map = new HashMap<>();
        map.put("text", "　如果运行这段代码会发现先输出“abc”");
        map.put("analyzer", "ik_max_word");
        String json = Tool.map2Json(map);//
        HttpEntity entity = new NStringEntity(json, ContentType.APPLICATION_JSON);
        Response response = client.performRequest("GET", "/_analyze", params, entity);
        String responseBody = EntityUtils.toString(response.getEntity());
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.toString().substring(0,builder.toString().length()-1));
    }


}
