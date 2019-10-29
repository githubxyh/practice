package sort;

/**
 * 插入排序：基准位置从1开始，在基准位置右边的第一个元素，找到该元素应该在基准位置左边的索引，将该元素放在该数组的索引，并将元素整体向右移，且每执行一次，基准位置+1
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {1,12,9,66,45,4,23,7,3};
        insert(arr);
        ArrayUtil.listArray(arr);
    }

    public static void insert(int[] arr){
        int pivot = 1;
        for(int i=pivot; i < arr.length; i++){
            for(int j = 0; j < pivot; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    for(int k=pivot; k > j; k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = temp;
                }
            }
            pivot++ ;
        }
    }
}
