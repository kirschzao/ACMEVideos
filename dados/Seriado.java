package dados;

public class Seriado extends Video{

    private int anoInicio;
    private int anoFim;
    private int numEpisodios;

    public Seriado (int codigo, String titulo, int anoInicio, int anoFim, int numEpisodios){
        super(codigo , titulo);  
        this.anoFim = anoFim;
        this.anoInicio = anoInicio;     
        this.numEpisodios = numEpisodios;
    }
    
    @Override
    public String geraTexto(){
        String texto = getCodigo() + "-" + getTitulo() + "-" + getAnoInicio() + "-" + getAnoFim()+ "-" + getNumEpisodio() + "-"+ String.format("%.2f", calculaCusto());
        return texto;     
    }

    @Override
    public double calculaCusto(){
        double custo = this.numEpisodios*0.5;
        return custo;
    }

    public int getAnoFim(){
        return this.anoFim;
    }

    public int getAnoInicio(){
        return this.anoInicio;
    }
    
    public int getNumEpisodio(){
        return this.numEpisodios;
    }

}
