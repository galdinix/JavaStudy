public final class LCI extends RendaFixa{
    private double juros;
    
    public LCI(){}
    
    public LCI(String nome, String cpf, String banco,double juros){
        super(nome,cpf,banco);
        this.juros=juros;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(int juros) {
        this.juros = juros;
    }
    

    public double CalcularInvestimento(double capitalInicial, int tempoAlocacao, double taxaSelic){
       double selicMensal = (juros/100) * (taxaSelic/12);
      
       double rendimento = capitalInicial * Math.pow((1 + selicMensal/100), tempoAlocacao) - capitalInicial;
       return rendimento;
    }
    
    
}
