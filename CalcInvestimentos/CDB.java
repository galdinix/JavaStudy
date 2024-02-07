public final class CDB extends RendaFixa{
    private double juros;
    
    public CDB(){}
    
    public CDB(String nome, String cpf, String banco,double juros){
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
        double IR=0;
         if (tempoAlocacao <= 6) {
            IR = rendimento * 0.225;
        } else if (tempoAlocacao <= 12) {
            IR = rendimento * 0.2;
        } else if (tempoAlocacao <= 24) {
            IR = rendimento * 0.175;
        } else {
            IR = rendimento * 0.15;
        }
        return rendimento-IR;
    }   
}