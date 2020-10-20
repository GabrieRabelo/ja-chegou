import java.util.ArrayList;
import java.time.LocalDateTime;

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

    public String geraListaComIntervaloDeData(int mesInicial, int diaInicial, int mesFinal, int diaFinal){
        LocalDateTime dataInicio = LocalDateTime.of(2020, mesInicial, diaInicial, 00,00);
        LocalDateTime dataFinal = LocalDateTime.of(2020, mesFinal, diaFinal, 23,59);
        String listaGerada = "====== Lista de Entregas ======\n";
        for (Entrega entrega : lista) {
            if (entrega.getData().isAfter(dataInicio) && entrega.getData().isBefore(dataFinal)){
                listaGerada = listaGerada + entrega + "\n";
            }
        }

        return listaGerada;
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
