import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int opcao = 1;

        //Operador opatual = new Operador (nome, id, ....)

        System.out.println("App já chegou do Condomínio ES");
        System.out.println("===============================");
        System.out.println("");
        //System.out.println("O usuário atual é: " + opatual);
        System.out.println("");
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Mudar operador");
        System.out.println("0- Sair");

        opcao = in.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Digite as iniciais do novo operador: ");
                String iniciaisNovoOperador = in.nextLine();
                //opatual = ListaOperadores.mudarOperador(iniciaisNovoOperador);
                break;
            case 2:
            case 3:
            case 0:
            default:

        }


    }

}
