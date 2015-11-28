package sexo;

import java.util.Scanner;

public class Sexo {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		String sexo;
		
		System.out .println("Digite a letra do seu sexo");
		sexo = scan.next();
		
		if (sexo.equalsIgnoreCase("f"))
			System.out .println("Feminino");
		
		else {
                    if (sexo.equalsIgnoreCase("m"))
                        System.out .println("Masculino");
                        
                    else 
			System.out .println("Sexo inválido");	   
		}
	}
}

