package com.pjinc.filereader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static final String ISO_8859_4 = "ISO-8859-4";

	public static List<String> parseFromFile(String fileName) throws IOException, URISyntaxException {
        Path fileFromResource = getFileFromResource(fileName);
        System.out.println("FileFromResoure:"+fileFromResource);
		return Files.readAllLines(fileFromResource, Charset.forName("UTF-8"));
    }

    private static Path getFileFromResource(String fileName) throws URISyntaxException {
    	URI uri = FileReader.class.getClassLoader().getResource(fileName).toURI();
    	System.out.println("uri:"+uri);
		return Paths.get(uri);        
    }

}
