package LeetCode;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/4/22 9:03
 * @Version: 1.0
 * @Function:
 * @Description:
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class Solution295_数据流的中位数 {
    //利用ArrayList，效率极低
    class MedianFinder {

        ArrayList<Integer> list;
        int size = 0;
        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
            size++;

        }

        public double findMedian() {
            Collections.sort(list);
            if(size % 2 == 0){
                //偶数
                if(size == 0){
                    return 0;
                }
                int n1 = list.get(size/2);
                int n2 = list.get(size/2 - 1);
                double res = (n1+n2)/2.0;
                return res;
            }

            return list.get(size/2);
        }
    }

    //利用堆，一个最大堆一个最小堆，取堆顶元素,每个堆的大小维持为1
    class MedianFinder1 {

        Queue<Integer> maxHeap;
        Queue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder1() {
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            minHeap = new PriorityQueue<>();//默认小根堆
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size()){
                if(maxHeap.size() == 0){
                    return 0;
                }
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            } else{
                return minHeap.peek();
            }
        }
    }
}
