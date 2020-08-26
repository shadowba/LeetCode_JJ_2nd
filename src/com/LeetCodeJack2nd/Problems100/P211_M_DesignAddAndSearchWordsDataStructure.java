package com.LeetCodeJack2nd.Problems100;

public class P211_M_DesignAddAndSearchWordsDataStructure {
    public static class WordDictionary {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node("");
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null)
                    cur.children[word.charAt(i) - 'a'] = new Node(word.substring(0, i + 1));
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return helper(word, root, 0);
        }

        private boolean helper(String word, Node root, int idx) {
            if (root == null)
                return false;
            if (idx == word.length()){
                if(root.val.equals(word) && root.isWord)
                    return true;
                else
                    return false;
            }

            if (word.charAt(idx) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (root.children[i] != null) {
                        String newStr = word.substring(0, idx) + (char)(i + 'a') + word.substring(idx + 1, word.length());
                        if (helper(newStr, root.children[i], idx + 1))
                            return true;
                    }
                }
            } else {
                if (helper(word, root.children[word.charAt(idx) - 'a'], idx + 1))
                    return true;
            }
            return false;
        }

        private class Node {
            String val;
            Node[] children;
            boolean isWord;

            public Node(String str) {
                this.val = str;
                isWord = false;
                children = new Node[26];
            }
        }
    }


}
