package Java刷题模板;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: pyh
 * @Date: 2019/4/23 8:30
 * @Version: 1.0
 * @Function:
 * @Description:
 *  Java刷题通用模板
 *
 *      该java刷题模板均来自于 https://github.com/ZXZxin/ZXBlog
 *      略有修改
 */
public class Main {

    static class FR{
        BufferedReader br;
        StringTokenizer tk;

        FR(InputStream stream){
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            tk = null;
        }

        String next(){
            while(tk == null || !tk.hasMoreElements()){
                try {
                    tk = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return tk.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }

    //解题在这
    static void solve(InputStream stream, PrintWriter out){
        FR in = new FR(stream);

        //start code

    }

    //main函数
    public static void main(String[] args){
        OutputStream os = System.out;
        InputStream is = System.in;
        PrintWriter out = new PrintWriter(os);
        solve(is, out);
        out.close();//不关闭就没有输出
    }

}
