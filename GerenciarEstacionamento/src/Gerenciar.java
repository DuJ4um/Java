public class Gerenciar {
    public static void main(String[] args) {
        // Cadastrar
        // Mostrar
        Cliente cliente1 = new Cliente(1,"Joãozinho");
        Cliente cliente2 = new Cliente(2,"Luarinha");
        Carro carro1 = new Carro(1, "Corsa", "Chevrolet", 2015, 25000);
        Carro carro2 = new Carro(2, "Opala", "Chevrolet", 1984, 40000);
        Carro carro3 = new Carro(3, "Civic SI", "Honda", 2014, 95000);
        cliente1.adicionarCarro(carro2);
        cliente1.adicionarCarro(carro3);
        cliente2.adicionarCarro(carro1);
        System.out.println(cliente1);
    }
}