package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/23 11:09
 * @Version: 1.0
 * @Function:
 * @Description:
 * 二分最主要的就是边界问题:
 *
 *  第一个=key的，不存在返回-1；
 *  第一个>=key的；
 *  第一个>key的；
 *  最后一个=key的；
 *  最后一个<=key的；
 *  最后一个<key的；
 */
public class 二分 {

    //最基本的二分查找
    static int binarySearch(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while (L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个=key的，不存在返回-1；
    //口诀L左边的先R（if后的），右边的先L
    static int firstEqual(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] >= key){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        if(L < arr.length && arr[L] == key) return L;
        return -1;
    }

    //查找第一个 >= key的
    static int firstLargeEqual(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] >= key){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return L;
    }

    //查找第一个 >key的
    static int firstLarge(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] > key){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return L;
    }

    //查找最后一个=key的
    static int lastEqual(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] <= key){
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        if(R >= 0 && arr[R] == key){
            return R;
        }
        return -1;
    }

    //查找最后一个 <= key的
    static int lastEqualSmall(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] <= key){
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return R;
    }

    //查找最后一个 <key 的
    static int lastSmall(int[] arr, int key){
        int L = 0;
        int R = arr.length - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(arr[mid] < key){
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        return R;
    }

    //测试主函数
    public static void main(String[] args){
        int[] arr = new int[]{3,4,1,7,5,2,9,6,8};
        int[] arr1= new int[]{3,4,1,7,5,2,9,6,8,3,4,1,7,5,2,9,6,8};
        int res = -1;
        res = binarySearch(arr, 5);

        res = firstEqual(arr1, 7);
        System.out.println(res);
    }
}
