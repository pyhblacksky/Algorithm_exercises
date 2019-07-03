package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 13:42
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4_寻找两个有序数组中的中位数 {

    //相当于是合并两个数组后的中位数,归并，时间复杂度 O(N) 空间复杂度 O(N)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1 == null && nums2==null){
                return 0;
            }

            int len1 = 0;
            int len2 = 0;
            if(nums1 != null)
                len1 = nums1.length;

            if(nums2 != null)
                len2 = nums2.length;


            int[] arr = new int[len1+len2];
            int index = 0;
            int p1 = 0;
            int p2 = 0;
            while(p1 < len1 && p2 < len2)
                arr[index++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];

            while(p1 < len1)
                arr[index++] = nums1[p1++];

            while(p2 < len2)
                arr[index++] = nums2[p2++];


            if(arr.length % 2 == 0)
                return (arr[arr.length/2] + arr[arr.length/2-1]) / 2.0;
            else
                return arr[arr.length/2];

        }
    }


    //复杂度 log(m+n)
    class Solution1 {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }


}
