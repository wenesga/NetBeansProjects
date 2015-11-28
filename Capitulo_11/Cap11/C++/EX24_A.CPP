#include <stdio.h>
int main()
{ FILE *contas;
  struct conta
    { int numero_conta, numero_cli;
      float saldo;
    };

  conta a, b;
  int c, con;
  float dep;
  contas = fopen("c:\\contas.dat", "rb+");
  if (contas == NULL)
     { printf("\nErro na abertura do arquivo contas");
       getchar();
     }
  else
     { printf("\nDigite o numero da conta que sofrera o deposito: ");
       scanf("%d%*c", &con);
       c=0;
       fread(&b, sizeof(conta), 1, contas);
       while ((!feof(contas)) && (b.numero_conta != con))
				 { fread(&b, sizeof(conta), 1, contas);
					 c++;
				 }
	   if (feof(contas))
	      { printf("\nConta nao cadastrada !");
		    getchar();
		  }
	   else
	      { rewind(contas);
		    fseek(contas, c * sizeof(conta), SEEK_SET);
			printf("\nSaldo atual da conta: %12.2f ", b.saldo);
			printf("\nDigite valor do deposito: ");
			scanf("%f%*C", &dep);
			b.saldo = b.saldo + dep;
			fwrite(&b, sizeof(conta), 1, contas);
			printf("\nDeposito realizado com sucesso !");
			getchar();
		  }
		fclose(contas);
	 }
   return 0;
}

