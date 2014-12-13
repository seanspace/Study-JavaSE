package com.bin.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.junit.Test;

public class SocketTest {
	
	@Test
	public void testURLConnection(){
		
	}
	
	/**
	 * URL
	 * 
	 * 
	 * 
	 * 输出结果:
	 *  /docs/BUILDING.txt
	 *	/docs/BUILDING.txt?a=b
	 *	?a=b
	 *	sun.net.www.protocol.http.HttpURLConnection:http://localhost:8080/docs/BUILDING.txt
	 */
	@Test
	public void testURL() throws IOException{
		URL url = new URL("http://localhost:8080/docs/BUILDING.txt?a=b") ;
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getQuery()); 
		
		url.openStream() ;// 只能得到输入流,所以需要使用openConnection();
		
		URLConnection urlConnection = url.openConnection() ;
		System.out.println(urlConnection);
		
		urlConnection.setDoInput(true);
		urlConnection.setDoOutput(true);
		
		InputStream in = urlConnection.getInputStream() ;
		FileOutputStream out = new FileOutputStream("test.txt") ;
		
		byte [] buffer = new byte[1024] ;
		int len = 0 ;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
		
	}
	
	@Test
	public void testClientScoket2() throws IOException{
		InetAddress address = InetAddress.getByName("127.0.0.1") ;
		Socket socket = new Socket(address,8686) ;
		
		InputStream in = socket.getInputStream() ;
		OutputStream out = new FileOutputStream("d:\\abcd.jpg") ;
		
		byte[] buffer = new byte[1024] ;
		int len = 0 ;
		
		OutputStream out1 = socket.getOutputStream() ;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		
		out1.close();
		out.close();
		
		socket.close();
		in.close();	
		
	}
	
	
	/**
	 * 被我修改后的;
	 */
	@Test
	public void testServerSocket2() throws IOException{
		ServerSocket serverSocket = new ServerSocket(8686) ;
		
		while(true){
			Socket socket = null ;
			socket = serverSocket.accept() ;
			InputStream in = new FileInputStream("abc.jpg") ;
			byte[] buffer = new byte[1024] ;
			int len = 0 ;
			
			OutputStream out = socket.getOutputStream() ;
			while((len = in.read(buffer)) != -1){
				out.write(buffer,0,len) ;
			}
			
			out.close();
			in.close();
			
			socket.close();
			
		}
		//serverSocket.close();
		
	}
	
	/*
	 * InetAddress:地址
	 */
	@Test
	public void testInetAddress() throws UnknownHostException{
//		InetAddress address = InetAddress.getByName("www.atguigu.com") ;
//		
//		System.out.println(address);//www.atguigu.com/42.121.6.2
		
		InetAddress address = InetAddress.getLocalHost() ;
		System.out.println(address);//www.atguigu.com/42.121.6.2
		
		
	}
	@Test
	public void testSocket() throws IOException{
		InetAddress address = InetAddress.getByName("127.0.0.1") ;
		Socket socket = new Socket(address,8989) ;
		
		InputStream in = socket.getInputStream() ;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in)) ;
		System.out.println("^_^" + reader.readLine());
		
		in.close();
		reader.close();
		socket.close();
	}
	
	/**
	 * ServerSocket服务端;
	 * @throws IOException
	 */
	@Test
	public void testServerSocket() throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(8989) ;
		Socket socket = serverSocket.accept() ;
		
		OutputStream out = socket.getOutputStream() ;
		PrintWriter writer = new PrintWriter(out) ;
		writer.write("来自服务端的问候。");
		writer.close();
		out.close();
		
		
		socket.close();
		serverSocket.close();
		
	}
	
	

}
