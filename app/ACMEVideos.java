package app;

import dados.Acervo;
import dados.Diretor;
import dados.Filme;
import dados.Seriado;
import dados.Video;
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

            switch (Integer.parseInt(elementos[0].trim())) {
                case 1:
                    Filme filme = new Filme((Integer.parseInt(elementos[1].trim())),elementos[2].trim(),elementos[3].trim(), Double.parseDouble(elementos[4].trim()));
                    if(acervo.addVideo(filme)){
                        System.out.println("1:" +filme.geraTexto());
                    }
                    break;
                case 2:
                    Seriado seriado = new Seriado((Integer.parseInt(elementos[1].trim())),elementos[2].trim(),(Integer.parseInt(elementos[3].trim())),(Integer.parseInt(elementos[4].trim())),(Integer.parseInt(elementos[5].trim())));
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

        //passo 6 - bonus
        calculodeDP();

    }

    public void tituloLongo(){
        try {
            Video video = acervo.tituloMaisLongo();
            String retorno = "2:"+video.getCodigo() +"," + video.getTitulo();
            System.out.println(retorno);
        } catch (Exception e) {
            System.out.println("2:Erro - "+ e.getMessage());
        }
        
    }

    public void custoBaixo(){
       try{
            Video video = acervo.custoMenor();
            String retorno = "3:"+ video.getCodigo()+","+video.getTitulo()+","+ String.format("%.2f",(video.calculaCusto()));
            System.out.println(retorno);
       }catch(Exception e){
            System.out.println("3:Erro - "+ e.getMessage());
       }
    }

    public void maiorExebicao(){
        try{
            Seriado seriado = acervo.seriadoMaisVelho();
            String retorno = "4:"+ seriado.getCodigo()+","+seriado.getTitulo()+","+seriado.getIdade();
            System.out.println(retorno);
        }catch(Exception e){
            System.out.println("4:Erro - "+ e.getMessage());
        }    
    }

    public void diretorMaisCopeiro(){
        try{
            Diretor diretor = acervo.diretorMaisFilmes();
            String retorno = "5:"+ diretor.getNome()+ ","+ diretor.getCount();
            System.out.println(retorno);
        }catch(Exception e){
            System.out.println("5:Erro - "+ e.getMessage());
        }    
    }

    public void calculodeDP(){ 
        String texto = acervo.menorDesvioPadrao().geraTexto();
        String retorno = "6:"+ String.format("%.2f",(acervo.media()))+","+ texto;
        System.out.println(retorno);
    }


}