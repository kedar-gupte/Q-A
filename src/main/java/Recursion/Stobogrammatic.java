package Recursion;

import Base.BaseExecutor;

import java.util.*;

public class Stobogrammatic implements BaseExecutor {

    String[][] arr = {{"1", "1"},{"0", "0"},{"8", "8"},{"6", "9"},{"9", "6"}};

    public List<String> findStrobogrammatic(int n) {

        List<String> result = new ArrayList<>();
        if(n%2 == 0) {
            build(n, "", result);
        } else {
            build(n-1, "1", result);
            build(n-1, "0", result);
            build(n-1, "8", result);
        }

        return result;
    }

    public void build(int n, String temp, List<String> result) {

        if(n == 0) {
            result.add(temp);
            return;
        }
        for(String[] element : arr) {
            if(element[0] != "0" || n-2 != 0)
                build(n-2, element[0] + temp + element[1], result);
        }
    }

    @Override
    public void execute() {

        findStrobogrammatic(4).forEach(e -> {
            System.out.println(e);
        });

    }

    public static void main(String[] args) {
        new Stobogrammatic().execute();
    }
}
