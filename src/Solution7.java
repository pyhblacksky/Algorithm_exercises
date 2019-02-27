import java.util.ArrayList;

public class Solution7 {
    /**
     * 题目：机器人的运动范围
     * 描述：
     *  地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     *  每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     *  方法：
     *
     * */
    public int movingCount(int threshold, int rows, int cols) {
        if(threshold <= 0 || rows <= 0 || cols <= 0){
            return 0;
        }

        boolean[][] flag = new boolean[rows][cols];
        return moving(threshold, rows, cols, flag, 0, 0);
    }
    //flag是标记矩阵，走过的路标记为true，不能再走
    public int moving(int threshold, int rows, int cols, boolean[][] flag, int i, int j){
        if(i < 0 || j < 0 || i >= rows || j >= cols || (getThresholdNum(i)+getThresholdNum(j) > threshold) || flag[i][j]){
            return 0;//无效访问，返回0
        }

        flag[i][j] = true;
        //上下左右四个方向走
        return moving(threshold, rows, cols, flag, i+1, j)
                + moving(threshold, rows, cols, flag, i-1, j)
                + moving(threshold, rows, cols, flag, i, j+1)
                + moving(threshold, rows, cols, flag, i, j-1)
                +1;//走一步，+1
    }

    //获取限制，求每一位上的数相加
    public int getThresholdNum(int i){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    /**
     * 题目：和为S的连续正数序列
     * 描述：
     *  小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     *  但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     *  没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     *  现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     *
     * 输出描述：
     *  输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     *
     *  方法：
     *      双重for循环，注意条件是 <= sum/2 + 1，连续正整数序列之和不会超过这个值
     *      此时时间复杂度为O(N^2)
     * */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum <= 0){
            return res;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        //双重for循环，注意条件是 <= sum/2 + 1，连续正整数序列之和不会超过这个值
        for(int i = 1; i <= sum/2+1; i++){
            count = i;
            temp.add(i);
            for(int j = i+1; j <= sum/2+1 && count < sum; j++){
                temp.add(j);
                count += j;
                if(count == sum){
                    ArrayList<Integer> list = new ArrayList<>(temp);
                    res.add(list);
                }
            }
            temp = new ArrayList<>();
        }

        return res;
    }

    /**
     * 方法二：使用双指针
     *  当总和小于sum，大指针继续+，否则小指针+
     * */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        //两个起点，相当于滑动窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int pHigh = 2;
        int pLow = 1;
        while(pHigh > pLow){
            //由于是连续序列，是公差为1的等差数列，求和公式(a0+an)*n/2
            int cur = (pHigh + pLow) * (pHigh - pLow + 1)/2;

            //相等，将窗口范围内的值添加入结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = pLow; i <= pHigh; i++){
                    list.add(i);
                }
                res.add(list);
                pLow++; //添加完，寻找下一个
            } else if(cur < sum){
                //如果当前窗口内的值小于sum，窗口右边界向右移动，即扩大
                pHigh++;
            } else{
                //如果当前窗口内的值大于sum，窗口左边界向右移动，即缩小
                pLow++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list = FindContinuousSequence1(5);
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(new Solution7().movingCount(18,5,7));
    }


}
