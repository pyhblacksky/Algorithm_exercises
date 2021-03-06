package LeetCodeRace.Contest142;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/6/23 19:50
 * @Version: 1.0
 * @Function:
 * @Description:
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 *
 * 这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了你的第 i 次行程信息：
 *
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 *
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 示例 3：
 *
 * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
 * 输出：true
 * 示例 4：
 *
 * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * 输出：true
 *
 *
 * 提示：
 *
 * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */
public class Solution1094_拼车 {

    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            if(trips == null || trips.length == 0 || capacity == 0){
                return false;
            }

            //按照出发地点排序
            Arrays.sort(trips, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            //第一批人就装不下，false
            if(trips[0][0] > capacity){
                return false;
            }

            capacity -= trips[0][0];
            Set<Integer> set = new HashSet<>();//当前车上存在的人的组数
            set.add(0);
            for(int i = 1; i < trips.length; i++){
                capacity -= trips[i][0];
                if(capacity < 0 && set.size() > 0){
                    List<Integer> list = new ArrayList<>();
                    //判断是否有下车
                    for(int index : set){
                        if(trips[i][1] >= trips[index][2]){
                            capacity += trips[index][0];
                            list.add(index);
                        }
                    }

                    //下车
                    for(int index : list){
                        set.remove(index);
                    }
                }
                //依然为负，则返回false
                if(capacity < 0){
                    return false;
                }
                set.add(i);//上车
            }

            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] trips = {{3,2,8},{4,4,6},{10,8,9}};
        boolean b = solution.carPooling(trips, 11);
        System.out.println(b);
    }

}
