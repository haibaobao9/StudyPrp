package com.example.james.studypro.Sort;

public class SortAlgorithm {
    public static void quickSort(int[] a, int low, int high){
        if(low < high){
            int mid = getMid(a, low, high);
            quickSort(a, low, mid);
            quickSort(a, mid + 1, high);
        }
    }

    public static int getMid(int[] a, int low, int high){
        int temp = a[low];
        while (low < high){
            while (low < high && temp < a[high]){
                high--;
            }
            a[low] = a[high];
            while (low < high && temp > a[low]){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void mergeSort(int[] a, int low, int high){
        if(low < high){
            int mid = (high - low) / 2 + low;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, high);
        }
    }

    public static void merge(int[] a, int low, int high){
        if (low < high){
            int k = 0;
            int mid = (high - low) / 2 + low;
            int i = low, j = mid + 1;
            int[] temp = new int[high - low + 1];
            while (i <= mid && j <= high){
                if(a[i] < a[j]){
                    temp[k++] = a[i++];
                }else {
                    temp[k++] = a[j++];
                }
            }
            while (i <= mid){
                temp[k++] = a[i++];
            }
            while (j <= high){
                temp[k++] = a[j++];
            }
            for (int l = 0; l < temp.length; l++){
                a[low + l] = temp[l];
            }
        }
    }


    public static void minHeapSort(int[] a){
        for (int i = 0; i < a.length; i++){
            minHeapSort(a, a.length - 1 - i);
            swap(a, 0, a.length - 1- i);
        }
    }

    public static void minHeapSort(int[] a, int lastIndex){
        for (int i = (lastIndex - 1) / 2; i >= 0; i--){
            int k = i;
            while (2 * k + 1 <= lastIndex){
                int smallerIndedx = 2 * k + 1;
                if (smallerIndedx < lastIndex && a[smallerIndedx] > a[smallerIndedx + 1]){
                    smallerIndedx ++;
                }
                if (a[smallerIndedx] < a[k]){
                    swap(a, smallerIndedx, k);
                    k = smallerIndedx;
                }else {
                    break;
                }
            }
        }
    }

    public static void maxHeapSort(int[] a){
        for (int i = 0; i < a.length; i++){
            buildMaxHeap(a, a.length - 1 - i);
            swap(a, 0, a.length - 1- i);
        }
    }

    public static void buildMaxHeap(int[] a, int lastIndex){
        for (int i = (lastIndex - 1) / 2; i >= 0; i--){
            int k = i;
            while (2 * k + 1 <= lastIndex){
                int biggerIndex = 2 * k + 1;
                if(biggerIndex < lastIndex && a[biggerIndex] < a[biggerIndex + 1]){
                    biggerIndex ++;
                }
                if(a[biggerIndex] > a[k]){
                    swap(a, biggerIndex, k);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shellSort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < a.length; i++){
                int temp = a[i];
                int j = 0;
                for (j = i; j >= gap; j -= gap){
                    if (a[j -gap] > temp){
                        a[j] = a[j - gap];
                    }else {
                        break;
                    }
                }
                a[j] = temp;
            }
        }
    }


    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            int temp = a[i];
            int j = 0;
            for (j = i; j >= 1; j--){
                if (a[j - 1] > temp){
                    a[j] = a[j - 1];
                }else {
                    break;
                }
            }
            a[j] = temp;
        }
    }

    public static void selectSort(int[] a){
        for (int i = 0; i < a.length; i++){
            int minIndex = i;
            for (int j = i; j < a.length; j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++){
            boolean flag = false;
            for (int j = 0; j < a.length - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

}
