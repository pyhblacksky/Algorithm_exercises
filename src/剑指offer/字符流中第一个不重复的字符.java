package 剑指offer;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/19 20:46
 * @Version 1.0
 * @Function:
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *      当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 *      如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class 字符流中第一个不重复的字符 {

    StringBuilder sb = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();;
    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if(!map.containsKey(ch)){
            map.put(ch, 1);
        } else{
            map.put(ch, -1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if(sb.length() == 0){
            return '#';
        }

        for(int i = 0; i < sb.length(); i++){
            if(map.get(sb.charAt(i)) == 1){
                return sb.charAt(i);
            }
        }
        return '#';
    }

}
