package work;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/1/26.
 */
public class Client {
    public void menu() {
        System.out.println("您好~请根据一下提示选择业务：");
        System.out.println("1、注册\t2、登录\t3、重新登陆");
    }
    public void show(String msg){
        System.out.println(msg);
    }
    public void start() {
        try {
            BufferedReader reader = null;
            BufferedWriter writer = null;
            String name = null;
            String password = null;
            String yanzheng = null;
            Socket socket = new Socket("127.0.0.1", 9999);
            String msg = "";
            boolean isRetrun = true;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(isRetrun) {
                menu();
                int chooce = 0;
                boolean isNumber = true;
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.next();
                while (isNumber) {
                    try {
                        chooce = Integer.parseInt(answer);
                        if (1 <= chooce && chooce <= 3) {
                            isNumber = false;
                        }
                    } catch (NumberFormatException e) {
                        show("请正确输入");
                        answer = scanner.next();
                    }
                }
                switch (chooce) {
                    case 1: {
                        show("请输入注册账号：");
                        name = scanner.next();
                        show("请输入密码：");
                        password = scanner.next();
                        writer.write("1" + "\r\n");
                        writer.flush();
                        msg = reader.readLine();
                        show("验证码为:" + msg);
                        show("请输入验证码：");
                        yanzheng = scanner.next();
                        writer.write("1" + "-" + name + "-" + password + "-" + yanzheng + "\r\n");
                        writer.flush();
                        msg = reader.readLine();
                        System.out.println(msg);
                        System.out.println("是否继续？y/o");
                        String s = scanner.next();
                        if(s.trim().toLowerCase().equals("y")){
                            isRetrun = true;
                        }else{
                            isRetrun = false;
                        }
                        break;
                    }
                    case 2: {
                        writer.write("2" + "\r\n");
                        writer.flush();
                        show("请输入账号：");
                        name = scanner.next();
                        show("请输入密码：");
                        password = scanner.next();
                        writer.write("2" + "-" + name + "-" + password + "\r\n");
                        writer.flush();
                        msg = reader.readLine();
                        System.out.println(msg);
                        System.out.println("是否继续？y/o");
                        String s = scanner.next();
                        if(s.trim().toLowerCase().equals("y")){
                            isRetrun = true;
                        }else{
                            isRetrun = false;
                        }
                        break;
                    }
                    case 3: {
                        writer.write("2" + "\r\n");
                        writer.flush();
                        show("请输入账号：");
                        name = scanner.next();
                        show("请输入密码：");
                        password = scanner.next();
                        writer.write("2" + "-" + name + "-" + password + "\r\n");
                        writer.flush();
                        msg = reader.readLine();
                        System.out.println(msg);
                        System.out.println("是否继续？y/o");
                        String s = scanner.next();
                        if(s.trim().toLowerCase().equals("y")){
                            isRetrun = true;
                        }else{
                            isRetrun = false;
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
}
