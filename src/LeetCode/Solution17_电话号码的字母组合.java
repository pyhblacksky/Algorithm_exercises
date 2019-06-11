package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/6/11 10:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17_电话号码的字母组合 {

    static class Solution {
        //笛卡尔积
        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0)
                return new ArrayList<>();

            Map<Integer, String[]> map = new HashMap<>();
            map.put(0, null);
            map.put(1, null);
            map.put(2, new String[]{"a","b","c"});
            map.put(3, new String[]{"d","e","f"});
            map.put(4, new String[]{"g","h","i"});
            map.put(5, new String[]{"j","k","l"});
            map.put(6, new String[]{"m","n","o"});
            map.put(7, new String[]{"p","q","r","s"});
            map.put(8, new String[]{"t","u","v"});
            map.put(9, new String[]{"w","x","y","z"});

            String[] temp = map.get(digits.charAt(0) - '0');
            for(int i = 1; i < digits.length(); i++){
                int num = digits.charAt(i) - '0';
                if(num == 0 || num == 1)
                    continue;
                temp = help(temp, map.get(num));
            }
            List<String> list = new ArrayList<>();
            for(String str : temp){
                list.add(str);
            }
            return list;
        }
        public String[] help(String[] c1, String[] c2){
            //计算笛卡尔积
            String[] res = new String[c1.length*c2.length];
            int index = 0;
            for(int i = 0; i < c1.length; i++){
                for(int j = 0; j < c2.length; j++){
                    res[index++] = c1[i]+c2[j];
                }
            }
            return res;
        }

        public static void main(String[] args){
            Solution solution = new Solution();
            solution.letterCombinations("23");
        }
    }

}
