package LeetCode;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/5/30 8:19
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Solution49_字母异位词分组 {

    //排序数组并分类，使用HashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            } else{
                map.put(temp, new ArrayList<>());
                map.get(temp).add(strs[i]);
            }
        }

        for(Map.Entry entry : map.entrySet()){
            res.add((List<String>)entry.getValue());
        }
        return res;
    }

}
