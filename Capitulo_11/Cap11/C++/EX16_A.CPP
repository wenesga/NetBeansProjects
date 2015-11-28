#include <stdio.h>
int main()
{ struct vendedor
    { int codigo_vendedor, mes;
      char nome_vendedor[20];
      float valor_venda;
    };
  FILE *loja, *auxi;
  vendedor b;
  int cod;
  float total=0;
  loja = fopen("c:\\vendas.dat", "ab+");

  if (loja == NULL)
	 { printf("\nErro na criacao do arquivo");
	   getchar();
	 }
  else
	 { printf("Digite o codigo do vendedor desejado: ");
	   scanf("%d%*c", &cod);
	   fread(&b, sizeof(vendedor), 1, loja);
	   if (feof(loja))
		  { printf("\nArquivo vazio !");
			getchar();
		  }
	   else
		  { while (!feof(loja))
			  { if (b.codigo_vendedor == cod)
				    total = total + b.valor_venda;
			    fread(&b, sizeof(vendedor), 1, loja);
			  }
		    if (total == 0)
			    printf("\nNao existem vendas cadastradas para este vendedor");
		    else
			    printf("\nTotal das vendas: %12.2f", total);
		    getchar();
	      }
	   fclose(loja);
     }
  return 0;
}
