package com.socket.simple.simple;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by pc on 2016/1/25.
 * 客户端代码
 */
public class Client {

    public void start(){
        Socket socket = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            //1.连接服务器，靠socket对象
            socket = new Socket("127.0.0.1",9999);
            //2.接收服务器发送的消息
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            System.out.println("服务器对我说："+msg);
            //开始发送消息给服务器
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            msg = "";
            while (true){
                System.out.println("请输入您要发送的消息：");
                msg = scanner.next();
                writer.write(msg+"\r\n");
                writer.flush();
                if(msg.toLowerCase().trim().equals("exit")){
                    break;
                }
                //接收服务器的消息
                msg = reader.readLine();
                System.out.println("服务器对我说："+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (reader != null){
                    reader.close();;
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args){
        new Client().start();
    }
}
