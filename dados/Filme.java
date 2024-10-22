package dados;

public class Filme extends Video{

    private String diretor;
    private double duracao;

    public Filme(int codigo, String titulo, String diretor, double tempo){
        super(codigo , titulo);  
        this.diretor = diretor;
        this.duracao = tempo;     
    }
    
    @Override
    public String geraTexto(){
        String texto = getCodigo() + "-" + getTitulo() + "-" + getDiretor() + "-" + String.format("%.2f", getTempo()) + "-" + String.format("%.2f", calculaCusto());
        return texto;     
    }

    @Override
    public double calculaCusto(){
        double custo = this.duracao*0.3;
        return custo;
    }

    public String getDiretor(){
        return diretor;
    }

    public double getTempo(){
        return duracao;
    }

}
