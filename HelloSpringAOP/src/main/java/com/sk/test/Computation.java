package com.sk.test;

import java.util.Date;
import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Computation {

	HashMap<Integer, Long> hm = new HashMap<Integer, Long>();

	static int i,j;
	
	public long fibo(int n) {
		i++; 
		if (n <= 1)
			return n;
		else
			return fibo(n - 2) + fibo(n - 1);
	}

	public long fiboHash(int n) {
		j++; 
		// 핵심 코드
		if (hm.containsKey(n))
			return hm.get(n);

		// n이 key, 결과 값이 value
		if (n <= 1) {
			hm.put(n, (long) 1);
			return n;
		} else {
			long x = fiboHash(n - 1) + fiboHash(n - 2);
			hm.put(n, x);
			return x;
		}
	}
	
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("computation.xml");
		Computation cpu = (Computation) ctx.getBean("cpu");

		System.out.println(cpu.fibo(4));
		System.out.println(cpu.fibo(5));
		System.out.println(cpu.fibo(6));

		System.out.println(cpu.fiboHash(40));
		System.out.println(cpu.fiboHash(50));
		System.out.println(cpu.fiboHash(60));
		System.out.println(cpu.fiboHash(70));
	
		ctx.close();
	}
}
