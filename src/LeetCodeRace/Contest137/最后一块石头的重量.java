package LeetCodeRace.Contest137;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/5/19 10:31
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class 最后一块石头的重量 {

    //堆
    public static int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }

        Queue<Integer> pq = new PriorityQueue<>(stones.length, myComparator);
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int r1 = pq.poll();
            int r2 = 0;
            if(!pq.isEmpty()){
                r2 = pq.poll();
            }
            if(r1 != r2){
                pq.add(r1-r2);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static Comparator<Integer> myComparator = new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public static void main(String[] args){
        lastStoneWeight(new int[]{5,6,1, 10,10});
    }

}
