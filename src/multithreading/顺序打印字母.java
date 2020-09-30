package multithreading;

/**
 * 三个线程顺序打印字母A~Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok
 * @Author: SCSA
 * @Date: 2020/9/25 21:28
 */
public class 顺序打印字母 {
    private static int i = 0;
    private static char ch = 'A';

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
               synchronized (this) {
                   int id = Integer.parseInt(Thread.currentThread().getName());
                   while(ch <= 'Z') {
                       try {
                           if (i % 3 == id - 1) {
                               System.out.println(id + " " + (char) ch);
                               ch++;
                               i++;
                               this.notifyAll();
                           } else {
                               this.wait();
                           }
                       } catch(InterruptedException e){
                           e.printStackTrace();
                       }
                   }
               }
            }
        };
        new Thread(r, "1").start();
        new Thread(r, "2").start();
        new Thread(r, "3").start();
    }
}
