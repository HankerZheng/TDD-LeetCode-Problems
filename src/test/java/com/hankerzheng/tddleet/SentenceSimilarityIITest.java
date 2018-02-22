package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceSimilarityIITest {

    private SentenceSimilarityII solution;

    @Before
    public void setUp() throws Exception {
        solution = new SentenceSimilarityII();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(true, new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, getNormalSimilarity());
        verify(true, new String[]{"good", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, getNormalSimilarity());
        verify(false, new String[]{"good", "acting", "skills"}, new String[]{"fine", "talent", "drama"}, getNormalSimilarity());
    }

    @Test
    public void shouldPassFailedExample() throws Exception {
        verify(true, new String[]{"I","have","enjoyed","happy","thanksgiving","holidays"}, new String[]{"I","have","enjoyed","happy","thanksgiving","holidays"}, getNormalSimilarity());
    }


    private String[][] getNormalSimilarity() {
        return new String[][]{
            {"great", "good"},
            {"fine", "good"},
            {"acting","drama"},
            {"skills","talent"}
        };
    }

    private void verify(final boolean expected, final String[] words1, final String[] words2, final String[][] pairs) {
        assertEquals(expected, solution.areSentencesSimilarTwo(words1, words2, pairs));
    }

}