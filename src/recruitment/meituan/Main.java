package recruitment.meituan;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/9/11 4:16 PM
 * @project: cc-leetcode
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CountDownLatch latch = new CountDownLatch(n);
        ReviewEncourage reviewEncourage = new ReviewEncourage(n, latch);
        Thread worker1 = new Thread(new Worker(reviewEncourage));
        Thread worker2 = new Thread(new Worker(reviewEncourage));
        Thread worker3 = new Thread(new Worker(reviewEncourage));
        worker1.start();
        worker2.start();
        worker3.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reviewEncourage.print();
    }

}

class ReviewEncourage {

    public int n;
    private String[] result;
    private CountDownLatch latch;

    public ReviewEncourage(int n, CountDownLatch latch) {
        this.n = n;
        this.latch = latch;
        result = new String[n];
    }

    public class PrizePool {

        private int index;

        public void setIndex(int index) {
            this.index = index;
        }

        public void send(String input) {
            latch.countDown();
            result[index - 1] = input;
        }
    }

    public void bonus(PrizePool prizePool) {
        prizePool.send("A");
    }

    public void bonus(int index) {
        PrizePool prizePool = new PrizePool();
        prizePool.setIndex(index);
        bonus(prizePool);
    }

    public void coupon(PrizePool prizePool) {
        prizePool.send("B");
    }

    public void coupon(int index) {
        PrizePool prizePool = new PrizePool();
        prizePool.setIndex(index);
        coupon(prizePool);
    }

    public void contribution(PrizePool prizePool) {
        prizePool.send("C");
    }

    public void contribution(int index) {
        PrizePool prizePool = new PrizePool();
        prizePool.setIndex(index);
        contribution(prizePool);
    }

    public void print() {
        for (String s : result) {
            System.out.print(s);
        }
    }
}

class Worker implements Runnable {

    private int n;
    private volatile int i;
    private ReviewEncourage reviewEncourage;

    public Worker(ReviewEncourage reviewEncourage) {
        this.reviewEncourage = reviewEncourage;
        this.n = reviewEncourage.n;
    }

    @Override
    public void run() {
        while (++i <= n) {
            if (i % 2 == 0) {
                if ((i / 2) % 2 == 1) {
                    reviewEncourage.coupon(i);
                } else {
                    reviewEncourage.contribution(i);
                }
            } else {
                reviewEncourage.bonus(i);
            }
        }
    }
}
