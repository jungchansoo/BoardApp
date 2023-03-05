package com.ssamz.biz.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class BoardWebListener implements HttpSessionAttributeListener {

	public BoardWebListener() {
		System.out.println("===> BoardWebSessionListener 생성");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("---> 세션에 정보를 등록함.");
	}

	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("---> 세션에 등록된 정보를 덮어씀");
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("---> 세션에 등록된 정보가 삭제됨");
	}
    
}
