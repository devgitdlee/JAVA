package PythonComm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import javafx.application.Platform;



public class Main extends Thread{
	// TODO Auto-generated method stub
	//������ �����ϴ� 
	public static ExecutorService threadPool;
	//public static Vector<> clients = new Vector<>();
	ServerSocket serverSocket;
	Socket socket;
	//������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ��Դϴ�.
	public void startSever(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch (Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopSever();
			}
			return;
			
		}
		
		//Ŭ���̾�Ʈ�� ������ ������ ����� ��ٸ��� �������Դϴ�.
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						socket = serverSocket.accept();
						//clients.add(new Client(socket));
						System.out.println("[Ŭ���̾�Ʈ ����] "
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e) {
						if(!serverSocket.isClosed()) {
							stopSever();
						}
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}
	
	//������ �۵��� ������Ű�� �޼ҵ��Դϴ�.
	public void stopSever() {
		try {
			//���� �۵� ���� ��� ���� �ݱ�
			//Iterator<Client> iterator = clients.iterator();
			/*
			while(iterator.hasNext()) {
				//Client client = iterator.next();
				//client.socket.close();
				iterator.remove();
				
			}
			*/
			//���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//������ Ǯ �����ϱ�
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//�����κ��� �޽����� ���޹޴� �޼ҵ��Դϴ�.
	public String receive() {
		while(true) {
			try {
				BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//byte[] buffer = new byte[1024];
				/*
				int length = in.(buffer);
				if(length == -1) throw new IOException();
				String message = new String(buffer, 0, length, "UTF-8");
				*/
				String message = in.readLine();
				return message;
				
			} catch (Exception e) {
				
				break;
			}
		}
		return null;
	}
	
	//�����κ��� �޽����� �����ϴ� �޼ҵ��Դϴ�.
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch (Exception e) {
					//stopClient();
				}
				
			}
		};
		thread.start();
	}
	
	public static void main(String[] args) {
		
		String IP = "127.0.0.1";
		int port = 9876;
		
		Main com = new Main();
		Ora oracle = new Ora();
		
		com.startSever(IP, port);;
		System.out.println("1");;
		while(true) {
			String rev = com.receive();;
			String sen = "";
			if (rev == null) {
				continue;
			}
			System.out.println("Receive:"+rev);
			sen = oracle.Procedure(rev);
			com.send(sen);
			System.out.println("Send:"+sen);;
		}
		
	}

}
