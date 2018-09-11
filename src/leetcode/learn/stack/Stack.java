package leetcode.learn.stack;

/**
 * @description: 栈的数组实现
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/10 下午8:15
 * @project: cc-leetcode
 */
public class Stack<T> {

    private T[] data;
    private int maxSize;
    private int top;

    public Stack() {
        this(10);
    }

    public Stack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            this.top = -1;
            data = (T[]) new Object[initialSize];
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T t) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满，无法将元素入栈！");
        }
        data[++top] = t;
    }

    public T pop() {
        if(top == -1){
            throw new RuntimeException("栈为空！");
        }else{
            return data[top--];
        }
    }

    public int getSize() {
        return top + 1;
    }
}
