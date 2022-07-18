import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

// https://www.youtube.com/watch?v=e7FJaSXwvdk
public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> json = client.send(request, BodyHandlers.ofString());
        String body = json.body();

        var jsonParser = new JsonParser();
        List<Map<String, String>> listaFilmes = jsonParser.parse(body);
        for (Map<String, String> filme : listaFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("\n");
        }
    }
}
