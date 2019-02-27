package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/2/23 14:41
 * @Version 1.0
 * @Function:   120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution120_三角形最小路径和 {

    //DP解法
    public static int minimumTotal(List<List<Integer>> list){
        if(list == null || list.get(0) == null){
            return 0;
        }

        //最后一层是初始情况
        for(int i = list.size()-2; i >= 0; i--){
            for(int j = list.get(i).size()-1; j >= 0; j--){
                int min = Math.min(list.get(i+1).get(j), list.get(i+1).get(j+1));//求出两个之间的最小者
                min += list.get(i).get(j);//加上自身
                list.get(i).set(j, min);//更新三角形
            }
        }

        return list.get(0).get(0);
    }
    //递归解法 ,超时
    public static int minimumTotal1(List<List<Integer>> list){
        if(list == null || list.get(0) == null){
            return 0;
        }
        int[] res = {Integer.MAX_VALUE};
        _dfs(list, 0, 0, "", 0, res);
        return res[0];
    }

    private static void _dfs(List<List<Integer>> list, int i, int j, String path, int sum, int[] res) {
        //terminator
        if(i == list.size()-1){
            sum += list.get(i).get(j);
            //path += list.get(i).get(j) + " # ";
            //System.out.println(path + " : with sum " + sum);
            res[0] = Math.min(res[0], sum);
            return;
        }
        //process
        //path += list.get(i).get(j) + "->";
        sum += list.get(i).get(j);

        //drill down
        _dfs(list, i+1, j, path, sum, res);
        _dfs(list, i+1, j+1, path, sum, res);

        //clear states
        return;
    }

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(list));
    }

}
