package com.pjinc.random.selector;

import com.pjinc.resources.V1WordList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomSelector {

    public static V1WordList selectFrom(List<String> wordList) {
        Collections.shuffle(wordList);
        List<String> selectedList = wordList.stream().limit(25).collect(Collectors.toList());
        return new V1WordList(selectedList);
    }

}
