#include <stdio.h>
int main()
{ struct vendedor
    { int codigo_vendedor, mes, ativo;
      char nome_vendedor[20];
      float valor_venda;
    };
  FILE *loja;
  vendedor b;
  int cod, mes, c;
  loja = fopen("c:\\vendas.dat", "rb+");

  if (loja == NULL)
	 { printf("\nErro na criacao do arquivo");
       getchar();
	 }
  else
	 { printf("Digite o codigo do vendedor a ser excluido: ");
	   scanf("%d%*c", &cod);
	   printf("Digite o mes a ser excluido: ");
	   scanf("%d%*c", &mes);
	   c=0;
	   fread(&b, sizeof(vendedor), 1, loja);
	   while ((!feof(loja)) && ((cod != b.codigo_vendedor) || (mes != b.mes) || (b.ativo != 1)))
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
		    b.ativo = 0;
		    fwrite(&b, sizeof(vendedor), 1, loja);
	        printf("\nDados excluidos com sucesso !");
		    getchar();
		  }
	   fclose(loja);
	}
 return 0;
}

