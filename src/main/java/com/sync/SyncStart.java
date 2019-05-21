package main.java.com.sync;

/**
 * SyncStart
 */
public class SyncStart {

    public static void main(String[] args) {
        SyncObject obj = new SyncObject();
        Thread_A t_a = new Thread_A(obj);
        t_a.start();

        Thread_B t_b = new Thread_B(obj);
        t_b.start();

    }
}