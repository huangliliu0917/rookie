package com.cainiao.exclusive.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by wangkecheng on 2018/8/10.
 */
public class SocketServer {
    public static final int PORT = 8899;//监听的端口号

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        SocketServer server = new SocketServer();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {
            try {
                // 读取客户端数据
                OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(),"GBK");
                InputStream input = socket.getInputStream();
                String instr = "";
                PrintWriter pw=null;
                int length = 0;
                byte[] buf = new byte[2048];
                try {
                    while (-1 != (length = input.read(buf, 0, 100))) {
                        String str = new String(buf, 0, length, "GBK");
                        instr = instr.concat(str);
                    }
                } catch (SocketException e2) {
                    System.out.println(e2);
                }
                // 处理客户端数据
                System.out.println("客户端发过来的内容:" + instr);

                pw=new PrintWriter(output,true);
                pw.write("147   417000004148295440110440110|410701820194|101080|89|04148295|172725|20180809|41700000000|00000000|5002||||||||||99440000000|079038480|90686383||");
                pw.flush();
                socket.shutdownOutput();

                output.close();
                input.close();
                pw.close();
            } catch (Exception e) {
                System.out.println("服务器 run 异常: " + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
