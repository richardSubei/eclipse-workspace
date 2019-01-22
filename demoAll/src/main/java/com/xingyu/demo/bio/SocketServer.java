package com.xingyu.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO blocked IO
 * @author forever11270201
 *
 */
public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("服务器已启动");
		while (!serverSocket.isClosed()) {
			Socket socket = serverSocket.accept();	//阻塞方法
			
			InputStream inputStream = socket.getInputStream();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			String msg = "";
			while ((msg = bufferedReader.readLine())!= null) {	//阻塞
				if (msg.length() == 0) {
					break;
				}
				System.out.println(msg);
			}
			System.out.println("收到数据，来自" + socket.toString());
			
			socket.close();
			
			serverSocket.close();
			
		}

	}
}
