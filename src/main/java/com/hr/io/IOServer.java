package com.hr.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huran
 * @Title: IOServer
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2618:09
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        //接收新的连接线程
        new Thread(() -> {
            while (true) {
                try {
                    //阻塞方法获取新连接
                    Socket socket = serverSocket.accept();

                    //每一个连接都创建一个线程 负责接收数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            //按照字节流的方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (Exception e) {

                        }
                    }).start();
                } catch (Exception e) {

                }
            }
        }).start();

    }


}
