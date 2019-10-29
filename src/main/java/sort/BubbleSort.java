package sort;

/**
 * 冒泡排序:每相邻两个元素比较，一遍一遍的比较冒泡，直到冒泡一轮后没有发生元素调换则排序结束。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {1,5,9,6,8,4,2,6,3};
        bubble(arr);
        ArrayUtil.listArray(arr);
    }

    public static void bubble(int arr[]){
        boolean flag = false;
        for(int j=0 ; j < arr.length; j++){
            for(int i=0 ; i < arr.length-1; i++){
                if(arr[i+1] < arr[i]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
