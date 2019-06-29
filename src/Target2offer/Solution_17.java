package Target2offer;

// 题目17 打印从1到最大的n位数
//      题目描述：输入数字n，按顺序打印出从1到最大的n位十进制数。
//      比如输入3，则打印出1、2、3一直到最大的3位数999。

// n的范围
// 考虑方法 ： 字符串模拟加减法(暂未实现)  字符数组全排列回溯法(已实现)   BigInteger(已实现)

import java.math.BigInteger;

public class Solution_17 {

    // 方法1 使用BigInteger类
    public void printNumber1(int n){
        if (n <= 0) {
            return;
        }
        StringBuilder nToStrBuild = new StringBuilder() ;
        for (int i = 1;i<=n; i++){
            //nToStr = nToStr + "9";
            // 经常修改所以使用StringBuilder类。使用+会产生一个新的String实例，在内存中创建新的字符串对象。重复修改增加开销。
            nToStrBuild.append('9');
        }
        BigInteger bigN = new BigInteger(nToStrBuild.toString());
        BigInteger NumOne = new BigInteger("1");
        BigInteger CurNum = new BigInteger("1");
        while (CurNum.compareTo(bigN)<=0){                  //compareTo 相等返回0、小于返回负、大于返回正
            System.out.println(CurNum);
            CurNum = CurNum.add(NumOne);
        }
    }

    // 方法2 使用字符全排列
    public void printNumber2(int n){
        if (n <= 0)
            return;
        char[] number = new char[n];
        printNumber2Backing(number,0);
    }
    // 把number[]的每index位进行0~9的全排列。 最后一位排列好后，直接打印。
    private void printNumber2Backing(char[] number, int index){
        if (index == number.length){    // 已经是排列满的 直接打印
            printCharArray(number);
            return;
        }
        for (int i = 0;i<10;i++){       // 回溯法 进行全排列
            number[index] = (char) ('0'+i);
            printNumber2Backing(number,index+1);
        }


    }

    // 将字符数组打印，并去掉左侧0。
    private void printCharArray (char[] number){
        int index = 0;
        while (index < number.length && number[index] == '0'){   // 去掉左边的0
            index++;
        }
        while (index < number.length){
            System.out.print(number[index++]);
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Solution_17 solution_17 = new Solution_17();
        solution_17.printNumber1(2);
        //solution_17.printNumber2(2);
    }
}
