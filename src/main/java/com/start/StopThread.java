package main.java.com.start;

/**
 * StopThread
 * 停止线程的方法
 * jdk 已经不推荐使用 stop方法
 * 下面来介绍几种Thread 的stop方法
 */
public class StopThread {

    /**
     * InnerStopThred
     * 使用内部类来创建线程
     * 实现Runnable接口创建线程，重写run方法
     */
   class InnerStopThread implements Runnable{

        int time =  10;// 执行次数
        @Override
        public void run() {
            // 这里实现线程要处理的事情
            try {
                // 睡眠一秒，处理
                while (time >=0) {
                    Thread.sleep(1000);
                    System.out.println("线程：\t"+Thread.currentThread().getName()+",在处理事情！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // 测试
    public static void main(String[] args) {
        StopThread s = new StopThread();
        Thread th_a = new Thread(s.new InnerStopThread(), "线程A");
        th_a.start();


    }


}