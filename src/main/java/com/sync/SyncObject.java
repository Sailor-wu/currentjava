package main.java.com.sync;

/**
 * SyncObject
 * 共享对象
 */
public class SyncObject {

    private  int  num = 5;

    synchronized public int addMethod(int num){
        int tempnum = this.getNum() + num;
        this.setNum(tempnum);
        return  tempnum;
    }

    synchronized public int prevMethod(int num){
        int tempnum = this.getNum() - num;
        this.setNum(tempnum);
        return  tempnum;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
    
}