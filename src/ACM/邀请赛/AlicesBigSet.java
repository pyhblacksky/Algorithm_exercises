package ACM.邀请赛;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/5/19 15:42
 * @Version: 1.0
 * @Function:
 * @Description:
 *  Description
 *
 * There are n numbers in a box. Alice can choose two numbers A and B every second.
 * And Alice will get a new number A + B. Then she will put the 3 numbers A, B and A+b into the box.
 *
 * Now Alice wants to maximize the sum of all numbers in the box. After k second.
 * Alice wants to know what is the maximum sum.
 *
 *
 * Input
 * The first line contains 2 integers. n and k.
 * The second line contains n integers a[i].
 * 1<=n<=100000 0<=a[i]<=100000 1<=k<=1000000000
 *
 * Output
 * Output the sum mod 10000007.
 * If the answer is a negative number. Please make it add10000007.
 *
 *
 * Sample Input 1
 * 2 2
 * 3 6
 *
 * Sample Output 1
 * 33
 *
 */
public class AlicesBigSet {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        long res = getResult(arr, k);
        if(res < 0){
            System.out.println(res + 10000007);
        } else{
            System.out.println(res % 10000007);
        }

        System.out.println();
    }

    //O(N)
    static int getRes(int[] arr, int k){
        Queue<Integer> pq = new PriorityQueue<>(arr.length+1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.add(0);

        int res = 0;
        for(int num : arr){
            pq.add(num);
            res += num;
        }

        while(k > 0 && pq.size() >= 2){
            int r1 = pq.poll();
            if(!pq.isEmpty()) {
                int r2 = pq.poll();
                int temp = (r1+r2) % 10000007;
                res += temp;
                res %= 10000007;
                pq.add(temp);
            }
            pq.add(r1);
            k--;
        }

        return res;
    }

    //O(N)
    static int countRes(int[] arr, int k){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }

        int sum = 0;
        Arrays.sort(arr);
        for(int num : arr){
            sum += num;
        }
        int a = arr[arr.length-1];
        int b = arr[arr.length-2];
        while(k != 0){
            int temp = a;
            a = a + b;
            b = temp;
            sum += a;
            sum %= 10000007;
            k--;
        }
        return sum;
    }


    //O(logN)   矩阵乘法
    static long getResult(int[] arr, int k){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }

        int sum = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-2; i++){
            sum += arr[i];
        }

        int a = arr[arr.length-1];
        int b = arr[arr.length-2];

        long[][] base = {{1,1},{1,0}};
        long[][] res = matrixPower(base, k+2);
        long result = a * res[0][0] + b * res[1][0] - a;
        return arr.length > 2 ? result + sum : result;
    }

    //矩阵的p次方,快速幂
    public static long[][] matrixPower(long[][] m, int p){
        long[][] res = new long[m.length][m[0].length];
        //res设为单位矩阵
        for(int i = 0; i < res.length; i++){
            res[i][i] = 1;
        }
        long[][] temp = m;
        for(; p != 0; p >>= 1){
            if((p & 1) != 0){
                res = mulMatrix(res, temp);
            }
            temp = mulMatrix(temp, temp);
        }
        return res;
    }
    public static long[][] mulMatrix(long[][] m1, long[][] m2){
        long[][] res = new long[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length; j++){
                for(int k = 0; k < m2.length; k++){
                    res[i][j] += (m1[i][k] * m2[k][j]) % 10000007;
                }
            }
        }
        return res;
    }





    public static void main2(String[] args){
        //测试矩阵运算
        double[][] strss={
                {3,2,0,0,5},
                {0,0,3,2,3},
                {2,1,0,0,3},
                {0,0,2,1,2},
        };
        calculate(strss);
    }

    public static double[] calculate(double[][] strss) {
        double[][] dss={
                {strss[0][0],strss[0][1],strss[0][2],strss[0][3]},
                {strss[1][0],strss[1][1],strss[1][2],strss[1][3]},
                {strss[2][0],strss[2][1],strss[2][2],strss[2][3]},
                {strss[3][0],strss[3][1],strss[3][2],strss[3][3]}
        };
        double[][] d1ss={
                {strss[0][4],strss[0][1],strss[0][2],strss[0][3]},
                {strss[1][4],strss[1][1],strss[1][2],strss[1][3]},
                {strss[2][4],strss[2][1],strss[2][2],strss[2][3]},
                {strss[3][4],strss[3][1],strss[3][2],strss[3][3]}
        };
        double[][] d2ss={
                {strss[0][0],strss[0][4],strss[0][2],strss[0][3]},
                {strss[1][0],strss[1][4],strss[1][2],strss[1][3]},
                {strss[2][0],strss[2][4],strss[2][2],strss[2][3]},
                {strss[3][0],strss[3][4],strss[3][2],strss[3][3]}
        };
        double[][] d3ss={
                {strss[0][0],strss[0][1],strss[0][4],strss[0][3]},
                {strss[1][0],strss[1][1],strss[1][4],strss[1][3]},
                {strss[2][0],strss[2][1],strss[2][4],strss[2][3]},
                {strss[3][0],strss[3][1],strss[3][4],strss[3][3]}
        };
        double[][] d4ss={
                {strss[0][0],strss[0][1],strss[0][2],strss[0][4]},
                {strss[1][0],strss[1][1],strss[1][2],strss[1][4]},
                {strss[2][0],strss[2][1],strss[2][2],strss[2][4]},
                {strss[3][0],strss[3][1],strss[3][2],strss[3][4]}
        };

        double d=calculateFour(dss);
        if(d==0){
            System.out.println("无解或多个解");
            return null;
        }
        double d1=calculateFour(d1ss);
        double d2=calculateFour(d2ss);
        double d3=calculateFour(d3ss);
        double d4=calculateFour(d4ss);

        double x=d1/d;
        double y=d2/d;
        double z=d3/d;
        double m=d4/d;
        System.out.println("结果：x="+x+" y="+y+" z="+z+" m="+m);
        System.out.println("计算完毕!");
        return new double[]{x,y,z,m};
    }

    /**
     * 计算4阶线性方程组
     * @param strss
     * @return
     */
    private static double calculateFour(double[][] strss) {
        double[][] t00={
                {strss[1][1],strss[1][2],strss[1][3]},
                {strss[2][1],strss[2][2],strss[2][3]},
                {strss[3][1],strss[3][2],strss[3][3]}
        };
        double[][] t01={
                {strss[1][0],strss[1][2],strss[1][3]},
                {strss[2][0],strss[2][2],strss[2][3]},
                {strss[3][0],strss[3][2],strss[3][3]}
        };
        double[][] t02={
                {strss[1][0],strss[1][1],strss[1][3]},
                {strss[2][0],strss[2][1],strss[2][3]},
                {strss[3][0],strss[3][1],strss[3][3]}
        };
        double[][] t03={
                {strss[1][0],strss[1][1],strss[1][2]},
                {strss[2][0],strss[2][1],strss[2][2]},
                {strss[3][0],strss[3][1],strss[3][2]}
        };
        double result=Math.pow(-1, 0+0)*strss[0][0]*calculateThree(t00) + Math.pow(-1, 0+1)*
                strss[0][1]*calculateThree(t01) +
                Math.pow(-1, 0+2)*strss[0][2]*calculateThree(t02) +
                Math.pow(-1, 0+3)*strss[0][3]*calculateThree(t03) ;
        return result;
    }

    /**
     * 计算3阶行列式
     * @param strss
     * @return
     */
    private static double calculateThree(double[][] strss) {
        double result=
                strss[0][0]*strss[1][1]*strss[2][2] +
                        strss[0][1]*strss[1][2]*strss[2][0] +
                        strss[0][2]*strss[1][0]*strss[2][1] +
                        -strss[0][2]*strss[1][1]*strss[2][0] -
                        strss[0][1]*strss[1][0]*strss[2][2] -
                        strss[0][0]*strss[2][1]*strss[1][2] ;
        return result;
    }
}
