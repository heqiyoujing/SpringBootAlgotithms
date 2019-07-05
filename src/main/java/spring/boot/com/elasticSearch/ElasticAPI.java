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
 * @date: 2019/2/27
 * @description:
 */
public class ElasticAPI {
    private static RestClient restClient;

    static {
        restClient=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
    }

    /***
     * Index API
     * @throws IOException
     */
    @Test
    public void IndexAPI() throws IOException {
        String method = "PUT";
        String endpoint = "twitter/_doc/1";
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
     * 获取
     */
    @Test
    public void GetIndexAPI() throws IOException {
        String method = "GET";
        String endpoint = "twitter/_doc/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * API还允许使用以下方式检查文档是否存在 HEAD：
     * 获取
     */
    @Test
    public void HeadIndexAPI() throws IOException {
        String method = "HEAD";
        String endpoint = "twitter/_doc/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(response.getEntity());
    }

    /**
     * ××××××
     * @throws IOException
     */
    public void OperationType() throws IOException {
        String method = "PUT";
        String endpoint = "twitter/docs/3";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"ssss\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"Elasticsearch\"\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * ××××××
     * 获取
     */
    @Test
    public void GetOperationType() throws IOException {
        String method = "GET";
        String endpoint ="twitter/docs/3";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /**
     * POST 产生一个随机id
     * @throws IOException
     */
    @Test
    public void IndexAPIPost() throws IOException {
        String method = "POST";
        String endpoint = "twitter/_doc";
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
     * 获取 根据随机id
     * @throws IOException
     */
    @Test
    public void GetIndexAPIPost() throws IOException {
        String method = "GET";
        String endpoint = "twitter/_doc/EWq-LmkBioM-ebzVc1rq";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     *Stored Fields
     *get操作允许指定将通过传递stored_fields参数返回的一组存储字段。如果未存储请求的字段，则将忽略它们。
     * 首先得添加相应映射
     */

    @Test
    public void Stored() throws IOException {
        String method = "PUT";
        String endpoint = "twitters";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "   \"mappings\": {\n" +
                        "      \"_doc\": {\n" +
                        "         \"properties\": {\n" +
                        "            \"counter\": {\n" +
                        "               \"type\": \"integer\",\n" +
                        "               \"store\": false\n" +
                        "            },\n" +
                        "            \"tags\": {\n" +
                        "               \"type\": \"keyword\",\n" +
                        "               \"store\": true\n" +
                        "            }\n" +
                        "         }\n" +
                        "      }\n" +
                        "   }\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    @Test
    public void putS() throws IOException {
        String method = "PUT";
        String endpoint = "twitters/_doc/1";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"counter\" : 1,\n" +
                        "    \"tags\" : [\"red\"]\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void getS() throws IOException {
        String method = "GET";
        String endpoint = "twitters/_doc/1?stored_fields=tags,counter";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
        /**
         * {"_index":"twitters","_type":"_doc","_id":"1","_version":3,"found":true,"fields":{"tags":["red"]}}
         由于该counter字段未存储，因此get请求在尝试获取时只是忽略它stored_fields。map映射时，counter的store属性为false
         */

    }

    @Test
    public void putS2() throws IOException {
        String method = "PUT";
        String endpoint = "twitters/_doc/2?routing=user11";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"counter\" : 1,\n" +
                        "    \"tags\" : [\"white\"]\n" +
                        "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void getS2() throws IOException {
        String method = "GET";
        String endpoint = "twitters/_doc/2?routing=user11&stored_fields=tags,counter";
        /**
         * {"_index":"twitters","_type":"_doc","_id":"2","_version":2,"_routing":"user11","found":true,"fields":{"tags":["white"]}}
         * 使用控制路由的能力进行索引时，为了获取文档，还应提供路由值。
         */
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void getTest() throws IOException {
        String method = "GET";
        String endpoint = "twitters/_doc/1/_source";
        /**
         * 只获取_source文档的字段，而不包含任何其他内容
         {
         "counter" : 1,
         "tags" : ["red"]
         }
         */
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
