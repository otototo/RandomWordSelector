package com.pjinc.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjinc.filereader.FileReader;
import com.pjinc.random.selector.RandomSelector;

@Path("/"+WordSelectorResource.VERSION_V1+"/"+WordSelectorResource.PATH_WORDS)
public class WordSelectorResource {

	public static final String VERSION_V1 = "v1";
	public static final String PATH_WORDS = "words";
	// private static final Logger LOG =
	// LoggerFactory.getLogger(CodeNamesRestApi.class);

	@GET
	@Produces("application/json; charset=UTF-8")
	public Response getCodeNames() throws IOException, URISyntaxException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<String> wordList = FileReader.parseFromFile("wordList.txt");
			V1WordList codeNames = RandomSelector.selectFrom(wordList);
			System.out.println("selected:"+codeNames);
			final String json = objectMapper.writeValueAsString(codeNames);
			System.out.println("sending out:"+json);
			return Response.ok(json).build();
		} catch (IOException e) {
			System.err.println("Failed to read the word file:" + e.getMessage() + "/n/r" + e.getStackTrace());
			return Response.serverError().build();
		}
	}
}
