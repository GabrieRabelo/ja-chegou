import java.time.LocalDateTime;


public class Entrega {

    private LocalDateTime data;
    private String descricao;
    private String apDestino;
    private int id;
    private Operador usuario;
    private LocalDateTime dataRetirada;
    private Morador moradorRetirada;

    public Entrega(String descricao,String apDestino, int id, Operador usuario){
        data = LocalDateTime.now();
        this.descricao = descricao;
        this.apDestino = apDestino;
        this.id = id;
        this.usuario = usuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public String getApDestino() {
        return apDestino;
    }

    public Operador getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public Morador getMoradorRetirada() {
        return moradorRetirada;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setDataRetirada(LocalDateTime dataRetirada){this.dataRetirada = dataRetirada;}

    public void setMoradorRetirada(Morador moradorRetirada) {
        this.moradorRetirada = moradorRetirada;
    }

    @Override
    public String toString() {
        return "ID: " + id  + "- Data: " + data + " - Descrição: " + descricao + " - Apto: "+ apDestino + " - Operador: " + usuario.getIniciais();
    }
}
