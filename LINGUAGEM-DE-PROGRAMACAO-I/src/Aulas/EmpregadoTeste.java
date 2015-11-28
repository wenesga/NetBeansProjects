package Aulas;
public class EmpregadoTeste {
      
      public static void main (String[] args) {
                    
            Empregado empregado1 = new Empregado ("Wenes", "Aquino", 500 );
            Empregado empregado2 = new Empregado ("João", "Piedade", 500 );

            System.out.println ("Nome: " + empregado1.getNome()+" " + empregado1.getSobrenome() +" - Salario: " + empregado1.getSalario());
            System.out.println("Salário anual: " +  empregado1.getSalario()*12);
            
            System.out.println ("Nome: " + empregado2.getNome()+" " + empregado2.getSobrenome() +" - Salario: " + empregado2.getSalario());
            System.out.println("Salário anual: " +  empregado2.getSalario()*12);
            
            empregado1.calcularAumento();
            System.out.println ("Salario com aumento: " + empregado1.getSalario());
           
            empregado2.calcularAumento();
            System.out.println ("Salario com aumento: " + empregado2.getSalario());
      }
}
