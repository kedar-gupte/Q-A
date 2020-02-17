package Design;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public boolean isWord;
    public Map<Character, Trie> map;

    /** Initialize your data structure here. */
    public Trie() {
        isWord = false;
        map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie dictionary = this;
        for(Character c : word.toCharArray()) {
            if(dictionary.map.containsKey(c)) {
                dictionary = dictionary.map.get(c);
            } else {
                Trie temp = new Trie();
                dictionary.map.put(c, temp);
                dictionary = temp;
            }
        }
        dictionary.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie dictionary = this;
        for(Character c : word.toCharArray()) {
            if(dictionary.map.containsKey(c)) {
                dictionary = dictionary.map.get(c);
            } else {
                return false;
            }
        }
        return dictionary.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie dictionary = this;
        for(Character c : prefix.toCharArray()) {
            if(dictionary.map.containsKey(c)) {
                dictionary = dictionary.map.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
