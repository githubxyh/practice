package interview10_sort;

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
        for(int pivot=0; pivot < arr.length-1; pivot++){
            //基准位置右边最小值索引
            int minIndex = pivot;
            for(int j = pivot + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //如果最小值索引不是当前基准位置
            if(minIndex != pivot){
                int temp2 = arr[minIndex];
                arr[minIndex] = arr[pivot];
                arr[pivot] = temp2;
            }
        }
    }
}