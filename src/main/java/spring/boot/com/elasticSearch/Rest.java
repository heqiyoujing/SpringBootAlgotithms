package spring.boot.com.elasticSearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * @author: yiqq
 * @date: 2019/2/27
 * @description: ElasticSearch----JAVA客户端之RestClient操作详解
 * https://blog.csdn.net/u011781521/article/details/77853571
 */
public class Rest {

    private static RestClient restClient;



    public void getRestClient(){

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "changeme"));

        restClient = RestClient.builder(new HttpHost("localhost",9200,"http"))
                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    }
                }).build();

    }

    @Before
    public void getRest(){
        restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
    }



    /**
     * 查看api信息
     * @throws Exception
     */
    @Test
    public void CatApi() throws Exception{
        String method = "GET";
        String endpoint = "/_cat";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 创建索引
     * @throws Exception
     */
    @Test
    public void CreateIndex() throws Exception{
        String method = "PUT";
        String endpoint = "/test-index";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 创建文档
     * @throws Exception
     */
    @Test
    public void CreateDocument()throws Exception{

        String method = "PUT";
        String endpoint = "/test-index/test/1";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"kimchy\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"trying out Elasticsearch\"\n" +
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
        String endpoint = "/test-index/test/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /**
     * 查询所有数据
     * @throws Exception
     */
    @Test
    public void QueryAll() throws Exception {
        String method = "POST";//TODO
        String endpoint = "/test-index/test/_search";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint,Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 根据ID获取
     * @throws Exception
     */
    @Test
    public void QueryByField() throws Exception {
        String method = "POST";//TODO
        String endpoint = "/test-index/test/_search";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"user\": \"大美女\"\n" +
                "    }\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint,Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 更新数据
     * @throws Exception
     */
    @Test
    public void UpdateByScript() throws Exception {
        String method = "POST";
        String endpoint = "/test-index/test/1/_update";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"doc\": {\n" +
                "    \"user\":\"大美女\"\n" +
                "	}\n" +
                "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint,Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    @Test
    public void GeoBoundingBox() throws IOException {
        String method = "POST";
        String endpoint = "/attractions/restaurant/_search";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  },\n" +
                "  \"post_filter\": {\n" +
                "    \"geo_bounding_box\": {\n" +
                "      \"location\": {\n" +
                "        \"top_left\": {\n" +
                "          \"lat\": 39.990481,\n" +
                "          \"lon\": 116.277144\n" +
                "        },\n" +
                "        \"bottom_right\": {\n" +
                "          \"lat\": 39.927323,\n" +
                "          \"lon\": 116.405638\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
