package Base.ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

public class getNoZeroIntegers implements BaseExecutor {

    public int[] getNoZeroIntegers(int n) {

        int i = 1;

        while(String.valueOf(i).contains("0") || String.valueOf(n - i).contains("0")) {
            i++;
        }

        int[] result = {i, n - i};
        return result;

    }

    @Override
    public void execute() {

        System.out.println(Arrays.toString(getNoZeroIntegers(1000)));
        System.out.println(Arrays.toString(getNoZeroIntegers(111)));
        System.out.println(Arrays.toString(getNoZeroIntegers(57491)));

    }

    public static void main(String[] args) {
        new getNoZeroIntegers().execute();
    }
}
