package app;

import dados.Acervo;
import dados.Diretor;
import dados.Filme;
import dados.Seriado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMEVideos{
    
    private Scanner sc = new Scanner(System.in);  // Atributo para entrada padrao (teclado)
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "dadosentrada.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "relatorio.txt";  // Nome do arquivo de saida de dados
    private final String separadorDeLinha = ";";
    private Acervo acervo = new Acervo();

    public ACMEVideos(){
        redirecionaEntrada();    // Redireciona Entrada para arquivos
        redirecionaSaida();    // Redireciona Saida para arquivos
    }  

    private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            sc = new Scanner(streamEntrada);   // Usa como entrada um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        sc.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
    }

    public void processar(){
        //passo 1
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] elementos = linha.split(separadorDeLinha); // Separar os elementos da linha utilizando o separador ";"

            switch (Integer.parseInt(elementos[0])) {
                case 1:
                    Filme filme = new Filme((Integer.parseInt(elementos[1])),elementos[2],elementos[3], Double.parseDouble(elementos[4]));
                    if(acervo.addVideo(filme)){
                        System.out.println("1:" +filme.geraTexto());
                    }
                    break;
                case 2:
                    Seriado seriado = new Seriado((Integer.parseInt(elementos[1])),elementos[2],(Integer.parseInt(elementos[3])),(Integer.parseInt(elementos[4])),(Integer.parseInt(elementos[5])));
                    if(acervo.addVideo(seriado)){
                        System.out.println("1:" + seriado.geraTexto());
                    }
                    break;    
                default:
                    break;
            }

        }
        
        //passo 2
        tituloLongo();

        //passo 3
        custoBaixo();

        //passo 4
        maiorExebicao();

        //passo 5
        diretorMaisCopeiro();

    }

    public void tituloLongo(){
        String retorno = "2:"+ acervo.tituloMaisLongo().getCodigo() +"," + acervo.tituloMaisLongo().getTitulo();
        System.out.println(retorno);
    }

    public void custoBaixo(){
        String retorno = "3:"+ acervo.custoMenor().getCodigo()+","+acervo.custoMenor().getTitulo()+","+ String.format("%.2f",(acervo.custoMenor().calculaCusto()));
        System.out.println(retorno);
    }

    public void maiorExebicao(){
        Seriado seriado = acervo.seriadoMaisVelho();
        String retorno = "4:"+ seriado.getCodigo()+","+seriado.getTitulo()+","+seriado.getIdade();
        System.out.println(retorno);
    }

    public void diretorMaisCopeiro(){
        Diretor diretor = acervo.diretorMaisFilmes();
        String retorno = "5:"+ diretor.getNome()+ ","+ diretor.getCount();
        System.out.println(retorno);
    }


}