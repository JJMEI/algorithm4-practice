package cn.meijunjie.spider.common;


import cn.meijunjie.spider.constant.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtils {

    private final static String GET_METHOD = "GET";
    private final static String POST_METHOD = "POST";

    public static String sendGet(String url, Map<String,String> headers, Map<String,String> params)
    {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        StringBuilder reqUrl = new StringBuilder(url);
        String result = "";

        //拼接访问地址
        if(params != null && params.size() > 0)
        {
            reqUrl.append("?");
            //遍历参数键值对,进行
            for(Map.Entry<String,String> param : params.entrySet())
            {
                reqUrl.append(param.getKey() + "=" + param.getValue() + "&");
            }
            //过滤吊最后一个&字符
            url = reqUrl.substring(0, reqUrl.length() - 1);
        }

        log.debug("[url: " + url+" ,method: " + GET_METHOD + "]");

        //创建HttpGet请求对象
        HttpGet httpGet = new HttpGet(url);

        //设置头部，进行浏览器伪装
        log.debug("Header \n");
        if(headers != null && headers.size() > 0)
        {
            for(Map.Entry<String,String> header : headers.entrySet())
            {
                httpGet.addHeader(header.getKey(), header.getValue());
                log.debug(header.getKey() + " : " + header.getValue());
            }
        }

        //响应实例CloseableHttpResponse
        CloseableHttpResponse httpResponse = null;
        //设置响应
        try {

            httpResponse = httpClient.execute(httpGet);

            //判断是否是否成功响应,通过获取状态行进而获取状态码 如果状态码等于200 则响应成功
            if(httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200)
            {
                //HttpEntity 可以理解为响应中的实体，即响应的主要内容
                HttpEntity httpEntity = httpResponse.getEntity();
                //获取响应的内容，指定字符串的编码格式,这些都是需要持久化
                result = EntityUtils.toString(httpEntity, SysConstant.DEFAULT_CHARSET);
            }
        } catch (IOException e) {
            log.error("网络请求错误,请检查原因...");
            e.printStackTrace();
        }finally {
            try{
                if(httpResponse != null)
                    httpResponse.close();
                httpClient.close();
            }catch (IOException e)
            {
                log.error("网络关闭错误，请检查网络...");
            }
        }
        return result;
    }

    public static String sendPost(String url, Map<String,String> headers, Map<String,String> params)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        HttpPost httpPost = new HttpPost(url);

        //获取参数
        if(params != null && params.size() > 0)
        {
            List<NameValuePair> paramList = new ArrayList<>();

            for(Map.Entry<String,String> param : params.entrySet())
                paramList.add(new BasicNameValuePair(param.getKey(),param.getValue()));

            log.debug("[url: " + url + ",method: " + POST_METHOD + "]");

            //模拟表单提交
            try
            {
                UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(paramList,SysConstant.DEFAULT_CHARSET);

                //设置请求体
                httpPost.setEntity(encodedFormEntity);

            }catch (UnsupportedEncodingException e)
            {
                log.error("不支持的编码格式....");
            }
        }

        return null;
    }
}
