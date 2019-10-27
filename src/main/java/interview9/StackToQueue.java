package interview9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数，appendTail和deleteHead，
 * 分别完成队列尾部插入节点和在队列头部删除节点的功能。
 */
public class StackToQueue {

    static class SQueue{
        public Stack<Integer> stack1 = new Stack<>();
        public Stack<Integer> stack2 = new Stack<>();

        /**
         * 添加元素到队列的尾部
         * @param val
         */
        public void appendTail(int val){
            stack1.push(val);
        }

        //删除队列的头结点
        public void deleteHead(){
            if(!stack2.empty()){
                stack2.pop();
            }else{
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                stack2.pop();
            }
        }

        //遍历队列的值
        public void listSQueue(){
            while (!stack2.empty()){
                System.out.println(stack2.pop());
            }

            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }

            while (!stack2.empty()){
                System.out.println(stack2.pop());
            }
        }
    }

    public static void main(String[] args) {
        SQueue queue = new SQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        queue.appendTail(5);
        queue.deleteHead();
        queue.appendTail(6);
        queue.deleteHead();
        queue.listSQueue();
    }
}
