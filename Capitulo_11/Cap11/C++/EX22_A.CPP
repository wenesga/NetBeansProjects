#include <stdio.h>
int main()
{ FILE *contas, *clientes;
  struct cliente
    { int numero;
      char nome[20];
	};
  struct conta
    { int numero_conta, numero_cli;
	  float saldo;
	};

  conta a, b;
  cliente c;
  int cli, achou = 0;
  contas = fopen("c:\\contas.dat", "rb+");
  clientes = fopen("c:\\clientes.dat", "rb+");
  if ((contas == NULL) || (clientes == NULL))
     { printf("\nErro na abertura dos arquivos");
       getchar();
	 }
  else
     { printf("\nDigite o numero do cliente desejado: ");
	   scanf("%d%*c", &cli);
	   fread(&c, sizeof(cliente), 1, clientes);
	   while ((!feof(clientes)) && (c.numero != cli))
	     fread(&c, sizeof(cliente), 1, clientes);
	   if (feof(clientes))
	      { printf("\nCliente nao cadastrado! ");
		    getchar();
		  }
       else
	      { printf("Nome cliente: %s ", c.nome);
		    fread(&b, sizeof(conta), 1, contas);
			while (!feof(contas))
              { if (b.numero_cli == cli)
			       { achou = 1;
				     printf("\nNumero conta: %d Saldo: %12.2f ", b.numero_conta, b.saldo);
	                }
				fread(&b, sizeof(conta), 1, contas);
			  }
			if (achou == 0)
			   printf("\nNao ha contas para este cliente");
			printf("\n\n\t\tTecle enter ...");
			getchar();
		  }
	  }
   return 0;
}




