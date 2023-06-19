public class ProdutoDigital extends Produto {
    private String formato;
    private double tamanhoArquivo;

    public ProdutoDigital(
            String nome,
            String descricao,
            String formato,
            int codigo,
            int quantidadeEmEstoque,
            double preco,
            double tamanhoArquivo
    ) {
        super(
                codigo,
                nome,
                descricao,
                preco,
                quantidadeEmEstoque
        );
        this.formato = formato;
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public String getFormato() {return formato;}
    public double getTamanhoArquivo() {return tamanhoArquivo;}
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("||===========================================================||");
        System.out.println("||  Extensão: " + formato);
        System.out.println("||  Tamanho Arquivo: " + tamanhoArquivo + " MB");
        System.out.println("||===========================================================||");
    }
}