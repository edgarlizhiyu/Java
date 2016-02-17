package com.socket.simple.simple3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by pc on 2016/1/25.
 * 服务器端
 */
public class Server {
    public void start(){
        ServerSocket serverSocket = null;
        try {
            System.out.println("在端口9999启动服务器...");
            //1.开启端口的监听
            serverSocket = new ServerSocket(9999);
            //2.创建Socket对象,当程序运行到此会被阻塞，等待客户端连接
            //一旦客户端连接进来该方法会生成一个和当前连接进来的客户端一一对应的一个socket对象
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("接收到客户端连接");
                //3.输出消息到客户端
                BizThread biz = new BizThread(socket);
                biz.start();
                }
            } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    public static void main(String [] args){
        new Server().start();

    }
}
