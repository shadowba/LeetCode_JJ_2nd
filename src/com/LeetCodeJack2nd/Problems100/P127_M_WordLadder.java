package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P127_M_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        int size = 0;
        q.offer(beginWord);
        visited.put(beginWord, 1);

        String word;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            size = q.size();

            while (size > 0) {
                word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    sb.append(word);
                    for (int j = 'a'; j <= 'z'; j++) {
                        sb.replace(i, i + 1, Character.toString(j));
                        if (set.contains(sb.toString())) {
                            if (sb.toString().equals(endWord))
                                return visited.get(word) + 1;
                            if (!visited.containsKey(sb.toString())) {
                                q.offer(sb.toString());
                                visited.put(sb.toString(), visited.get(word)+1);
                            }
                        }
                    }
                    sb.delete(0, sb.length());
                }
                size--;
            }
        }
        return 0;
    }
}
