package ArraysString;

import Base.BaseExecutor;

public class BalancedStringSplit implements BaseExecutor {

    int balancedStringSplit(String s) {

        int count = 0, result = 0;
        for(Character c : s.toCharArray()) {
            if(c == 'R') {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                result++;
            }
        }
        return result;
    }

    @Override
    public void execute() {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    public static void main(String[] args) {
        new BalancedStringSplit().execute();
    }
}
