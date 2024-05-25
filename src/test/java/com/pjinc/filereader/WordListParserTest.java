package com.pjinc.filereader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class WordListParserTest {

	public static final ClassPathResource EMPTY_RES = new ClassPathResource("empty.txt");
	public static final ClassPathResource DATA_RES = new ClassPathResource("data.txt");

	@Test
	public void givenEmptyFile_returnsEmptyList() throws IOException {
		List<String> data = Files.readAllLines(EMPTY_RES.getFile().toPath(),
				StandardCharsets.ISO_8859_1);
		Assertions.assertTrue(data.isEmpty());
	}

	@Test
	public void givenDataFile_returnListWithElements() throws IOException {
		List<String> data = Files.readAllLines(DATA_RES.getFile().toPath(),
				StandardCharsets.ISO_8859_1);
		Assertions.assertEquals(2, data.size());
	}
}
