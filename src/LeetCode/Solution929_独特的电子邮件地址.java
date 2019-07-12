package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/7/12 13:48
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 *
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 *
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 *
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 *
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 *
 * 可以同时使用这两个规则。
 *
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 *  
 *
 * 示例：
 *
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *  
 *
 * 提示：
 *
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution929_独特的电子邮件地址 {

    static class Solution {
        public int numUniqueEmails(String[] emails) {
            if(emails == null || emails.length == 0)
                return 0;

            Set<String> set = new HashSet<>();

            for(int i = 0; i < emails.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < emails[i].length(); j++){
                    char c = emails[i].charAt(j);
                    if(c == '@'){
                        sb.append(emails[i].substring(j));
                        break;
                    }
                    if(c == '.'){
                        continue;
                    }
                    if(c == '+'){
                        while(j < emails[i].length() && emails[i].charAt(j) != '@'){
                            j++;
                        }
                        j--;
                        continue;
                    }
                    sb.append(c);
                }
                set.add(sb.toString());
            }

            return set.size();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] strs = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int res = solution.numUniqueEmails(strs);
        System.out.println(res);
    }

}
