package com.bin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * 字符流,字节流
 * File
 * 接口  inputStream OutputStream,reader Writer
 * 
 *
 */
public class IOTest {
	
	/**
	 * 插入数据到第二行,原来的数据下移一行;
	 * @throws IOException 
	 */
	@Test
	public void testRandomAccessFile2() throws IOException{
		RandomAccessFile access = new RandomAccessFile("hello2.txt","rw" ) ;
		String line = access.readLine() ;
		byte[] buffer = new byte[(int)(access.length())] ;
		access.read(buffer) ;// 指针到结尾
		access.seek(line.length());
		
		access.writeBytes("\nI Love Gongfu..\n");
		access.write(buffer);
		
		access.close();
	}
	
	@Test
	public void testRandomAccessFile() throws IOException{
		// 1.创建RandomAccessFile对象
		RandomAccessFile access = new RandomAccessFile("hello2.txt","rwd" ) ;
		// 2.对文件进行读写操作
		String str = null ;
		while((str = access.readLine()) != null){
			System.out.println(str);
		}
		// 向文件结尾写入数据
		access.seek(20);// 设置指针的位置;
		access.writeBytes("www.liusi.com");// 直接干掉已经存在于对应位置的数据;
		
		// 3.
		access.close();
	}
	
	@Test
	public void testInputObjectStream() throws IOException, ClassNotFoundException{
		InputStream in = new FileInputStream("D:\\obj.txt") ;
		ObjectInputStream objInputStream = new ObjectInputStream(in) ;
		Object obj = objInputStream.readObject() ;
		System.out.println(obj);
		
		in.close();
		objInputStream.close();
	}
	
	/*
	 * 对象输入,输出流----字节流
	 */
	@Test
	public void testSerializable() throws IOException{
		Person person = new Person("AA",12) ;
		
		//
		OutputStream out = new FileOutputStream("D:\\obj.txt") ;
		ObjectOutputStream objOutputStream = new ObjectOutputStream(out) ;
		
		objOutputStream.writeObject(person);
		out.close();
		objOutputStream.close();
	}
	
	/**
	 * 装换字符输出流;
	 * @throws IOException 
	 */
	@Test
	public void testOutputStreamWriter() throws IOException{
		InputStream in = new FileInputStream("hello2.txt") ;
		Reader reader = new InputStreamReader(in) ;
		BufferedReader bufferedReader = new BufferedReader(reader) ;
		
		OutputStream out = new FileOutputStream("hello7.txt") ;
		Writer writer = new OutputStreamWriter(out) ;
		BufferedWriter bufferedWriter = new BufferedWriter(writer) ;
		
		String str = null ;
		int i = 0 ;
		while ((str = bufferedReader.readLine()) != null){
			if (i != 0){
				bufferedWriter.write("\n") ;
			}
			bufferedWriter.write(str) ;
			i ++ ;
		}
		
		
		/*
		 * 关闭输入流,从里往外关闭;
		 * 关闭输出流,从外往里关闭;
		 */
		in.close();
		reader.close();
		bufferedReader.close();
		
		bufferedWriter.close();
		writer.close();
		out.close();
	}
	
	/**
	 * 转换字符流;
	 */
	@Test
	public void testInputStreamReader() throws IOException{
		// 指向文档的字节流
		InputStream in = new FileInputStream("hello2.txt") ;
		// 把上面的流转换位字符流
		Reader reader = new InputStreamReader(in) ;
		// 把字符流装换为带缓冲的字符流
		BufferedReader bufferedReader = new BufferedReader(reader) ;
		/*
		BufferedReader buffedredReader2 = new BufferedReader(
				new InputStreamReader(new FileInputStream("hello2.txt"))) ;
		*/
		String str = null ;
		while ((str = bufferedReader.readLine()) != null){
			System.out.println(str);
		}
		
		// 关闭流;从里忘外关闭
		in.close();
		reader.close();
		bufferedReader.close();
		
		
	}
	
	/**
	 * 用BufferedInputStream和buffedOutputStream复制文件;(缓冲流,包装流)
	 * @throws IOException 
	 */
	@Test
	public void testBufferedInputStreamAndBufferedOutputStream() throws IOException{
		InputStream in = new FileInputStream("hello2.txt") ;
		BufferedInputStream bufferedInputStream = new BufferedInputStream(in) ;
		OutputStream out = new FileOutputStream("hello6.txt") ;
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out) ;
		
		byte [] buffer = new byte[1024] ;
		int len = 0 ;
		while((len = bufferedInputStream.read(buffer)) != -1){
			bufferedOutputStream.write(buffer,0,len);
		}
		
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
	
	
	/**
	 * 用BufferedReader和buffedWriter复制文件;(缓冲流,包装流);
	 * @throws IOException 
	 */
	@Test
	public void testBufferedReaderAndBufferedWriter() throws IOException{
		// 1.创建bufferedReader和BufferedWriter
		Reader in = new FileReader("hello2.txt") ;
		BufferedReader bufferedReader = new BufferedReader(in) ;
		Writer out = new FileWriter("hello5.txt") ;
		BufferedWriter bufferedWriter = new BufferedWriter(out) ;
		// 2.进行读写操作
		String str = null ;
		int i = 0 ;
		while((str = bufferedReader.readLine()) != null){
			if (i != 0) {
				bufferedWriter.write("\n");
			}
			bufferedWriter.write(str);
			i++ ;
		}
		
		// 3.关闭流,关闭封装流就可以了;
		bufferedReader.close();
		bufferedWriter.close();
	}
	
