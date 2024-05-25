package com.pjinc.config;


import com.pjinc.random.selector.RandomSelector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@Configuration
public class ApplicationConfig {
    @Bean("fileName")
    public String fileName(@Value("${app.wordlist.filename}") String fileName) {
        return fileName;
    }

    @Bean(name = "wordListResource")
    public ClassPathResource wordListResource(@Qualifier("fileName") String fileName) {
        return new ClassPathResource(fileName);
    }

    @Bean(name = "wordList")
    public List<String> wordlist(@Qualifier("wordListResource") ClassPathResource wordListResource) throws IOException {
        File file = wordListResource.getFile();
        return Files.readAllLines(file.toPath(), StandardCharsets.ISO_8859_1);
    }

    @Bean
    public RandomSelector randomSelector(@Qualifier("wordList") List<String> wordlist) {
        return new RandomSelector(wordlist);
    }
}
