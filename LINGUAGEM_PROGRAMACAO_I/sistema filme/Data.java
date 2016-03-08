package tp1;

import java.util.Scanner;

public class Data {
    Scanner S = new Scanner(System.in);
    private int Dia, Mes, Ano;

    public int getDia() {
        return Dia;
    }
    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }
    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAno() {
        return Ano;
    }
    public void setAno(int Ano) {
        this.Ano = Ano;
    }
    
    public void setData(Data D){
        System.out.println("Dia:");
        D.setDia(S.nextInt());
        System.out.println("Mes:");
        D.setMes(S.nextInt());
        System.out.println("Ano:");
        D.setAno(S.nextInt());
}
    public void exibeData(Data D){
        System.out.println(D.getDia()+"/"+D.getMes()+"/"+D.getAno());
    }
}
