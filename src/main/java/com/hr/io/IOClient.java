package com.hr.io;

import java.net.Socket;
import java.util.Date;

/**
 * @author BUCHU
 * @Title: IOClient
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2618:16
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true){
                    try {
                        socket.getOutputStream().write((new Date()+"hello world").getBytes());
                    }catch (Exception e){

                    }
                }
            }catch (Exception e){

            }
        }).start();
    }
}
