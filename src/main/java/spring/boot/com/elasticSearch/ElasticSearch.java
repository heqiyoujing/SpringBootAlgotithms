package spring.boot.com.elasticSearch;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2019/2/25
 * @description:
 * https://blog.csdn.net/HoloLens/article/details/79594583
 */
public class ElasticSearch {

//    private Logger logger = LoggerFactory.getLogger(ElasticSearch.class);


    private static RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();

    @Test
    public void GetJSON() throws IOException {
//        logger.info("begin!!!!!");
        Response response = restClient.performRequest("GET", "/posts/doc/1");
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void PutJSON() throws IOException {
        Map<String, String> map = Collections.singletonMap("pretty", "true");//只能添加一个元素  添加多个时编译不报错，但是运行报错
        Map<String, String> params = Collections.emptyMap();
        String json = "{  \"user\":\"fendo\",\"postDate\":\"2013-01-30\",\"message\":\"Hello World\"}";
        HttpEntity entity = new NStringEntity(json, ContentType.APPLICATION_JSON);// org.apache.http.HttpEntity 为了让Elasticsearch 能够解析,需要设置ContentType。
        Response response = restClient.performRequest("PUT", "/posts/doc/1", params, entity);
        System.out.println(EntityUtils.toString(response.getEntity()));

        //获取响应
        RequestLine requestLine = response.getRequestLine(); //请求信息
        System.out.println(requestLine);
        HttpHost host = response.getHost(); //返回response host信息
        System.out.println(host);
        int statusCode = response.getStatusLine().getStatusCode(); //返回状态行，获取状态码
        System.out.println(statusCode);
        Header[] headers = response.getHeaders(); //response headers ，也可以通过名字获取 `getHeader(String)`
        for (int i=0;i<headers.length;i++) {
            System.out.println(headers[i]);
        }
        String responseBody = EntityUtils.toString(response.getEntity()); //response org.apache.http.HttpEntity 对象
        System.out.println(responseBody);
    }




}
