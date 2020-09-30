package multithreading.buyerandseller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用synchronized 的生产者消费者
 * @Author: SCSA
 * @Date: 2020/9/25 21:46
 */
public class useSynchronized {
    private static final int maxLength = 10;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Producer(list));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(list));
        }
    }
    static class Producer implements Runnable {
        private List<Integer> list;

        public Producer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        while (list.size() == maxLength) {
                            System.out.println("生产者" + Thread.currentThread().getName() + "达到最大容量，开始等待");
                            list.wait();
                            System.out.println("生产者" + Thread.currentThread().getName() + "退出等待");
                        }
                        Random random = new Random();
                        int i = random.nextInt();
                        list.add(i);
                        System.out.println("生产者"+Thread.currentThread().getName()+"生产者生产  "+i);
                        list.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable {
        private List<Integer> list;

        public Consumer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (list) {
                    try {
                        while (list.size() == 0) {
                            System.out.println("消费者" + Thread.currentThread().getName() + "等待生产");
                            list.wait();
                            System.out.println("消费者" + Thread.currentThread().getName() + "退出等待");
                        }
                        Integer remove = list.remove(0);
                        System.out.println("消费者" + Thread.currentThread().getName() + "消费  " + remove);
                        list.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
