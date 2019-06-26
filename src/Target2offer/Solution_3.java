package Target2offer;
//题目3：数组中的重复数字
//题目描述
//        在一个长度为n的数组里的所有数字都在0到n-1的范围内。
//        数组中某些数字是重复的，但不知道有几个数字是重复的。
//        也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
//        例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3
//        要求时间复杂度 O(N)，空间复杂度 O(1)。


// 思路：对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。


import java.sql.SQLOutput;

public class Solution_3 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0){
            return  false;
        }

        for (int i = 0; i <= length - 1; i++) {
            while (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];

                    return true;
                }else {
                    //swap number[i] number[number[i]]
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int data[] = {2,3,1,0,2,5,3};
        int data2[] = {0,3,2,1,4,5,6};
        int dataLength = 7;
        int duplication[] = new int[1];
        Solution_3 solution_3 = new Solution_3();
        if (solution_3.duplicate(data2, dataLength, duplication)){
            System.out.println("重复数字是" + duplication[0]);
        }else {
            System.out.println("没有重复");
        }
    }
}
