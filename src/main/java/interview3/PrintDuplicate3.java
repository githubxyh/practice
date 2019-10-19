package interview3;

/**
 * 不修改数组找出数组中的重复数字。
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围。数组中某些数字重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次。找出数组中任意一个重复的数字。
 * 例如：数组{2,3,1,0,2,5,3}对应的输出结果是2或3。
 */
public class PrintDuplicate3 {

    public static void main(String[] args) {
        int[] arr = {4,1,5,2,3,4,6,7};
        int start = 1;
        int end = arr.length - 1;

        while (end >= start){
            int middle = ((end - start)>>2) + start;
            int count = getCountFromArr(arr,start,middle);
            System.out.println("count的值:" + count);

            if(end == start){
                /**
                 * 这里原来是:
                 * if(count > (midData - startData + 1)){
                 * 看完书上代码后优，如果end == start时，midData - startData=0
                 */
                if(count > 1){
                    System.out.println(start);
                }
                break;
            }

            if(count > (middle - start + 1)){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
    }

    /**
     * 获取startData-endData之间的数字，在数组arr中出现的次数总和。
     * @param arr
     * @param startData
     * @param endData
     * @return
     */
    private static int getCountFromArr(int arr[],int startData,int endData){
        if(arr.length == 0){
            return 0;
        }
        int count = 0;
        //数组中的元素出现在start-end范围内的次数
        for(int i=0; i<arr.length; i++){
            /**
             * 这里我的实现是：
             * for(int j=startData; j < endData+1; j++){if(j == arr[i]){count++;}}
             * 看完书上代码后优化为如下:
             */
            if(arr[i] >= startData && arr[i] <= endData){
                ++count;
            }
        }
        return count;
    }
}
