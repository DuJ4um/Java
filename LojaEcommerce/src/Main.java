import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Carrinho carrinho = new Carrinho();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("||===========================================================||");
            System.out.println("|| MENU");
            System.out.println("|| 1. Gerenciamento de Produtos");
            System.out.println("|| 2. Funcionalidades para Consumidor");
            System.out.println("|| 0. Sair");
            System.out.print("|| Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menuGprodutos(loja, scanner);
                    break;
                case 2:
                    menuFconsumidor(loja, carrinho, scanner);
                    break;
                case 0:
                    System.out.println("||===========================================================||");
                    System.out.println("|| Encerrando o programa...");
                    System.out.println("||===========================================================||");
                    break;
                default:
                    System.out.println("||===========================================================||");
                    System.out.println("||  Opção inválida. Tente novamente.");
                    System.out.println("||===========================================================||");
            }
        } while (opcao != 0);
    }

    private static void menuGprodutos(Loja loja, Scanner scanner) {
        int opcao;

        do {
            System.out.println("||===========================================================||");
            System.out.println("|| Gerenciamento de Produtos");
            System.out.println("|| 1. Cadastrar Produto");
            System.out.println("|| 2. Exibir Informações de um Produto");
            System.out.println("|| 3. Gerar Relatório de Produtos");
            System.out.println("|| 0. Voltar");
            System.out.println("|| Escolha uma opção: ");
            System.out.print("||===========================================================||");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(loja, scanner);
                    break;
                case 2:
                    exibirInfoProduto(loja, scanner);
                    break;
                case 3:
                    gerarRelatorioDeProdutos(loja);
                    break;
                case 0:
                    System.out.println("||===========================================================||");
                    System.out.println("|| Voltando ao menu principal...");
                    System.out.println("||===========================================================||");
                    break;
                default:
                    System.out.println("||===========================================================||");
                    System.out.println("|| Opção inválida. Tente novamente.");
                    System.out.println("||===========================================================||");
            }
        } while (opcao != 0);
    }

    private static void menuFconsumidor(Loja loja, Carrinho carrinho, Scanner scanner) {
        int opcao;

        do {
            System.out.println("||===========================================================||");
            System.out.println("|| Funcionalidades para Consumidor");
            System.out.println("|| 1. Adicionar Produto ao Carrinho");
            System.out.println("|| 2. Remover Produto do Carrinho");
            System.out.println("|| 3. Calcular Valor Total da Compra");
            System.out.println("|| 4. Exibir Produtos Disponíveis");
            System.out.println("|| 0. Voltar");
            System.out.println("|| Escolha uma opção: ");
            System.out.print("||===========================================================||");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProdAoCarrinho(loja, carrinho, scanner);
                    break;
                case 2:
                    removerProdDoCarrinho(carrinho, scanner);
                    break;
                case 3:
                    calcularValorTotal(carrinho);
                    break;
                case 4:
                    exibirProdutosDisp(loja);
                    break;
                case 0:
                    System.out.println("||===========================================================||");
                    System.out.println("|| Voltando ao menu principal...");
                    System.out.println("||===========================================================||");
                    break;
                default:
                    System.out.println("||===========================================================||");
                    System.out.println("|| Opção inválida. Tente novamente.");
                    System.out.println("||===========================================================||");
            }
        } while (opcao != 0);
    }

    private static void exibirProdutosDisp(Loja loja) {
        System.out.println("||===========================================================||");
        System.out.println("|| Produtos Disponíveis");
        loja.exibirProdutos();
    }


    public static void cadastrarProduto(Loja loja, Scanner scanner) {
        System.out.print("Código do Produto: ");
        int codigo = scanner.nextInt();

        System.out.print("Nome do Produto: ");
        String nome = scanner.next();

        System.out.print("Descrição do Produto: ");
        String descricao = scanner.next();

        double preco;
        while (true) {
            System.out.print("Preço do Produto: ");
            if (scanner.hasNextDouble()) {
                preco = scanner.nextDouble();
                break;
            } else {
                System.out.println("Valor inválido. Insira um número válido para o preço.");
            }
        }

        System.out.print("Quantidade em Estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, descricao, preco, quantidade);
        loja.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }


    private static void exibirInfoProduto(Loja loja, Scanner scanner) {
        System.out.print("\nCódigo do Produto: ");
        int codigo = scanner.nextInt();

        try {
            loja.exibirInformacoesProduto(codigo);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void adicionarProdAoCarrinho(Loja loja, Carrinho carrinho, Scanner scanner) {
        System.out.print("Código do Produto: ");
        int codigo = scanner.nextInt();

        try {
            loja.exibirInformacoesProduto(codigo);
            System.out.println("||===========================================================||");
            System.out.println("||  Quantidade: ");
            System.out.println("||===========================================================||");
            int quantidade = scanner.nextInt();
            Produto produto = loja.getProdutoByCodigo(codigo);
            carrinho.adicionarProduto(produto, quantidade);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void removerProdDoCarrinho(Carrinho carrinho, Scanner scanner) {
        System.out.print("Código do Produto: ");
        int codigo = scanner.nextInt();
        Produto produto = carrinho.getProdutoByCodigo(codigo);
        if (produto != null) {
            carrinho.removerProduto(produto);
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }


    private static void calcularValorTotal(Carrinho carrinho) {
        double valorTotal = carrinho.calcularValorTotal();
        System.out.println("Valor final: R$" + valorTotal);
    }

    private static void gerarRelatorioDeProdutos(Loja loja) { loja.gerarRelatorioProdutos(); }
}