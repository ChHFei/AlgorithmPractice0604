package Target2offer;

// 题目13：机器人的运动范围
//        题目描述：
//        地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
//        每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
//        例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//        但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
//        请问该机器人能够达到多少个格子？

//  0 建立辅助标志矩阵，初始值为false
//  1 递归终止条件：越界，数位之和大于格子大于k

public class Solution_13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold<0 || rows<=0 || cols<=0)
            return 0;
        // 建立标志数组
        boolean[][] marked = new boolean[rows][cols] ;
        int count = movingCountBacking(threshold,rows,cols,0,0,marked);
        return count;
    }

    // 回溯递归函数
    public int movingCountBacking(int threshold,int rows, int cols, int i, int j ,boolean[][] marked){
        int count = 0;
        //判断当前节点是否符合标准,若符合，计数并标志。递归上下左右。
        if (judgeCurNode(threshold,rows,cols,i,j,marked)){
            marked[i][j] = true;
            count = 1 + movingCountBacking(threshold,rows,cols,i+1,j,marked)
                    + movingCountBacking(threshold,rows,cols,i,j+1,marked)
                    + movingCountBacking(threshold,rows,cols,i-1,j,marked)
                    + movingCountBacking(threshold,rows,cols,i,j-1,marked);
        }
        return count;
    }

    // 判断当前点，是否符合标准。
    public boolean judgeCurNode (int threshold, int rows, int cols, int i, int j, boolean[][] marked){
        if (i<rows && j<cols && i>=0 && j>=0 && (sum(i)+sum(j)) <= threshold && !marked[i][j])
            return true;
        return false;
    }

    // 计算数位之和
    public int sum(int num){
        int result = 0;
        while(num!= 0){
            result += num%10 ;
            num = num/10;
        }
        return  result;
    }

    public static void main(String[] args) {
        Solution_13 solution_13 = new Solution_13();
        System.out.println(solution_13.movingCount(2,4,4));
    }



}
