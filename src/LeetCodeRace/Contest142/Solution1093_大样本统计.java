package LeetCodeRace.Contest142;

/**
 * @Author: pyh
 * @Date: 2019/6/23 20:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
 *
 * 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
 *
 * 我们先来回顾一下中位数的知识：
 *
 * 如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
 * 如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
 *
 *
 * 示例 1：
 *
 * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
 * 示例 2：
 *
 * 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
 *
 *
 * 提示：
 *
 * count.length == 256
 * 1 <= sum(count) <= 10^9
 * 计数表示的众数是唯一的
 * 答案与真实值误差在 10^-5 以内就会被视为正确答案
 */
public class Solution1093_大样本统计 {

    static class Solution {
        public double[] sampleStats(int[] count) {
            if(count == null){
                return null;
            }

            //最小值、最大值、平均值、中位数和众数
            double[] res = new double[5];
            int maxCount = 0;//众数
            int maxCountIndex = 0;
            int n = 0;
            int minNum = Integer.MIN_VALUE;//最小值
            int maxNum = 0;//最大值
            double sum = 0;//计算和
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    n += count[i];
                    if(minNum == Integer.MIN_VALUE){
                        minNum = i;
                    }
                    maxNum = Math.max(maxNum, i);
                    sum += count[i]*i;

                    if(count[i] > maxCount){
                        maxCount = count[i];
                        maxCountIndex = i;
                    }
                }
            }

            res[0] = minNum;
            res[1] = maxNum;
            res[2] = (double)sum / n;
            res[4] = maxCountIndex;

            //求中位数
            int idx = -1;
            int midNum = 0;
            int r = n / 2, l = (n + 1) / 2 - 1;
            for(int i = 0; i < count.length; i++){
                idx += count[i];
                if(l == r){
                    if(idx >= l){
                        midNum += 2 * i;
                        break;
                    }
                } else{
                    if(idx >= r && midNum == 0){
                        midNum += 2 * i;
                        break;
                    }else if(idx >= r && midNum != 0){
                        midNum += i;
                        break;
                    }else if(idx >= l){
                        midNum += i;
                    }
                }
            }
            res[3] = midNum/2.0;

            return res;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

    }

}
