package LeetCodeRace.Contest144;

/**
 * @Author: pyh
 * @Date: 2019/7/7 10:30
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 *
 * 提示：
 *
 * 给出的 address 是一个有效的 IPv4 地址
 */
public class IP地址无效化 {

    class Solution {
        public String defangIPaddr(String address) {
            if(address == null || address.length() == 0 || address.trim().equals(""))
                return address;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < address.length(); i++){
                char c = address.charAt(i);
                if(c == '.'){
                    sb.append("[.]");
                } else{
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

}
