package main.java.com.start;

/**
 * Sync
 * 线程通信
 */
public class Sync {


    private InnerSyncObjClazz getDrawInstance() {
        return new InnerSyncObjClazz();
    }
    /**
     * InnerSyncClazz
     * 内部内，为共享对象
     */
    class InnerSyncObjClazz {
        // 私有属性
        private int time = 10;
        
        public  int  MenthodAdd(int addNum){
            return time + addNum;
        }


        public  int  MenthodPrev(int prevNum){
            return time - prevNum;
        }

    }

    /**
     * InnerSyncThread_A
     * 创建内部线程A 
     * 操作共享对象,执行5次加1
     */
    class InnerSyncThread_A extends Thread{
            private Sync.InnerSyncObjClazz inClazz;
            public InnerSyncThread_A(){
            }
            public InnerSyncThread_A(Sync.InnerSyncObjClazz inClazz){
                this.inClazz=inClazz;
            }
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    int times = inClazz.MenthodAdd(1);
                    try {
                        Thread.sleep(1000);
                        System.out.println("InnerSyncThread_A次数：\t"+times);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

    }


    
    /**
     * InnerSyncThread_A
     * 创建内部线程A 
     * 操作共享对象,执行5次加1
     */
    class InnerSyncThread_B extends Thread{
            private Sync.InnerSyncObjClazz inClazz;
            public InnerSyncThread_B(){

            }
            public InnerSyncThread_B(Sync.InnerSyncObjClazz inClazz){
                this.inClazz=inClazz;
            }
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    int times = inClazz.MenthodPrev(1);
                    try {
                        Thread.sleep(1000);
                        System.out.println("InnerSyncThread_B次数：\t"+times);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

    }

    public static void main(String[] args) {


        Sync  clazz =  new Sync();
        InnerSyncObjClazz clazz2 = clazz.getDrawInstance();
        InnerSyncThread_A thread_A = clazz.new InnerSyncThread_A(clazz2);
        thread_A.start();
        InnerSyncThread_B thread_B = clazz.new InnerSyncThread_B(clazz2);
        thread_B.start();
        
    }
}