package com.bin.demo;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in) ;
		
		System.out.println("请输入学生的人数:");
		int length = scan.nextInt() ;
		
		int [] scores = new int[length] ;
		
		for (int i = 0 ; i < scores.length ; i++) {
			System.out.println("请输入scores[" + i + "]");
			scores[i] = scan.nextInt() ;
		}
		
		System.out.println();
		
		int [][][] test = new int[5][][] ;
		
		for(int j = 0 ; j < test.length ; j++) {
			System.out.println(test[j]);
			
			test[j] = new int [3][] ;
			test[j][0] = new int[4] ;
			test[j][0][0] = 4 ;
			
			test[j][1] = new int[7] ;
			
		}
		
		int [][][] test1 = new int[3][][] ;//第一个维度的长度必须确定;
		
		
	}
 
}
