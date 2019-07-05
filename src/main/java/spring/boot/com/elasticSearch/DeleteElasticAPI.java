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

/**
 * @author: yiqq
 * @date: 2019/2/28
 * @description:
 */
public class DeleteElasticAPI {
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
        String endpoint = "/delete-index/test/2";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"大美女\",\n" +
                        "    \"post_date\" : \"2009-02-15T14:12:12\",\n" +
                        "    \"message\" : \"trying begin Elasticsearch\"\n" +
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
        String endpoint = "/delete-index/test/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 删除文档
     * @throws IOException
     */
    @Test
    public void delete () throws IOException {
        String method = "DELETE";
        String endpoint = "/delete-index/test/1";
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap());
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 删除文档,按查询api
     * @throws IOException
     */
    @Test
    public void deleteBySearch () throws IOException {
        String method = "POST";
        String endpoint = "/delete-index/_delete_by_query";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "  \"query\": { \n" +
                        "    \"match\": {\n" +
                        "      \"message\": \"begin\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 查询匹配，message为条件
     * @throws IOException
     */
    @Test
    public void search () throws IOException {
        String method = "POST";
        String endpoint = "/delete-index/_search/";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "  \"query\": { \n" +
                        "    \"match\": {\n" +
                        "      \"message\": \"trying begin Elasticsearch\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
