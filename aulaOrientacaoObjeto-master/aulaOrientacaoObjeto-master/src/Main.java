public class Main {
    public static void main(String[] args) {
        Veiculo minivan = new Veiculo();
        Veiculo truck = new Veiculo();
        minivan.setPassegeiro(0);
        System.out.println(minivan.getPassegeiro());
        minivan.setAutonomia(20);
        System.out.println(minivan.getAutonomia());
        minivan.setCapacidade(5);
        System.out.println(minivan.getCapacidade());
    }
}