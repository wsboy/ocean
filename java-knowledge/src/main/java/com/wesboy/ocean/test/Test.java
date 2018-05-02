package com.wesboy.ocean.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws Exception {
        byte a = 127;
        byte b = 127;
        // b = a + b; 编译出错，需要的是byte找到的为int
        b += a; // 结果为-2


        //System.out.println(b);
        //System.out.println(3*0.1 == 0.3);

//        LRUCache<String, String> cache = new LRUCache<>(16);
//
//        cache.put("a", "1");
//        cache.put("b", "2");
//        cache.put("c", "3");
//        cache.put("d", "4");
//        cache.put("e", "5");
//        cache.put("f", "6");
//        cache.put("g", "7");
//        cache.put("h", "8");
//        cache.put("i", "9");
//        cache.put("j", "10");
//        cache.put("k", "11");
//        cache.put("l", "12");
//        cache.put("m", "13");
//        cache.put("n", "14");
//        cache.put("o", "15");
//        cache.put("p", "16");
//        cache.put("q", "17");
        //count();
        //System.out.println(stringToInt(" 456 789"));
        swap();

    }

    public static int count() throws IOException {
        //读入文本(字符)，用FileReader->BufferedReader
        //读入输入(字节)，用FileInputStream->InputStreamReader->BufferedReader
        String path = Test.class.getResource("/1.txt").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            sb.append(str);
        }
        Pattern p = Pattern.compile("mobnet");
        Matcher m = p.matcher(sb);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static int stringToInt(String str) {
        int index = 0;
        int sign = 1;
        int digit = 0;
        int total = 0;
        char ch;

        // 1.1判断字符串是否为空。
        if (str.length() == 0) {
            return 0;
        }

        // 1.2判断字符串中是否含有空格，如果有就跳过。
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }

        // 2.判断字符串为正还是负。
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index) == '+')
                sign = 1;
            else {
                sign = -1;
            }
            index++;
        }

        // 3.进行处理。
        while (index < str.length()) {
            ch = str.charAt(index);
            if (ch < '0' || ch > '9')
                break;
            digit = ch - '0';

            //校验后续 total = total * 10 + digit; 操作之后数字的绝对值的大小，如果超出 MAX_VALUE，则根据负号标志位进行相应的赋值。
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total * 10 + digit;
            index++;

        }
        return sign * total;
    }

    public static void swap() {
        int a = 5;
        int b = 8;
        System.out.println("before:a=" + a + ", b=" + b);
//        a = a + b;
//        b = a - b;
//        a = a - b;
        a = a ^ b; // 0101 ^ 1000 = 1100
        b = b ^ a; // 1000 ^ (0101 ^ 1000) = 1000 ^ 1000 ^ 0101 = 0000 ^ 0101 = 0101
        a = a ^ b; // (0101 ^ 1000) ^ 0101 = 0101 ^ 0101 ^ 1000 = 0000 ^ 1000 = 1000
        System.out.println("after:a=" + a + ", b=" + b);
    }

}
