import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] pa;
        
        System.out.println("Informe o termo inicial da PA: ");
        int termoInicial = inp.nextInt();
        
        System.out.println("Informe a razao da PA: ");
        int razao = inp.nextInt();
        
        System.out.println("Informe o tamanho que deseja a PA: ");
        int tamanho = inp.nextInt();
        pa = new int[tamanho];
        
       ConstruirPa(pa, termoInicial, tamanho, razao);
       ImprimirPa(pa, tamanho);
        System.out.println("");
       SomarMetodoGauss(pa,termoInicial, tamanho);
    }
    
    public static void ImprimirPa(int[] pa, int tamanho){       
         for(int i =0; i < tamanho; i++){
            System.out.print(pa[i] + ", ");
        }
    }
    
    public static void ConstruirPa(int[] pa, int termoInicial, int tamanho, int razao){

         for(int i = 0;i<tamanho; i++){
             pa[i] = termoInicial;
             termoInicial += razao; 
         }
            
    
    }
    
    public static void SomarMetodoGauss(int[] pa,int termoInicial, int tamanho){
         double pares = (tamanho) / 2;
         int somaPares = pa[tamanho-1] + termoInicial;
         double somaGauss = somaPares * pares;
      
         System.out.println("Calculo da progressão aritimética com o método de Gauss: " + somaGauss);
    }
    
    
}
