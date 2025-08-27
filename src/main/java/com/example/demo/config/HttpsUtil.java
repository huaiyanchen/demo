package com.example.demo.config;

import cn.hutool.http.ssl.TrustAnyHostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsUtil {

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    public  static String postHttps(String url, String content) throws Exception {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[]{new TrustAnyTrustManager()},
                new java.security.SecureRandom());

        URL console = new URL(null,url,new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setDoOutput(true);
        conn.connect();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.write(content.getBytes(Charset.defaultCharset()));
        // 刷新、关闭
        out.flush();
        out.close();
        InputStream is = conn.getInputStream();
        System.out.println(url+"调用服务："+url+"，调用参数："+content);
        String result = "";
        if (is != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            byte[] array = outStream.toByteArray();
            result = new String(array, StandardCharsets.UTF_8);
            System.out.println(url+"调用服务："+url+"，返回值："+result);
            return result;

        }
        System.out.println(url+"调用服务："+url+"，返回值："+result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        String s = HttpsConnection.doPost("https://localhost:8080/test", "asdasd");
//         String s = HttpsConnection.doGet("https://localhost:8080/test?name=asd");
        System.out.println(s);
    }

}
