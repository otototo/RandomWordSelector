package com.pjinc.random.selector;

import com.pjinc.resources.V1WordList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomSelector {
    private final List<String> wordList;

    public RandomSelector(List<String> wordList) {
        this.wordList = wordList;
    }

    public V1WordList selectFrom(int maxSize) {
        Collections.shuffle(wordList);
        List<String> selectedList = wordList.stream()
                .limit(maxSize)
                .collect(Collectors.toList());
        return new V1WordList(selectedList);
    }

}
