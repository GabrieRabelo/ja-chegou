import java.util.Scanner;  // Importa a classe Scanner (para o input)
public class Operadores {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        /* 
        Classe de teste apenas - não será usada no final
        - Usar essa clase para criar una lista de Operador com método para selecionar Operador
        */

        // Array para adicionar os nomes
        String nomes[] = new String[10];
        nomes[0] = "Luiz";
        nomes[1] = "Gabriel";
        nomes[2] = "Roberto";
        nomes[3] = "Leonardo";
        nomes[4] = "André";
        nomes[5] = "Wiillian";
        nomes[6] = "Bruna";
        nomes[7] = "Amanda";
        nomes[8] = "Professor";
        nomes[9] = "Seu barriga";


        // Adiciona um nome e o id para os operadores
        Operador[] operadores = new  Operador[10];
        for (int i = 0; i < operadores.length; i++) {
            operadores[i] = new Operador(nomes[i], i);
        };

        // Lista todos os operadores registrados
        System.out.println("\n----------Lista de operadores----------\n");
        for (int i = 0; i < operadores.length; i++) {
            System.out.println("Nome: " + operadores[i].getName());
            System.out.println("ID: " + operadores[i].getId() + "\n");
        }

        // Seleciona o operador pelo ID
        System.out.println("Selecione um operador pelo seu ID: ");
        int selectId = in.nextInt();

        // Mostra o retorno do ID para o operador selecionado
        System.out.println("\n----------Operador selecionado----------\n");
            // Para fazer => System.out.println("Nome do operador: " + getSelectedID(selectId, operadores));
        System.out.println("ID do operador: " + getSelectedID(selectId, operadores));



    }
    // Para arrumar: Retornar o objeto Operador para acessar o nome e ID.
    public static int getSelectedID(int idS, Operador operadores[]){
        int IdSelected = 0;
        for (int i = 0; i < operadores.length; i++) {
            if(operadores[i].getId() != idS){
                continue;
            }
            else
                IdSelected = operadores[i].getId();
        }
        return IdSelected;
    }

}
