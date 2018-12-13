package com.util.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeepCloneUtil {

	/**
	 * 实现对象深拷贝，对象图中的每个对象都要实现Serializable接口
	 * 
	 * @param obj
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object deepClone(Object obj) throws ClassNotFoundException, IOException {
		Object obj2 = null;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);

		obj2 = ois.readObject();

		return obj2;
	}
}
