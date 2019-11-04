package sort;

/**
 * 选择排序：基准位置从位置1开始，从基准位置向右选择出未排序元素中最小元素按照大小顺序放在基准左边，每处理一次后基准位置向右移动一下。
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {235,12,9,66,45,4,23,7,3};
        select(arr);
        ArrayUtil.listArray(arr);
    }

    public static void select(int[] arr){
        int pivot = 0;
        for(int i=pivot; i < arr.length; i++){
            int temp = arr[pivot];
            int index = pivot;

            for(int j=pivot; j < arr.length; j++){
                if(temp > arr[j]){
                    index = j;
                }
            }

            if(index != pivot){
                int temp2 = arr[index];
                arr[index] = arr[pivot];
                arr[pivot] = temp2;
            }
            pivot++;
        }
    }
}
