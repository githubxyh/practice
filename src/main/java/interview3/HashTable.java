package interview3;

public class HashTable {

    /**
     * hash表的结点
     */
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    //hash表
    private Node[] table;

    /**
     * 构造方法
     * @param tableLength:hash表的长度
     */
    public HashTable(int tableLength) {
        table = new Node[tableLength];
    }

    //向hash表中添加元素
    public void add(int data){
        //由于题目的特殊性，数组中值都小于数组长度，所以hash函数如下：
        int position = data;
        Node head = table[position];

        if(head == null){
            table[position] = new Node(data);
        }else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            //***给链表最后一个位置赋值时，一定要给temp.next赋值，不能给temp赋值
            temp.next = new Node(data);
        }
    }

    /**
     * 打印hash表指定位置的链表
     * @param index
     */
    public void print(int index){
        Node head = table[index];
        if(head != null){
            System.out.println(head.data);
            Node temp = head.next;
            while (temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    /**
     * 获取hash表中指定位置的链表长度
     * @param index
     * @return
     */
    public int getPositionLength(int index){
        int count = 0;
        Node head = table[index];
        if(head != null){
            count++;
            Node temp = head.next;
            while (temp != null){
                count++;
                temp = temp.next;
            }
        }
        return count;
    }
}