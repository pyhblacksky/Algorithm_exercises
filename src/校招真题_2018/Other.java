package 校招真题_2018;

/**
 * @Author: pyh
 * @Date: 2019/2/14 10:28
 * @Version 1.0
 * @Function:
 *      代码测试
 */
public class Other {

    /**
     * 堆排, 大根堆
     * */
    public static void heapSort(int[] arr){
        int[] temp = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            temp[i+1] = arr[i];
            heapSink(temp, i+1);
        }

        for(int i = temp.length-1; i > 0; i--){
            exch(temp, 1, i);
            heapAdjust(temp, 1, i);
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i+1];
        }
    }

    /**
     * 小根堆
     * */
    public static void heapSinkLess(int[] arr, int k){
        while(k > 0 && arr[k] < arr[k/2]){
            exch(arr, k, k/2);
            k = k/2;
        }
    }

    /**
     * 获取k个小的数
     * */
    public static int[] getKNum(int[] arr, int k){
        int[] temp = new int[arr.length+1];

        for(int i = 0; i < arr.length; i++){
            temp[i+1] = arr[i];
            heapSink(temp, i+1);
        }
        int[] res = new int[k];
        int index = 0;
        int length = temp.length-1;
        //取数
        while(k > 0 && length > 0){
            k--;
            res[index++] = temp[1];
            exch(temp, 1, length);
            heapAdjust(temp, 1, length--);
        }

        return res;
    }

    public static void heapAdjust(int[] arr, int parrent, int length){
        int child = parrent*2;
        while(child < length){
            if(child+1 < length && arr[child+1] > arr[child]){
                child++;
            }

            if(arr[parrent] > arr[child]){
                break;
            }

            exch(arr, child, parrent);
            parrent = child;
            child = parrent*2;
        }

    }

    public static void heapSink(int[] arr, int k){
        while(k > 1 && arr[k/2] < arr[k]){
            exch(arr, k, k/2);
            k = k/2;
        }
    }


    public static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*****************************************************************************************************************/

    /**
     * 快排
     * */
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

        quickSort(arr, 0, arr.length -1);
    }

    private static void quickSort(int[] arr, int L, int R){
        if(L < R){
            int[] j = participate(arr, L, R);
            quickSort(arr, L, j[0]);
            quickSort(arr, j[1], R);
        }
    }

    private static int[] participate(int[] arr, int L, int R){
        int less = L-1;
        int more = R;
        int cur = L;

        while(cur < more){
            if(arr[cur] < arr[R]){
                exch(arr, cur++, ++less);
            } else if(arr[cur] > arr[R]){
                exch(arr, cur, --more);
            } else{
                cur++;
            }
        }
        exch(arr, more, R);
        return new int[]{less, more};

    }


    /**
     * 代码测试
     * */
    public static void main(String[] args){
        int[] arr = {1,23,5,78,3,4,765,9,1,2,3,2,24,56};
        //heapSort(arr);
        //int[] res = getKNum(arr, 4);
        quickSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
