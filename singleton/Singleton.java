package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// https://www.youtube.com/watch?v=QsBQnFUx388
public class Singleton {

	/*
	 * Reflection
	 * serialization/deserialization
	 * multi-threaded access
	 * clone
	 * multiple class loader
	 * garbage collection--not now, java 1.2, garbage collector collected singleton obj, so when getInstance() is called, the old one will be null, and new one will be created
	 */
	public static void main(String[] args) throws Exception {
		SingletonSample singletonSample1 = SingletonSample.getInstance();
		SingletonSample singletonSample2 = SingletonSample.getInstance();
		System.out.println(singletonSample1);
		System.out.println(singletonSample2);
		
		// breaking singleton rule using reflection
		@SuppressWarnings("unchecked")
		Class<SingletonSample> cls = (Class<SingletonSample>) Class.forName("singleton.SingletonSample");
		Constructor<SingletonSample> constrctr = cls.getDeclaredConstructor();
		constrctr.setAccessible(true);
		SingletonSample s3 = constrctr.newInstance();
		System.out.println(s3);
		
		// breaking singleton rule using serialization
		SingletonSampleVioletSerialization serObj = SingletonSampleVioletSerialization.getInstance();
		System.out.println(serObj);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./s4.ser"));
		oos.writeObject(serObj);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./s4.ser"));
		SingletonSampleVioletSerialization serObj2 = (SingletonSampleVioletSerialization) ois.readObject();
		System.out.println(serObj2);
		ois.close();
		oos.close();
		
		// breaking singleton rule using clone
		SingletonSampleVioletClonable clone1 = SingletonSampleVioletClonable.getInstance();
		SingletonSampleVioletClonable clone2 = (SingletonSampleVioletClonable) clone1.clone();
		System.out.println(clone1);
		System.out.println(clone2);
		
		// breaking singleton rule using multi-thread
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(Singleton::useSingletonMultithread);
		service.submit(Singleton::useSingletonMultithread);
		service.shutdown();
	}
	
	public static void useSingletonMultithread(){
		SingletonSample single = SingletonSample.getInstance();
		System.out.println("test multithreading : "+single);
	}

}

class SingletonSample {
	//private static SingletonSample singletonSample = new SingletonSample();// eager
	private static SingletonSample singletonSample = null;//lazy init
	private SingletonSample(){
		System.out.println("creating");
	}
	
	public static SingletonSample getInstance(){
		if(singletonSample==null)//one thread checks, and goes to create new instance, another thread by that time checks and see it is null, so it also creates another obj
			singletonSample = new SingletonSample();
		return singletonSample;
	}
}

class SingletonSampleVioletSerialization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SingletonSampleVioletSerialization singletonSample = new SingletonSampleVioletSerialization();
	
	private SingletonSampleVioletSerialization(){
		System.out.println("creating");
	}
	
	public static SingletonSampleVioletSerialization getInstance(){
		return singletonSample;
	}
}


class SingletonSampleVioletClonable implements Cloneable {
	private static SingletonSampleVioletClonable singletonSample = new SingletonSampleVioletClonable();
	
	private SingletonSampleVioletClonable(){
		System.out.println("creating");
	}
	
	public static SingletonSampleVioletClonable getInstance(){
		return singletonSample;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}