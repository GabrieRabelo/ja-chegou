import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private ListaDeMoradores listaDeMoradores;

    public App() {
        listaDeMoradores = new ListaDeMoradores();
        populaApp();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int opcao = 1;

        System.out.println("Bem vindo ao App já chegou do Condomínio ES");
        System.out.println("===============================");

        while(opcao!= 0){       // Repetição do menu

            System.out.println();
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1- Listar Moradores");
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
                    listarMoradores();
                    break;
                case 0:     // Sai do menu, encerra programa
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void listarMoradores() {
        System.out.println(listaDeMoradores);
    }


    private void populaApp(){
        populaLista();
    }

    private void populaLista(){
        Morador velloso = new Morador("Gabriel Velloso" , 3464224754L, 24);
        Morador rabelo = new Morador("Gabriel Rabelo", 3456353333L, 12);
        Morador adriana = new Morador("Adriana Serpa", 2353433423L, 23);
        Morador roberto = new Morador("Roberto Rezende", 3246863534L, 34);
        Morador juliane = new Morador("Juliane Beatrycce", 3468532243L, 54);
        Morador andre = new Morador("André Sacilotto", 3457543224L, 33);
        Morador callegari = new Morador("Daniel Callegari", 3345467990L, 88);
        Morador luiz = new Morador("Luiz Eduardo dos Reis", 4446662343L, 32);
        Morador severo = new Morador("Gabriel Severo", 4567893456L, 31);
        Morador leonardo = new Morador("Leonardo Silva", 1236784563, 22);

        listaDeMoradores.adicionaMorador(velloso);
        listaDeMoradores.adicionaMorador(rabelo);
        listaDeMoradores.adicionaMorador(adriana);
        listaDeMoradores.adicionaMorador(roberto);
        listaDeMoradores.adicionaMorador(juliane);
        listaDeMoradores.adicionaMorador(andre);
        listaDeMoradores.adicionaMorador(callegari);
        listaDeMoradores.adicionaMorador(luiz);
        listaDeMoradores.adicionaMorador(severo);
        listaDeMoradores.adicionaMorador(leonardo);

        System.out.println("Foram adicionados " + listaDeMoradores.getSize() + " moradores na lista de moradores.");
    }


}
