package part3;
/**
 * 找出数组（数组的每一个值都小于数组的长度）中的重复数据。
 * 例如：数组{2,3,1,0,2,5,3}对应的输出结果是2或3。
 *
 * 第二种解法：
 *
 */
public class PrintDuplicate2 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};

        for(int i=0; i < arr.length; i++){
            //只要数组的值不等于该位置。
            while(i != arr[i]){
                //***经过替换以后，位置i的值，与1以 位置i的值 为索引的位置值相等时，说明没有必要再替换，该值也就是重复值。
                if(arr[arr[i]] == arr[i]){
                    System.out.println(arr[i]);
                    break;
                }
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
