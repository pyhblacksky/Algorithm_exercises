package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/5 15:51
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution71_简化路径 {

    //注意情况比较多....   容易漏掉
    static class Solution {
        public String simplifyPath(String path) {
            if(path == null || path.length() == 0)
                return path;

            int end = path.length()-1;
            while(end >= 0 && path.charAt(end) == '/'){
                end--;
            }

            StringBuilder sb = new StringBuilder();
            boolean add_ = true;
            for(int i = 0; i <= end; i++){
                char c = path.charAt(i);
                if(c == '/' && add_){
                    sb.append(c);
                    add_ = false;
                } else if(c != '/') {
                    //只有一个点
                    if(c == '.' && (i+1 <= end && path.charAt(i+1) == '/')){
                        continue;
                    }
                    if(c == '.' && i+1 > end)
                        continue;

                    //三个点以上直接添加
                    if(c == '.' && i+1 <= end && path.charAt(i+1) == '.' && i+2 <= end && path.charAt(i+2) != '/'){
                        while(i <= end && path.charAt(i) != '/'){
                            sb.append(path.charAt(i));
                            i++;
                        }
                        i--;//回退一格
                        add_ = true;
                        continue;
                    }

                    //两个点
                    if(c == '.' && i+1 <= end && path.charAt(i+1) == '.' && (i+2 > end || path.charAt(i+2) != '.')){
                        if(sb.length() > 0)
                            sb.deleteCharAt(sb.length()-1);
                        int index = sb.length()-1;
                        while(index >= 0 && sb.charAt(index) != '/'){
                            sb.deleteCharAt(index);
                            index--;
                        }
                    } else{
                        sb.append(c);
                        add_ = true;
                    }
                }
            }

            //检查是否合法
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == '/')
                sb.deleteCharAt(sb.length()-1);
            if(sb.length() == 0 || sb.charAt(0) != '/')
                sb.insert(0,'/');

            return sb.toString();
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.simplifyPath("/home/../../........./.....");
    }
}
