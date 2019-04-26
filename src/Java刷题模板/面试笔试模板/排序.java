package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/23 9:03
 * @Version: 1.0
 * @Function:
 * @Description:
 *  各种排序算法汇总
 *  这里的排序算法基本是排序  从小到大，升序排列
 */
public class 排序 {

    //交换函数
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //冒泡排序
    static void bubleSort(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            boolean isSorted = true;//冒泡优化，默认有序，无序则设置为false
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted){break;}//剩下部分有序，不用遍历
        }
    }

    //选择排序
    static void selectSort(int[] arr){
        //选择当前最小的
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //插入排序1, 几个边界，i = 1开始， j >= 0  arr[j+1] = key
    static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j;
            for(j = i - 1; j >= 0 && arr[j] > key; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
    }
    //插入排序2
    static void insertSort2(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0 && arr[j-1] > arr[j]; j--){
                swap(arr, j-1, j);
            }
        }
    }
    //二分插入排序
    static void binaryInsertSort(int[] arr){
        //注意R = i - 1， 注意找第一个 >= key的， 注意arr[i]先用key保存
        for(int i = 1; i < arr.length; i++){
            int L = 0;
            int R = i - 1;
            //找到第一个大于的
            int key = arr[i];
            while(L <= R){
                int mid = L + (R - L) / 2;
                if(arr[mid] > arr[i]){
                    R = mid - 1;
                } else{
                    L = mid + 1;
                }
            }
            for(int j = i - 1; j >= L; j--){
                arr[j+1] = arr[j];
            }
            arr[L] = key;
        }
    }

    //希尔排序，采取的是增量序列每次减半的策略
    static void shellSort(int[] arr){
        for(int g = arr.length; g > 0; g /= 2){//增量序列gap
            for(int end = g; end < arr.length; end++){//每一个组的结束元素，从数组第gap个元素开始
                //每组做插入排序
                int key = arr[end];
                int i;
                for(i = end - g; i >= 0 && key < arr[i]; i -= g){
                    arr[i+g] = arr[i];
                }
                arr[i+g] = key;
            }
        }
    }

    //三路快排
    static void quickSort(int[] arr){
        if(arr == null || arr.length == 0){return;}
        quickRec(arr, 0, arr.length - 1);
    }
    static void quickRec(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        swap(arr, L, L + (int)(Math.random() * (R - L + 1)));
        int[] p = partition(arr, L, R);
        quickRec(arr, L, p[0] - 1);
        quickRec(arr, p[1] + 1, R);
    }
    static int[] partition(int[] arr, int L, int R){
        //用arr[L]作为划分点
        int key = arr[L];
        int less = L;
        int more = R + 1;
        int cur = L + 1;
        while(cur < more){
            if(arr[cur] < key){
                swap(arr, ++less, cur++);
            } else if(arr[cur] > key){
                swap(arr, --more, cur);
            } else{
                cur++;
            }
        }
        swap(arr, L, less);
        //返回相等的两个下标， less位置是最后交换过来的划分值，more位置是>的，所以返回more-1
        return new int[]{less, more - 1};
    }

    //归并排序
    static void mergeSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        mergeRec(arr, 0, arr.length - 1);
    }
    static void mergeRec(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int mid = L + (R - L) / 2;
        mergeRec(arr, L, mid);
        mergeRec(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        while(p1 <= mid && p2 <= R){
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= R){
            help[index++] = arr[p2++];
        }
        //合并到原数组
        index = 0;
        for(int i = L; i <= R; i++){
            arr[i] = help[index++];
        }
    }

    //非递归归并排序
    static void mergeSortBU(int[] arr){
        for(int sz = 1; sz <= arr.length; sz += sz){    //区间个数，1， 2， 4， 8 ...
            for(int i = 0; sz + i < arr.length; i += sz + sz){  //对[i...i+sz-1]和[i+sz...i+sz*2-1]内归并
                merge(arr, i, i + sz - 1, Math.min(arr.length-1, i + sz * 2 - 1));//min防止越界
            }
        }
    }

    //堆排序
    static void heapSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            shiftUp(arr, i);//上浮方式建立堆
        }
        int size = arr.length - 1;
        swap(arr, 0, size);
        while(size > 0){
            shiftDown(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    static void shiftUp(int[] arr, int i){
        //上浮操作
        while(arr[i] > arr[(i-1)/2]){
            swap(arr, i, (i-1)/2);
            i = (i-1) / 2;
        }
    }
    static void shiftDown(int[] arr, int i, int heapSize){
        //下沉操作
        int L = i * 2 + 1;
        while(L < heapSize){
            int maxIndex = L+1 < heapSize && arr[L+1] > arr[L] ? L+1 : L;
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
            if(maxIndex == i){
                break;
            }
            swap(arr, i, maxIndex);
            i = maxIndex;
            L = i * 2 +1;
        }
    }

    //堆排序，方法二，只使用上浮过程
    static void heapSort2(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int size = arr.length - 1;
        for(int i = (size-1)/2; i >= 0; i--){
            shiftDown(arr, i, size+1);
        }
        swap(arr, 0, size);
        while(size > 0){
            shiftDown(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //测试方法
    public static void main(String[] args){
        int[] arr = new int[]{3,4,1,7,5,2,9,6,8};

        //bubleSort(arr);
        //selectSort(arr);
        //insertSort(arr);
        //insertSort2(arr);
        //binaryInsertSort(arr);
        //shellSort(arr);
        //quickSort(arr);
        //mergeSort(arr);
        //mergeSortBU(arr);
        //heapSort(arr);
        heapSort2(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
