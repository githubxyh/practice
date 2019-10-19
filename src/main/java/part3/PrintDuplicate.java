package part3;

/**
 * 找出数组（数组的每一个值都小于数组的长度）中的重复数据。
 * 例如：数组{2,3,1,0,2,5,3}对应的输出结果是2或3。
 *
 * 第一种解法：
 * 1.创建一个HashTable，将数组中的每一个值放在该值对应的位置上。例如：第一个元素2放在第2个位置上。
 * 2.在hash表的长度找出链表长度大于1的位置，对应的位置（即该位置链表的头结点的值）。
 * 3.该值就是结果。
 */
public class PrintDuplicate {

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        HashTable table = new HashTable(arr.length);

        for(int i=0; i<arr.length; i++){
            table.add(arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            int length = table.getPositionLength(i);
            if(length > 1){
                System.out.println(i);
            }
        }
    }
}
