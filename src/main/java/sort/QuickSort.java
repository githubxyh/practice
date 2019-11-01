package sort;

/**
 * 快速排序：在数组中选取一个基准值（一般选择数组的第一个元素或者最后一个元素），
 * 针对这个基准值，比它小的全部放在基准值左边，比它大的全放在基准值右边。
 * 通过不断缩小数组范围，换基准值完成排序。
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {53,78,34,45,2,9,28,45,90,65,28,3};
        ArrayUtil.listArray(quick(arr,0,arr.length - 1));
    }

    private static int[] quick(int[] arr,int start,int end){
        if(arr == null || arr.length == 0){
            return new int[1];
        }

        int pivot = arr[start];
        int leftIndex = start;
        int rightIndex = end;
        while (leftIndex < rightIndex){
            while ((leftIndex < rightIndex) && arr[leftIndex] < pivot){
                leftIndex ++;
            }
            while ((leftIndex < rightIndex) && arr[rightIndex] > pivot){
                rightIndex--;
            }
            if((leftIndex < rightIndex) && arr[leftIndex] == arr[rightIndex]){
                leftIndex++;
            }else{
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }

        if(leftIndex - 1 > start){
            arr = quick(arr,start,leftIndex -1);
        }

        if(rightIndex + 1 <end){
            arr = quick(arr,rightIndex +1,end);
        }

        return arr;
    }
}
