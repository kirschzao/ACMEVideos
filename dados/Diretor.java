package dados;

public class Diretor {
 
    private String nome;
    private int count;

    public Diretor(String nome){
        this.nome = nome;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public String getNome(){
        return nome;
    }

    public void aumentaCount(){
        count++;
    }

}
