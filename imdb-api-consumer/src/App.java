import java.io.InputStream;
import java.net.URL;
import java.util.List;

// https://www.youtube.com/watch?v=e7FJaSXwvdk
public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://api.mocki.io/v2/549a5d8b";
        ClienteHttp cliente = new ClienteHttp(url);

        String json = cliente.buscaDados();

        var jsonParser = new JsonParser();
        ExtratorConteudo extratorImdb = new ExtratorImbd(jsonParser);
        List<Conteudo> listaConteudoImdb = extratorImdb.extrair(json);

        var geradoraDeFigurinhas = new GeradoraDeFigurinhas();
        InputStream inputStream = null;
        for (Conteudo conteudo : listaConteudoImdb) {
            inputStream = new URL(conteudo.getUrlImagem()).openStream();
            System.out.println(conteudo.getTitulo());
            geradoraDeFigurinhas.criar(inputStream, conteudo.getTitulo() + ".png");
        }

    }
}
