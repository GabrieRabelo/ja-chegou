import java.util.ArrayList;
import java.util.Collection;

public class ListaDeOperadores {
    private ArrayList<Operador> lista;
    private int contador;

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

    public Operador getOperadorInicial(String iniciais) {
        for (Operador b : lista) {
            if(b.getIniciais().equalsIgnoreCase(iniciais)){
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String op = "";
        for (Operador operador: lista){
            op = op + operador + "\n";
        }
        return "---Lista de Operadores:\n" + op;
    }
}