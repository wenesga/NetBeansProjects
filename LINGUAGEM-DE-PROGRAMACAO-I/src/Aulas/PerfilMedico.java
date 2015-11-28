
//Classe Perfil Medico
package Aulas;
public class PerfilMedico  
{  
    private String nome;            //variável para nome  
    private String sobrenome; //variável para sobrenome  
    private String sexo;             //variável para sexo  
    private int dia;                       //variável para dia  
    private int mes;                    //variável para mes  
    private int ano;                     //variável para ano  
    private double altura;         //variável para altura  
    private double peso;           //variável para peso  
      
    //construtor  
    public PerfilMedico (){}  
    public PerfilMedico ( String n, String s, String sex, int d, int m, int a, double alt, double p )  
    {  
        nome = n;                  //inicia nome  
        sobrenome = s;        //inicia sobrenome  
        sexo = sex;                //inicia sexo  
        if( d <= 31 )  
        dia = d;                        //inicia dia  
        if( m <= 12 )  
        mes = m;                     //inicia mes  
        if( a <= 2099 )  
        ano = a;                      //inicia ano  
        if( alt > 0.0 )  
        altura = alt;              //inicia altura  
        if( p > 0.0 )  
        peso = p;                  //inicia peso  
    }                                     //fim do construtor  
      
    //Metodo para configurar o nome  
    public void setNome( String n )  
    {  
        nome = n;//armazena nome  
    }//fim de setNome  
      
    //Metodo para retornar o nome  
    public String getNome()  
    {  
        return nome;  
    }//fim de getNome  
      
    //Metodo para configurar o sobrenome  
    public void setSobrenome( String s )  
    {  
        sobrenome = s;//armazena sobrenome  
    }//fim de setSobrenome  
      
    //Metodo para recuperar o sobrenome  
    public String getSobrenome()  
    {  
        return sobrenome;  
    }//fim de getSobrenome  
      
    //Metodo para configurar o sexo  
    public void setSexo( String sex )  
    {  
        sexo = sex;//armazena sexo  
    }//fim de setSexo  
      
    //Metodo para retornar o sexo  
    public String getSexo()  
    {  
        return sexo;  
    }//fim de getSexo  
      
    //Metodo para configurar o dia  
    public void setDia( int d )  
    {  
        dia = d;//armazena o dia  
    }//fim de setDia  
      
    //Metodo para recuperar o dia  
    public int getDia()  
    {  
        return dia;  
    }//fim de getDia  
      
    //Metodo para configurar o mes  
    public void setMes( int m )  
    {  
        mes = m;//armazena o mes  
    }//fim de setMes  
      
    //Metodo para retornar o mes  
    public int getMes()  
    {  
        return mes;  
    }//fim de getMes  
      
    //Metodo para configurar o ano  
    public void setAno( int a )  
    {  
        ano = a;//armazena o ano  
    }//fim de setAno  
      
    //Metodo para retornar o ano  
    public int getAno()  
    {  
        return ano;  
    }//fim de getAno  
      
    //Metodo para configurar a altuta  
    public void setAltura( double alt )  
    {  
        altura = alt;//armazena a altura  
    }//fim de setAltura  
      
    //Metodo para recuperar a altura  
    public double getAltura()  
    {  
        return altura;  
    }//fim de getAltura  
      
    //Metodo configura o peso  
    public void setPeso( double p )  
    {  
        peso = p;//armazena o peso  
    }//fim de setPeso  
      
    //Metodo para retornar o peso  
    public double getPeso()  
    {  
        return peso;  
    }//fim de getPeso  
      
  //-------------------------------------------------------------------------------------------------------------------------------  
    
    //Metodo para calcular a idade  
    public int getIdade()  
    {  
        return 2013 - ano;  
    }  //fim de getIdade  
//-------------------------------------------------------------------------------------------------------------------------------  
      
    //Metodo para calcular a frequencia cardiaca maxima  
    public int getFCM()  
    {  
        return 220 - getIdade();  
    }  //fim de getFMC  
//-------------------------------------------------------------------------------------------------------------------------------  
     
    //Metodo para calcular a frequencia cardiaca alvo  
    public double getFCA()  
    {  
        return getFCM() * 0.85;  
    }  //fim de getFMA  
 
//-------------------------------------------------------------------------------------------------------------------------------  
     
    //Metodo para calcular o IMC  
    public double getIMC()  
    {  
        return altura * altura / peso;  
    }  //fim de getIMC  
//-------------------------------------------------------------------------------------------------------------------------------  
      
    
    
    
    //Exibe uma Mensagem  
    public void displayInfo()  
    {  
    System.out.printf("NOME\t\tSEXO\tNASCIMENTO\tALTURA\tPESO\n");  
    System.out.printf("%s %s\t%s\t%d/%d/%d\t\t%.1f\t%.2f\n", getNome(), getSobrenome(), getSexo(), getDia(),  
                        getMes(), getAno(), getAltura(), getPeso());  
                              
    System.out.printf("IDADE\tFCM\tFCA\t\tIMC\n");  
    System.out.printf("%d\t%d\t%.2f\t%.2f\n", getIdade(), getFCM(), getFCA(), getIMC());  
    }//fim de displayInfo  
}//Fim da classe  