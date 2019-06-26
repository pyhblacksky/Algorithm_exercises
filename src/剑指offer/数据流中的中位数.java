package 剑指offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: pyh
 * @Date: 2019/2/20 11:32
 * @Version 1.0
 * @Function:
 *      如何得到一个数据流中的中位数？
 *      如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *      我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 */
public class 数据流中的中位数 {
    //传统方法
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert1(Integer num) {
        list.add(num);
    }

    public Double GetMedian1() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return -1;
                } else{
                    return 1;
                }
            }
        });
        if(list.size() % 2 != 0){
            return (double) list.get(list.size()/2);
        } else{
            int num = list.get(list.size()/2) + list.get(list.size()/2-1);
            double res = num /2.0;
            return res;
        }
    }

    //维护两个堆，一个大根堆一个小根堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int count = 0;

    public void Insert(Integer num) {
        count++;
        //总数为偶数时
        if((count % 2) == 0){
            maxHeap.offer(num);
            int filter = maxHeap.poll();
            minHeap.offer(filter);
        } else{
            minHeap.offer(num);
            int filter = minHeap.poll();
            maxHeap.offer(filter);
        }
    }

    public Double GetMedian() {
        double res;
        if((count % 2) == 0){
            res = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else{
            res = maxHeap.peek();
        }
        return res;
    }
}
