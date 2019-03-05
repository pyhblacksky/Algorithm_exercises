package HDU_OJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/4 15:12
 * @Version 1.0
 * @Function:
 * 问题描述
 * 如今，我们都知道计算机学院是HDU最大的部门。但是，也许你不知道2002年计算机学院曾被分成计算机学院和软件学院。
 * 分裂绝对是HDU中的一件大事！与此同时，这也是一件麻烦事。所有设施必须减半。首先，评估所有设施，
 * 如果两个设施具有相同的价值，则认为它们是相同的。假设有N（0 <N <1000）种设施（不同的值，不同的种类）。
 *
 * 输入
 * 输入包含多个测试用例。每个测试用例以数字N开始（0 <N <= 50 - 不同设施的总数）。
 * 接下来的N行包含整数V（0 <V <= 50 - 设施值）和整数M（0 <M <= 100 - 相应的设施数）。您可以假设所有V都不同。
 * 以负整数开头的测试用例终止输入，并且不处理该测试用例。
 *
 * 输出
 * 对于每种情况，打印一行包含两个整数A和B，分别表示计算机学院和软件学院的价值。
 * A和B应尽可能相等。同时，你应该保证A不低于B.
 *
 * 样本输入
 * 2
 * 10 1
 * 20 1
 * 3
 * 10 1
 * 20 2
 * 30 1
 * -1
 *
 * 样本输出
 * 20 10
 * 40 40
 */
public class HDU1171_BigEventInHDU {
/**
 * 这道题咋看有点复杂，其实也只是换了一种思维，因为题目要求要尽量平均分配，
 * 所以我们可以先将总价值sum求出，然后得出其分配的平均值为sum/2,要注意这个答案可能为小数，
 * 但是又因为sum是整数，所以最后得出的sum/2是要小于等于实际的值。
 * 将这个结果进行01,背包，可以得出其中一个宿舍所得的最大价值，
 * 而另一个宿舍的最大价值也可以相应的得到，而前者必定小于等于后者。
 * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            if(n < 0){ //为负数，退出
                break;
            }
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            int index = 0;
            for(int i = 0; i < n; i++){
                int v = scan.nextInt();
                int m = scan.nextInt();
                while(m > 0){
                    m--;
                    list.add(v);
                    sum += v;
                }
            }
            int[] val = new int[list.size()+1];
            for(int i = 0; i < list.size(); i++){
                val[i] = list.get(i);
                index++;
            }

            //目标均分一半
            int[] dp = new int[sum/2+1];
            for(int i = 0; i < index; i++){
                for(int j = sum/2; j >= val[i]; j--){
                    dp[j] = Math.max(dp[j], dp[j - val[i]] + val[i]);
                }
            }
            System.out.println((sum-dp[sum/2]) + " " + dp[sum/2]);
        }
    }

}
