#include <stdio.h>
int main()
{ struct vendedor
    { int codigo_vendedor, mes;
			char nome_vendedor[20];
			float valor_venda;
		};
	FILE *loja, *auxi;
	vendedor b;
	int cod, mes, c;
	loja = fopen("c:\\vendas.dat", "ab+");

	if (loja == NULL)
	   { printf("\nErro na criacao do arquivo");
	     getchar();
	   }
	else
	   { printf("Digite o codigo do vendedor desejado: ");
		 scanf("%d%*c", &cod);
		 printf("Digite o mes desejado: ");
		 scanf("%d%*c", &mes);
		 c=0;
		 fread(&b, sizeof(vendedor), 1, loja);
		 while ((!feof(loja)) && ((cod != b.codigo_vendedor) || (mes != b.mes)))
		   { fread(&b, sizeof(vendedor), 1, loja);
			 c++;
		   }
		 if (feof(loja))
			{ printf("\nVenda nao cadastrada ! ");
			  getchar();
			  fclose(loja);
			}
		else
		   { rewind(loja);
			 fseek(loja, c * sizeof(vendedor), SEEK_SET);
			 printf("\nCodigo: %d", b.codigo_vendedor);
			 printf("\nNome: %s", b.nome_vendedor);
			 printf("\nMes: %d", b.mes);
			 printf("\nValor da venda: %10.2f \n", b.valor_venda);
			 getchar();
	      }
        fclose(loja);
	 }
   return 0;
}
