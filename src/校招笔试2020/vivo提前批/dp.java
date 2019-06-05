package 校招笔试2020.vivo提前批;

/**
 * @Author:pyh
 * @Date:2019/6/4 20:54
 * @Description:
 */

public class dp {

    //背包问题
    /**
     * 1000
     * 200,600,300,100,180,450
     * 6,10,3,4,5,8
     * */
    public static void main(String[] args){
        int[] arrA = new int[]{200,400,600,100,180,450};
        int[] arrB = new int[]{6,10,3,4,5,8};
        solution(1000, arrA, arrB);
    }

    //热度问题
    public static void solution(int total, int[] arrA, int[] arrB){
        int[][] dp = new int[arrA.length + 1][total+1];
        for(int i = arrA.length - 1; i >= 0; i--){
            for(int j = 0; j <= total; j++){
                dp[i][j] = j + arrA[i] > total ? dp[i+1][j] : Math.max(dp[i+1][j], dp[i+1][j + arrA[i]] + arrB[i]);
            }
        }
        System.out.println(dp[0][0]);
    }

}
