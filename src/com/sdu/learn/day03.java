package com.sdu.learn;

/**
 * @author huaikong
 * @create 2021-01-17 12:28
 */
public class day03 {
    //非递归方法实现
    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while(mergeSize < N){
            int L = 0;
            while(L < N){
                int M = L + mergeSize - 1;
                if(M >= N){
                    break;
                }
                int R = Math.min(M + mergeSize,N - 1);
                merge(arr,L,M,R);
                L = R + 1;
            }
            if(mergeSize > N / 2){
                break;
            }
            mergeSize <<= 1;
        }
    }
    //递归方法实现
    public static void mergeSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr,L,mid);
        process(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while(p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0;i < help.length;i++){
            arr[L + i] = help[i];
        }
    }

    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if(L >= R){
            return;
        }
        int[] equalArea = netherlandsFlag(arr,L,R);
        process1(arr,L,equalArea[0] - 1);
        process1(arr,equalArea[1] + 1,R);
    }

    public static int[] netherlandsFlag(int[] arr,int L,int R){
        if(L > R){
            return new int[]{-1,-1};
        }
        if(L == R){
            return new int[]{L,R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while(index < more){
            if(arr[index] == arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                swap(arr,index++,++less);
            }else{
                swap(arr,index,--more);
            }
        }
        swap(arr,more,R);
        return new int[]{less + 1,more};
    }

    private static void swap(int[] arr, int more, int r) {
        int temp = arr[more];
        arr[more] = arr[r];
        arr[r] = temp;
    }
}
