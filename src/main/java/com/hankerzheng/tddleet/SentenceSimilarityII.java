package com.hankerzheng.tddleet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 737. Sentence Similarity II
 *
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are similar.
 *
 * For example, words1 = ["great", "acting", "skills"]
 * and words2 = ["fine", "drama", "talent"] are similar,
 * if the similar word pairs are pairs =
 *      [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 *
 * Note that the similarity relation is transitive.
 * For example, if "great" and "good" are similar,
 * and "fine" and "good" are similar, then "great" and "fine" are similar.
 *
 * Similarity is also symmetric.
 * For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 *
 * Also, a word is always similar with itself.
 * For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar,
 * even though there are no specified similar word pairs.
 *
 * Finally, sentences can only be similar if they have the same number of words.
 * So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null && words2 == null) return true;
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        final Map<String, String> unionFind = new HashMap<>();
        for (final String[] pair: pairs) {
            if (!unionFind.containsKey(pair[0])) unionFind.put(pair[0], pair[0]);
            if (!unionFind.containsKey(pair[1])) unionFind.put(pair[1], pair[1]);
            union(unionFind, pair[0], pair[1]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!isSimilarity(unionFind, words1[i], words2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSimilarity(final Map<String, String> unionFind, final String a, final String b) {
        if (!unionFind.containsKey(a) || !unionFind.containsKey(b)) {
            return a.equals(b);
        } else {
            return find(unionFind, a).equals(find(unionFind, b));
        }
    }

    private void union(final Map<String, String> unionFind, final String a, final String b) {
        final String parentA = find(unionFind, a);
        final String parentB = find(unionFind, b);
        unionFind.put(parentA, parentB);
    }

    private String find(final Map<String, String> unionFind, final String a) {
        final LinkedList<String> stack = new LinkedList<>();
        String curNode = a;
        while (unionFind.get(curNode) != curNode) {
            stack.add(curNode);
            curNode = unionFind.get(curNode);
        }
        for(final String node: stack) {
            unionFind.put(node, curNode);
        }
        return curNode;
    }
}
