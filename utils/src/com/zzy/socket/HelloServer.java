package com.zzy.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloServer {
	public static void main(String[] args) throws IOException {
		new HelloServer();
	}

	private static final int SERVER_PORT = 9527;
	private final int POOL_SIZE = 2;
	private ServerSocket serverSocket;
	private ExecutorService executorService;

	public HelloServer() throws IOException {
		//检查cpu个数
		int cpuCount = Runtime.getRuntime().availableProcessors();
		//创建线程池，用于支持多线程处理任务
		executorService = Executors.newFixedThreadPool(cpuCount*POOL_SIZE);
		//创建ServerSocket实例
		serverSocket = new ServerSocket(SERVER_PORT);
		//开始监听
		System.out.println(">>服务器已经启动，监听端口"+SERVER_PORT);
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				executorService.execute(new HelloResp(socket));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
