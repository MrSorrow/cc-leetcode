package leetcode.learn.queue;

/**
 * @description: 测试所有实现的队列
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午10:38
 * @project: cc-leetcode
 */
public class TestQueues {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(3);
        System.out.println(queue.isEmpty());
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.getSize());

        LinkQueue<String> linkQueue = new LinkQueue<>();
        System.out.println(linkQueue.isEmpty());
        linkQueue.add("aa");
        linkQueue.add("bb");
        linkQueue.add("cc");
        linkQueue.add("dd");
        System.out.println(linkQueue.getSize());
        System.out.println(linkQueue.peek());
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.peek());

        LoopQueue<String> loopQueue = new LoopQueue<>(3);
        System.out.println(loopQueue.isEmpty());
        loopQueue.add("aaa");
        loopQueue.add("bbb");
        loopQueue.add("ccc");
        System.out.println(loopQueue.peek());
        System.out.println(loopQueue.poll());
        loopQueue.add("ddd");
        System.out.println(loopQueue.peek());
        System.out.println(loopQueue.getSize());
    }
}
