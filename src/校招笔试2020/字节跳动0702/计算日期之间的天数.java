package 校招笔试2020.字节跳动0702;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/7/3 20:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 为了纪念2012年3月12日这个重要的日子，希望对于之后的任何一个日期，计算出公司已经成立了多少天
 * 输入：
 * 第一行输入一个整数T,表示有T组数据，接下去T行，每行三个整数y，m，d，分表表示年月日
 *
 * 输出
 * 对于每组数据，输出1个整数，表示从2012年3月12日到给出的日期经过了多少天
 */
public class 计算日期之间的天数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T != 0){
            T--;
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            String nowDate = y + "-" + m + "-" + d;
            String oldDate = "2012-3-12";

            countDays(oldDate, nowDate);
        }
    }


    public static void countDays(String oldDate, String nowDate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        try {
            Date fDate = sdf.parse(oldDate);
            Date oDate = sdf.parse(nowDate);
            long days = (oDate.getTime() - fDate.getTime())/(1000*3600*24);
            System.out.print(days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
