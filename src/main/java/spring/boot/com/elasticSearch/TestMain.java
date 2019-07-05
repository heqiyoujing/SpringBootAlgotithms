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
public class TestMain {
    private static RestClient restClient;

    static {
        restClient=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
    }

    /**
     * 查询所有数据
     * @throws Exception
     */
    @Test
    public void QueryAllSkuId() throws Exception {
        String method = "POST";
        String endpoint = "/sku/doc/_search";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 查询匹配，message为条件,新增的时候必须包含该字段
     * @throws IOException
     */
    @Test
    public void searchSkuId () throws IOException {

        /**
         * 添加的数据格式
         {"skuId":"111111111","content":"对于非基本类型，也就是常说的引用数据类型"}
         */

        String method = "POST";
        String endpoint = "/sku/doc/_search";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "  \"query\": { \n" +
                        "    \"match\": {\n" +
                        "      \"content\": \"基本类型\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /**
     * 查询所有数据
     * @throws Exception
     */
    @Test
    public void QueryAll() throws Exception {
        String method = "POST";
        String endpoint = "/delete-index/_search/";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 查询匹配，message为条件,新增的时候必须包含该字段
     * @throws IOException
     */
    @Test
    public void search () throws IOException {

        /**
         * 添加的数据格式
         {\n" +
         "    \"user\" : \"kimchy\",\n" +
         "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
         "    \"message\" : \"trying out Elasticsearch\"\n" +
         "}
         */

        String method = "POST";
        String endpoint = "/delete-index/_search/";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "  \"query\": { \n" +
                        "    \"match\": {\n" +
                        "      \"message\": \"out\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
