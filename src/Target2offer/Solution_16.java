package Target2offer;
//
//题目描述
//        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

// 0 健壮性考虑，exponent为0和负数。e为负数是，base为0无意义。
// 1 优化power传统累乘方法。
// 2 0的0无意义 输出0或1都可以接受
// 3 设置全局变量，标志是否出错

// 对PowerWithUnsignedExponent 的优化：
//      power(a,n)  = power(a,n/2) * power(a,n/2)                ----n为偶数
//                  = power(a,(n-1)/2) * power(a,(n-1)/2) * a    -----n为奇数

public class Solution_16 {
    private boolean invalidInput = false;
    public double Power(double base, int exponent) {
        invalidInput = false;
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            return PowerWithUnsignedExponent(base,exponent);
        }else {
            if (base == 0){
                invalidInput = true;
                System.out.println("输入无意义");
                return 0.0;
            }
            return 1/PowerWithUnsignedExponent(base,-exponent);
        }
    }

    // 传统累乘计算次方
    private double PowerWithUnsignedExponent_old(double base, int exponent){
        double result = 1.0;
        for (int i=1;i<=exponent;i++){
            result = result * base;
        }
        return result;
    }

    private double PowerWithUnsignedExponent(double base,int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = PowerWithUnsignedExponent(base,exponent>>1); // 右移1位，代表除以2
        result *= result;
        if ((exponent & 1) == 1)  // 与1做与运算 判断是否为奇数
            result *= base;
        return result;
    }


    public static void main(String[] args) {
        Solution_16 solution_16 = new Solution_16();
        System.out.println("测试2的3  "+solution_16.Power(2,3));
        System.out.println("测试2的0  "+solution_16.Power(2,0));
        System.out.println("测试-2的5  "+solution_16.Power(-2,5));
        System.out.println("测试2的-3  "+solution_16.Power(2,-3));
        System.out.println("测试0的-3  "+solution_16.Power(0,-3));
        System.out.println("测试-1的0  "+solution_16.Power(-1,0));
    }

}
