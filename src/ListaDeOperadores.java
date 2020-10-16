import java.util.ArrayList;
import java.util.Collection;

public class ListaDeOperadores {
    // Lista de Operadores principal
    private ArrayList<Operador> lista;
    private int contador;

    // Construtor
    public ListaDeOperadores() {
        lista = new ArrayList<>();
    }

    public void add(Operador b) {
        lista.add(b);
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public ArrayList<Operador> getLista() {
        return lista;
    }

    // Método para buscar operador específico pelo ID
    public ArrayList<Operador> getOperadorID(int newID) {
        ArrayList<Operador> list = new ArrayList();
        for (Operador b : lista) {
            if(b.getId() == newID){
                list.add(b);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        String op = "";
        for (Operador operador: lista){
            op = op + operador + "\n";
        }
        return "Lista De Operadores\n" + op;
    }
}