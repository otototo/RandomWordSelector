package com.pjinc.random.selector;

import com.pjinc.resources.V1WordList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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
        V1WordList codeNames = RandomSelector.selectFrom(wordList);
        Assert.assertEquals(wordList, codeNames.names);
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

        V1WordList codeNames = RandomSelector.selectFrom(wordList);
        Assert.assertNotEquals(wordList, codeNames.names);
        Assert.assertEquals(25, codeNames.names.size());
    }

}
