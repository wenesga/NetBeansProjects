#include <stdio.h>
int main()
{ struct vendedor
    { int codigo_vendedor, mes;
      char nome_vendedor[20];
      float valor_venda;
    };
  FILE *loja, *auxi;
  vendedor a, b;
  loja = fopen("c:\\vendas.dat", "ab+");

  if (loja == NULL)    
	 { printf("\nErro na criacao do arquivo");
	   getchar();
	 }
  else
	 { printf("\nDigite o codigo do vendedor a ser incluido: ");
	   scanf("%d%*c", &a.codigo_vendedor);
	   printf("Digite o mes da venda a ser incluido: ");
	   scanf("%d%*c", &a.mes);
	   fread(&b, sizeof(vendedor), 1, loja);
	   if (feof(loja))
		  { printf("Digite o nome do vendedor a ser incluido: ");
		    scanf("%s%*c", a.nome_vendedor);
		    printf("Digite o valor da venda a ser incluida: ");
		    scanf("%f%*c", &a.valor_venda);
		    fwrite(&a, sizeof(vendedor), 1, loja);
		    fclose(loja);
		    printf("\nVenda incluida com sucesso !");
		    getchar();
	      }
	   else
	     { while ((!feof(loja)) && ((a.codigo_vendedor != b.codigo_vendedor) || (a.mes != b.mes)))
		     { fread(&b, sizeof(vendedor), 1, loja);
		     }
	       if (feof(loja))
		      { printf("Digite o nome do vendedor a ser incluido: ");
			    scanf("%s%*c", a.nome_vendedor);
		        printf("Digite o valor da venda a ser incluida: ");
		        scanf("%f%*c", &a.valor_venda);
		        auxi = fopen("c:\\auxi.dat", "ab+");
		        fclose(loja);
		        loja = fopen("c:\\vendas.dat", "rb");
		        fread(&b, sizeof(vendedor), 1, loja);
	            while ((!feof(loja)) && ((b.codigo_vendedor < a.codigo_vendedor)
					 || ((b.codigo_vendedor == a.codigo_vendedor) && (b.mes < a.mes))))
		           { fwrite(&b, sizeof(vendedor), 1, auxi);
		             fread(&b, sizeof(vendedor), 1, loja);
		           }
		       fwrite(&a, sizeof(vendedor), 1, auxi);
		       while (!feof(loja))
		         { fwrite(&b, sizeof(vendedor), 1, auxi);
	               fread(&b, sizeof(vendedor), 1, loja);
		         }
		      fclose(loja);
		      fclose(auxi);
		      remove("c:\\vendas.dat");
		      rename("c:\\auxi.dat", "c:\\vendas.dat");
		      printf("\nDados incluidos com sucesso !");
		      getchar();
	        }
	      else
	        { printf("\nDados ja estao cadastrados !");
	          getchar();
	          fclose(loja);
	          fclose(auxi);
	          remove("c:\\auxi.dat");
	        }
       }
    }
   return 0;
}
