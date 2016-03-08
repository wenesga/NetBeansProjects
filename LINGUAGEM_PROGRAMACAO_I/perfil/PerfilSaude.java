package Aulas;
/**
 * CLASSE SEGUNDARIA
 * 
 * @author WENES GOMES AQUINO
 */
public class PerfilSaude {
       private String nome;
       private String sobrenome;
       private String sexo;
       private int diaNasci;
       private int mesNasci;
       private int anoNasci;
       private double altura;
       private double peso;	
       
//-----------CONSTRUTOR------------------------------------
       
       public PerfilSaude() {}
       public PerfilSaude (String nome, String sobrenome, String sexo, int diaNasci, int mesNasci, int anoNasci, float altura, float peso) {
              this.nome = nome;
              this.sobrenome = sobrenome;
              this.sexo = sexo;
              if(diaNasci <= 31)
                     this.diaNasci = diaNasci;
              if(mesNasci <= 12)
                     this.mesNasci = mesNasci;
              if(anoNasci <= 2015)
                     this.anoNasci = anoNasci;
              if(altura > 0)
                     this.altura = altura;
              if(peso > 0)
                     this.peso = peso;
       }
//--------------------------------------------GET-SET-------------
              public String getNome() {
                      return nome;
              }
              public void setNome(String nome) {
                      this.nome = nome;
              }
//----------------------------------------------------------------
              public String getSobrenome() {
                      return sobrenome;
              }
              public void setSobrenome(String sobrenome) {
                      this.sobrenome = sobrenome;
              }
//----------------------------------------------------------------
              public String getSexo() {
                      return sexo;
              }
              public void setSexo(String sexo) {
                      this.sexo = sexo;
              }
//----------------------------------------------------------------
              public int getDiaNasci() {
                      return diaNasci;
              }
              public void setDiaNasci(int diaNasci) {
                      this.diaNasci = diaNasci;
              }
//-----------------------------------------------------------------------
              public int getMesNasci() {
                      return mesNasci;
              }
              public void setMesNasci(int mesNasci) {
                      this.mesNasci = mesNasci;
              }
             //----------------------------------------------------------------
              public int getAnoNasci() {
                      return anoNasci;
              }
              public void setAnoNasci(int anoNasci) {
                      this.anoNasci = anoNasci;
              }
//------------------------------------------------------------------------
              public double getAltura() {
                      return altura;
              }
              public void setAltura(double altura) {
                      this.altura = altura;
              }
//-------------------------------------------------------------------------
              public double getPeso() {
                      return peso;
              }
              public void setPeso(double peso) {
                      this.peso = peso;
              }
//-------------------------------------------------------CALCULAR A IDADE----------------------------------------------------------     
       public int calcIdade() {
               return 2015 - anoNasci;
       }
//---------------------------------------------------CALCULAR FREQ-CARD-MAX--------------------------------------------------
       public int calFrequMax() {
              return  220 - calcIdade();
       }
//--------------------------------------------------CALCULAR FREQ-CARD-ALVO-------------------------------------------------
      public  double calFrequAlvo() {
             return calFrequMax() * 0.85;
       }
//-----------------------------------------------------------CALCULAR IMC----------------------------------------------------------       
       public double calIMC() {
              return peso/(altura * altura);
       }
//---------------------------------------------------------MOSTRAR NA TELA-------------------------------------------------------
            
       public void mostrarTela() {
              System.out.println ( "NOME: "+getNome() +" "+ getSobrenome() +" - "+ "SEXO: "+getSexo() +" - "+ " DATA DE NASCIMENTO: "+getDiaNasci() +"/"+  getMesNasci() + "/" + getAnoNasci() +" - "+ "ALTURA: "+getAltura() +" - "+"PESO: " + getPeso());         
              System.out.println ("IDADE: " + calcIdade() +" - "+ "FREQUENCIA CARDIACA MÁXIMA: "+calFrequMax() +" - "+ "FREQUENCIA CARDIACA  ALVO: "+calFrequAlvo() +" - "+ "INDICE DE MASSA CORPORAL: "+calIMC() );  
       }
	       
      
}
