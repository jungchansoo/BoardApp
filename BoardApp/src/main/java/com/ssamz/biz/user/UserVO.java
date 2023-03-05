package com.ssamz.biz.user;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.Data;

@Data
public class UserVO implements HttpSessionBindingListener{
	private String id;
	private String password;
	private String name;
	private String role;
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVO 객체가 세션에 등록됨.");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVO 객체가 세션에 제거됨.");
	}
	
	
}
