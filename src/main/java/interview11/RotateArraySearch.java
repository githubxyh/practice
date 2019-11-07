package interview11;

import interview10_sort.ArrayUtil;

/**
 * 旋转数组查找最小值。
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转（其实就是一个排好序的数组，被旋转了一次），输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 *
 * 要求：必须是递增数组的一个旋转。
 */
public class RotateArraySearch {

    public static void main(String[] args) {
        int arr[] = {9,1,2,3,4,5,6,7,8};
        System.out.println(rotate(arr));
    }

    public static int rotate(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while ((end - start) > 1){
            int mid = (end + start)/2;
            if(arr[start] > arr[mid]){
                end = mid;
            }else if(arr[start] < arr[mid]){
                start = mid;
            }else{
                return arr[mid];
            }
        }
        return arr[end];
    }
}
