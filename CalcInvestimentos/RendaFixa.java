public abstract class RendaFixa implements IRendaFixa{
    
    private String nome;
    private String cpf;
    private String banco;
    
    public RendaFixa(){}
    
    public RendaFixa(String nome, String cpf, String banco){
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
 
    public double CalcularInvestimento(double montante, int tempoAlocacao, double taxaSelic){
        return 0;
    }
}
