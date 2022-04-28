package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {
    public static HttpResponse<String> postRequest(String uri, String postJSON) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new
                            URI(uri))
                    .POST(HttpRequest.BodyPublishers.ofString(postJSON))
                    .header("Content-type", "application/json")
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (IOException | InterruptedException e) {
            System.out.println("Something went wrong with our request!");
            System.out.println(e.getMessage());
        } catch (URISyntaxException ignored) {}

        return null;
    }

    public static HttpResponse<String> getRequest(String uri) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new
                            URI(uri))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();

            return client.send(request,
                    HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            System.out.println("Something went wrong with our request!");
            System.out.println(e.getMessage());
        } catch (URISyntaxException ignored) {}

        return null;
    }
}
