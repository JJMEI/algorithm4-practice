package cn.meijunjie.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClientTest {

    public static HttpClient httpClient = HttpClients.createDefault();
    public static String url = "http://www.yeetrack.com";


    @Test
    public  void testHttpClient() throws Exception
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        String[]  reponseResult = httpResponse.toString().split(",");
        for(String  s : reponseResult)
            System.out.println(s);


        System.out.println(httpResponse.getProtocolVersion());
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        System.out.println(httpResponse.getStatusLine().toString());
        System.out.println(httpResponse.getAllHeaders().toString());
    }

    @Test
    public void testURIBuilder() throws URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .setParameter("q","httpclient")
                .setParameter("btnG","Google Search")
                .setParameter("aq","f")
                .setParameter("oq","")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());
    }

    @Test
    public void testHttpEntity() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        try
        {
            //HttpEntity的write的writeTo(OutputStream)方法，当Http实体被写入到
            //OutputStream后，也要确保释放了系统资源
            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpEntity != null)
            {
                InputStream inputStream = httpEntity.getContent(); //从消息实体中获取 字节流

                try
                {
                    //将字节流包装成缓存字符流
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String s = " ";
                    while(null != (s = bufferedReader.readLine()))
                    {
                        System.out.println(s);
                    }
                }finally {
                    inputStream.close();  // 通过消耗Http实体内容来保持相关的http连接
                }
            }
        }finally {
            httpResponse.close(); //http响应一旦关闭就会立刻丢弃Http连接
        }
    }

    @Test
    public void testHttpEntitySmallPart() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        try
        {
            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpEntity != null)
            {
                InputStream inputStream = httpEntity.getContent();
                int byteOne = inputStream.read();
                int byteTwo = inputStream.read();

                System.out.println((char) byteOne + "" + (char)byteTwo);
            }
        }finally {

            httpResponse.close();
        }
    }

    @Test
    public void testHttpEntityUtils() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        try
        {
            HttpEntity httpEntity = httpResponse.getEntity();

            if(httpEntity != null)
            {
                long len = httpEntity.getContentLength(); //获取响应的长度
                if(len != -1 && len < 2048)
                {
                    System.out.println(EntityUtils.toString(httpEntity));
                }else
                {
                    //以流的形式进行读取,EntityUtils可以采用String类型
                    InputStream inputStream = httpEntity.getContent(); //从消息实体中获取 字节流
                    try
                    {
                        //将字节流包装成缓存字符流
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String s = " ";
                        while(null != (s = bufferedReader.readLine()))
                        {
                            System.out.println(s);
                        }
                    }finally {
                        inputStream.close();  // 通过消耗Http实体内容来保持相关的http连接
                    }
                }

            }
        }finally {
            httpResponse.close();
        }
    }

    //将Http实体的内容缓存到内存中或者磁盘里，有助于重复读取实体中的内容，最简单的方法就是将
    //HttpEntity 转换成BufferedHttpEntity

    @Test
    public void testBufferefHttpEntity() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        try
        {
            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpEntity != null)
            {
                BufferedHttpEntity bufferedHttpEntity =
                        new BufferedHttpEntity(httpEntity);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedHttpEntity.getContent()));
                String regex = "[^\\u4E00-\\u9FA5]";
                Pattern pattern = Pattern.compile(regex);

                String line = " ";

                while((line = bufferedReader.readLine()) != null)
                {
                    Matcher matcher = pattern.matcher(line);
                    System.out.println(matcher.replaceAll(""));
                }
            }
        }finally {

            httpResponse.close();
        }
    }

}
