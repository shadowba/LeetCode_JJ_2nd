package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P208_M_ImplementTrie_PrefixTree {
    /**
     * Initialize your data structure here.
     */
    trieNode root;

    public P208_M_ImplementTrie_PrefixTree() {
        root = new trieNode("");
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        trieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.arr[word.charAt(i)-'a']==null)
                cur.arr[word.charAt(i)-'a'] = new trieNode(word.substring(0, i + 1));
//                cur.map.put(word.charAt(i), new trieNode(word.substring(0, i + 1)));
            cur = cur.arr[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        trieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.arr[word.charAt(i)-'a']==null)
                return false;
            cur = cur.arr[word.charAt(i)-'a'];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        trieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.arr[prefix.charAt(i)-'a']==null)
                return false;
            cur = cur.arr[prefix.charAt(i)-'a'];
        }
        return true;
    }

    private class trieNode {
        HashMap<Character, trieNode> map;
        trieNode[] arr;
        String str;
        boolean isWord;

        public trieNode(String input) {
//            map = new HashMap<>();
            arr = new trieNode[26];
            this.str = input;
            isWord = false;
        }
    }
}
