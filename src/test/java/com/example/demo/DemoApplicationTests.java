package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

import static java.lang.System.out;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	IA a;

	@Test
	void contextLoads() {
		out.println(a.getClass());
		out.println(AopUtils.getTargetClass(a));

		a.m2();
		a.m2();
	}

	@Test
	void contextLoads1() {
		a.m1("Hello");
		a.m1("Hello");
	}

	@Test

	void  javaProxy(){
		A a1 = new A();
		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IA.class}, (o, method, objects) -> {
			out.println("Proxy +"+ method.getName());
			return method.invoke(a1, objects);
		});
		IA proxy1 = (IA) proxy;
		proxy1.m2();
		proxy1.m2();
	}


	@Test
	void  CGlibProxy(){
		A a1 = new A();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(A.class);
		enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
			out.println("obj +" + obj.getClass());
			out.println("Proxy +" + proxy.getClass());
			out.println("method +" + method.getName());
			return proxy.invokeSuper(obj, args);
		});
		IA a2 = (IA) enhancer.create();
		a2.m2();
	}
}
