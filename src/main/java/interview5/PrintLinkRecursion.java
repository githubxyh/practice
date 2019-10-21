package interview5;

/**
 * 从尾到头打印链表。（将链表倒着打印）
 * 思路:利用递归，写一个打印方法，每次都打印传入节点的下一个节点，直到某个节点的下一个节点不存在。
 */
public class PrintLinkRecursion {

    public static void main(String[] args) {
        Node head = Node.getLinkByCount(6);
        print(head);
    }

    private static void print(Node node){
        if(node != null){
            if(node.next != null){
                print(node.next);//递归
            }
            System.out.println(node.data);
        }
    }
}
