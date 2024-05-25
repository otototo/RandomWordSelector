package com.pjinc;

import com.pjinc.resources.V1WordList;
import com.pjinc.resources.WordSelectorResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.URISyntaxException;

@WebMvcTest
@ActiveProfiles("test")
public class WordSelectorResourceTest {
    @Autowired
    WordSelectorResource wordSelectorResource;

    @Test
    public void whenGET_returns200AndPayloadWith2Elements() {
        V1WordList wordList = wordSelectorResource.getCodeNames();
        Assertions.assertEquals(2, wordList.names().size());
    }

}
