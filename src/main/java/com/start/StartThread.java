package main.java.com.start;
/**
 * StartThread
 */
public class StartThread implements Runnable{

    int time = 1;
    @Override
    public void run() {

        while (time<10) {
            System.out.println(Thread.currentThread().getName()+"\t执行次数："+time);
            try {
                System.out.println("状态：\t"+Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                Thread.sleep(1000);
                ++time;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}