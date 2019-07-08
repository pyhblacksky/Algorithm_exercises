package 程序员面试金典;

/**
 * @Author: pyh
 * @Date: 2019/7/7 16:42
 * @Version: 1.0
 * @Function:
 * @Description:
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 *
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 *
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 */
public class 基本字符串压缩 {
    static class Zipper {
        public String zipString(String iniString) {
            // write code here
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < iniString.length(); i++){
                char c = iniString.charAt(i);
                if(i+1 < iniString.length() && iniString.charAt(i+1) == c){
                    int j = i+1;
                    int count = 1;
                    while(j < iniString.length() && iniString.charAt(j) == c){
                        j++;
                        count++;
                    }
                    sb.append(c);
                    sb.append(count);
                    i = j-1;
                } else{
                    sb.append(c);
                    sb.append(1);
                }
            }

            return sb.length() < iniString.length() ? sb.toString() : iniString;
        }
    }

    public static void main(String[] args) {
        Zipper zipper = new Zipper();
        System.out.println(zipper.zipString("welcometonowcoderrrrr"));
    }
}
