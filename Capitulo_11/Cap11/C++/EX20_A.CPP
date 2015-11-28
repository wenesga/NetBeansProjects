#include <stdio.h>
int main()
{   FILE *clientes;
	struct cliente
		{ int numero;
			char nome[20];
		};

	cliente a, b;
	clientes = fopen("c:\\clientes.dat", "ab+");
	if (clientes == NULL)
       { printf("\nErro na criacao do arquivo");
	     getchar();
       }
	else
	   { printf("\nDigite o numero do cliente a ser incluido: ");
	     scanf("%d%*c", &a.numero);
		 printf("Digite o nome do cliente a ser incluido: ");
		 scanf("%s%*c", a.nome);
		 fread(&b, sizeof(cliente), 1, clientes);
		 if (feof(clientes))
		    { fwrite(&a, sizeof(cliente), 1, clientes);
			  fclose(clientes);
			  printf("\nCliente incluido com sucesso !");
			  getchar();
			}
		 else
		    { while ((!feof(clientes)) && (a.numero != b.numero))
			    { fread(&b, sizeof(cliente), 1, clientes);
			    }
			  if (feof(clientes))
			     { fwrite(&a, sizeof(cliente), 1, clientes);
				   printf("\nCliente incluido com sucesso !");
				   getchar();
				 }
			  else
				 { printf("\nJa existe cliente cadastrado com este codigo !");
				   getchar();
				 }
			  fclose(clientes);
		  }
	 }
  return 0;
}

