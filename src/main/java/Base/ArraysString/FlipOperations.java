package Base.ArraysString;

import Base.BaseExecutor;

import java.util.*;

public class FlipOperations implements BaseExecutor {

    public int minFlips(int a, int b, int c) {

        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        String s3 = Integer.toBinaryString(c);

        int result = 0;

        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        int max = Math.max(l3, Math.max(l1, l2));

        // Make all three strings of equal length
        while(max >= 0) {

            if(l1 < max) {
                s1 = "0" + s1;
            }
            if(l2 < max) {
                s2 = "0" + s2;
            }
            if(l3 < max) {
                s3 = "0" + s3;
            }

            max--;

        }

        System.out.println(s1 + " " + s2 + " " + s3);

        int i = s1.length() - 1;

        while(i >= 0) {
            Integer i1 = Integer.parseInt(String.valueOf(s1.charAt(i))),
                    i2 = Integer.parseInt(String.valueOf(s2.charAt(i))),
                    i3 = Integer.parseInt(String.valueOf(s3.charAt(i)));
            if(i3 != (i1 | i2)) {
                if(i3 == 0 && (i1 == 1 && i2 == 1)) {
                    result += 2;
                } else {
                    result += 1;
                }
            }
            i--;
        }

        return result;
    }

    @Override
    public void execute() {

        System.out.println(minFlips(2,6,5));
        System.out.println(minFlips(4,2,7));
        System.out.println(minFlips(1,2,3));

    }

    public static void main(String[] args) {
        new FlipOperations().execute();
    }
}
