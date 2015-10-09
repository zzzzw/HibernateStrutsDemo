package com.zq.www.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

//FastJson序列化和反序列化Demo
//扩展：http://www.oschina.net/code/snippet_228315_35122
/*
 * 1.常用的对象都可以进行序列化 JSON.toJSONString
 * 2.json->javabean:添加和修改用到       User jb1 = JSON.parseObject(js1, User.class);		
 */
public class test1 {

	@Test
	public void test() {

      
		/////////////////////////////////////////////////////List<String>
		String msg = "success";
		String msg2 = "success";
		List<String> ls=new ArrayList();
		ls.add(msg);
		ls.add(msg2);
		
		
        /////////////////////////////////////////////////////List<String[]>
		String[] msgarr = { "success", "111", "true" };
		String[] msgarr2 = { "硬座", "T180", "300元" };
        
		List<String[]> msgls = new ArrayList();
		msgls.add(msgarr);
		msgls.add(msgarr2);

		
		
        /////////////////////////////////////////////////////entity
		User u1 = new User();
		u1.setAge(11);
		u1.setName("张亮");

		User u2 = new User();
		u2.setAge(12);
		u2.setName("黎明");

		User u3 = new User();
		u3.setAge(13);
		u3.setName("周星驰");

        /////////////////////////////////////////////////////List<entity>
		List<User> us = new ArrayList();
		us.add(u1);
		us.add(u2);
		us.add(u3);
		
		
        /////////////////////////////////////////////////////复杂entity
		Group g1 = new Group();
		g1.setId(1);
		g1.setGname("明星组");
		g1.setUsers(us);

		
        /////////////////////////////////////////////////////Map
		Map m = new HashMap();
		m.put("明星一", u1);
		m.put(2, u2);
		m.put("明星组", us);

		
		
		
		// 序列化JavaBean对象
		String js1 = JSON.toJSONString(u1);
		System.out.println(js1);
		// 反序列化
		User jb1 = JSON.parseObject(js1, User.class);		 
		System.out.println(jb1.name);

		System.out.println("----------------------------------");

		// 序列化List<JavaBean>集合对象
		String js2 = JSON.toJSONString(us);
		System.out.println(js2);
		// 反序列化
		List<User> jb2 = JSON.parseArray(js2, User.class);
		System.out.println(jb2.get(0).name);

		System.out.println("----------------------------------");

		// 序列化复杂对象
		String js3 = JSON.toJSONString(g1);
		System.out.println(js3);
		// 反序列化
		Group jb3 = JSON.parseObject(js3, Group.class);
		System.out.println(jb3.getUsers().get(1).getName());

		System.out.println("----------------------------------");

		// 序列化Map对象
		// SerializerFeature.DisableCircularReferenceDetect 禁止引用
		// SerializerFeature.WriteClassName 对于复杂类型，带入类型信息，以备反序列化时使用
		String js4 = JSON.toJSONString(m,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteClassName);
		System.out.println(js4);
		// 反序列化
		Map jb4 = JSON.parseObject(js4, Map.class);
		User jbu = (User) jb4.get(2);
		System.out.println(jbu.getName());

		System.out.println("----------------------------------");

		// 序列化单个字符串
		String js5 = JSON.toJSONString(msg);
		System.out.println(js5);
		// 反序列化
		Object jb5 = JSON.parse(js5);
		System.out.println(jb5);

		System.out.println("----------------------------------");

		// 序列化字符串数组
		String js6 = JSON.toJSONString(msgarr);
		System.out.println(js6);
		// 反序列化
		Object jb6 = JSON.parse(js6);
		System.out.println(jb6);

		System.out.println("----------------------------------");

		// 序列化List<String[]>
		String js7 = JSON.toJSONString(msgls);
		System.out.println(js7);
		// 反序列化
		List<String[]> jb7 = (List<String[]>) JSON.parse(js7);
		System.out.println(jb7.get(0));

	}

}

class User {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Group {

	private Integer id;

	private String gname;

	private List<User> users = new ArrayList<User>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}