package com.socket.simple.simple1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pc on 2016/1/25.
 * 服务器端
 */
public class Server {
    public void start(){
        ServerSocket serverSocket = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            System.out.println("在端口9999启动服务器...");
            //1.开启端口的监听
            serverSocket = new ServerSocket(9999);
            //2.创建Socket对象,当程序运行到此会被阻塞，等待客户端连接
            //一旦客户端连接进来该方法会生成一个和当前连接进来的客户端一一对应的一个socket对象
            Socket socket = serverSocket.accept();
            System.out.println("接收到客户端连接");
            //3.输出消息到客户端
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("客户端你好！\r\n");
            writer.flush();
            //创建输入流接收客户端发送的消息
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            while(msg != null || msg.toLowerCase().trim().equals("")){
                System.out.println("客户端说"+msg);
                msg = reader.readLine();
                if(msg.toLowerCase().trim().equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args){
        new Server().start();
    }
}
