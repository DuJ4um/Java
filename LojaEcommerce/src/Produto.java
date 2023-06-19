public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;
    public Produto(
            int nome,
            String descricao,
            String codigo,
            double quantidadeEmEstoque,
            double preco
    ) {
        this.codigo = Integer.parseInt(codigo);
        this.nome = String.valueOf(nome);
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = (int) quantidadeEmEstoque;
    }
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public void exibirInformacoes()
    {
        System.out.println("||===========================================================||");
        System.out.println("||  Código: " + codigo);
        System.out.println("||  Nome: " + nome);
        System.out.println("||  Descrição: " + descricao);
        System.out.println("||  Preço: R$" + preco);
        System.out.println("||  Quantidade no Estoque: " + quantidadeEmEstoque);
        System.out.println("||===========================================================||");
    }
}