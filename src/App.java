import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final Scanner in = new Scanner(System.in);

    private ListaDeMoradores listaDeMoradores;
    private ListaDeOperadores listaDeOperadores;
    private ListaDeEntregas listaDeEntregas;
    private Operador operadorAtual;

    public App() {
        listaDeMoradores = new ListaDeMoradores();
        listaDeOperadores = new ListaDeOperadores();
        listaDeEntregas = new ListaDeEntregas();
        populaApp();
    }

    public void run() {
        int opcao = 1;

        System.out.println("\nBem vindo ao App já chegou do Condomínio ES");
        System.out.println("===============================");

        while(opcao!= 0){       // Repetição do menu

            System.out.println();
            System.out.println("Escolha uma das opções abaixo: \n");

            System.out.println("---------- Operador ----------");
            System.out.println("1 - Escolher operador");
            System.out.println("2 - Incluir novo operador");

            System.out.println("----------- Entrega -----------");
            System.out.println("3 - Registrar Entrega");
            System.out.println("4 - Registrar Retirada");
            System.out.println("5 - Procurar entregas pela descrição");
            System.out.println("6 - Listar entregas não retiradas");
            System.out.println("7 - Gerar relatório de entregas com data inicial e data final");

            System.out.println("--------- Moradores -----------");
            System.out.println("8 - Incluir novo Morador");
            System.out.println("9 - Listar Todos Moradores");

            System.out.println("0 - sair\n");

            try{       // Impede que usuário digite letra
                opcao = in.nextInt();
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente.");
                in.nextLine();
                continue;
            }


            switch (opcao){
                case 1 :
                    escolheOperador();                
                    break;

                case 2:
                    novoOperador();
                    break;

                case 3:
                    registraEntrega();
                    break;

                case 4:
                    registraRetirada();
                    break;

                case 5:
                    listaEntregasPorDescricao();
                    break;

                case 6:
                    listaNaoRetirada();
                    break;

                case 7:
                    geraRelatorio();
                    break;

                case 8:
                    novoMorador();
                    break;

                case 9:
                    listarMoradores();
                    break;

                case 0:     // Sai do menu, encerra programa
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void escolheOperador(){
        System.out.println(listaDeOperadores.toString());
        System.out.println("\n--------Escolha um operador pelas suas iniciais. ex: GR--------");
        String inicialEsc = in.nextLine();
        Operador operador =listaDeOperadores.getOperadorInicial(inicialEsc);
        if(operador != null){
            operadorAtual = operador;
            System.out.println("Operador atual: " + operadorAtual.getName() + " (" + operadorAtual.getIniciais() + ")");
        }
        else
            System.out.println("Operador com iniciais " + inicialEsc + " não encontrado.");
    }

    private void novoOperador(){
        System.out.println("Informe o nome e último nome do novo operador\n");
        String nome = in.nextLine();
        if(nome.split(" ").length == 2){
            listaDeOperadores.add(new Operador(nome));
            System.out.println(nome + " adicionado a lista de operadores\n");
        }
        else
            System.out.println("Nome inválido.");
    }


    private void registraEntrega(){
        System.out.println("Informe a descrição da entrega\n");
        String descricao = in.nextLine();
        System.out.println("Informe o apartamento de destino\n");
        String apDestino = in.nextLine();
        listaDeEntregas.adicionaEntrega(new Entrega(descricao,apDestino,listaDeEntregas.getCount(), operadorAtual));
    }

    private void registraRetirada() {
        System.out.println("Informe o id da entrega\n");
        int idRetirada = in.nextInt();
        System.out.println("Informe o RG do morador\n");
        long rgRetirada = in.nextLong();
        Morador recebido = listaDeMoradores.buscaPorRG(rgRetirada);
        Entrega aux = listaDeEntregas.buscaPorId(idRetirada);
        if(listaDeEntregas.Retirada(aux,recebido))
            System.out.println("Retirada realizada com sucesso\n");
        else {
            System.out.println("ERRO: Retirada já realizada");
        }
    }

    private void listaEntregasPorDescricao(){
        System.out.println("Informe a descrição para pesquisa da entrega:\n");
        String descricao = in.nextLine();
        ArrayList subLista = listaDeEntregas.buscaPorDescricao(descricao);
        if(!subLista.isEmpty()){
            System.out.println(subLista);
        }else{
            System.out.println("Descrição não encontrada!");
        }
        }

    private void geraRelatorio(){
        int mesInicio = 0;
        int diaInicio = 0;
        int mesFinal = 0;
        int diaFinal = 0;

        while (mesInicio<1 || mesInicio>12){
        System.out.println("Informe o mês da data inicial do relatório");
        mesInicio = in.nextInt();
        if (mesInicio<1 || mesInicio>12) System.out.println("Entrada inválida. Tente novamente.");
        }

        if (mesInicio == 1 || mesInicio == 3 || mesInicio == 5 || mesInicio == 7
                || mesInicio == 8 || mesInicio == 10 || mesInicio == 12){
        while (diaInicio<1 || diaInicio>31) {
            System.out.println("Informe o dia da data inicial do relatório");
            diaInicio = in.nextInt();
            if (diaInicio<1 || diaInicio>31) System.out.println("Entrada inválida. Tente novamente.");
        }
        }

        if (mesInicio == 4 || mesInicio == 6 || mesInicio == 9 || mesInicio == 11) {
            while (diaInicio<1 || diaInicio>30) {
                System.out.println("Informe o dia da data inicial do relatório");
                diaInicio = in.nextInt();
                if (diaInicio<1 || diaInicio>30) System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        if (mesInicio == 2) {
            while (diaInicio<1 || diaInicio>28) {
                System.out.println("Informe o dia da data inicial do relatório");
                diaInicio = in.nextInt();
                if (diaInicio<1 || diaInicio>28) System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        while (mesFinal<1 || mesFinal>12) {
            System.out.println("Informe o mês da data final do relatório");
            mesFinal = in.nextInt();
            if (mesFinal<1 || mesFinal>12) System.out.println("Entrada inválida. Tente novamente.");
        }

        if (mesFinal == 1 || mesFinal == 3 || mesFinal == 5 || mesFinal == 7
                || mesFinal == 8 || mesFinal == 10 || mesFinal == 12){
            while (diaFinal<1 || diaFinal>31) {
                System.out.println("Informe o dia da data final do relatório");
                diaFinal = in.nextInt();
                if (diaFinal<1 || diaFinal>31) System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        if (mesFinal == 4 || mesFinal == 6 || mesFinal == 9 || mesFinal == 11) {
            while (diaFinal<1 || diaFinal>30) {
                System.out.println("Informe o dia da data final do relatório");
                diaFinal = in.nextInt();
                if (diaFinal<1 || diaFinal>30) System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        if (mesFinal == 2) {
            while (diaFinal<1 || diaFinal>28) {
                System.out.println("Informe o dia da data final do relatório");
                diaFinal = in.nextInt();
                if (diaFinal<1 || diaFinal>28) System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        System.out.println(listaDeEntregas.geraListaComIntervaloDeData(mesInicio,diaInicio,mesFinal,diaFinal));

    }

    private void novoMorador(){
        System.out.println("Informe o nome completo do novo morador: \n");
        String nome = in.nextLine();

        System.out.println("Informe o RG do morador: \n");
        long rg = in.nextLong();
        while(rg < 1){
            System.out.println("RG inválido (Usar inteiro positivo).");
            rg = in.nextLong();
        }

        System.out.println("Informe o número do apartamento deste morador: \n");
        int numAp = in.nextInt();
        while(rg < 1){
            System.out.println("RG inválido (Usar inteiro positivo).");
            rg = in.nextLong();
        }

        while (numAp < 1){
            System.out.println("Número de apartamento inválido (Usar inteiro positivo).");
            numAp = in.nextInt();
        }

        listaDeMoradores.adicionaMorador(new Morador(nome,rg,numAp));
        System.out.println(nome + " adicionado a lista de Moradores\n");

    }

    private void listarEntregas(){
        System.out.println(listaDeEntregas);
    }
    
    private void listaNaoRetirada(){
        System.out.println(listaDeEntregas.buscaNaoRetiradas());
    }

    private void listarMoradores() {
        System.out.println(listaDeMoradores);
    }

    private void populaApp(){
        populaLista();
        populaOperadores();
        populaOperadorAtual();
        populaEntregas();
        populaRetiradas();
    }

    private void populaOperadorAtual(){
        operadorAtual = listaDeOperadores.getOperadorInicial("RR");
        System.out.println("Operador atual: " + operadorAtual.getName());
    }

    private void populaOperadores(){
        Operador rabelo = new Operador("Gabriel Rabelo");
        Operador roberto = new Operador("Roberto Rezende");
        Operador adriana = new Operador("Adriana Serpa");
        Operador luiz = new Operador("Luiz Reis");

        listaDeOperadores.add(rabelo);
        listaDeOperadores.add(roberto);
        listaDeOperadores.add(adriana);
        listaDeOperadores.add(luiz);

        System.out.println("Foram adicionados " + listaDeOperadores.getContador() + " operadores na lista de operadores.");

    }

    private void populaEntregas(){
        Entrega caixaDeFerramentas = new Entrega("Caixa de ferramentas","23",listaDeEntregas.getCount(), listaDeOperadores.getOperadorInicial("RR"));
        caixaDeFerramentas.setData(LocalDateTime.of(2020,5,18,15,02));
        listaDeEntregas.adicionaEntrega(caixaDeFerramentas);

        Entrega escada = new Entrega("Escada","24",listaDeEntregas.getCount(),listaDeOperadores.getOperadorInicial("GR"));
        escada.setData(LocalDateTime.of(2020,6,10,20,45));
        listaDeEntregas.adicionaEntrega(escada);

        Entrega envelope = new Entrega("Envelope grande","12",listaDeEntregas.getCount(),listaDeOperadores.getOperadorInicial("AS"));
        envelope.setData(LocalDateTime.of(2020,6,14,9,10));
        listaDeEntregas.adicionaEntrega(envelope);

        Entrega monitor = new Entrega("Monitor LG","34",listaDeEntregas.getCount(),listaDeOperadores.getOperadorInicial("LR"));
        monitor.setData(LocalDateTime.of(2020,8,19,15,00));
        listaDeEntregas.adicionaEntrega(monitor);

        Entrega bicicleta = new Entrega("Bicicleta","24",listaDeEntregas.getCount(),listaDeOperadores.getOperadorInicial("GR"));
        bicicleta.setData(LocalDateTime.of(2020,10,10,16,45));
        listaDeEntregas.adicionaEntrega(bicicleta);

        Entrega calcado = new Entrega("Calçado","23",listaDeEntregas.getCount(),listaDeOperadores.getOperadorInicial("LR"));
        bicicleta.setData(LocalDateTime.of(2020,10,15,20,5));
        listaDeEntregas.adicionaEntrega(calcado);

        System.out.println("Foram adicionadas " + listaDeEntregas.getCount() + " entregas na lista de entregas.");
    }

    private void populaRetiradas(){
        Morador retirado = listaDeMoradores.buscaPorRG(2353433423L);
        Entrega aux = listaDeEntregas.buscaPorId(1);
        aux.setMoradorRetirada(retirado);
        aux.setDataRetirada(LocalDateTime.of(2020,5,26,9,10));

        Morador retirado1 = listaDeMoradores.buscaPorRG(3464224754L);
        Entrega aux1 = listaDeEntregas.buscaPorId(5);
        aux1.setMoradorRetirada(retirado1);
        aux1.setDataRetirada(LocalDateTime.of(2020,10,11,8,15));

        Morador retirado2 = listaDeMoradores.buscaPorRG(3246863534L);
        Entrega aux2 = listaDeEntregas.buscaPorId(4);
        aux2.setMoradorRetirada(retirado2);
        aux2.setDataRetirada(LocalDateTime.of(2020,8,21,19,03));

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

        System.out.println("\nForam adicionados " + listaDeMoradores.getSize() + " moradores na lista de moradores.");
    }
}
