#include <stdio.h>
int main()
{ FILE *l;
  l = fopen("c:\\vendas.dat", "w");
  if (l == NULL)
	  printf("\nErro na criacao do arquivo");
  else
	 { printf("\nSucesso na criacao do arquivo");
       fclose(l);
     }
  getchar();
  return 0;
}
