package part3;

public class HashTable {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private Node[] table;

    public HashTable(int tableLength) {
        table = new Node[tableLength];
    }

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
            temp.next = new Node(data);
        }

    }

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