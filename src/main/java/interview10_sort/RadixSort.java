package interview10_sort;

/**
 * 基数排序：每次都利用一个10*10的二维数组来记录要排序数的情况。用几个二维数组取决于最大数的位数（个位、十位、百位……）
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {101,201,122,0,235,99,0,7};
        radix(arr);
        ArrayUtil.listArray(arr);
    }

    public static void radix(int[] arr){
        if(arr.length == 0){
            return;
        }

        int max = 0;
        for(int a : arr){
            if(max < a){
                max = a;
            }
        }

        int radixCount[] = new int[10];
        int radixArr[][] = new int[10][10];
        for(int a : arr){
            radixArr[a%10][radixCount[a%10]] = a;
            radixCount[a%10]++;
        }

        int temp = max;
        int count = 0;
        while (temp%10 > 0){
            temp = temp/10;
            int tempCount[] = new int[10];
            int tempArr[][] = new int[10][10];
            for(int i = 0; i <radixArr.length; i++){
                for(int j = 0; j <radixCount[i]; j++){
                    int val = radixArr[i][j];
                    int position = val;
                    for(int k=0; k<count;k++){
                        position = position/10;
                    }
                    position = position % 10;
                    tempArr[position][tempCount[position]] = val;
                    tempCount[position] ++;
                }
            }
            count ++;
            radixArr = tempArr;
            radixCount = tempCount;
        }

        int index = 0;
        for(int i = 0; i <radixArr.length; i++){
            for(int j = 0; j <radixCount[i]; j++){
                arr[index] = radixArr[i][j];
                index++;
            }
        }
    }
}
