package com.xingyu.demo.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8080);
		OutputStream out = socket.getOutputStream();
		out.write("hello world".getBytes());		//阻塞，写完成
		out.close();
	}
}
