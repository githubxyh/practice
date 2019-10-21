package interview5;

import java.util.Stack;

/**
 * 从尾到头打印链表。（将链表倒着打印）
 * 思路:链表正序遍历，将元素放在一个栈中。然后利用栈结构的特性，将栈中的元素一个一个pop
 */
public class PrintLinkStack {
    public static void main(String[] args) {
        Node head = Node.getLinkByCount(6);
        //创建一个栈，用存放链表数据
        Stack stack = new Stack();
        Node temp = head.next;
        stack.push(head.data);
        //循环将链表中的元素正序添加到栈中。
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        //将栈中的数字弹出
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
