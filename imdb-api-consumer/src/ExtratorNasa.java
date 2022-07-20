import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExtratorNasa extends ExtratorConteudo {

    private JsonParser jsonParser;

    public ExtratorNasa(JsonParser parser) {
        this.jsonParser = parser;
    }

    @Override
    List<Conteudo> extrair(String json) {
        List<Conteudo> listaConteudos = new ArrayList<>();
        Optional<JsonParser> parser = Optional.of(this.jsonParser);
        Optional<String> jsonOptional = Optional.of(json);
        if (parser.isPresent() && jsonOptional.isPresent()) {
            List<Map<String, String>> listaDeAtributos = jsonParser.parse(json);
            for (Map<String, String> filme : listaDeAtributos) {
                String urlImagem = filme.get("image");
                String tituloImagem = filme.get("url").replaceAll("' ", "_")
                        .replaceAll("'", "_")
                        .replaceAll(" ", "_")
                        .replaceAll(":", "_")
                        .replaceAll(",", "_");
                listaConteudos.add(new Conteudo(tituloImagem, urlImagem));
            }
        } else {
            throw new IllegalArgumentException("Argumentos ausentes, impossível realizar a operação");
        }
        return listaConteudos;
    }

}
