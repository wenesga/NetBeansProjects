/**
 * Crie uma classe chamada aluno que contem os seguintes campos: 
 * nome do aluno (string) numero da matricula (string) nota1 (double) 
 * nota2 (double) média (double).Crie os gets e sets e 
 * construtor que inicializa todas as variáveis, exceto média.Crie também 
 * um método chamado calcula média, que através da nota1 e nota2 
 * realizará a media do estudante e atribuirá a variável de instancia média.Crie 
 * outro método chamado informa situação que,através da média do estudante, vai 
 * verificar a situação e retornar: aprovado (caso o estudante tenha maior que 7), 
 * prova final (caso estudante tenha media maior ou igual a 3) reprovado 
 * (caso o estudante tenha nota menor que 3).Crie uma aplicação que inicialize 
 * dois objetos da classe aluno e que através do método responsável por calcular 
 * a média, calcule a média de cada estudante.Ao final apresente uma mensagem 
 * estudante,  média, situação.
 */
package linguagem_programacao;
/**
 * @author WENES
 */
public class Aluno {
    private String nome;
    private String numMatricula;
    private double nota1;
    private double nota2;
    private double media;

    Aluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//-------------------------------------    
    public String getNome(){
        return nome;
    }
    public void setNome(String aluno){
        this.nome = aluno;
    }
//-------------------------------------    
    public String getNumMatricula(){
        return numMatricula;
    }
    public void setNumMaticula(String numMatricula){
        this.numMatricula = numMatricula;
    }
//-------------------------------------
    public double getNota1(){
        return nota1;
    }
    public void setNota1(double nota1){
        this.nota1 = nota1;
    }
//-------------------------------------
    public double getNota2(){
        return nota2;
    }
    public void setNota2(double nota2){
        this.nota2 = nota2;
    }
//-------------------------------------    
    public double getMedia(){
        return media;
    }
    public void setMedia(double media){
        this.media = media;
    }
//-------------------------------------
    public Aluno(String nome, String numMatricula){
        this.nome=nome;
        this.numMatricula=numMatricula;
        this.nota1=nota1;
        this.nota2=nota2;
    }
    
    public void calcMedia(){
        media = (nota1 + nota2)/2;
    }
    
    public String informaSituacao(){
       String sit = null;
       
       if (media >= 7)
            sit = "aprovado";
       else
       { 
           if (media >=3 && media < 7)
               sit = "prova final";
           else 
               sit = "reprovado";
       }
       return sit;    
    }
}
