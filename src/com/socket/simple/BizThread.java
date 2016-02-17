package com.socket.simple;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * Created by pc on 2016/1/26.
 */
public class BizThread extends Thread {
    private Socket socket;
    private Map<String,String> map;
    private Object obj;
    public BizThread(Socket socket,Map<String,String> map,Object obj){
        this.socket = socket;
        this.map = map;
        this.obj = obj;
    }
    public String[] cut(String string){
        return string.split("-");
    }
    public String register(Map<String,String> map, int number, String name, String password, String tempNumber ){
        String someThings = "";
        if(Integer.parseInt(tempNumber) == number){
            if(!map.containsKey(name) || map.size() == 0){
                map.put(name,password);
                someThings = "注册成功\r\n";
            }else{
                someThings = "注册失败用户已存在\r\n";
            }
        }else{
            someThings = "注册失败验证码错误\r\n";
        }
        return someThings;
    }
    public String logon(Map<String,String> map,String name,String password){
        String someThings = "";
        if(map.containsKey(name) && map.get(name).equals(password)){
            someThings = "登录成功\r\n";
        }else{
            someThings = "登录失败\r\n";
        }
        return someThings;
    }
    public void run(){
        InputStream in = null;
        OutputStream out = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        System.out.println("接收到客户端连接");
        try {
            out = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(out));
            //接收客户端传送过来的消息并进行操作
            in = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            while(true) {
                String str = reader.readLine();
                switch (str) {
                    case "1":
                        while(true) {
                            int number = (int) (Math.random() * 10000);
                            if (999 < number && number < 10000) {
                                writer.write(number + "\r\n");
                                writer.flush();
                                String[] str1 = cut(reader.readLine());
                                String string = null;
                                string = register(map, number, str1[1], str1[2], str1[3]);
                                writer.write(string);
                                writer.flush();

                                break;
                            }
                        }
                        break;
                    case "2":
                        String[] str1 = cut(reader.readLine());
                        String string = null;
                        string = logon(map, str1[1], str1[2]);
                        writer.write(string);
                        writer.flush();



                        break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
