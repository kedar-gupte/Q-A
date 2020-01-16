package ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

/**
 * Given an array with three enumerations S,M and L - sort the arrays with S, M and L in that orer
 */
public class SortThreeEnumerations implements BaseExecutor {

    char[] sortArrayOfEnumerations(char[] arr) {

        int start = 0, end = arr.length - 1;

        while(start < end) {
            if(arr[start] == 'L') {
                swap(arr, start, end);
                end--;
            } else if(arr[end] == 'S') {
                swap(arr, start, end);
                start++;
            } else if(arr[start] == 'S'){
                start++;
            } else if(arr[end] == 'L') {
                end--;
            } else {
                start++;
                end--;
            }
        }

        return arr;
    }

    void swap(char[] arr, int i, int j) {
        if(i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    @Override
    public void execute() {
        char[] arr = {'M', 'S', 'S', 'L', 'M', 'S', 'L'};
        System.out.println(Arrays.toString(sortArrayOfEnumerations(arr)));
    }

    public static void main(String[] args) {
        new SortThreeEnumerations().execute();
    }
}
