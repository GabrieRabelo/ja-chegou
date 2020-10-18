import java.time.LocalDateTime;


public class Entrega {

    private LocalDateTime data;
    private String descricao;
    private int id;
    private Operador usuario;

    public Entrega(String descricao, int id, Operador usuario){
        data = LocalDateTime.now();
        this.descricao = descricao;
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

    public Operador getUsuario() {
        return usuario;
    }


}
