package interview10_sort;

/**
 * 计数排序：创建一个长度为（最大值-最小值）长度的数组newArr，遍历要排序数组，将每个元素都减去最小值，
 * 得到的值作为索引，索引到newArr位置，将该位置加1。最后遍历新数组newArr，将newArr中不为0的索引位置加上最小值就是最终的值。且按照这个顺序取值后就是一个有序数组。
 */
public class CountSort {
    public static void main(String[] args) {
        int arr[] = {9,78,34,45,2,28,3,45,90,65,28,3};
        count(arr);
        ArrayUtil.listArray(arr);
    }

    public static void count(int arr[]){
        if(arr.length == 0){
            return;
        }
        int min = arr[0];
        int max = 0;
        for(int a : arr){
            if(min >= a)min = a;
            if(max < a) max = a;
        }

        int[] newInt = new int[(max - min)+1];
        for(int a : arr){
            newInt[(a-min)] ++;
        }

        int count = 0;
        for(int j=0; j<newInt.length; j++){
            if(newInt[j] != 0 && count < newInt.length){
                for (int k=0; k<newInt[j]; k++){
                    arr[count] = j+min;
                    count ++;
                }
            }
        }
    }
}
