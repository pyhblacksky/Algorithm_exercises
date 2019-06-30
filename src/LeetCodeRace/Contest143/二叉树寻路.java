package LeetCodeRace.Contest143;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/6/30 10:41
 * @Version: 1.0
 * @Function:
 * @Description:
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 *
 * 提示：
 *
 * 1 <= label <= 10^6
 */
public class 二叉树寻路 {

    //方法较蠢...
    static class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> pathInZigZagTree(int label) {
            if(label <= 0){
                return res;
            }

            help(label);

            List<Integer> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for(int i = res.size()-1; i >= 0; i--){
                temp.add(res.get(i));
            }
            res = temp;

            if(res.size() % 2 == 0) {
                int num = 0;
                for (int i = 0; i < res.size(); i++) {
                    num++;
                    if (i % 2 == 0) {
                        int cur = (int) Math.pow(2, num) - 1;
                        int before = (int) Math.pow(2,num-1);
                        int pos = cur;
                        for(int j = before; j < cur; j++){
                            if(res.get(i) == j){
                                break;
                            }
                            pos--;
                        }
                        result.add(pos);
                        continue;
                    }
                    result.add(res.get(i));
                }
            } else{
                int num = 0;
                for (int i = 0; i < res.size(); i++) {
                    num++;
                    if (i % 2 == 1) {
                        int cur = (int) Math.pow(2, num) - 1;
                        int before = (int) Math.pow(2,num-1);
                        int pos = cur;
                        for(int j = before; j < cur; j++){
                            if(res.get(i) == j){
                                break;
                            }
                            pos--;
                        }
                        result.add(pos);
                        continue;
                    }
                    result.add(res.get(i));
                }
            }

            return result;
        }

        private List<Integer> help(int label){
            if(label <= 0){
                return res;
            }

            res.add(label);
            if(label == 1){
                return res;
            }

            return help(label/2);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<Integer> res = solution.pathInZigZagTree(26);
        int a = 0;
    }

}
