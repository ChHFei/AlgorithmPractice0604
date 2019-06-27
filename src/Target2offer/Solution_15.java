package Target2offer;
// 题目15 二进制中1的个数
// 题目描述:
//          输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。


public class Solution_15 {

    // 方法1(常规解法) 用1进行与操作，将1左移继续与操作。
    public int NumberOf1(int n){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((flag & n) !=0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    // 方法2 （惊喜解法） 思路 把一个数减去1 再与原整数做与运算，会把该整数最右边的1变成0。
    public int NumberOf1_2(int n){
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n-1);
        }
        return count;
    }



    public static void main(String[] args) {
        Solution_15 solution_15 = new Solution_15();
        System.out.println(solution_15.NumberOf1(9));
        System.out.println(solution_15.NumberOf1(12));
        System.out.println(solution_15.NumberOf1(1));
        System.out.println(solution_15.NumberOf1(5));
        System.out.println("方法2");
        System.out.println(solution_15.NumberOf1_2(9));
        System.out.println(solution_15.NumberOf1_2(12));
        System.out.println(solution_15.NumberOf1_2(1));
        System.out.println(solution_15.NumberOf1_2(5));

    }

}
