package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/3 14:44
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution93_复原IP地址 {

    //回溯DFS
    class Solution {
        int n;
        String s;
        LinkedList<String> segments = new LinkedList<>();
        ArrayList<String> output = new ArrayList<>();

        //检查是否合法
        private boolean valid(String segment){
            //1. <= 255
            //2. 数字前缀不为0 ， 单个0 可以
            int m = segment.length();
            if(m > 3)
                return false;

            return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
        }

        //回溯
        private void backtrack(int prev, int dots){
            int max_pos = Math.min(n-1, prev + 4);//至少4个值
            for(int cur_pos = prev + 1; cur_pos < max_pos; cur_pos++){
                String segment = s.substring(prev + 1, cur_pos + 1);
                if(valid(segment)){
                    segments.add(segment);
                    if(dots - 1 == 0)
                        update_output(cur_pos);
                    else
                        backtrack(cur_pos, dots-1);

                    segments.removeLast();
                }
            }
        }

        //更新输出
        private void update_output(int cur_pos){
            String segment = s.substring(cur_pos + 1, n);
            if(valid(segment)){
                segments.add(segment);
                output.add(String.join(".", segments));
                segments.removeLast();
            }
        }

        public List<String> restoreIpAddresses(String s) {
            n = s.length();
            this.s = s;
            backtrack(-1, 3);
            return output;
        }
    }

}
