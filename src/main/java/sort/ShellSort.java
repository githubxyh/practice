package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[] = {235,12,9,66,45,4,23,7,3,10,6,5,34,99,88};
        ArrayUtil.listArray(arr);
        System.out.println();
        shell(arr);
        //InsertSort.insert(arr);
        //ArrayUtil.listArray(arr);
    }

    public static void shell(int[] arr){
        int step = arr.length/2;
        int start = 0;

        while (step > 1){
            int index = start + step;
            while (index < arr.length && index > 0){
                for(int i=0; i< index/step; i++){
                    int index1 = index - step * i;
                    int index2 = start - step * i;
                    if(arr[index1] < arr[index2]){
                        int temp = arr[index1];
                        arr[index1] = arr[index2];
                        arr[index2] = temp;
                    }
                }
                start++;
                index = start + step;
            }
            ArrayUtil.listArray(arr);
            System.out.println();
            step = step/2;
        }
    }

    private static int[] getSort(int[] ints){

        int gap = ints.length;
        while (gap > 1){
            gap = gap/2;
            for (int i = 0;i < gap;i++){
                for (int j = i+gap;j < ints.length;j += gap){
                    if (ints[j-gap]>ints[j]){
                        Boolean flag = true;
                        for (int a = i;a < j;a += gap){
                            if (ints[a]>ints[j]){
                                int temp = ints[j];
                                for (int b = j;b>a;b -= gap){
                                    ints[b] = ints[b-gap];
                                }
                                ints[a] = temp;
                                flag = false;
                                break;
                            }
                        }
                        if (flag){
                            int temp1 = ints[j];
                            ints[j] = ints[j-gap];
                            ints[j-gap] = temp1;
                        }
                    }
                }
            }
        }

        return ints;
    }
}
