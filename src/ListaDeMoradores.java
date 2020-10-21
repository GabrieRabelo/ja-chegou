import java.util.ArrayList;

public class ListaDeMoradores {

    private ArrayList<Morador> lista;

    public ListaDeMoradores(){
        lista = new ArrayList<>();
    }

    public boolean adicionaMorador(Morador novoMorador){
        if (novoMorador==null) return false;
        lista.add(novoMorador);
        return true;
    }

    public int getSize(){
        return lista.size();
    }


    public Morador buscaPorRG(long rgRetirada){
        for (Morador morador : lista) {
            if (morador.getRg()==rgRetirada)return morador;
        }
        return null;
    }
    @Override
    public String toString() {
        String listaDeMoradores = "===== ListaDeMoradores =====\n";

        for (int i=0; i<lista.size(); i++){
            listaDeMoradores = listaDeMoradores + lista.get(i) + "\n";
        }
        return listaDeMoradores;
    }
}
