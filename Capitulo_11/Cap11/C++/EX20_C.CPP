#include <stdio.h>
int main()
{   FILE *clientes, *auxi;
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
		 fread(&b, sizeof(cliente), 1, clientes);
		 if (feof(clientes))
			{ printf("Digite o nome do clientes a ser incluido: ");
			  scanf("%s%*c", a.nome);
			  fwrite(&a, sizeof(cliente), 1, clientes);
			  fclose(clientes);
			  printf("\nCliente incluido com sucesso !");
			  getchar();
			}
		 else
            { while ((!feof(clientes)) && (a.numero != b.numero))
			    { fread(&b, sizeof(cliente), 1, clientes);
				}
			  if (feof(clientes))
			     {  printf("Digite o nome do cliente a ser incluido: ");
					scanf("%s%*c", &a.nome);
					auxi = fopen("c:\\auxi.dat", "ab+");
					fclose(clientes);
					clientes = fopen("c:\\clientes.dat", "ab+");
					fread(&b, sizeof(cliente), 1, clientes);
					while ((!feof(clientes)) && (b.numero < a.numero))
				      { fwrite(&b, sizeof(cliente), 1, auxi);
					    fread(&b, sizeof(cliente), 1, clientes);
		              }
					fwrite(&a, sizeof(cliente), 1, auxi);
					while (!feof(clientes))
					  { fwrite(&b, sizeof(cliente), 1, auxi);
					    fread(&b, sizeof(cliente), 1, clientes);
					  }
					fclose(clientes);
					fclose(auxi);
					remove("c:\\clientes.dat");
					rename("c:\\auxi.dat", "c:\\clientes.dat");
					printf("\nCliente incluido com sucesso !");
					getchar();
				 }
			  else
				 { printf("\nJa existe cliente cadastrado com este codigo !");
				   getchar();
			       fclose(clientes);
				}
            }
       }
   return 0;
}
