package Target2offer;
// 题目10 斐波那契数列
// 题目二 青蛙跳台阶
//         一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
//         求该青蛙跳上一个n级台阶总共有多少种方法。

public class Solution_10_2 {
    public int WaysOfJump(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return WaysOfJump(n - 1) + WaysOfJump(n - 2);
    }

    public static void main(String[] args) {
        Solution_10_2 solution_10_2 = new Solution_10_2();
        for (int i = 1; i <= 10; i++) {
            System.out.println("跳" + i + "级台阶，有方法数：" + solution_10_2.WaysOfJump(i));
        }
    }

}
