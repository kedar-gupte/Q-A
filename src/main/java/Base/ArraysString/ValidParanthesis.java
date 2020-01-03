package Base.ArraysString;

import Base.BaseExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParanthesis implements BaseExecutor {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        Set<Character> set = map.keySet();

        for(Character c : s.toCharArray()) {

            if(set.contains(c)) {
                stack.push(c);
            } else {

                if(!stack.isEmpty()) {
                    Character temp = stack.pop();
                    if(map.get(temp) != c) {
                        return false;
                    }
                } else {
                    return false;
                }

            }

        }

        return stack.isEmpty();
    }

    @Override
    public void execute() {

        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("](]"));

    }

    public static void main(String[] args) {

        new ValidParanthesis().execute();

    }
}
