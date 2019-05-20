package 牛客竞赛OJ.牛客练习赛_46;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/20 20:26
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 链接：https://ac.nowcoder.com/acm/contest/894/B
 * 来源：牛客网
 *
 * 题目描述
 * 华华用数组a和数组b合成了矩阵c。其中a数组长度为n，b数组长度为m，c是n行m列的矩阵，
 * 且c[i][j]=a[i]*b[j]。定义矩阵的权值为矩阵中所有元素的和。然后他想把矩阵送给奕奕。
 * 然而他怕奕奕不喜欢。若矩阵的权值小于L,奕奕会讨厌它，因为奕奕不喜欢太小的数字。
 * 若矩阵的权值大于R，奕奕会生气因为奕奕不认识比R大的数字。
 * 所以奕奕只喜欢权值大于等于L并且小于等于R的矩阵。
 * 还好华华学过acm，他马上想到可以送奕奕一个子矩阵，并且他立马写程序从c矩阵中找出了所有奕奕喜欢的子矩阵。
 * 你只需要帮他算算这样的子矩阵有多少个即可。
 *
 * 输入描述:
 * 第一行输入n,m,L,R。
 * 第二行n个数表示a数组
 * 第三行m个数表示b数组
 * 1<=n,m<=1000,1<=L<=R<=1e18
 * 1<=a[i],b[i]<=1e6
 * 输出描述:
 * 输出一个数表示子矩阵的个数
 * 示例1
 * 输入
 * 复制
 * 3 3 3 8
 * 3 2 3
 * 2 3 1
 * 输出
 * 复制
 * 10
 */
public class 华华送奕奕小礼物 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        long L = sc.nextLong();
        long R = sc.nextLong();
        long[] A = new long[n+1];
        long[] B = new long[m+1];
        for(int i = 1; i <= n; i++){
            int num = sc.nextInt();
            A[i] = A[i-1] + num;
        }
        for(int i = 1; i <= m; i++){
            int num = sc.nextInt();
            B[i] = B[i-1] + num;
        }

        long[] C = new long[n*m+1];
        int index=1;
        for(int i=1;i<=m;i++) {
            for(int j=i;j<=m;j++) {
                C[index++] = B[j] - B[i-1];
            }
        }

        Arrays.sort(C,1, index);
        long ans=0;
        for(int i=1;i<=n;i++) {
            for(int j=i;j<=n;j++) {
                long sum=A[j]-A[i-1];
                int res1=upper(C,0,index-1,R/sum);
                int res2=lower(C,1,index, L % sum==0 ? L/sum : L/sum+1);
                if(res1<=index-1&&res1>=1&&res2<=index-1&&res2>=1) {
                    ans+=(res1-res2+1);
                }
            }
        }
        System.out.println(ans);
    }

    //最小后继
    public static int lower(long[] s,int l,int r,long k) {
        while(l<r) {
            int mid=(l+r)>>1;
            if(s[mid]>=k)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    //最大前驱
    public static int upper(long[] s,int l,int r,long k) {
        while(l<r) {
            int mid=(l+r+1)>>1;
            if(s[mid]<=k)
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }
}
