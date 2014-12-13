package com.bin.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {
	
	/**
	 * 关于Class
	 * 1.Class是一个类
	 * 2.是对象照镜子之后得到的信息;
	 * 3.对于每个类而言,JRE都为其保留一个不变的Class类型的对象;
	 * 4.Class对象只能油系统建立对象;
	 * 5.一个类在JVM中只会有一个Class实例;
	 * 6.每个类的实例都会记得自己是由哪个Class实例生成;
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testClass() throws ClassNotFoundException{
		
		@SuppressWarnings("rawtypes")
		Class clazz = null ;
		
		
		/**
		 * 获取Class实例3种方式:
		 * 1.通过类名.class的方式得到;
		 * 2.通过对象的getClass方式得到;
		 * 3.通过全类名字符串的方式得到;(较为常用) ;
		 */
		clazz = Person.class ;
		
		Person person = new Person() ;
		clazz = person.getClass() ;
		
		/*
		 * 下面代码说明了实例对象实际是哪个类,那么得到的Class类实例就是谁的;
		 * 不管变量声明的是谁的对象;
		 */
		Object obj = new Person() ;
		clazz = obj.getClass() ;
		Object obj1 = new Object() ;
		clazz = obj1.getClass() ;
		
		String className = "com.bin.reflection.Person";
		clazz = Class.forName(className) ;
				
		
		Field[] fields = clazz.getDeclaredFields() ;
		
		System.out.println(clazz);
	}
	
	/**
	 * Class类的newInstance()方法;
	 * 实际上是调用的类的无参数构造器;如果没有无参构造器,就会异常 ;
	 */
	@Test
	public void testNewInstance(){
		String className = "com.bin.reflection.Person" ;
		try {
			@SuppressWarnings("rawtypes")// 消除警告
			Class clazz = Class.forName(className) ;
			
			Object obj = clazz.newInstance() ;
			System.out.println(obj);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 两类加载器:用来把类装入JVM中;
	 * 1.bootStrap加载器:启动类加载器;
	 * 2.用户自定义类加载器;
	 * 
	 * JVM运行时会产生3个类加载器
	 * 1.System classLoader
	 * 2.Extension Classloader
	 * 3.BootStrap ClassLoader   无法直接获取;
	 */
	@Test
	public void testClassLoader() throws ClassNotFoundException{
		// 1.获取一个系统的类加载器;
		ClassLoader classLoader = ClassLoader.getSystemClassLoader() ;
		System.out.println(classLoader);
		
		// 2.获取系统类加载器的父类加载器---扩展类加载器;
		classLoader = classLoader.getParent() ;
		System.out.println(classLoader);
		
		// 3.获取扩展类加载器的父类加载器---bootStrap(引导类加载器);
		classLoader = classLoader.getParent() ;
		System.out.println(classLoader);//输出null,无法直接获取;
		
		// 4.测试当前类由哪个类加载器进行加载的;系统类加载器;
		classLoader = Class.forName("com.bin.reflection.Person").getClassLoader() ;
		System.out.println(classLoader);// 系统的类加载器;
		
		// 5.测试JDK提供的Object是由哪个类加载器负责加载;由bootStrap类加载器,加载;
		classLoader = Class.forName("java.lang.Object").getClassLoader() ;
		System.out.println(classLoader);// 无法直接获取,输出null
		
		
		// 6.关于类加载器的一个主要方法;systemClassLoader可以读取所有的类路径(classPath)的资源;
		this.getClass().getClassLoader().getResourceAsStream("jdbc.properties") ;
		
		
	}
	
	/**
	 * Class是一个类的描述;
	 * 类的属性:Field
	 * 类的方法:Method
	 * 类的构造器:Constructor
	 * 
	 */
	@Test
	public void testMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class clazz = Class.forName("com.bin.reflection.Person") ;
		
		// 1.得到对应的所有非私有方法,包含父类的方法;
		Method[] methods = clazz.getMethods() ;
		for (Method method:methods){
			System.out.println(method);
		}
		
		// 2.获取所有方法,包括private的方法,且只获取当前类的方法;
		Method[] methods2 = clazz.getDeclaredMethods() ;
		for (Method method:methods2){
			System.out.println(method);
		}
		
		// 3.获取指定的方法;
		Method method = clazz.getMethod("setName", String.class) ;// 包括父类在内;的public方法;
		System.out.println(method);
		Method method1 = clazz.getDeclaredMethod("setName", String.class) ;// 只获取当前类;所有方法;
		
		// 4.执行方法;
		Object obj = clazz.newInstance() ;
		method.invoke(obj,"小明") ;
	}
	
	/**
	 * 练习1
	 */
	public Object invoke(String className,String methodName,Object ... args){
		Object obj = null ;
		
		try {
			obj = Class.forName(className) ;
			return invoke(obj,methodName,args) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null ;
	}
	
	/**
	 * 练习2
	 */
	public Object invoke(Object obj,String methodName,Object ... args){
		// 1.获取Method对象
		Class[] parameterTypes = new Class[args.length] ;
		for (int i = 0 ; i < args.length ; i++){
			parameterTypes[i] = args[i].getClass() ;
		}
		// 2.执行Method方法
		Method method;
		try {
			method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
		// 3.返回值;
			return method.invoke(obj, args) ;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Test
	public void testInvoke2(){
		Method method = null ;
		method.setAccessible(true);// 获得执行私有方法的权限;
	}
	
	public void invoke2() {
		
	}
	
	/**
	 * 得到父类的class实例
	 */
	@Test
	public void testGetSuperClass() throws ClassNotFoundException{
		String className = "com.bin.reflection.Student" ;
		
		Class clazz = Class.forName(className) ;
		Class superClazz = clazz.getSuperclass() ;// 获取父类的class对象.
		
		System.out.println(superClazz);
		
		
	}
	
	/**
	 * 获取clazz的methodName指定的私有方法.该方法可能是私有方法,还可能是父类的私有方法;
	 */
	public Method getDeclaredMethod(Class clazz,String methodName ,Class ... parameterTypes) {
		for (;clazz != Object.class;clazz = clazz.getSuperclass()) {
			try {
				Method method = clazz.getDeclaredMethod(methodName,parameterTypes) ;
				return method ;
			} catch (NoSuchMethodException | SecurityException e) {
//				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	/**
	 * 重要提示:Integer.class和int.class是得到的不同的Class类;
	 */
	@Test
	public void testGetMethod(){
		Class<Student> clazz = Student.class ;
		Method method = getDeclaredMethod(clazz, "method1",int.class) ;// student的方法
		System.out.println(method);
		method = getDeclaredMethod(clazz, "method2") ;// student的父类的方法;
		System.out.println(method);
	}
	
	
	
	
}
