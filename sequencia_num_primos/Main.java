import java.util.Scanner;
class Main {
  public static void main(String [] agrs){
   int num = CapturarNumero();
    ImprimirSequenciaPrimos(num);
  }
    public static int CapturarNumero(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Informe um número: ");
        int num = inp.nextInt();
        return num;
    }
    
    public static void ImprimirSequenciaPrimos(int num){
        System.out.println("Aqui estão os " + num + " números primos");
        for(int i=2; i<=num+1; i++){
            if(VerificarNumPrimo(i, num) == true){
                
                System.out.print(i + " ");
            } else {
                num++;
            }
        }
    }
    
    public static boolean VerificarNumPrimo(int i, int num){
        boolean resp = false;
        int cont = 0;
        for(int k = 1; k<=i; k++){
            if(i%k == 0){
                cont++;
            }
        }
        if(cont == 2){
            resp = true;
        } 
        return resp;
    }
}