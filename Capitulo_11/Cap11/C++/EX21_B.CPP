#include <stdio.h>
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
  contas = fopen("c:\\contas.dat", "ab+");
  if (contas == NULL)
     { printf("\nErro na abertura do arquivo contas");
       getchar();
     }
  else
     { printf("\nDigite o numero da conta a ser incluida: ");
       scanf("%d%*c", &a.numero_conta);
       printf("Digite o numero do cliente: ");
       scanf("%d%*c", &a.numero_cli);
       clientes = fopen("c:\\clientes.dat", "rb+");
       if (clientes == NULL)
		   { printf("\nErro na abertura do arquivo clientes");
		     getchar();
		   }
		else
		   { fread(&c, sizeof(cliente), 1, clientes);
             while ((!feof(clientes)) && ((a.numero_cli != c.numero) || (c.ativo != 1)))
			    fread(&c, sizeof(cliente), 1, clientes);
			 if (feof(clientes))
			    { printf("\nCliente nao cadastrado! ");
				  getchar();
				}
			 else
			    { printf("Nome cliente: %s ", c.nome);
				  printf("\nDigite o saldo da conta a ser incluida: ");
				  scanf("%f%*c", &a.saldo);
				  a.ativo = 1;
				  fread(&b, sizeof(conta), 1, contas);
				  if (feof(contas))
				     { fwrite(&a, sizeof(conta), 1, contas);
					   fclose(clientes);
					   printf("\nConta incluida com sucesso !");
					   getchar();
					 }
				  else
				     { while ((!feof(contas)) && ((a.numero_conta != b.numero_conta) || (b.ativo != 1)))
					     fread(&b, sizeof(conta), 1, contas);
				       if (feof(contas))
					      { fwrite(&a, sizeof(conta), 1, contas);
						    printf("\nConta incluida com sucesso !");
	                        getchar();
						  }
				       else
					      { printf("\nJa existe conta cadastrada com este numero!");
						    getchar();
						  }
				     }
				}
		     fclose(clientes);
		}
     fclose(contas);
   }
  return 0;
}
