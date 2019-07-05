package spring.boot.com.elasticSearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;

import java.util.Collections;

/**
 * @author: yiqq
 * @date: 2019/2/28
 * @description:
 */
public class UpdateElasticAPI {
    private static RestClient restClient;

    static {
        restClient=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
    }

    /**
     * 创建文档
     * @throws Exception
     */
    @Test
    public void CreateDocument()throws Exception{

        String method = "PUT";
        String endpoint = "/update_index/test/1";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"counter\" : 1,\n" +
                        "    \"tags\" : [\"red\"]\n" +
                        "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 获取文档
     * @throws Exception
     */
    @Test
    public void getDocument()throws Exception{
        String method = "GET";
        String endpoint = "/update_index/test/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 更新文档，给counter字段加4
     * @throws Exception
     */
    @Test
    public void UpdateDocument()throws Exception{

        String method = "POST";
        String endpoint = "/update_index/test/1/_update";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"script\" : {\n" +
                        "        \"source\": \"ctx._source.counter += params.count\",\n" +
                        "        \"lang\": \"painless\",\n" +
                        "        \"params\" : {\n" +
                        "            \"count\" : 4\n" +
                        "        }\n" +
                        "    }\n" +
                        "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 部分文档更新增加字段(不存在name字段)，存在则覆盖
     * @throws Exception
     */
    @Test
    public void SomeUpdateDocument()throws Exception{

        String method = "POST";
        String endpoint = "/update_index/test/1/_update";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"doc\" : {\n" +
                        "        \"user\" : \"kimchy\"\n" +
                        "    }\n" +
                        "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 按查询API更新
     */


}
