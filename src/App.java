import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public App() {
        //Construtor vazio
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int opcao = 1;

        System.out.println("Bem vindo ao App já chegou do Condomínio ES");
        System.out.println("===============================");

        while(opcao!= 0){       // Repetição do menu

            System.out.println();
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1- Testar método 1");
            System.out.println("0- Sair");

            try{       // Impede que usuário digite letra
                opcao = in.nextInt();
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente.");
                in.nextLine();
                continue;
            }


            switch (opcao){
                case 1:
                    metodoUm(); // Executa método 1
                    break;
                case 0:     // Sai do menu, encerra programa
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Exemplo de método chamado pelo menu
     */
    public void metodoUm() {
        System.out.println("Método 1 executado com sucesso");
    }

}
