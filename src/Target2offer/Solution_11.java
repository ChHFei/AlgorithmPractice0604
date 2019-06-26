package Target2offer;
// 题目11：旋转数组的最小数字
// 题目描述:
//      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//      输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
//      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

import java.util.ArrayList;


public class Solution_11 {

    public int minNumberInRotateArray(int [] array){
        int length = array.length;
        if (length==0){
            return 0;
        }else{
            int left = 0;
            int right = array.length-1;
            int mid = 0 ;
            while (array[left] >= array[right]) {
                if ((right-left) == 1){
                    mid = right;
                    break;
                }
                mid = (left+right)/2;
                // 特例时只能用顺序查找 比如 {01111} 的旋转 {10111} {11101}
                if ((array[left] == array[mid]) && (array[left] == array[right]))
                    return Search(array);
                //
                if (array[mid] >= array[left]){
                    left = mid ;
                }else if (array[mid] <= array[right]){
                    right = mid ;
                }
            }
            return array[mid];
        }
    }
    public int Search(int [] array){
        int result = array[0];
        for (int i=0;i<array.length;i++){
            if (array[i] < result)
                result = array[i];
        }
        return result;
    }
    public static void main (String[] args){
        int[] arrayone = {1,2,2,3,4,5,0};
        int[] arraytwo = {5,6,7,1,3,3,4};
        int[] arraythr = {4};
        Solution_11 solution_11 = new Solution_11();
        System.out.println(solution_11.minNumberInRotateArray(arrayone));
        System.out.println(solution_11.minNumberInRotateArray(arraytwo));
        System.out.println(solution_11.minNumberInRotateArray(arraythr));
    }

}
