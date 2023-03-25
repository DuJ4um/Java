import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String nome;
    private List<Carro> carros;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    // Método construtor
    public Cliente(int idCliente, String nome){
        this.idCliente = idCliente;
        this.nome = nome;
        this.carros = new ArrayList<>();
    }

    // Método para adicionar carro

    public void adicionarCarro(Carro  carro){
        // Na lista
        carros.add(carro);
    }

    @Override
    public String toString() {
        String dados = "Dados do Cliente"+ "\n" +
                "idCliente=" + idCliente + "\n" +
                ", nome='" + nome + "\n" +
                ", Lista de carros cadastrados=" + "\n";
        String str_carros = "";
        for (Carro carro : getCarros()){
            str_carros += carro.toString() + "\n";
        }
        return dados + str_carros;
    }
}
