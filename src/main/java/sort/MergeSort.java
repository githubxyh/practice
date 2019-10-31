package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {9,78,34,45,2,28,45,90,65,28,3};
        ArrayUtil.listArray(arr);
    }

    private static int[] merge(int[] ints,int start,int end){
        if (start == end){
            return new int[] {ints[start]};
        }
        int middle = start + (end-start)/2;
        int[] leftInt = merge(ints,start,middle);
        int[] rightInt = merge(ints,middle+1,end);
        int intsN[] = new int[leftInt.length+rightInt.length];
        int m = 0;
        int i = 0;
        int j = 0;
        while (i<leftInt.length && j<rightInt.length){
            intsN[m++] = leftInt[i]<rightInt[j]?leftInt[i++]:rightInt[j++];
        }
        while (i<leftInt.length){
            intsN[m++] = leftInt[i++];
        }
        while (j<rightInt.length){
            intsN[m++] = rightInt[j++];
        }
        return intsN;
    }

}
