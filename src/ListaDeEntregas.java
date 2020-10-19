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

    public ArrayList<Entrega> buscaNaoRetirada(ArrayList<Entrega> todasEntregas){
        ArrayList<Entrega> naoRetirada = new ArrayList<>();
        for (Entrega entrega : todasEntregas){
            if(entrega.getData() == null)
                naoRetirada.add(entrega);
        }
        return naoRetirada;
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
