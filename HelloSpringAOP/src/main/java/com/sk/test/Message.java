package com.sk.test;

import java.util.Date;

// 클래스가 로딩될때도 분석할 수 있다. 
public class Message {

	int a = 10;

	public String getNews() {
		// long start = System.currentTimeMillis();
		String msg = "[08.09]더워요";
		try {
			Thread.sleep(900);
		} catch (Exception e) {
		}
		// long finish = System.currentTimeMillis();

		// System.out.println("log:[" + new Date() + "] getNews : " + msg + " "
		// + (finish - start));

		return msg;
	}

	public String getFile(String file) {
		// long start = System.currentTimeMillis();
		String out = "ok~ " + file;
		try {
			Thread.sleep(900);
		} catch (Exception e) {
		}
		// long finish = System.currentTimeMillis();

		// System.out.println("log:[" + new Date() + "] getFile : " + out + " "
		// + (finish - start));

		return out;
	}

	public void test123() {
		System.out.println("testestest~~~~~~~~~~");
	}
	
	public void dummy123() {
		System.out.println("dummydummydummy~~~~~~~~~~"); 
	}
	
	public String debug123() {
		return (new Date()).toString(); 
	}
	
	public void before123() {
		
	}
	
	
}
