import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    private Graphics2D graphics;

    /**
     * @throws Exception
     */
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {
        File diretorioSaida = criarDiretorioSaida("imdb-api-consumer\\saida");
        File arquivoSaida = new File(diretorioSaida, nomeArquivo);

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar uma nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        final BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);

        // copiar imagem original para nova imagem (em memória)
        graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // escreva um texto na nova imagem
        Font fontString = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        Color cor = Color.YELLOW;
        graphics.setColor(cor);
        graphics.setFont(fontString);

        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        System.out.println(arquivoSaida.getAbsolutePath() + "\n");
        ImageIO.write(novaImagem, "png", arquivoSaida);

        // escrever a nova imagem no arquivo
    }

    public File criarDiretorioSaida(String diretorioPath) throws IOException {
        File diretorioSaida = new File(diretorioPath);
        if (!diretorioSaida.exists()) {
            diretorioSaida.mkdir();
        }
        return diretorioSaida;
    }

    public void verificarExistenciaDiretorioEntrada(File diretorioImagemEntrada) throws FileNotFoundException {
        if (diretorioImagemEntrada.exists()) {
            System.out.println(diretorioImagemEntrada.getAbsolutePath() + " existe");
        } else {
            System.out.println(diretorioImagemEntrada.getAbsolutePath() + " não existe");
            throw new FileNotFoundException(diretorioImagemEntrada.getAbsolutePath() + " não existe");
        }
    }

    public void verificarArquivoEntradaExiste(File arquivoEntradaFilme) throws FileNotFoundException {
        if (!arquivoEntradaFilme.exists()) {
            throw new FileNotFoundException(
                    "Arquivo imdb-api-consumer\\entrada\\filme.jpg não encontrado no diretorio: "
                            +
                            arquivoEntradaFilme.getPath());
        }
    }

}
