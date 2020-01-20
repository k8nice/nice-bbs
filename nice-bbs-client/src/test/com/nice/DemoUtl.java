package com.nice;

import java.util.Random;

public class DemoUtl {

    public static int index = 0;

    public static void main(String[] args) throws InterruptedException {
        try {
            for (int i = 0; i < 100000; i++) {
                Thread.sleep((new Random()).nextInt(200) + 100);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int j = 0; j < 100000; j++) {
                            try {
                                Thread.sleep((new Random()).nextInt(3200) + 1500);
                                HttpUtilTest tt = new HttpUtilTest();
                                tt.sendPost(
                                        "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=nice%E5%AE%81%E6%B5%B7%E5%8D%9A&oq=%25E7%25A8%258B%25E5%25BA%258F%25E5%2591%2598%25E4%25B8%259A%25E5%258A%25A1%25E5%2592%258C%25E6%258A%2580%25E6%259C%25AF%25E5%2593%25AA%25E4%25B8%25AA%25E9%2587%258D%25E8%25A6%2581&rsv_pq=a190953901daab5f&rsv_t=3579ABY4uu1gKGqR9Vk1Ttn%2FRmy4VO9G7BuaDy9a3k6VBDNFCijTZCApWNY&rqlang=cn&rsv_enter=0&rsv_dl=tb&rsv_sug3=16&rsv_sug1=11&rsv_sug7=100&inputT=5729&rsv_sug4=7334&rsv_sug=1",
                                        Thread.currentThread().getName());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
