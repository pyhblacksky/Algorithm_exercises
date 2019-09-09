package LeetCodeRace.Contest153;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: pyh
 * @Date: 2019/9/8 10:37
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 *
 * 提示：
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 */
public class main2 {

    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance(); // 获得一个日历
            Date datet = null;
            String datetime = year + "-" + (month < 10 ? "0"+month : month) + "-" + (day < 10 ? "0"+day : day);
            try {
                datet = f.parse(datetime);
                cal.setTime(datet);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
            if (w < 0)
                w = 0;
            return days[w];
        }
    }

}
