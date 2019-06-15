package 校招笔试2020.tplink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/6/15 14:06
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  假设运行日志中有1KK条URL访问记录（每条URL不超过256Byte），
 *  设计一个算法找出出现次数最多的前十个URL以及他们出现的次数，要求占用内存尽可能小
 */
public class 找出最多的访问记录 {

    public static void main(String[] args){
        try {
            String pathname = "log.txt"; //读取日志文件
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            //使用map存储
            Map<String, Integer> map = new HashMap<>();
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                map.put(line, map.getOrDefault(line, 0) + 1);//放入
            }
            //对map进行排序
            //输出次数最多的
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            //排序
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    //从大到小
                    return o2.getValue() - o1.getValue();
                }
            });
            //输出前十个
            for(int i = 0; i < 10; i++){
                System.out.println("url:"+list.get(i).getKey() + " count:" + list.get(i).getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
