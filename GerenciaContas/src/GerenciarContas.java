import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarContas {
    private final List<Conta> contas = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GerenciarContas gerenciarContas = new GerenciarContas();
        gerenciarContas.run();
    }

    private void run() {
        int opcao;
        do {
            System.out.println("------------------------------------");
            System.out.println("Gerenciador de Contas");
            System.out.println("------------------------------------");
            System.out.println("1 | Desejo cadastrar conta");
            System.out.println("2 | Desejo alterar conta");
            System.out.println("3 | Desejo excluir conta");
            System.out.println("------------------------------------");
            System.out.println("4 | Desejo depositar");
            System.out.println("5 | Desejo sacar");
            System.out.println("6 | Desejo exibir saldo");
            System.out.println("------------------------------------");
            System.out.println("7 | Desejo mostrar patrimônio do banco");
            System.out.println("8 | Desejo mostrar contas");
            System.out.println("------------------------------------");
            System.out.println("9 | Desejo sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> execCadastrarConta();
                case 2 -> execAlterarConta();
                case 3 -> execExcluirConta();
                case 4 -> execDepositar();
                case 5 -> execSacar();
                case 6 -> execExibirSaldo();
                case 7 -> execMostrarPatrimonio();
                case 8 -> execMostrarContas();
                case 9 -> execSair();
                default -> System.out.println("Opção inválida");
            }

            System.out.println("Pressione ENTER para continuar!");
            scanner.nextLine();
        } while (opcao != 9);
    }

    private void execMostrarContas() {
        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada\n");
            return;
        }

        System.out.println("\nContas cadastradas");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    private void execExcluirConta() {
        System.out.print("Digite o id da conta: ");
        String id = scanner.nextLine();

        Conta conta = buscarConta(id);

        if (conta != null) {
            contas.remove(conta);
            System.out.println("Conta excluída com sucesso");
            return;
        }

        System.out.println("Conta não encontrada");
    }

    public void execCadastrarConta() {
        System.out.println("Cadastrar Conta");

        System.out.print("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o nome do banco: ");
        String banco = scanner.nextLine();

        System.out.print("Digite o número da agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldo = Double.parseDouble(scanner.nextLine());

        Conta conta = new Conta(nome, banco, agencia, saldo);
        contas.add(conta);

        System.out.println("Conta cadastrada com sucesso!!");
        System.out.println("Id da conta: " + conta.getId());
    }

    public void execAlterarConta() {
        System.out.print("Digite o id da conta: ");
        String id = scanner.nextLine();

        Conta conta = buscarConta(id);

        if (conta != null) {
            System.out.print("Digite o novo nome do titular: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o novo nome do banco: ");
            String banco = scanner.nextLine();

            System.out.print("Digite o novo número da agência: ");
            String agencia = scanner.nextLine();

            conta.setNome(nome);
            conta.setBanco(banco);
            conta.setAgencia(agencia);

            System.out.println("Conta alterada com sucesso");
            return;
        }

        System.out.println("Conta não encontrada");
    }


    public void execDepositar() {
        System.out.print("Digite o id da conta: ");
        String id = scanner.nextLine();

        Conta conta = buscarConta(id);

        if (conta != null) {
            System.out.print("Digite o valor do depósito: ");
            double valor = Double.parseDouble(scanner.nextLine());

            if (conta.depositar(valor)) {
                System.out.println("Depósito realizado com sucesso");
                return;
            }

            System.out.println("Valor inválido para depósito");
        }

        System.out.println("Conta não encontrada");
    }

    public void execSacar() {
        System.out.print("Digite o id da conta: ");
        String id = scanner.nextLine();

        Conta conta = buscarConta(id);

        if (conta != null) {
            System.out.print("Digite o valor do saque: ");
            double valor = Double.parseDouble(scanner.nextLine());

            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso");
                return;
            }

            System.out.println("Saldo insuficiente");
        }

        System.out.println("Conta não encontrada");
    }

    public void execExibirSaldo() {
        System.out.print("Digite o id da conta: ");
        String id = scanner.nextLine();

        Conta conta = buscarConta(id);

        if (conta != null) {
            System.out.println("Saldo: " + conta.getSaldo());
            return;
        }

        System.out.println("Conta não encontrada");
    }

    public void execMostrarPatrimonio() {
        double patrimonio = 0;

        for (Conta conta : contas) {
            patrimonio += conta.getSaldo();
        }

        System.out.println("Patrimônio do banco: " + patrimonio);
    }

    public Conta buscarConta(String id) {
        for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                return conta;
            }
        }
        return null;
    }

    public void execSair() {
        System.out.println("Bye bye see you again!!");
        System.exit(0);
    }
}