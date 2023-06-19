public class ProdutoFisico extends Produto {
    private double peso;
    private String dimensoes;
    public ProdutoFisico(
            int codigo,
            String nome,
            String descricao,
            double preco,
            int quantidadeEmEstoque,
            double peso,
            String dimensoes
    ) {
        super(
                codigo,
                nome,
                descricao,
                preco,
                quantidadeEmEstoque
        );
        this.peso = peso;
        this.dimensoes = dimensoes;
    }
    public double getPeso() {return peso;}
    public String getDimensoes() {return dimensoes;}
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("||===========================================================||");
        System.out.println("||  Peso: " + peso + " Kg");
        System.out.println("||  Dimensão: " + dimensoes);
        System.out.println("||===========================================================||");
    }
}