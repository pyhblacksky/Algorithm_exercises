package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 21:03
 * @Version 1.0
 * @Function:
 *      统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {

    //利用二分查找，找到第一个等于k，然后找到最后一个等于k的
    public static int GetNumberOfK1(int [] array , int k){
        if(array == null || array.length == 0){
            return 0;
        }
        int first = getFirst(array, 0, array.length-1, k);
        int last = getLast(array, 0, array.length-1, k);

        if(first == -1 || last == -1){
            return 0;
        } else {
            return last-first+1;
        }
    }
    private static int getFirst(int[] arr, int start, int end, int k){

        int mid = start + ((end-start)>>1);
        while(start <= end){
            if(arr[mid] > k){
                end = mid-1;
            } else if(arr[mid] < k){
                start = mid+1;
            } else if(mid-1 >= 0 && arr[mid-1] == k){
                end = mid-1;
            } else{
                return mid;
            }
            mid = start + ((end-start)>>1);
        }

        return -1;
    }
    private static int getLast(int[] arr, int start, int end, int k){
        if(start > end){
            return -1;
        }

        int mid = start + ((end-start)>>1);
        if(arr[mid] > k){
            return getLast(arr, start, mid-1, k);
        } else if(arr[mid] < k){
            return getLast(arr, mid+1, end, k);
        } else if(mid+1 < arr.length && arr[mid+1] == k){
            return getLast(arr, mid+1, end, k);
        } else{
            return mid;
        }
    }




    //二分查找
    private static int binarySearch(int[] arr, int start, int end, int k){
        int mid = start + (end-start)/2;
        while(start <= end){
            if(arr[mid] == k){
                return mid;
            } else if(arr[mid] > k){
                end = mid-1;
            } else if(arr[mid] < k){
                start = mid+1;
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }

    //一般解法
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1){
            if(array[0] == k){
                return 1;
            } else{
                return 0;
            }
        }
        if(array[0] > array[1]){
            for(int i = 0; i < array.length; i++){
                if(array[i] == k){
                    count++;
                    continue;
                }
                if(array[i] < k){
                    break;
                }
            }
        } else{
            for(int i = 0; i < array.length; i++){
                if(array[i] == k){
                    count++;
                    continue;
                }
                if(array[i] > k){
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,7,9,11,13};
        int[] arr1 = {1,2,4,5,6};
        System.out.println(GetNumberOfK1(arr, 10));

        System.out.println(getLast(arr1, 0, arr1.length, 3));
        System.out.println(getFirst(arr1, 0, arr1.length, 3));
    }
}
