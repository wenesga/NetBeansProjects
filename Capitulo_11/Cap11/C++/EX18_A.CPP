#include <stdio.h>
#include <string.h>
int main()
{ struct vendedor
    { int codigo_vendedor, mes;
      char nome_vendedor[20];
      float valor_venda;
    };
  FILE *loja, *auxi;
  vendedor b;
  char nome[20];
  int cod, mes, c;
  float maior=0;
  loja = fopen("c:\\vendas.dat", "ab+");

  if (loja == NULL)
	 { printf("\nErro na criacao do arquivo");
       getchar();
	 }
  else
	 { fread(&b, sizeof(vendedor), 1, loja);
	   if (feof(loja))
		  { printf("\nArquivo vazio !");
		    getchar();
		  }
	   else
		  { c=0;
			while (!feof(loja))
			  { if (c==0)
				   { maior = b.valor_venda;
					 strcpy(nome, b.nome_vendedor);
					 cod = b.codigo_vendedor;
					 mes = b.mes;
					 c=1;
				   }
				else
				   { if (b.valor_venda > maior)
				 		{ maior = b.valor_venda;
					      strcpy(nome, b.nome_vendedor);
						  cod = b.codigo_vendedor;
						  mes = b.mes;
						}
			       }
				fread(&b, sizeof(vendedor), 1, loja);
			  }
			if (c==0)
			   { printf("\nNao ha vendas cadastradas !");
			     getchar();
			   }
			else
			   { printf("\n\nA maior venda ocorreu no mes: %d", mes);
			     printf("\nRealizada pelo vendedor: %s - Codigo: %d", nome, cod);
			     printf("\nValor da venda: %10.2f", maior);
			     getchar();
			   }
		  }
		fclose(loja);
	 }
 return 0;
}
