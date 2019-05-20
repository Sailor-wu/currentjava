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
     * 正常线程执行完毕
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
                    System.out.println("线程：\t"+Thread.currentThread().getName()+",在处理事情！"+ time--);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * InnerStopThred
     * 使用内部类来创建线程
     * 实现Runnable接口创建线程，重写run方法
     * 使用Interrupt来标记该线程为需要终端，如果被标记了的线程还去执行的话，会跑出InterruptedException异常
     * 需要在使用之前调用isInterrupted() 来判断
     *   来Stop 线程
     * 
     */
   class InterruptStopThread implements Runnable{

    int time =  10;// 执行次数
    @Override
    public void run() {
        // 这里实现线程要处理的事情
        try {
            // 睡眠一秒，处理
            while (time >=0) {
                if(Thread.currentThread().isInterrupted()){
                    // 如果标记了，停止线程 
                    // 1. 抛出异常
                    // throw new InterruptedException("退出标记中断的线程！");
                    
                    //  2.return 
                    System.out.println("直接return标记终端的线程！");
                    return;
                }
                Thread.sleep(1000);
                System.out.println("线程：\t"+Thread.currentThread().getName()+",在处理事情！"+ time--);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    // 测试
    public static void main(String[] args) {
        StopThread s = new StopThread();
        // Thread th_a = new Thread(s.new InnerStopThread(), "线程A");
        // th_a.start();
        Thread th_a = new Thread(s.new InterruptStopThread(), "线程A");
        th_a.start();
        th_a.interrupt();// 标记中断


    }


}