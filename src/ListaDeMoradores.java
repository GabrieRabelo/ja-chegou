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

    @Override
    public String toString() {
        String listaDeMoradores = "===== ListaDeMoradores =====\n";

        for (int i=0; i<lista.size(); i++){
            listaDeMoradores = listaDeMoradores + lista.get(i) + "\n";
        }
        return listaDeMoradores;
    }
}
