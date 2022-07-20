import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    private URI endereco;
    private HttpClient cliente;

    private ClienteHttp(HttpClient cliente, String url) {
        if (this.cliente == null) {
            this.cliente = HttpClient.newHttpClient();
        }
        this.endereco = URI.create(url);
    }

    public ClienteHttp(String url) {
        this(HttpClient.newHttpClient(), url);
    }

    public String buscaDados() {
        if (validarCliente()) {
            var request = HttpRequest.newBuilder(this.endereco).GET().build();
            try {
                HttpResponse<String> json = this.cliente.send(request, BodyHandlers.ofString());
                return json.body();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalStateException("HttpCliente não devidamente configurado");
        }
    }

    private boolean validarCliente() {
        return (this.cliente != null && this.endereco != null);
    }

}
