package com.pjinc.random.selector;

import com.pjinc.resources.V1WordList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RandomSelectorTest {

    @Test
    public void given25_selects25() {
        List<String> wordList = Arrays.asList(
                "AFRIKA",
                "AGENTAS",
                "ORAS",
                "ATEIVIS",
                "ALPĖS",
                "AMAZONĖS",
                "GREITOJI",
                "AMERIKA",
                "ANGELAS",
                "ANTARCTIKA",
                "OBUOLYS",
                "RANKA",
                "ATLANTIKS",
                "AUSTRALIA",
                "ACTEKAI",
                "NUGARA",
                "KAMUOLYS",
                "GRUPĖ",
                "BANKAS",
                "BARAS",
                "LOTI",
                "PAGRINDAS",
                "ŠIKŠNOSPATNIS",
                "BATERIJA",
                "PRIEPLAUKA"
        );
        RandomSelector randomSelector = new RandomSelector(wordList);
        V1WordList codeNames = randomSelector.selectFrom(25);
        Assertions.assertEquals(wordList, codeNames.names());
    }

    @Test
    public void given100_selects25() {
        List<String> wordList = Arrays.asList(
                "AFRIKA",
                "AGENTAS",
                "ORAS",
                "ATEIVIS",
                "ALPĖS",
                "AMAZONĖS",
                "GREITOJI",
                "AMERIKA",
                "ANGELAS",
                "ANTARCTIKA",
                "OBUOLYS",
                "RANKA",
                "ATLANTIKS",
                "AUSTRALIA",
                "ACTEKAI",
                "NUGARA",
                "KAMUOLYS",
                "GRUPĖ",
                "BANKAS",
                "BARAS",
                "LOTI",
                "PAGRINDAS",
                "ŠIKŠNOSPATNIS",
                "BATERIJA",
                "PRIEPLAUKA",
                "PEREJA"
        );

        RandomSelector randomSelector = new RandomSelector(wordList);
        V1WordList codeNames = randomSelector.selectFrom(25);
        Assertions.assertEquals(25, codeNames.names().size());
    }

}
