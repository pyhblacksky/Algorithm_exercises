package 校招笔试2020.拼多多提前批;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/7/28 15:20
 * @Version: 1.0
 * @Function:
 * @Description:
 * 单词是否可以成环
 */
public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] str = line.split(" ");
        Map<Character, Integer> mapLeft = new HashMap<>();
        Map<Character, Integer> mapRight = new HashMap<>();
        for(int i = 0; i < str.length; i++){
            char first = str[i].charAt(0);
            char last = str[i].charAt(str[i].length()-1);
            str[i] = first + last + "";
            mapLeft.put(first, mapLeft.getOrDefault(first, 0) + 1);
            mapRight.put(last, mapRight.getOrDefault(last, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : mapLeft.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if(mapRight.get(key) == null || mapRight.get(key) != val){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");

    }

}
