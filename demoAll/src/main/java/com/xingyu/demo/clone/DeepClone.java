package com.xingyu.demo.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.util.deepclone.DeepCloneUtil;

/**
 * 
 * @author forever11270201
 * 实现深克隆的方式
 * 1.对象图中的每一个对象都实现clonable接口，重写clone方法
 * 2.对象图中的每一个对象都实现serializable接口，利用输入输出流复制对象
 * 3.第三方jar包
 */
public class DeepClone {

	
	public static void main(String[] args) throws Exception{
//		test1();
//		cloneTest();
//		serializableTest();
		testUtil();
	}
	
	public static void testUtil() {
		Address address = new Address("la");
		Person person = new Person("kobe", 18, address);
		Person person2 = null;
		try {
			person2 = (Person) DeepCloneUtil.deepClone(person);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person == person2);		//false
		person.setName("james");
		person.setAge(20);
		address.setAddress("maiami");
		person.setAddress(address);
		System.out.println(person.toString());		//james,20,maiami
		System.out.println(person2.toString());		//kobe,18,la
		System.out.println(person.getAddress() == person2.getAddress());	//false
	}
	
	//测试 = 赋值
	public static void test1() {
		Address address = new Address("la");
		Person person = new Person("kobe", 18, address);
		Person person2 = person;
		System.out.println(person == person2);
		person.setAge(20);
		System.out.println(person.toString());
		System.out.println(person2.toString());
	}
	
	public static void cloneTest() throws CloneNotSupportedException {
		Address address = new Address("la");
		Person person = new Person("kobe", 18, address);
		Person person2 = (Person) person.clone();
		System.out.println(person == person2);		//false
		person.setName("james");
		person.setAge(20);
		address.setAddress("maiami");
		person.setAddress(address);
		System.out.println(person.toString());		//james,20,maiami
		System.out.println(person2.toString());		//kobe,18,maiami
		System.out.println(person.getAddress() == person2.getAddress());	//true
	}
	
	public static void serializableTest() throws Exception{
		Address address = new Address("la");
		Person person = new Person("kobe", 18, address);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(person);
		oos.flush();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Person person2 = (Person) ois.readObject();
		System.out.println(person == person2);		//false
		person.setName("james");
		person.setAge(20);
		address.setAddress("maiami");
		person.setAddress(address);
		System.out.println(person.toString());		//james,20,maiami
		System.out.println(person2.toString());		//kobe,18,maiami
		System.out.println(person.getAddress() == person2.getAddress());	//true
	}
	
	//实现深复制的方法，对象实现clonable接口，重写clone方法
	//对象图中的每一个对象都实现clonable接口，重写clone方法，在顶层对象的clone方法中调用下层对象的clone方法
	static class Person implements Cloneable, Serializable{
		private String name;
		private int age;
		private Address address;
		
		public Person(String name, int age, Address address) {
			this.name = name;
			this.age = age;
			this.address = address;
		}

		public Address getAddress() {
			return address;
		}
		
		public void setAddress(Address address) {
			this.address = address;
		}
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

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Object obj = null;
			obj = super.clone();
			Person person = (Person) obj;
			person.setAddress((Address)person.getAddress().clone());
			return obj;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", address=" + address.getAddress() + "]";
		}
		
		
	}
	
	static class Address implements Cloneable, Serializable{
		private String address;
		
		public Address(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
	
}
