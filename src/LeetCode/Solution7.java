package LeetCode;
//LeetCode 题目7
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
//          示例 1:
//        输入: 123
//        输出: 321
//          示例 2:
//        输入: -123
//        输出: -321
//          示例 3:
//        输入: 120
//        输出: 21
//        注意:
//        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
//        请根据这个假设，如果反转后整数溢出那么就返回 0。


//***************越界处理问题！？**********************

public class Solution7 {

    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            //判断溢出
            if (((x > 0) && (y > Integer.MAX_VALUE / 10)) || ((x < 0) && (y < Integer.MIN_VALUE / 10))) {
                //System.out.println("溢出了了了");
                return 0;
            }
            y = x % 10 + y * 10;
            x = x / 10;
        }
        return y;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
        System.out.println(Math.pow(2,31));
        System.out.println("越界测试：");
        //System.out.println(solution.reverse(1000000003));
        //System.out.println(solution.reverse(-2147483412));
        System.out.println(solution.reverse(-2147483648));
        System.out.println(-2%10);

    }
}
