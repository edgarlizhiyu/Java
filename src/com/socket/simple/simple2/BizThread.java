package com.socket.simple.simple2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by pc on 2016/1/25.
 */
public class BizThread extends Thread {
    private Socket socket;
    public BizThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            System.out.println(socket.getRemoteSocketAddress());
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("客户端你好！\r\n");
            writer.flush();
            //创建输入流接收客户端发送的消息
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = "";
            Scanner scanner = new Scanner(System.in);
            while (msg != null || msg.toLowerCase().trim().equals("")) {
                msg = reader.readLine();
                System.out.println("客户端"+socket.getRemoteSocketAddress()+"说" + msg);
                if (msg.toLowerCase().trim().equals("exit")) {
                    break;
                }
                //向客户端发送消息
                System.out.println("请输入你需要发送的内容：");
                msg = scanner.next();
                writer.write(msg + "\r\n");

                writer.flush();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }



    }
}
