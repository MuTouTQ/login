package com.tq.client;

import java.util.Scanner;

import com.tq.entity.User;
import com.tq.service.DoLogin;

public class Login {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.nextLine();
		System.out.println("请输入密码：");
		String pwd = input.nextLine();
		
		DoLogin dl = new DoLogin();
		User user = dl.findUser(name, pwd);//调用查询用户的方法
		if(user!=null){
			System.out.println("欢迎你："+user.getName());
		}else{
			System.out.println("用户名或密码错误！");
		}
		

	}

}
