package com.coin.shadow.kits;


import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 11:02
 * @description：Http请求工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class HttpKits {
    private HttpKits(){
    }

    public static String get(String host, String params){
        byte[] bytes = http(host, params, "GET");
        return ByteKits.byteArrayToString(bytes);
    }

    public static String post(String host, String params){
        byte[] bytes = http(host, params, "POST");
        return ByteKits.byteArrayToString(bytes);
    }

    public static String get(String host, Map<String, String> params){
        byte[] bytes = http(host, params, "GET");
        return ByteKits.byteArrayToString(bytes);
    }

    public static String post(String host, Map<String, String> params){
        byte[] bytes = http(host, params, "POST");
        return ByteKits.byteArrayToString(bytes);
    }

    public static byte[] http(String host, Map<String, String> params, String method){
        return http(host, UrlKits.mapToUrl(params),method);
    }

    /***
     * 这个为后面自己封装网络做一个准备
     * @param host
     * @param params
     * @param method
     * @return
     */
    private static byte[] http(String host, String params, String method){
        byte[] buf = new byte[0];
        if (StringKits.isBlank(host)){
            return buf;
        }
        if (!host.substring(host.length() - 1).equals("/")){
            host += "/";
        }
        // GET 方法走这个
        if (method.equalsIgnoreCase("GET")){
            boolean flag = params.startsWith("?");
            if (!flag){
                host += "?";
                host += params;
            }
        }
        URL url = null;
        HttpURLConnection connection = null;
        try {
            // 打开一个链接
            connection = openConnection(new URL(host));
            // 为链接设置属性
            setPropertyForConnection(connection, method);
            // 链接
            connection.connect();

            if (StringKits.isNotBlank(params) && method.equalsIgnoreCase("POST")){
                // 向外写流
                OutputStream output = connection.getOutputStream();
                // TODO 如果报文太长这里可能会有问题
                output.write(params.getBytes());
                output.flush();
                output.close();
            }
            // 响应
            InputStream input = null;
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                input = connection.getErrorStream();
            }else {
                input = connection.getInputStream();
            }
            // TODO 如果是下载文件需要特殊处理
            buf = IoKits.read(input, 1024 * 4);
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    private static HttpURLConnection openConnection(URL url){
        HttpURLConnection connection = null;
        try {
            String protocol = url.getProtocol().toLowerCase();
            if (protocol.equals("http")){
                connection = (HttpURLConnection)url.openConnection();
            }else if (protocol.equals("https")){
                HttpsURLConnection target = (HttpsURLConnection)url.openConnection();
                // 绕过HTTPS
                target.setHostnameVerifier((hostname, session)-> true);
                connection = target;
            }else {
                connection = (HttpURLConnection)url.openConnection();
            }
            connection.setConnectTimeout(DEFAULT_CONNECT_TIME_OUT);
            connection.setReadTimeout(DEFAULT_READ_TIME_OUT);
            connection.setDoInput(true);
            connection.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //
    public static void setPropertyForConnection(HttpURLConnection connection, String method) throws ProtocolException {
        connection.setRequestMethod(method);
        // 禁用缓存
        connection.setUseCaches(false);
        // 系统自动处理重定向
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");//设置参数类型是urlencoded格式
        connection.setRequestProperty("Connection", "Keep-Alive");
    }

    private static int DEFAULT_CONNECT_TIME_OUT = 30 * 1000;
    private static int DEFAULT_READ_TIME_OUT    = 30 * 1000;
}
