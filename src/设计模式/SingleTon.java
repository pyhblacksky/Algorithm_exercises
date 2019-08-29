package 设计模式;

/**
 * @Author: pyh
 * @Date: 2019/3/6 17:26
 * @Version 1.0
 * @Function:   单例模式
 */
public class SingleTon {
}
//1、懒汉式     线程不安全
class Singleton1{
    private static Singleton1 uniqueInstance;
    private Singleton1(){}

    public static Singleton1 getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}

//2、饿汉式，线程安全，但资源存在浪费
class Singleton2{
    private static Singleton2 uniqueInstance = new Singleton2();
    private Singleton2(){}

    private static Singleton2 getUniqueInstance(){
        return uniqueInstance;
    }
}

//3、懒汉式，线程安全
class Singleton3{
    private static Singleton3 uniqueInstarnce;
    private Singleton3(){}

    public static synchronized Singleton3 getUniqueInstarnce(){
        if(uniqueInstarnce == null){
            uniqueInstarnce =  new Singleton3();
        }
        return uniqueInstarnce;
    }
}

//4.双重校验-线程安全
class Singleton4{
    private static volatile Singleton4 uniqueInstance;//如果不加，引起重排序后不安全
    public Singleton4(){}

    public static Singleton4 getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton4.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}

//5.静态内部类实现
class Singleton5{
    private Singleton5(){}

    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}