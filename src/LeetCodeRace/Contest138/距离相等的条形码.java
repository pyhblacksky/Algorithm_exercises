package LeetCodeRace.Contest138;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/5/26 18:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 *
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 */
public class 距离相等的条形码 {

    //正解2，奇偶填充
    public static int[] r(int[] barcodes){
        if(barcodes == null || barcodes.length <= 1){
            return barcodes;
        }

        //排序按照相同个数来排序
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < barcodes.length; i++){
            if(map.containsKey(barcodes[i])){
                map.put(barcodes[i], map.get(barcodes[i])+1);
            } else{
                map.put(barcodes[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //重写数组，奇偶填充,先把偶数位填充满
        int oddIndex = 1;
        int evenIndex = 0;
        for(int i = 0; i < list.size(); i++){
            Map.Entry<Integer,Integer> entry = list.get(i);
            int val = entry.getKey();
            int count = entry.getValue();
            while(count != 0){
                count--;
                if(evenIndex < barcodes.length){
                    barcodes[evenIndex] = val; //偶
                    evenIndex += 2;
                } else{
                    barcodes[oddIndex] = val; //奇
                    oddIndex += 2;
                }
            }
        }

        return barcodes;
    }

    //正解1
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxBar = barcodes[0];
        int max = 0;
        for (int b : barcodes) {
            int lastCount = count.getOrDefault(b, 0);
            int newCount = lastCount + 1;
            count.put(b, newCount);
            if (newCount > max) {
                max = newCount;
                maxBar = b;
            }
        }
        int n = barcodes.length;
        int[] ret = new int[n];
        int i = 0;
        int j = 0;
        while (max > 0) {
            ret[i] = maxBar;
            max -= 1;
            i += 2;
        }
        Arrays.sort(barcodes);
        while (i < n) {
            if (barcodes[j] == maxBar) {
                j += 1;
                continue;
            }
            ret[i] = barcodes[j];
            j += 1;
            i += 2;
        }
        i = 1;
        while (j < n) {
            if (barcodes[j] == maxBar) {
                j += 1;
                continue;
            }
            ret[i] = barcodes[j];
            j += 1;
            i += 2;
        }
        return ret;
    }


    //错解1
    public static int[] rearrangeBarcodesR1(int[] barcodes) {
        if(barcodes == null || barcodes.length <= 1){
            return barcodes;
        }

        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < barcodes.length; i++){
            set.add(i);
        }
        queue.add(barcodes[0]);
        while(queue.size() < barcodes.length) {
            for (int i = 1; i < barcodes.length; i++) {
                if (barcodes[i] != queue.getFirst() && set.contains(i)) {
                    queue.addFirst(barcodes[i]);
                    set.remove(i);
                    continue;
                }
                if (barcodes[i] != queue.getLast() && set.contains(i)) {
                    queue.addLast(barcodes[i]);
                    set.remove(i);
                    continue;
                }
            }
        }

        for(int i = 0; i < barcodes.length; i++){
            barcodes[i] = queue.poll();
        }

        return barcodes;
    }


    //错解2
    public static int[] rearrangeBarcodesR2(int[] barcodes){
        if(barcodes == null || barcodes.length <= 1){
            return barcodes;
        }

        //排序按照相同个数来排序，相同数量多的放两边，少的放中间
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < barcodes.length; i++){
            if(map.containsKey(barcodes[i])){
                map.put(barcodes[i], map.get(barcodes[i])+1);
            } else{
                map.put(barcodes[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //重写数组
        int startIndex = 0;
        int endIndex = barcodes.length-1;
        boolean flag = true;
        for(int i = 0; i < list.size(); i++){
            Map.Entry<Integer,Integer> entry = list.get(i);
            int val = entry.getKey();
            int count = entry.getValue();
            while(count != 0){
                count--;
                if(flag){
                    barcodes[startIndex++] = val; //头
                } else{
                    barcodes[endIndex--] = val; //尾
                }
            }
            flag = !flag;
        }

        //左右
        int[] res = new int[barcodes.length];
        int L = 0;
        int R = barcodes.length-1;
        int index = 0;
        boolean change = true;
        while(L <= R){
            if(change){
                change = false;
                res[index++] = barcodes[L];
                L++;
            } else{
                res[index++] = barcodes[R];
                R--;
                change = true;
            }
        }

        return res;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {7,7,7,8,5,7,5,5,5,8};
        r(arr);
    }

}
