import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
        System.out.println("Valor a ser investido em R$: ");
        double capitalInicial= inp.nextDouble();      
        System.out.println("Informe quanto tempo, em meses, que o dinherio ficará alocado: ");
        int tempoAlocacao = inp.nextInt();     
    
        System.out.println("Informe a taxa selic do ano atual: ");
        double taxaSelic = inp.nextDouble();
        
        CDB cdb = new CDB("lucas", "222.222.222-22", "Banco do lucas", 120);
        LCI lci = new LCI("lucas", "222.222.222-22", "Banco do lucas", 100);
        LCA lca = new LCA("lucas", "222.222.222-22", "Banco do lucas", 105);
        Poupança poup = new Poupança("lucas", "222.222.222-22", "Banco do lucas", 0);      
        ArmazenarInvestimentos(cdb, lci, lca, poup, capitalInicial, tempoAlocacao, taxaSelic);
    }
    
     public static void ArmazenarInvestimentos(CDB cdb, LCI lci, LCA lca, Poupança poup, double capitalInicial, int tempoAlocacao, double taxaSelic){
         
          try{
            FileWriter arquivo = new FileWriter("dados.txt");
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.println( "rendimento no CDB: R$"+ Math.round(cdb.CalcularInvestimento(capitalInicial, tempoAlocacao, taxaSelic)));
            gravarArquivo.println();
            gravarArquivo.println("rendimento no LCI: R$"+ Math.round(lci.CalcularInvestimento(capitalInicial, tempoAlocacao, taxaSelic)));
            gravarArquivo.println();
            gravarArquivo.println("rendimento no LCA: R$"+ Math.round(lca.CalcularInvestimento(capitalInicial, tempoAlocacao, taxaSelic)));
            gravarArquivo.println();
            gravarArquivo.println("rendimento na poupança: R$"+ Math.round(poup.CalcularInvestimento(capitalInicial, tempoAlocacao, taxaSelic)));
            arquivo.close();
        } catch (IOException e){
                System.out.println("Erro de grvação");
     
    }  
        
         
         
        }
  }
