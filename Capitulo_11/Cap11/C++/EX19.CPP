#include <stdio.h>
int main()
{ FILE *clientes, *contas;
  clientes = fopen("c:\\clientes.dat", "w");
  if (clientes == NULL)
     printf("\nErro na criacao do arquivo clientes");
  else
     { printf("\nSucesso na criacao do arquivo clientes");
	   fclose(clientes);
	 }
  contas = fopen("c:\\contas.dat", "w");
  if (contas == NULL)
     printf("\nErro na criacao do arquivo contas");
  else
     { printf("\nSucesso na criacao do arquivo contas");
       fclose(contas);
     }
  getchar();
  return 0;
}
