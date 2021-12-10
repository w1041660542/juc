package com.why;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * @program: juc
 * @author: WHY
 * @create: 2021-10-22 15:05
 **/
public class Test {


    public static void main(String[] args) throws UnsupportedEncodingException {
        HashMap map = new HashMap();

        String data = "quanshi=on&starttime=&endtime=&jobaddress=&jobname=";
        for (int i = 0; i < data.split("&").length; i++) {

            if (data.split("&")[i].split("=").length >= 2) {

                map.put(data.split("&")[i].split("=")[0], data.split("&")[i].split("=")[1]);

            } else {
                map.put(data.split("&")[i].split("=")[0], "");
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++0="+data.split("&")[0]);
        String s = URLDecoder.decode("%2525E9%252598%2525BF%2525E4%2525B8%252589","utf-8");
        System.out.println(URLDecoder.decode(s,"utf-8"));

    }
}

