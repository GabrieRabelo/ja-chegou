public class Morador {

    private String nome;
    private long rg;
    private int numeroApartamento;

    public Morador(String nome, long rg, int numeroApartamento) {
        this.nome = nome;
        this.rg = rg;
        this.numeroApartamento = numeroApartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public long getRg() {
        return rg;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int novoNumeroApartamento) {
        this.numeroApartamento = novoNumeroApartamento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", RG: " + rg + ", Apto: " + numeroApartamento;
    }
}
