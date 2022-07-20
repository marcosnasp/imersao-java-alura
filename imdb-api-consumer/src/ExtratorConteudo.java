import java.util.List;

public abstract class ExtratorConteudo {
    /**
     * @param json
     * @return
     */
    abstract List<Conteudo> extrair(String json);
}
