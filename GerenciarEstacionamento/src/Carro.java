import java.util.Objects;

public class Carro {
    private int idCarro;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;

    // Método construtor
    public Carro(int idCarro, String modelo, String marca, int ano, double valor){
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    public Carro(){
    }

    public int getCarro() {
        return idCarro;
    }

    public void setCarro(int carro) {
        this.idCarro = carro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "idCarro=" + idCarro +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", valor=" + valor +
                '}';
    }
}
