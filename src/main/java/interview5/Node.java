package interview5;

public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 获取指定长度的链表
     * @param length
     * @return
     */
    public static Node getLinkByCount(int length){
        Node head = new Node(1);
        Node temp = head;
        for(int i=2; i < length + 1; i++){
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head;
    }
}
