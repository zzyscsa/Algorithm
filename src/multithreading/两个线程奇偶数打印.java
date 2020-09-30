package multithreading;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: SCSA
 * @Date: 2020/9/25 21:38
 */
public class 两个线程奇偶数打印 {
    private static int value = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition conA = lock.newCondition();
        Condition conB = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(value <= 100) {
                        System.out.println(Thread.currentThread().getName()+" "+value++);
                        conB.signal();
                        conA.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(value <= 100) {
                        System.out.println(Thread.currentThread().getName()+" "+value++);
                        conA.signal();
                        conB.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "B").start();
    }
}
