package com.sdu.learn;


import org.junit.Test;

/**
 * @author huaikong
 * @create 2021-01-14 16:15
 */
public class day01 {

    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right){
            mid = left + ((right - left) >> 1);
            if(arr[mid] > arr[mid -1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public static int nearestIndex(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length == 0){
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] >= num){
                index = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static boolean exit(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] > num){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];//Math.random()随机生成[0,1)
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public  static  void  insertionSort(int[] arr){
        if(arr == null ||arr.length < 2){
            return;
        }
        for(int i = 1;i < arr.length;i++){
            for(int j = i - 1;j >= 0 && arr[j] > arr[j + 1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    public  static  void  bubbleSort(int[] arr){
        if(arr == null ||arr.length < 2){
            return;
        }
        for(int e = arr.length-1;e > 0;e--){
            for(int i = 0;i < e;i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        if(arr == null ||arr.length < 2){
            return;
        }
        for(int i = 0;i < arr.length;i++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    @Test
    public void fun(){
        System.out.println(-7*2);
        System.out.println((-7)<<3);
    }
}
