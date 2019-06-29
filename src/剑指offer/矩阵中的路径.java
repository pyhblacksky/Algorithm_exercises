package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/20 14:38
 * @Version 1.0
 * @Function:
 *      请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *      如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *      例如
 *      a b c e
 *      s f c s
 *      a d e e
 *      这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 *      但是矩阵中不包含"abcb"路径，
 *      因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 */
public class 矩阵中的路径 {

    //走过的路径不能再走
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix.length == 0 && str.length == 0){
            return true;
        }
        if(matrix.length == 0 && str.length != 0){
            return false;
        }
        if(str.length == 0){
            return true;
        }

        //如果没有str第一个字符，返回false
        boolean hasFirst = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i] == str[0]){
                hasFirst = true;
                break;
            }
        }
        if(!hasFirst){
            return false;
        }

        //构造矩阵
        char[][] myMatrix = new char[rows][cols];
        //走过路径标记矩阵,默认全为false，走过的标记为true
        boolean[][] pathMatrix = new boolean[rows][cols];


        //构造矩阵
        int index = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                myMatrix[i][j] = matrix[index++];
            }
        }

        int startX = -1;
        int startY = -1;
        boolean res = false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //在矩阵中的起点
                if(myMatrix[i][j] == str[0]){
                    startX = i;
                    startY = j;
                    pathMatrix[startX][startY] = true;  //标记起点
                    res = help(myMatrix, pathMatrix, startX, startY, str, 0);
                    if(res){
                        return res;
                    } else{
                        pathMatrix[startX][startY] = false;
                    }
                }
            }
        }

        return res;
    }

    //x:当前位置行坐标，y：当前位置列坐标，path：走过的路径矩阵    matrix：当前矩阵
    public boolean help(char[][] matrix, boolean[][] path, int x, int y, char[] str, int index){


        //index到底，说明全相等
        if(index == str.length-1){
            return true;
        }

        //标记位
        boolean mark1 = false;
        boolean mark2 = false;
        boolean mark3 = false;
        boolean mark4 = false;

        //走过的路不能走，先进行标记矩阵判断
        //存在致命缺陷，有顺序
        //向下走
        if(x+1 < matrix.length && !path[x+1][y] && matrix[x+1][y] == str[index+1]){
            //走过了，标记一下
            path[x+1][y] = true;
            mark1 = help(matrix, path, x+1, y, str, index+1);
        }

        //向上走
        if(x-1 >= 0 && !path[x-1][y] && matrix[x-1][y] == str[index+1]){
            path[x-1][y] = true;
            mark2 = help(matrix, path, x-1, y, str, index+1);
        }

        //向右走
        if(y+1 < matrix[x].length && !path[x][y+1] && matrix[x][y+1] == str[index+1]){
            path[x][y+1] = true;
            mark3 = help(matrix, path, x, y+1, str, index+1);
        }

        //向左走
        if(y-1 >= 0 && !path[x][y-1] && matrix[x][y-1] == str[index+1]){
            path[x][y-1] = true;
            mark4 = help(matrix, path, x, y-1, str, index+1);
        }

        //存在路径即为真
        return mark1 || mark2 || mark3 || mark4;
    }

    //简化版
    static class Solution{
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
            boolean[] visited = new boolean[matrix.length];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (search(matrix,rows,cols,i,j,0,str,visited))
                        return true;
                }
            }
            return false;
        }
        public boolean search(char[] matrix,int rows,int cols,int r,int c,int index,char[] str,boolean[] visited){
            if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
                return false;
            if (index == str.length - 1)    return true;
            visited[r * cols + c] = true;
            if (search(matrix,rows,cols,r - 1,c,index + 1,str,visited) ||
                    search(matrix,rows,cols,r,c -1,index + 1,str,visited) ||
                    search(matrix,rows,cols,r + 1,c,index + 1,str,visited) ||
                    search(matrix,rows,cols,r,c + 1,index + 1,str,visited))
                return true;
            visited[r * cols + c] = false;
            return false;
        }
    }


    public static void main(String[] args){
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCB".toCharArray();

    }
}
