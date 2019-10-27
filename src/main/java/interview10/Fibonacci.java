package interview10;

/**
 * 求斐波那契数列的第n项。
 * 写一个函数，输入n，求斐波那契数列的第n项。
 */
public class Fibonacci {

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();

        System.out.println(getFibonacci(40));
        //System.out.println(getFibonacci2(50));

        long endTime=System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    //递归实现：时间复杂度O(2的n次方)。如果n特别大，时间就会特别慢。
    public static long getFibonacci(long n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return getFibonacci(n-1) + getFibonacci(n-2);
        }
    }

    /**
     * 非递归实现。
     * 上面的递归实现过程：求f(10)得先求f(9)和f(8)，想求f(9)得先求f(8)和f(7)……中间有很多重复计算，
     * 且这些计算会随着n的增大而急剧增大。时间复杂度是以n的指数的方式递增的。
     * 解决办法是避免重复计算，把已经得到的数列的中间项保存起来。
     * 这种方式计算的时间复杂度是O(n)
     * @param n
     * @return
     */
    public static long getFibonacci2(int n){
        int[] result = {0,1};

        if(n < 2){
            return result[n];
        }

        long minusOne = 1;
        long minusTwo = 1;
        long fibN = 0;

        for(int i=2; i < n; i++){
            fibN = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = fibN;
        }

        return fibN;
    }
}
