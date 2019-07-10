package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/19 9:56
 * @Version 1.0
 * @Function:
 *      小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。
 *      但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *      没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *      现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *      输出描述:
 *      输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class 和为S的连续正数序列 {

    //双指针法
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int pL = 1;
        int pM = 2;
        while(pL < pM){
            int temp = (pL + pM) * (pM - pL + 1) / 2; //公差为1的等差数列求和公式 Sn = (a1+an)*n/2
            if(temp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = pL; i <= pM; i++){
                    list.add(i);
                }
                res.add(list);
                pL++;
            } else if(temp > sum){
                pL++;
            } else{
                pM++;
            }
        }
        return res;
    }

    //暴力递归求解
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 1; i < sum/2 + 1; i++){
            help(res, new ArrayList<>(), sum, i);
        }

        return res;
    }
    private static void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int sum, int num){
        if(sum <= 0){
            if(list.size() >= 2 && sum == 0){
                ArrayList<Integer> temp = new ArrayList<>(list);
                res.add(temp);
            }
            return;
        }

        list.add(num);
        help(res, list, sum-num, num+1);

    }

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(10);
        for(ArrayList list : res){
            printArrList(list);
        }
    }

}
