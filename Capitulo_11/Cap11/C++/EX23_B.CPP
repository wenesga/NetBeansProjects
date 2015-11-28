#include <stdio.h>
#include <ctype.h>
int main()
{ FILE *contas, *clientes;
  struct cliente
    { int numero, ativo;
      char nome[20];
    };
  struct conta
    { int numero_conta, numero_cli, ativo;
      float saldo;
    };

  conta a, b;
  cliente c;
  char letra;
  int achou;
  clientes = fopen("c:\\clientes.dat", "rb+");
  if ((contas == NULL) || (clientes == NULL))
     { printf("\nErro na abertura dos arquivos");
       getchar();
     }
  else
     { printf("\nDigite a letra inicial dos nomes que deseja cosultar: ");
       scanf("%c%*c", &letra);
       fread(&c, sizeof(cliente), 1, clientes);
       if (feof(clientes))
	      { printf("\nArquivo de clientes vazio !");
		    getchar();
		  }
       else
	      { while (!feof(clientes))
		      { if ((toupper(letra) == toupper(c.nome[0])) && (c.ativo == 1))
			       { printf("\nLista de contas do cliente: %s ", c.nome);
			         contas = fopen("c:\\contas.dat", "rb+");
					 achou = 0;
					 fread(&b, sizeof(conta), 1, contas);
					 while (!feof(contas))
					   { if ((b.numero_cli == c.numero) && (b.ativo == 1))
					        { printf("\nNumero conta: %d Saldo: %12.2f ", b.numero_conta, b.saldo);
							  achou = 1;
							}
						 fread(&b, sizeof(conta), 1, contas);
				       }
					 if (achou == 0)
					    printf("\nNao ha conta cadastrada para este cliente ! ");
				     printf("\n\t\tTecle enter ... \n");
					 getchar();
					 fclose(contas);
				   }
				 fread(&c, sizeof(cliente), 1, clientes);
			   }
		   }
		fclose(clientes);
	  }
  return 0;
}
