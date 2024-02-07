public final class Poupança extends RendaFixa{
    
    private double juros;
    
    public Poupança(){}
    
    public Poupança(String nome, String cpf, String banco,double juros){
        super(nome, cpf, banco);
        this.juros=juros;
    }

    public double getJuros() {
        return (juros/100) * 13.15;
    }

    public void setJuros(int juros) {
        this.juros = juros;
    }
    
  
    public double CalcularInvestimento(double capitalInicial, int tempoAlocacao, double taxaSelic){
        double rendimento =0;
        if(taxaSelic >= 8.5){
            rendimento = capitalInicial * Math.pow((0.50/100)+1, tempoAlocacao) - capitalInicial;
        } else {
            rendimento = capitalInicial * Math.pow((0.7 * ((taxaSelic/12)/100) ) + 1, tempoAlocacao) - capitalInicial;
            
        }
        return rendimento;
    }
    
    
}
