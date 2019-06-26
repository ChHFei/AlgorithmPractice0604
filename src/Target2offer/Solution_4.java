package Target2offer;
//题目4：二维数组中查找
//        在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

//思路：从走上角走，当前值比target大，向左；当前值比target小，向下。   或从左下角走
public class Solution_4 {
    public Boolean Find(int target, int[][] array) {
        if ((array == null) || (array.length == 0))
            return false;
        //右上角
        int row = 0;
        int col = array[0].length - 1;
        while ((row <= array.length - 1) && (col >= 0)) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testarry[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int testarry2[][] = null;
        int testarry3[][] = {};
        int target = 15;
        Solution_4 solution_4 = new Solution_4();
        System.out.println(solution_4.Find(target, testarry));
        System.out.println(solution_4.Find(target, testarry2));
        System.out.println(solution_4.Find(target, testarry3));
    }
}
