package part3;

public class HashTable {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private int tableLength = 10;

    private Node[] table = new Node[tableLength];

    public void add(int data){
        int position = data % tableLength;

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

    public int getLinkLength(int index){
        return 0;
    }

}