package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 16:37
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution88_合并两个有序数组 {

    //有额外空间
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
                return;
            }

            int[] arr = new int[m];
            for(int i = 0; i < m; i++){
                arr[i] = nums1[i];
            }

            int p1 = 0;
            int p2 = 0;
            int index = 0;
            while(p1 < m && p2 < n){
                nums1[index++] = arr[p1] < nums2[p2] ? arr[p1++] : nums2[p2++];
            }

            while(p1 < m)
                nums1[index++] = arr[p1++];

            while(p2 < n)
                nums1[index++] = nums2[p2++];

        }
    }

    //无额外空间
    class Solution1{
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //使用后指针

            int p1 = m-1;
            int p2 = n-1;
            int index = nums1.length-1;
            while(p1 >= 0 && p2 >= 0){
                nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }

            while(p1 >= 0)
                nums1[index--] = nums1[p1--];
            while(p2 >= 0)
                nums1[index--] = nums2[p2--];
        }
    }

}
