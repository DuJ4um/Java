public class Funcionario {
    private double salario;
    private long registro;
    private boolean estaAtivo;
    private String nome;
    private String Departamento;
    private String rg;
    public Funcionario(
            double salario,
            long registro,
            boolean estaAtivo,
            String nome,
            String Departamento,
            String rg)
    {
        this.salario = salario;
        this.registro = registro;
        this.estaAtivo = estaAtivo;
        this.nome = nome;
        this.Departamento = Departamento;
        this. rg = rg;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getRegistro() {
        return registro;
    }

    public void setRegistro(long registro) {
        this.registro = registro;
    }

    public boolean estaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return
                " \n | NOME DO FUNCIONÁRIO ~> " + nome  + "\n" +
                " \n | REGISTRO DO FUNCIONÁRIO ~> " + registro + "\n" +
                " \n | STATUS DE ATIVIDADE ~> " +  estaAtivo + "\n" +
                " \n | DEPARTAMENTO DO FUNCIONÁRIO ~> " + Departamento + "\n" +
                " \n | RG DO FUNCIONÁRIO ~> " + rg + "\n" +
                " \n | SALÁRIO DO FUNCIONÁRIO ~> " + salario + "\n";
    }

    public void bonificar(double valor) {
        salario  = salario + valor;
        System.out.println(
                "| BONIFICAÇÃO RECEBIDA NO VALOR DE R$ "+ valor +
                ", NOVO SALÁRIO NO VALOR DE R$ " + salario + " DEFINIDO"
        );
    }

    public void imprimir() {
        System.out.println(
                " \n | NOME DO FUNCIONÁRIO ~> " + nome + "\n" +
                " \n | SALÁRIO DO FUNCIONÁRIO ~> "+ salario + "\n" +
                " \n | DEPARTAMENTO DO FUNCIONÁRIO ~> " + Departamento + "\n" +
                " \n | REGISTRO DO FUNCIONÁRIO ~> "+ registro + "\n" +
                " \n | STATUS DE ATIVIDADE ~> "+ estaAtivo + "\n" +
                " \n | RG DO FUNCIONÁRIO ~> " + rg +  "\n"
        );
    }
}