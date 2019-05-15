package 牛客模拟笔试._2019_5;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/15 20:31
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] area = new char[n][n];

        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < n; j++){
                area[i][j] = str.charAt(j);
            }
        }

        int minLen = getMin(area);
        System.out.println(minLen);
    }

    public static int getMin(char[][] area){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[i].length; j++){
                if(area[i][j] == '@'){
                    min = Math.min(step(area, i, j), min);
                }
            }
        }
        return min;
    }

    static int step(char[][] area, int i, int j){

        if(i < 0 || i >= area.length || j < 0 || j >= area[i].length){
            return 0;
        }

        if(area[i][j] == '*'){
            return 1;
        }

        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;

        if(area[i-1][j] == '.'){
            up += step(area, i-1, j);
        }

        if(area[i-1][j] == '.'){
            down += step(area, i+1, j);
        }

        if(area[i-1][j] == '.'){
            left += step(area, i, j-1);
        }

        if(area[i-1][j] == '.'){
            right += step(area, i, j+1);
        }

        return Math.min(right, Math.min(left,Math.min(up,down)));
    }


}
