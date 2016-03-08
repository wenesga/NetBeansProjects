package Aulas;
public class Empregado {
//----------------------------VARIAVEIS DE INSTANCIA------------------------------//
      private String nome;
      private String sobrenome;
      private double salario;
//-----------------------------------CONSTRUTOR------------------------------------//   
      public Empregado (String nome, String sobrenome, double salario ){
            this.nome = nome;
            this.sobrenome = sobrenome;
            if(salario > 0) {
                  this.salario = salario;
            }  
      }
//----------------------------------------GET/-------------------------------------------//
      public String getNome() {
            return nome;
      }

       public void setNome(String nome) {
              this.nome = nome;
       }
      
      public String getSobrenome() {
            return sobrenome;
      }
       public void setSobrenome(String sobrenome) {
              this.sobrenome = sobrenome;
       }
      
      public double getSalario() {
            return salario;
      }
       public void setSalario(double salario) {
              this.salario = salario;
       }
//---------------------------------------MÉTODO---------------------------------------//
      public void calcularAumento() {
            salario = salario + (salario * 0.1);
      }     
}
