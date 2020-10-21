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

    public boolean Retirada(Entrega entrega, Morador moradorRetirada){
        if(entrega==null || moradorRetirada == null) return false;
        if(entrega.getMoradorRetirada() != null || entrega.getDataRetirada() != null ) return false;
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

    public String buscaNaoRetiradas(){
        String ret = "====== Lista de Entregas Não Retiradas ======\n";
        for (Entrega entrega : lista) {
            if (entrega.getDataRetirada() == null){
                ret += entrega + "\n";
            }
        }
        return ret;
    }

    public Entrega buscaPorId(int id){
        for(Entrega entrega : lista){
            if (entrega.getId()==id) return entrega;
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "===== Lista de Entregas =====\n";
        for (Entrega entrega : lista) {
            ret += entrega;
            if (entrega.getDataRetirada()!=null)
                ret += " - Retirada: " + entrega.getDataRetirada() + " - Morador: " + entrega.getMoradorRetirada().getNome()+ "\n";
            else ret += "- Retirada:                         " + " - Morador:                "+ "\n";
        }
        return  ret;
    }
}
