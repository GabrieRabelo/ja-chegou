import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListaDeEntregas {

    private ArrayList<Entrega> lista;
    private int count;

    public ListaDeEntregas(){
        lista = new ArrayList<>();
        count = 1;
    }

    public boolean adicionaEntrega(Entrega novaEntrega){
        if (novaEntrega==null) return false;
        lista.add(novaEntrega);
        count ++;
        return true;
    }

    public boolean Retirada(Entrega entrega, Morador moradorRetirada){
        if(entrega==null || moradorRetirada == null) return false;
        entrega.setDataRetirada(LocalDateTime.now());
        entrega.setMoradorRetirada(moradorRetirada);
        return true;
    }

    public int getCount(){
        return count;
    }

    public ArrayList<Entrega> buscaPorDescricao(String descricao){
       ArrayList subLista = new ArrayList<Entrega>();
       String descricaoTratada = descricao.toLowerCase();
        for (Entrega entrega : lista) {
            if(entrega.getDescricao().toLowerCase().contains(descricaoTratada)){
                subLista.add(entrega);
            }
        }
        return subLista;
    }

    @Override
    public String toString() {
        String ret = "===== Lista de Entregas =====\n";
        for (Entrega entrega : lista) {
            ret += entrega + "\n";
        }
        return  ret;
    }
}
