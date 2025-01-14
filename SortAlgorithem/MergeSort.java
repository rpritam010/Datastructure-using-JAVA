package SortAlgorithem;


public class MergeSort {
//Time complexity O(nlogn)
    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};

        mergeSort(intArray , 0, intArray.length);

        for (int j : intArray) {
            System.out.println(j);
        }
    }

    public static  void mergeSort(int[] input , int start , int end){
        if(end - start <2){
            return;
        }

        int mid = (start + end)/2;

        //for the left side
        mergeSort(input, start, mid);
        //for the right side
        mergeSort(input, mid, end);

        merge(input , start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        if(input[mid -1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex =0;

        int[] temp = new int[end - start];
        while(i < mid && j <end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i , input ,start + tempIndex,mid - i);
        System.arraycopy(temp, 0 , input, start,tempIndex);

    }
}
