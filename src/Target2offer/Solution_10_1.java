package Target2offer;

// 题10 斐波那契数列
// 题目一 求斐波那契数列前n项

// 递归效率很低！大量重复计算！

public class Solution_10_1 {

    // 将计算后的值保存起来 使用循环实现
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int FiOne = 0 ;
        int FiTwo = 1 ;
        int Fibo = 0 ;
        for (int i=2;i<=n;i++){
            Fibo = FiOne+FiTwo ;
            FiOne = FiTwo;
            FiTwo = Fibo;
        }
        return Fibo;
    }

    public static void main(String[] args) {
        Solution_10_1 solution_10_1 = new Solution_10_1();
        for (int i = 0; i <= 10; i++){
            System.out.println("第"+i+"位："+solution_10_1.Fibonacci(i));
        }
    }
}
