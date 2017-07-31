package cn.meijunjie.httpclient;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

    //如何高效地通过Http连接输出Http实体内容
    // HttpClient提供了 常见的几个操作类
    //StringEntity ByteArrayEntity InputStreamEntity FileEntity

    //HTML表单
    //HttpClient模拟表单进行登录

    @Test
    public void testHTMLPost() throws IOException {
        List<NameValuePair> formPair = new ArrayList<NameValuePair>(); //参数容器
        formPair.add(new BasicNameValuePair("param1","value1"));
        formPair.add(new BasicNameValuePair("param2","value2"));

        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formPair, Consts.UTF_8);

        HttpPost httpPost = new HttpPost("http://www.yeetrack.com/handler.do");
        httpPost.setEntity(encodedFormEntity);

        System.out.println(encodedFormEntity.getContent().toString());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try
        {
            httpClient.execute(httpPost);
        }catch(Exception e)
        {
            System.out.println("模拟登陆失败。。。");
        }


    }

    // Response Handlers， 处理http响应的方法就是使用ResponseHandler接口，该接口中handleResponse(HttpResponse response)

//    public  void testResponseHandler()
//    {
//        final CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//
//        final ResponseHandler<MyJsonObject> responseHandler = new ResponseHandler<MyJsonObject>() {
//            public MyJsonObject handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
//
//                StatusLine statusLine = httpResponse.getStatusLine(); // 获取状态码
//                HttpEntity entity = httpResponse.getEntity();
//
//                //  完善的检查机制，验证状态码
//                if (statusLine.getStatusCode() >= 300)
//                {
//                    throw new HttpResponseException(statusLine.getStatusCode(),statusLine.getReasonPhrase());
//                }
//
//                //验证实体是否为空
//                if(entity == null)
//                {
//                    throw new ClientProtocolException("Response contains no content");
//                }
//
//
//
//
//
//
//
//
//                return null;
//            }
//        };
//    }


    @Test
    public void testHttpConnectionMannager() throws  Exception
    {
        HttpClientContext httpClientContext = HttpClientContext.create();
        HttpClientConnectionManager httpClientConnectionManager =
                new BasicHttpClientConnectionManager();
        HttpRoute httpRoute =
                new HttpRoute(new HttpHost("www.yeetrack.com",80));

        ConnectionRequest connectionRequest =
                httpClientConnectionManager.requestConnection(httpRoute,null);

        HttpClientConnection clientConnection = connectionRequest.get(10, TimeUnit.SECONDS);
        try
        {
            if(!clientConnection.isOpen())
            {
                httpClientConnectionManager.connect(clientConnection,httpRoute,1000,httpClientContext);
                httpClientConnectionManager.routeComplete(clientConnection,httpRoute,httpClientContext);
                System.out.println("............");
            }
        }finally {
            httpClientConnectionManager.releaseConnection(clientConnection,null,1,TimeUnit.MINUTES);
        }
    }

    @Test
    public void testPoolHttpConnectionMannager() throws  Exception{
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
//
//        HttpHost localhost = new HttpHost("www.yeetrack.com", 80);
//
//        cm.setMaxPerRoute(new HttpRoute(localhost), 80);
//
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        String[] urisToGet = {"http://www.le.com", "http://www.baidu.com", "http://www.google.com","http://www.3535dy.com/vod-type-id-3-wd--letter--year-0-area--order-hits-p-1.html","https://item.jd.com/2847866.html#comment"};

        GetThread[] threads = new GetThread[urisToGet.length];

        for (int i = 0; i < threads.length; i++)
        {
            HttpGet httpGet = new HttpGet(urisToGet[i]);
            threads[i] = new GetThread(httpClient,httpGet);
        }

        for (int j = 0; j < threads.length; j++)
        {
            threads[j].start();
            Thread.sleep(1000);
        }


    }

   class GetThread extends  Thread
    {
        private final CloseableHttpClient httpClient;
        private final HttpContext httpContext;
        private final  HttpGet httpGet;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpGet)
        {
            this.httpClient = httpClient;
            this.httpContext = HttpClientContext.create();
            this.httpGet = httpGet;
        }

        @Override
        public void run()
        {
            try
            {
                CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

                try{
                    HttpEntity httpEntity = httpResponse.getEntity();
                    System.out.println("we get it");
                    if(httpEntity != null)
                    {
                        InputStream inputStream = httpEntity.getContent();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                        String line = new String();
                        while((line = bufferedReader.readLine()) != null)
                        {
                            System.out.println(Thread.currentThread() + " 线程正在输出 "+line);
                        }
                    }
                }finally {
                    httpResponse.close();
                }
            }catch (ClientProtocolException e)
            {
                e.printStackTrace();
                System.out.println("线程池发生异常。。。");
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
