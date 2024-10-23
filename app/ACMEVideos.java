package app;

import dados.Acervo;
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
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] elementos = linha.split(separadorDeLinha); // Separar os elementos da linha utilizando o separador ";"

            
         
            





        }
    }

    }