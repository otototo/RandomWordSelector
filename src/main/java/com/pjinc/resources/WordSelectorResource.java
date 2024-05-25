package com.pjinc.resources;

import com.pjinc.random.selector.RandomSelector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordSelectorResource {
    private final RandomSelector randomSelector;

    public WordSelectorResource(RandomSelector randomSelector) {
        this.randomSelector = randomSelector;
    }

    @GetMapping(path = "v1/words", produces = {"application/json"})
    public V1WordList getCodeNames() {
        return randomSelector.selectFrom(25);
    }
}
