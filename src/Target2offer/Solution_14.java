package Target2offer;
import java.lang.Math;


// 题目14 剪绳子
//      给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1,且m>1），每段绳子的长度记为k[0],k[1], ... ,k[m]。
//      请问k[0]*k[1]*...*k[m]可能的最大乘积是多少?
//      例如，当绳子的长度是8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18


public class Solution_14 {
    // 方法1 动态规划，从下往上的顺序先计算小问题的最优解并存储下来，再以此为基础求最优解
    public int maxProductAfterCutting(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        // 长度为i的绳子
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 把长度为i的绳子从j处切开
            for (int j = 1; j <= i / 2; ++j) {
                int temp = product[j] * product[i - j];
                max = max < temp ? temp : max;
                product[i] = max;
            }
        }
        return product[length];
    }

    // 方法2 贪心算法。
    // 策略：
    //      当n>=5时，尽可能多地剪长度为3的绳子；
    //      当剩下的绳子为4时，把绳子剪成两段长度为2的绳子
    public int maxProductAfterCutting2 (int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        // 尽可能多的剪长度为3的段。
        int timeOfthree = length/3 ;
        if (length%3 == 0)
            return (int)Math.pow(3,timeOfthree);
        if (length%3 == 1)
            return (int)Math.pow(3,timeOfthree-1)*4;
        if (length%3 == 2)
            return (int)Math.pow(3,timeOfthree)*2;
        return 0;
    }




    public static void main(String[] args) {
        Solution_14 solution_14 = new Solution_14();
        // 动态规划 测试
        System.out.println(solution_14.maxProductAfterCutting(8));
        System.out.println(solution_14.maxProductAfterCutting(7));
        System.out.println(solution_14.maxProductAfterCutting(9));

        // 贪心策略 测试
        System.out.println(solution_14.maxProductAfterCutting2(8));
        System.out.println(solution_14.maxProductAfterCutting2(7));
        System.out.println(solution_14.maxProductAfterCutting2(9));


    }
}
