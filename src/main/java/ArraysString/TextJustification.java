package ArraysString;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/uber/289/array-and-string/1685/
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class TextJustification implements BaseExecutor {

    List<String> fullJustify(String[] words, int maxWidth) {

        int lastIndex = words.length - 1, len = 0;

        List<String> result = new ArrayList<>();

        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {

            if((len + words[i].length() + list.size()) <= maxWidth) {
                list.add(words[i]);
                len += words[i].length();
            } else {
                result.add(align(list, len, maxWidth, i - 1 == lastIndex));
                list.clear();
                list.add(words[i]);
                len = words[i].length();
            }

        }

        if(!list.isEmpty()) {
            result.add(align(list, len, maxWidth, true));
        }

        return result;

    }

    String align(List<String> list, int len, int maxWidth, boolean lastLine) {

        int size = (list.size() > 1) ? list.size() - 1 : 1;

        int space = (maxWidth - len)/size;
        int rem = (maxWidth - len)%size;

        int spacing = space;

        String s = ""; int i = 0;
        for(String word : list) {
            spacing = space;
            if(rem > 0) {
                spacing++;
                rem--;
            }


            s += word;

            System.out.println(word + " " + lastLine);
            System.out.println(space + " " + rem + " " + size);

            if(lastLine && s.length() < maxWidth) {
                spacing = 1;
            }
            if(i == size) {
                spacing = 0;
            }

            while(spacing > 0) {
                s += " ";
                spacing--;
            }

            i++;
        }

        if(maxWidth - s.length() > 0) {
            spacing = maxWidth - s.length();
            while(spacing > 0) {
                s += " ";
                spacing--;
            }
        }

        return s;
    }

    @Override
    public void execute() {

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(words, 16).forEach(e -> {
            System.out.println("|" + e + "|");
        });

    }

    public static void main(String[] args) {
        new TextJustification().execute();
    }
}
