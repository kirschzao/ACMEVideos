package dados;
public abstract class Video implements Imprimivel{

    private int codigo;
    private String titulo;

        public Video(int codigo, String titulo){
            this.codigo = codigo;
            this.titulo = titulo;
        }

    public abstract String geraTexto();

    public abstract double calculaCusto();

    public int getCodigo(){
        return codigo;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setCodigo(){
        this.codigo = codigo;
    }

    public void setTitulo(){
        this.titulo = titulo;
    }



}