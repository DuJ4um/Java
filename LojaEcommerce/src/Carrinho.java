import java.util.ArrayList;
import java.util.List;
public class Carrinho {
    private List<Produto> produtos;
    public Carrinho() { produtos = new ArrayList<>(); }
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("||===========================================================||");
        System.out.println("|| Produto adicionado.");
        System.out.println("||===========================================================||");
    }
    public void adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < quantidade; i++) { produtos.add(produto); }
        System.out.println("||===========================================================||");
        System.out.println("||  " + quantidade + " unidades adicionadas.");
        System.out.println("||===========================================================||");
    }
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println("||===========================================================||");
        System.out.println("|| Produto removido.");
        System.out.println("||===========================================================||");
    }
    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Produto produto : produtos) { valorTotal += produto.getPreco(); }
        return valorTotal;
    }
    public Produto getProdutoByCodigo(int codigo) {
        for (Produto produto : produtos) { if (produto.getCodigo() == codigo) { return produto; }
        }
        return null;
    }
}