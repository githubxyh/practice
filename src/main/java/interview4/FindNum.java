package interview4;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序，每一列都按照从上到下递增饿顺序。
 * 完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否含有该数字。
 */
public class FindNum {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0] = new int[]{1,3,7,9};
        arr[1] = new int[]{2,5,8,10};
        arr[2] = new int[]{4,6,11,15};
        arr[3] = new int[]{6,13,16,19};

        int num = 30;
        int i = 0;
        int j = 3;
        String result = "不存在";

        while (i < arr.length && j > 0){
            if(num == arr[i][j]){
                result = "存在";
                break;
            }else if(num > arr[i][j]){
                //i = i+1;
                ++i;
            }else {
                //j = j-1;
                --j;
            }
        }
        System.out.println("查找结果是:" + result);
    }
}