	/**
	 * 字符输入输出流;
	 * @throws IOException 
	 */
	@Test
	public void testCopyByReaderAndWriter() throws IOException{
		// 创建输入,输出流
		Reader reader = new FileReader("hello2.txt") ;
		Writer writer = new FileWriter("hello3.txt") ;
		// 创建一个字符数组
		char [] buffer = new char[10] ;
		// 利用
		int len = 0 ;
		while ((len = reader.read(buffer))!= -1){
			writer.write(buffer,0,len);
		}
		
		// 没有关闭流的时候,可能会有问题;
		reader.close();
		writer.close();
	}
	
	/**
	 * 用字节输入输出流,完成hello.txt文件的复制;
	 * 字节输入输出流用的较多,可以复制所有文件;字符输入输出流,是对文本文件操作较多;
	 * @throws IOException 
	 */
	@Test
	public void testCopyFile() throws IOException{
		// 缺省的路径名称,其实就是工程的根目录下;
		// 1.创建定位到helo.txt的文件输入流
		InputStream in = new FileInputStream("src/hello.txt") ;
		// 2.创建定位到hello2.txt的文件输出流;
		OutputStream out = new FileOutputStream("hello2.txt") ;
		
		// 3.创建一个byte数组,用于读写文件;
		byte [] buffer = new byte[1024 * 10] ;
		int len = 0;
		// 4.读写文件
		// in.read(buffer) ; out.write(buffer,0,len) ;
		while((len = in.read(buffer)) != -1){
			out.write(buffer,0,len);
		}
		// 5.关闭流资源
		out.close();
		in.close();
	}
	
	/**
	 * 字节输出流
	 */
	@Test
	public void testOutputStream() throws IOException{
		OutputStream out = new FileOutputStream("abcd.txt") ;
		
		String content = "www.lifa.com\n\rHello Java!" ;
		/*
		int len = 10 ;
		byte [] contentBytes = content.getBytes() ;
		
		for (int i = 0 ; i < content.length() % 10 ; i++){
			// 把String拆分成多个buffer
			out.write(contentBytes,i * 10,len);
		}
		if (content.length()%10 != 0 ){
			out.write(contentBytes,10 * (content.length() / 10),
					content.length() - (10 * (content.length() / 10)));
		}*/
		out.write(content.getBytes());
		
		out.close();
	}
	
	/**
	 * File
	 * @throws IOException 
	 */
	//@Test
	public void testFile() throws IOException{
		File file = new File("src/hello.txt") ;
		// 1.文件名相关;
		String fileName = file.getName() ;
		System.out.println(fileName);
		
		// 2.访问文件的绝对路径;
		String path = file.getAbsolutePath() ;
		System.out.println(path);
		
		// 3.为文件重命名;
		//file.renameTo(new File("D:\\hello1.txt")) ; 
		
		// 4.文件检测相关
		System.out.println(file.exists()) ;
		
		// 5.文件常规信息
		System.out.println(file.length());
		
		// 6.文件操作相关
		File file2 = new File("aa.txt") ;
		file2.createNewFile() ;
	}
	
	/**
	 * 输入流,字节输入流;
	 */
	//@Test
	public void testInputStream() throws IOException{
		InputStream in = new FileInputStream("src/hello.txt") ;
		/*
		// 1.读取文件: 一次读一个字节
		int result = in.read() ;// 一次读一个字节,很少用;效率低 ;返回-1就没有了.
		while(result != -1){
			System.out.print((char)result);
			result = in.read() ;
		}
		System.out.println();
		*/
		
		/*
		// 2.一次读取一组字节;
		byte [] buffer = new byte[10] ;
		int len = 0 ;
		// 返回读取的字节数 ;
		while((len = in.read(buffer)) != -1){
			//此种遍历方法;最后一次读取可能会出问题;
			for (byte b: buffer){
				System.out.print((char)b);
			}
			for (int i = 0 ; i < len ; i++){
				System.out.print((char)buffer[i]);
			}
		}*/
		
		// 3.把内容读取到字节数组的部分连续的元素中;数组足够大,可以一次读完 ;
		byte [] result = new byte[1024 * 10] ;
		in.read(result, 10, in.available()) ;
		
		
		// 关闭流资源
		in.close() ;
	}
	
	/**
	 * 测试字符输入流;
	 * @throws IOException 
	 */
	//@Test
	public void testReader() throws IOException{
		// 利用字符输入流读取hello.txt文档的内容.输出到控制台;
		Reader reader = new FileReader("src/hello.txt") ;
		
		char [] buffer = new char[10] ;
		int len = 0 ;
		
		while((len = reader.read(buffer)) != -1){
			for (int i = 0 ;i < len ; i++){
				System.out.print(buffer[i]);
			}
		}
		
		reader.close();
	}

}
