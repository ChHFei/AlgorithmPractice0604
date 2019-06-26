package Target2offer;
import java.lang.String;
// 题目12：矩阵中的路径
// 题目描述：
//        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//        路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//        如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
//        例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
//        因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子

// 0. 将一维数组，建立成矩阵。 建立标志数组，初始化为false
// 1. 从任意一个格子开始 进入judge
// 2. 递归终止条件 ： 越界、不等于对应值、已经走过。直接false
// 3. 若pathlen到了str的最后一位说明匹配成功。
// 4. 寻找周围四个格子是否符合条件，只要有1个符合就继续走。
// 5. 不成功还原标志位


public class Solution_12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 将1维数组建立成矩阵
        char[][] buildedMaxtrix = buildMaxtrix(matrix,rows,cols);
        // 建立标志数组(boolean型数组默认值为false)
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i<rows; i++)
            for (int j = 0; j<cols ; j++)
                if (judge(str,buildedMaxtrix,marked,i,j,0,rows,cols))
                    return true;
        return false;
    }

    // 判断四周格子是否符合条件
    public boolean judge(char[] str, char[][] buildedMaxtrix, boolean[][] marked, int i ,int j , int pathlen, int rows, int cols){
        //若字符串已经到末尾
        if (pathlen == str.length)
            return true;
        // 终止条件
        if (i<0 || i>=rows || j<0 || j>=cols || buildedMaxtrix[i][j] != str[pathlen] || marked[i][j])
            return false;
        marked[i][j] = true;
        // 判断四周格子是否符合条件
        if (judge(str,buildedMaxtrix,marked,i+1,j,pathlen+1,rows,cols) ||
                judge(str,buildedMaxtrix,marked,i-1,j,pathlen+1,rows,cols) ||
                judge(str,buildedMaxtrix,marked,i,j+1,pathlen+1,rows,cols) ||
                judge(str,buildedMaxtrix,marked,i,j-1,pathlen+1,rows,cols))
            return true;

        //到这还没走通，说明这条路走不通
        marked[i][j] = false;
        return false;
    }

    // 将一维数组转化为二维矩阵
    public char[][] buildMaxtrix(char[] str, int rows, int cols){
        char[][] matrix = new char[rows][cols];
        for (int i = 0 , x = 0; i<rows ; i++)
            for (int j = 0; j<cols ; j++){
                matrix[i][j] = str[x++];
            }
        return matrix;
    }

    public static void main(String[] args) {
        char[] maxtrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'A','B','C','C','E','D'};
        Solution_12 solution_12 = new Solution_12();
        System.out.println(solution_12.hasPath(maxtrix,3,4,str));
    }

}
