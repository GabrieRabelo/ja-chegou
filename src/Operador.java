public class Operador{
    private String name;
    private String iniciais;

    // cName para construtorName
    public Operador(String cName){
        this.name = cName;
        String[] vetorInicial = cName.split(" ");
        this.iniciais = String.valueOf(vetorInicial[0].charAt(0)) + String.valueOf(vetorInicial[1].charAt(0));
    }

    public String getName(){
        return name;
    }
    public String getIniciais(){
        return iniciais;
    }

    @Override
    public String toString() {
        return "Operador: " + name + " - Iniciais: " + iniciais;
    }
}