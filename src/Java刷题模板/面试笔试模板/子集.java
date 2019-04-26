package Java刷题模板.面试笔试模板;

import java.io.PrintStream;

/**
 * @Author: pyh
 * @Date: 2019/4/24 16:48
 * @Version: 1.0
 * @Function:
 * @Description:
 * leetcode 上  78题
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 *  二进制枚举法
 *  讲解 ： https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/InterviewAlgorithm.md
 */
public class 子集 {

    static PrintStream out = System.out;

    //打印 0~n-1 的所有子集
    //按照递增顺序构造子集，防止子集重复
    static void print_subset(int[] arr, int cur, int n){
        for(int i = 0; i < cur; i++){
            out.print(arr[i] + " ");
        }
        out.println();
        int s = cur != 0 ? arr[cur-1] + 1 : 0;  //确定当前元素的最小可能值
        for(int i = s; i < n; i++){
            arr[cur] = i;
            print_subset(arr, cur+1, n);
        }
    }

    //1~n的所有子集：位向量法
    static void print_subset(int cur, boolean[] bits, int n){
        if(cur == n+1){
            for(int i = 0; i < cur; i++){
                if(bits[i]){
                    out.print(i + " ");
                }
            }
            out.println();
            return;
        }

        bits[cur] = true;
        print_subset(cur+1, bits, n);
        bits[cur] = false;
        print_subset(cur+1, bits, n);
    }

    //0~n-1的所有子集；二进制法枚举0~n-1的所有子集
    static void print_subset(int n){
        for(int mask = 0; mask < (1 << n); mask++){
            for(int i = 0; i < n; i++){
                if(((mask >> i) & 1) == 1){
                    out.print(i + " ");
                }
            }
            out.println();
        }
    }


    //测试方法
    public static void main(String[] args){
        int n = 3;
        //0~n-1 子集
        print_subset(new int[n], 0, n);
        out.println("--------------------------");

        //1~n 子集
        print_subset(1, new boolean[n+1], n);
        out.println("--------------------------");

        //0~n-1的子集
        print_subset(n);

    }
}
