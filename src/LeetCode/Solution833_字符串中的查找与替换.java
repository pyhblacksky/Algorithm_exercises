package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/7/20 16:41
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 对于某些字符串 S，我们将执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
 *
 * 每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是如果 x 从原始字符串 S 中的位置 i 开始，那么我们将用 y 替换出现的 x。如果没有，我们什么都不做。
 *
 * 举个例子，如果我们有 S = “abcd” 并且我们有一些替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，我们将用 “ffff” 替换它。
 *
 * 再来看 S = “abcd” 上的另一个例子，如果我们有替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不执行任何操作，因为原始字符串中 S[2] = 'c'，与 x[0] = 'e' 不匹配。
 *
 * 所有这些操作同时发生。保证在替换时不会有任何重叠： S = "abc", indexes = [0, 1], sources = ["ab","bc"] 不是有效的测试用例。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * 输出："eeebffff"
 * 解释：
 * "a" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
 * "cd" 从 S 中的索引 2 开始，所以它被替换为 "ffff"。
 * 示例 2：
 *
 * 输入：S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * 输出："eeecd"
 * 解释：
 * "ab" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
 * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 *  
 *"vmokgggqzp"
 * [3,5,1]
 * ["kg","ggq","mo"]
 * ["s","so","bfr"]
 * 输出："vbfrssozp"
 *
 * "imidcxiiqjwpvvcocjtskshvmqjnlhsqtezqttmoxuskbmujej"
 * [35,6,22,40,17,19,12,2,42,4,8,45,14,29,47,24]
 * ["qtt","ii","hv","xu","jt","sk","vv","id","skb","cx","qjw","mu","co","hsqtez","jej","mqjnl"]
 * ["idl","vo","yl","pg","efp","vqi","s","wb","mw","gmt","rkqc","kdx","o","vamwgpn","pl","xyvz"]
 *
 * 输出：
 * "imwbgmtvorkqcpsocefpvqisylxyvzvamwgpnidlmopg mwkdxpl"
 * "imwbgmtvorkqcpsocefpvqisylxyvzvamwgpnidlmopg vqibkdxpl"
 *
 * 提示：
 *
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * 给定输入中的所有字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution833_字符串中的查找与替换 {

    static class Solution {
        public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
            if(S == null || S.length() == 0 || indexes == null || indexes.length == 0)
                return S;

            //sources中存在重复的元素


            Map<String, String> realMap = new HashMap<>();
            for(int i = 0; i < indexes.length; i++){
                String key = sources[i] + " " + indexes[i];
                String val = targets[i];
                realMap.put(key, val);
            }

            StringBuilder sb = new StringBuilder();
            Arrays.sort(indexes);
            Arrays.sort(sources, ((o1, o2) -> o2.length()-o1.length()));
            int index = 0;
            for(int i = 0; i < S.length(); i++){
                if(index < indexes.length && i == indexes[index]){
                    boolean flag = false;
                    int len = 0;
                    //indexs也要对应匹配开始
                    for(int j = 0; j < sources.length; j++){
                        String key = sources[j] + " " + indexes[index];
                        if(S.substring(i).startsWith(sources[j])){
                            sb.append(realMap.get(key));
                            flag = true;
                            len = sources[j].length();
                            break;
                        }
                    }

                    if(flag) {
                        i += len-1;
                        continue;
                    }
                    index++;
                }
                sb.append(S.charAt(i));
            }

            return sb.toString();
        }
    }

    public static void main(String[] args){
        String S = "vmokgggqzp";
        String[] sources = {"kg","ggq","mo"};
        String[] target = {"s","so","bfr"};
        int[] indexs = {3,5,1};

        Solution solution = new Solution();
        //solution.findReplaceString(S, indexs, sources, target);

        String S1 = "imidcxiiqjwpvvcocjtskshvmqjnlhsqtezqttmoxuskbmujej";
        String[] sources1 = {"qtt","ii","hv","xu","jt","sk","vv","id","skb","cx","qjw","mu","co","hsqtez","jej","mqjnl"};
        String[] target1 = {"idl","vo","yl","pg","efp","vqi","s","wb","mw","gmt","rkqc","kdx","o","vamwgpn","pl","xyvz"};
        int[] indexs1 = {35,6,22,40,17,19,12,2,42,4,8,45,14,29,47,24};
        //solution.findReplaceString(S1, indexs1, sources1, target1);

        String S2 = "welshzapaezqgmcmrmfrfzttdgquizyducbvxzzuiddcnwuaap";
        String[] sources2 = {"lu","corm","uz","idvc","zzy","uq","fb","dc","wx","hz","gv","hzl","ka","ow","ya","ls"};
        String[] target2 = {"fgk","uho","t","okv","qlk","no","h","mjn","tcs","oxa","rj","zmut","wh","z","wza","wig"};
        int[] indexs2 = {38,14,9,40,28,32,18,24,0,20,12,4,46,44,7,2};
        solution.findReplaceString(S2, indexs2, sources2, target2);

    }
}
