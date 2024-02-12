public class Veiculo {
   private int passegeiro;
    private int capacidade;
    private int autonomia;

    void setPassegeiro(int p){
        if (p != 0)
            passegeiro = p;
    }
    int getPassegeiro (){
        return(passegeiro);
    }
    void setCapacidade(int cap){
        if (cap!=0)
            capacidade = cap;
    }
    int getCapacidade(){
        return(capacidade);
    }
    void setAutonomia(int auto){
        if (auto!=0)
            autonomia = auto;
    }
    int getAutonomia(){
        return (autonomia);
    }
}

