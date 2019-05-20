package main.java.com;

import main.java.com.start.StartThread;
public class AppStarter{

    public static void main(String[] args) throws InterruptedException {
        
       Thread t = new Thread(new StartThread(),"第0个线程执行完。。");
       Thread t1 = new Thread(new StartThread(),"第一个线程执行完。。");
       Thread t2 = new Thread(new StartThread(),"第二个线程执行完。。");
       Thread t3 = new Thread(new StartThread(),"第三个线程执行完。。");
    //    System.out.println(Thread.currentThread().getName());
    //    t.start();
       t1.start();
    //    t2.start();
       /**
        * 调用join方法
        */
    //    t2.join();
    //    t3.start();
       t1.interrupt();
       System.out.println("t1\t"+t1.isInterrupted());
    }
}