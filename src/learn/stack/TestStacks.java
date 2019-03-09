package learn.stack;

/**
 * @description: 测试所有实现的栈
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2018/9/11 上午10:49
 * @project: cc-leetcode
 */
public class TestStacks {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(4);
        System.out.println(stack.isEmpty());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        stack.push("e");
        System.out.println(stack.getSize());

        StackList<String> stackList = new StackList<>();
        System.out.println(stackList.isEmpty());
        stackList.push("aa");
        stackList.push("bb");
        stackList.push("cc");
        System.out.println(stackList.getSize());
        System.out.println(stackList.pop());
        System.out.println(stackList.peek());

        LinkedStack<String> linkedStack = new LinkedStack<>();
        System.out.println(linkedStack.isEmpty());
        linkedStack.push("aaa");
        linkedStack.push("bbb");
        linkedStack.pop();
        linkedStack.push("ccc");
        System.out.println(linkedStack.getSize());
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.pop());
    }
}
