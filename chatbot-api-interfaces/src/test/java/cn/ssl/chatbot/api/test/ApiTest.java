package cn.ssl.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get =new HttpGet("https://api.zsxq.com/v2/groups/48884218141548/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=C82FFE01-572F-2ED3-7BF3-2061264ECA98_096500B0AA98BDA6; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184522128218812%22%2C%22first_id%22%3A%22189e93c84d9455-04bad1ff4c33f9-7c54647e-1821369-189e93c84da160a%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5ZTkzYzg0ZDk0NTUtMDRiYWQxZmY0YzMzZjktN2M1NDY0N2UtMTgyMTM2OS0xODllOTNjODRkYTE2MGEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQ1MjIxMjgyMTg4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184522128218812%22%7D%2C%22%24device_id%22%3A%22189e93c84d9455-04bad1ff4c33f9-7c54647e-1821369-189e93c84da160a%22%7D; abtest_env=product; zsxqsessionid=fd732bbe690971396f5c67391bded805");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/811822521458422/answer");
        post.addHeader("cookie","zsxq_access_token=C82FFE01-572F-2ED3-7BF3-2061264ECA98_096500B0AA98BDA6; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184522128218812%22%2C%22first_id%22%3A%22189e93c84d9455-04bad1ff4c33f9-7c54647e-1821369-189e93c84da160a%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5ZTkzYzg0ZDk0NTUtMDRiYWQxZmY0YzMzZjktN2M1NDY0N2UtMTgyMTM2OS0xODllOTNjODRkYTE2MGEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQ1MjIxMjgyMTg4MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184522128218812%22%7D%2C%22%24device_id%22%3A%22189e93c84d9455-04bad1ff4c33f9-7c54647e-1821369-189e93c84da160a%22%7D; abtest_env=product; zsxqsessionid=fd732bbe690971396f5c67391bded805");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                " \"req_data\": {\n" +
                "  \"text\": \"我不会! \\n\",\n" +
                "  \"image_ids\": [],\n" +
                "  \"silenced\": true\n" +
                " }\n" + "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


}
