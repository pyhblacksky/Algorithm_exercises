package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/20 15:31
 * @Version 1.0
 * @Function:
 *      地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 *      每一次只能向左，右，上，下四个方向移动一格，
 *      但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *      例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 */
public class 机器人的运动范围 {

    public int movingCount(int threshold, int rows, int cols) {
        if(threshold <= 0 || rows <= 0 || cols <= 0){
            return 0;
        }

        boolean[][] judge = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                judge[i][j] = true;
            }
        }
        return move(threshold, 0, 0, judge);
    }
    public int move(int threshold, int rows, int cols, boolean[][] judge){

        if(rows < 0 || rows >= judge.length || cols < 0 || cols >= judge[0].length
                || !judge[rows][cols] || bits(rows) + bits(cols) > threshold){
            return 0;
        }

        //走过的不能再走
        judge[rows][cols] = false;
        int up = move(threshold, rows - 1, cols, judge) ;
        int down = move(threshold, rows + 1, cols, judge);
        int left = move(threshold, rows, cols - 1, judge);
        int right = move(threshold, rows, cols + 1, judge);
        return up + down + left + right + 1;
    }
    private int bits(int num){
        String r = String.valueOf(num);
        int count = 0;
        for(int i = 0; i < r.length(); i++){
            count += r.charAt(i) - '0';
        }
        return count;
    }

    public static void main(String[] args){
        //机器人的运动范围 e = new 机器人的运动范围();
        //int a = e.movingCount(5,10,10);
        //System.out.println(a);
        String q = "100";
        String x = "1" + "00";
        System.out.println(q == x);
    }
}
