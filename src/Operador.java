public class Operador{
    private String name;
    private int id;

    // cName para construtorName
    public Operador(String cName, int cId){
        if(cId < 0){
            throw new IllegalArgumentException("ID Inválido! Selecione um ID maior que zero");
        }
        this.name = cName;
        this.id = cId;
    }

    public String getName(){
        return name;
    }
    public void setId(int newId){
        this.id = newId;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return "Operador: " + name + " - ID: " + id;
    }
}