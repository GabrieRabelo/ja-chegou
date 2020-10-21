public class Operador{
    private String nome;
    private String iniciais;

    // cName para construtorName
    public Operador(String nome, String iniciais){
        this.nome = nome;
        this.iniciais = iniciais.toUpperCase();
    }

    public String getName(){
        return nome;
    }
    public String getIniciais(){
        return iniciais;
    }

    @Override
    public String toString() {
        return "Operador: " + nome + " - Iniciais: " + iniciais;
    }
}