package recruitment.yuewen;

/**
 * @description: 两个线程交替打印
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/16 7:32 PM
 * @project: cc-leetcode
 */
public class AlternatePrint {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(new Worker(lock, "A"));
        Thread b = new Thread(new Worker(lock, "B"));
        a.start();
        b.start();
    }
}

class Worker implements Runnable {

    private Object lock;
    private int i;
    private String name;

    public Worker(Object lock, String name) {
        this.lock = lock;
        i = 0;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (++i > 0) {
                System.out.println(name + ":" + i);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
