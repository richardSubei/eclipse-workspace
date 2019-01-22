package com.xingyu.demo.juc;

import javax.validation.constraints.Null;

/**
 * Map的链表实现
 * @author forever11270201
 *
 */
public class NodeMapDemo {

	static Node head = null;
	
	public static void main(String[] args) {
		NodeMapDemo nodeMapDemo = new NodeMapDemo();
		
		Node node1 = new Node<>();
		node1.key = "1";
		node1.value = "a";
		
		Node node2 = new Node<>();
		node2.key = "2";
		node2.value = "b";

		Node node3 = new Node<>();
		node3.key = "3";
		node3.value = "c";
		
		nodeMapDemo.add(node1);
		nodeMapDemo.add(node2);
		nodeMapDemo.add(node3);

		nodeMapDemo.print(head);
		
		
	}
	
	public void add(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = node;
		
	}
	
	public void print(Node head) {
		System.out.println(head.value);
		Node tmp;
		while ((tmp = head.next) != null) {
			System.out.println(tmp.value);
			head = tmp;
		}
	}
	
	static class Node<K, V> {
		K key;
		Object value;
		Node<K, V> next;
	}
	
}
