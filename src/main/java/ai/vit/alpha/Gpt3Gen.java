package ai.vit.alpha;

import ai.vit.alpha.model.Responses;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class Gpt3Gen {

    String execSum;

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public Gpt3Gen(String prompt) throws IOException, InterruptedException {

        // json formatted data
        String json = new StringBuilder()
                .append("{")
                .append("\"prompt\":\"")
                .append(prompt)
                .append("\",")
                .append("\"max_tokens\":50")
                .append("}").toString();

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://api.openai.com/v1/engines/davinci/completions"))
                .setHeader("Authorization", "Bearer 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") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
//        System.out.println(response.statusCode());

        // print response body
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap words = objectMapper.readValue(response.body(), HashMap.class);
        Gson g = new Gson();
//        ArrayList<String> w = (ArrayList<String>)words.get("choices");
        Responses r = g.fromJson(response.body(), Responses.class);
//        System.out.println(response.body());
//        System.out.println(words.get("choices"));
         execSum = r.getChoice();

    }

    public String getExecSum() {
        return execSum;
    }
}

