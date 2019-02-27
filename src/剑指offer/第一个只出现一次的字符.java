package 剑指offer;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/18 20:06
 * @Version 1.0
 * @Function:
 *      在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *      并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class 第一个只出现一次的字符 {

    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), i);
            } else{
                map.put(str.charAt(i), -1);
            }
        }

        int index = Integer.MAX_VALUE;
        for(int num : map.values()){
            if(num != -1){
                index = Math.min(index, num);
            }
        }

        return index == Integer.MAX_VALUE ? -1 : index;
    }

    public static void main(String[] args){
        FirstNotRepeatingChar("google");
    }
}
