package com.zzy.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloResp implements Runnable {

	private Socket socket;

	public HelloResp(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String clientIp = socket.getInetAddress().getHostAddress();
			System.out.println("开始处理来自\"" + clientIp + ":" + socket.getPort() + "\"的请求。");
			// 获得输入流，封装为BufferedReader（可以每次读一行，方便编码）
			InputStream socketInStream = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socketInStream, "UTF-8"));// 按UTF-8编码，无压力支持中文，客户端也要同样设置

			// 获得输出流，用于写回给客户端
			OutputStream socketOutStream = socket.getOutputStream();
			String clientRequestString = null;

			// 循环处理来自客户端的请求，直至客户端发送“sb”
			while ((clientRequestString = br.readLine()) != null) {
				// 客户端每次发送一行命令
				System.out.println("接收到客户端(" + clientIp + ")请求：" + clientRequestString);

				// 客户端发送“sb”，则完成一次交谈，下次需重新连接
				String serverReturn = null;
				if (clientRequestString.equals("sb")) {
					serverReturn = "你也SB。\r\n";

					// 返回处理结果给客户端
					System.out.println("发送给客户端(" + clientIp + ")应答：" + serverReturn);
					socketOutStream.write(serverReturn.getBytes("UTF-8"));// 也用UTF-8编码

					System.out.println("结束处理来自\"" + clientIp + ":" + socket.getPort() + "\"的请求。");
					break;
				} else {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
					serverReturn = df.format(new Date()) + "\r\n";

					// 返回处理结果给客户端
					System.out.println("发送给客户端(" + clientIp + ")应答：" + serverReturn);
					socketOutStream.write(serverReturn.getBytes("UTF-8"));// 也用UTF-8编码
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
