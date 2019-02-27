package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 8:33
 * @Version 1.0
 * @Function:
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *      如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *      思路：根据二叉搜索树的特点。
 */
public class 二叉搜索树的后续遍历序列 {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return judge(sequence, 0, sequence.length-1);
    }

    private static boolean judge(int[] arr, int L, int R){
        if(L >= R){
            return true;
        }

        int i = L;
        while(arr[i] < arr[R]){
            i++;
        }

        for(int j = i; j < R; j++){
            if(arr[j] < arr[R]){
                return false;
            }
        }

        return judge(arr, L, i-1) && judge(arr, i, R-1);

    }

    //扩展：根据二叉搜索树的后续遍历序列得出中序序列???


    public static void main(String[] args){
        int[] a = {1,4,3,6,8,7,5};

        System.out.println(VerifySquenceOfBST(a));
    }

}
