package com.nice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class HttpUtilTest {

    private int index = 0;

    public static void main(String[] args) {
        for (int i = 0; i<=99999; i++) {
            HttpUtilTest httpUtilTest = new HttpUtilTest();
            httpUtilTest.sendPost("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=nice%E5%AE%81%E6%B5%B7%E5%8D%9A&rsv_pq=d39c3a43009e998a&rsv_t=b7384u3mxTcbK4pmCbL1OmVWXzJLPGs5CWtmkKd3DCj9lXAUnGmo%2FNeJfbg&rqlang=cn&rsv_enter=0&rsv_dl=tb&rsv_sug3=18&rsv_sug1=13&rsv_sug7=100&inputT=7083&rsv_sug4=7083", null);
        }
    }

    public String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 随机生成ip
            String ip = randIP();
            conn.setRequestProperty("X-Forwarded-For", ip);
            conn.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
            conn.setRequestProperty("HTTP_CLIENT_IP", ip);
            conn.setRequestProperty("REMOTE_ADDR", ip);
            conn.setRequestProperty("Host", "");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Length", "17");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Origin", "ORIGIN");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Referer", "REFERER");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,pt;q=0.2");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            synchronized (this) {
                DemoUtl.index = DemoUtl.index + 1;
            }
            System.out.println("第" + DemoUtl.index + "次访问； -->  || 当前线程：" + param + "  || 请求成功！ || 模拟ip: " + ip
                    + " || 返回结果： " + result.toString().hashCode());
        } catch (Exception e) {
            // System.out.println("发送 POST 请求出现异常！" + e);
            // e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String randIP() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1);
    }
}

