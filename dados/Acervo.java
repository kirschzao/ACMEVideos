package dados;
import java.util.ArrayList;

public class Acervo{
    private ArrayList<Video> listaVideos;
    private ArrayList<Diretor> listaDiretores;

    public Acervo(){
        this.listaVideos = new ArrayList<Video>();
        this.listaDiretores = new ArrayList<Diretor>();
    }

    public boolean addVideo(Video v){
        for (Video vi : listaVideos){
            if(vi.getCodigo() == v.getCodigo()){
                return false;
            }
        }
        listaVideos.add(v);

        if(v instanceof Filme){
            for (Diretor dir : listaDiretores) {
                if(dir.getNome().equals(((Filme) v).getDiretor())){
                    dir.aumentaCount();
                    return true;
                }
            }
            Diretor novo = new Diretor(((Filme) v).getDiretor());
            listaDiretores.add(novo);
        }
        return true;
    }

    public Video tituloMaisLongo(){
        String nome = "";
        for (Video vi : listaVideos){
            if(nome.length() < (vi.getTitulo()).length()){
                nome = vi.getTitulo();
            }
        }
        
        for(Video v : listaVideos){
            if(nome.equals(v.getTitulo())){
                return v;
            }
        }
        return null;
    }

    public Video custoMenor(){
        double custo = 100000000;
        int codigo = 00;
        for (Video vi : listaVideos){
            if(custo > vi.calculaCusto()){
                codigo = vi.getCodigo();
                custo = vi.calculaCusto();
            }
        }
        
        for(Video v : listaVideos){
            if(codigo == v.getCodigo()){
                return v;
            }
        }
        return null;
    } 

    public Seriado seriadoMaisVelho(){
        Seriado maisVelho = new Seriado(0,"",0,0,0);
        for(Video v: listaVideos){
            if(v instanceof Seriado){
                if(((Seriado) v).getIdade() > maisVelho.getIdade()){
                    maisVelho = (Seriado) v;
                }
            }
        }
        return maisVelho;
    }

    public Diretor diretorMaisFilmes(){
        Diretor suporte = new Diretor(null);
        for (Diretor dir : listaDiretores) {
            if(dir.getCount() >= suporte.getCount()){
                suporte = dir;
            }
        }
        if(suporte.getNome() == null){
            return null;
        }
        return suporte;
    }

    public Video menorDesvioPadrao(){
        double denominador = listaVideos.size();
        double numerador = 0;
        for (Video v : listaVideos) {
            numerador = numerador + v.calculaCusto();
        }
        double media = numerador/denominador;
        double menorDP = 10;
        Video menorDesvio = listaVideos.get(0);

        for (Video v : listaVideos) {
            if( Math.abs(media-v.calculaCusto()) < menorDP){
                menorDP = Math.abs(media-v.calculaCusto());
                menorDesvio = v;
            }
        }
        return menorDesvio;
    }

    public double media(){
        double denominador = listaVideos.size();
        double numerador = 0;
        for (Video v : listaVideos) {
            numerador = numerador + v.calculaCusto();
        }
        double media = numerador/denominador;
        return media;
    }
}