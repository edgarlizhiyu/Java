package com.socket.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by pc on 2016/1/25.
 * 服务器端
 */
public class Server {
    public void start(Map<String,String> map,Object obj){
        ServerSocket serverSocket = null;
        try {
            System.out.println("在端口9999启动服务器...");
            //1.开启端口的监听
            serverSocket = new ServerSocket(9999);
            //2.创建Socket对象,当程序运行到此会被阻塞，等待客户端连接
            //一旦客户端连接进来该方法会生成一个和当前连接进来的客户端一一对应的一个socket对象
            while (true) {
                Socket socket = serverSocket.accept();
                //3.输出消息到客户端
                BizThread biz = new BizThread(socket, map, obj);
                biz.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        //用户集合KEY 是用户名 VALUE 是密码
        Map<String,String> map = new HashMap();
        Object obj = new Object();
        new Server().start(map,obj);

    }
}
