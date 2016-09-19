package com.pjinc.filereader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

	@Test
	public void givenEmptyFile_returnsEmptyList() throws IOException, URISyntaxException {
		List<String> data = FileReader.parseFromFile("empty.txt");
		Assert.assertTrue(data.isEmpty());
	}

	@Test
	public void givenDataFile_returnListWithElements() throws IOException, URISyntaxException {
		List<String> data = FileReader.parseFromFile("data.txt");
		Assert.assertEquals(2, data.size());
	}
}
