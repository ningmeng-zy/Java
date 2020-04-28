package src.lesson5;

import javax.naming.NamingEnumeration;

/**
 * @ClassName Sington
 * @Description TODO Sington
 * @Author 张洋
 * @Date 2020/4/3 09:18
 * @Version 2018.1.5
 **/
public class Sington {
    private Sington(){

    }

    //饿汉式
//    private static Sington SINGTON = new Sington();
//    public static Sington getInstance(){
//        return SINGTON;
//    }

    //懒汉式
//    private static Sington SINGTON;
//    public static Sington getInstance(){
//        if (SINGTON == null){
//            SINGTON = new Sington();
//        }
//        return SINGTON;
//    }
    //双重效验锁
    private volatile static Sington SINGTON;
    public static Sington getInstance(){
        //提高效率；变量使用volatile可以保证可见性
        if (SINGTON == null){
            synchronized (Sington.class){
                //为了保证单例：返回同一个对象；
                if (SINGTON == null) {
                    //new对象分解成三条指令：前两个指令是new，第三个是=
                    //1.分配内存空间
                    //2.初始化对象
                    //3.赋值给变量
                    SINGTON = new Sington();
                }
            }
        }

        return SINGTON;
    }
}
/*
public class Sington {
    public static Country newInstance(String name){
        return new Country(name);
    }
}

class Country{
    private String name;
    public Country(String name){
        this.name = name;
    }
}*/