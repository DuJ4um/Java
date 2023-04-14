import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionario {
    Scanner sc = new Scanner(System.in);
    public static List<Funcionario> listFuncionarios = new ArrayList<>();
    public static void main(String[] args) {
        GerenciarFuncionario  gf = new GerenciarFuncionario();
        int opcao;
        do {
            System.out.println("|===================================================================|");
            System.out.println("|                                                                   |");
            System.out.println("|                    GERENCIADOR DE FUNCIONÁRIOS                    |");
            System.out.println("|                                                                   |");
            System.out.println("|===================================================================|");
            System.out.println("|                                                                   |");
            System.out.println("|      OPÇÃO [ 1 ] | CADASTRAR FUNCIONÁRIO                          |");
            System.out.println("|      OPÇÃO [ 2 ] | CONSULTAR UM FUNCIONÁRIO ESPECÍFICO            |");
            System.out.println("|      OPÇÃO [ 3 ] | BONIFICAR UM FUNCIONÁRIO ESPECCÍFICO           |");
            System.out.println("|      OPÇÃO [ 4 ] | BONIFICAR TODOS OS FUNCIONÁRIOS                |");
            System.out.println("|      OPÇÃO [ 5 ] | MOSTRAR TODOS OS FUNCIONÁRIOS                  |");
            System.out.println("|      OPÇÃO [ 9 ] | SAIR                                           |");
            System.out.println("|                                                                   |");
            System.out.println("|===================================================================|");
            opcao = Integer.parseInt(gf.sc.nextLine());
            switch (opcao) {
                case 1 -> gf.execCadastrar();
                case 2 -> gf.execConsultarUnico();
                case 3 -> gf.execBonificarUnico();
                case 4 -> gf.execBonificar();
                case 5 -> gf.execMostrarFuncionarios();
                case 9 -> {
                    System.out.println("|===================================================================|");
                    System.out.println("|                                                                   |");
                    System.out.println("|                        PROGRAMA ENCERRADO!                        |");
                    System.out.println("|                                                                   |");
                    System.out.println("|===================================================================|");
                }
                default -> {
                    System.out.println("|===================================================================|");
                    System.out.println("|                                                                   |");
                    System.out.println("|                      !!  OPÇÃO  INVÁLIDA  !!                      |");
                    System.out.println("|                                                                   |");
                    System.out.println("|===================================================================|");
                }
            }
        }while(opcao != 9);

    }
    // métodos fora do main
    public void execCadastrar() {
        System.out.println("|==================================================================|");
        System.out.println("|                      CADASTRO DE FUNCIONÁRIO                     |");
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                 INFORME O SALÁRIO DO FUNCIONÁRIO                 |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        double salario = Double.parseDouble(sc.nextLine());
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                 INFORME O REGISTRO DO FUNCIONÁRIO                |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        long registro = Long.parseLong(sc.nextLine());
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                       ?? ATIVAR USUÁRIO ??                       |");
        System.out.println("|                                                                  |");
        System.out.println("|                     DIGITE [ SIM ] OU [ NAO ]                    |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        boolean estaAtivo = true;
        String entradaUsuario = sc.nextLine();
        if (entradaUsuario.equalsIgnoreCase("NAO")){
            estaAtivo = false;
        }
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                  INFORME O NOME DO FUNCIONÁRIO                   |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        String nome = (sc.nextLine());
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|               INFORME O DEPARTAMENTO DO FUNCIONÁRIO              |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        String Departamento =(sc.nextLine());
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                   INFORME O RG DO FUNCIONÁRIO                    |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        String rg = (sc.nextLine());
        System.out.println("|==================================================================|");
        System.out.println("|               FUNCIONÁRIO CADASTRADO COM SUCESSO!                |");
        System.out.println("|==================================================================|");

        Funcionario funcionarios = new Funcionario(salario,registro,estaAtivo,nome,Departamento,rg);
        listFuncionarios.add(funcionarios);

    }

    public void execConsultarUnico() {
        System.out.println("|==================================================================|");
        System.out.println("|                        REALIZAR CONSULTA                         |");
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                 INFORME O REGISTRO DO FUNCIONÁRIO                |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        long registro = Long.parseLong(sc.nextLine());
        for(Funcionario funcionarios: listFuncionarios) {
            if(funcionarios.getRegistro() == registro) {
                System.out.println("| FUNCIONÁRIO SELECIONADO: " + funcionarios.getNome() + " |");
                funcionarios.imprimir();
            }
        }
        System.out.println("|==================================================================|");
        System.out.println("|                       CONSULTA FINALIZADA                        |");
        System.out.println("|==================================================================|");

    }
    public void execBonificarUnico() {
        System.out.println("|==================================================================|");
        System.out.println("|                   BONIFICAR FUNCIONÁRIO ÚNICO                    |");
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                 INFORME O REGISTRO DO FUNCIONÁRIO                |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        long registro = Long.parseLong(sc.nextLine());
        for(Funcionario funcionarios: listFuncionarios) {
            if(funcionarios.getRegistro() == registro) {
                System.out.println("|==================================================================|");
                System.out.println("|                                                                  |");
                System.out.println("|INFORME O VALOR DA BONIFICAÇÃO |"
                        + " NOME  DO FUNCIONÁRIO: "
                        + funcionarios.getNome()
                        + " |");
                System.out.println("|                                                                  |");
                System.out.println("|==================================================================|");
                int num = Integer.parseInt(sc.nextLine());
                funcionarios.bonificar(num);
            }
        }
        System.out.println("|==================================================================|");
        System.out.println("|                      FUNCIONÁRIO BONIFICADO                      |");
        System.out.println("|==================================================================|");
    }

    public void  execBonificar() {
        System.out.println("|==================================================================|");
        System.out.println("|                  BONIFICAR TODOS OS FUNCIONÁRIO                  |");
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                  INFORME O VALOR DA BONIFICAÇÃO                  |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        int num = Integer.parseInt(sc.nextLine());
        for(Funcionario funcionarios: listFuncionarios) {
            funcionarios.bonificar(num);
        }
        System.out.println("|==================================================================|");
        System.out.println("|                      BONIFICAÇÃO REALIZADA                       |");
        System.out.println("|==================================================================|");
    }

    public void execMostrarFuncionarios() {
        System.out.println("|==================================================================|");
        System.out.println("|                                                                  |");
        System.out.println("|                     FUNCIONÁRIOS CADASTRADOS                     |");
        System.out.println("|                                                                  |");
        System.out.println("|==================================================================|");
        for( int i = 0; i < listFuncionarios.size(); i++ ) {
            System.out.println("|                                                                  |");
            System.out.println("\n| DADOS DO FUNCIONÁRIO "+ listFuncionarios+" |");
            System.out.println("|                                                                  |");
        }
        System.out.println("|==================================================================|");
        System.out.println("|                       EXIBIÇÃO FINALIZADA                        |");
        System.out.println("|==================================================================|");
    }
}