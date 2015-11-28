#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main()
{ struct aluno
    { int numero, ativo;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe;
  aluno b;
  char curs[15];
  int numero, achou = 0, i;
  classe = fopen("c:\\alunos.dat", "ab+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { printf("\nDigite o nome do curso: ");
       scanf("%s%*c", curs);
       for (i=0; i < strlen(curs); i++)
           curs[i] = toupper(curs[i]);
       fread(&b, sizeof(aluno), 1, classe);
       if (feof(classe))
          { printf("\nArquivo vazio !");
	        getchar();
	      }
       else
	      { while (!feof(classe))
	          {  for (i=0; i < strlen(b.curso); i++)
                     b.curso[i] = toupper(b.curso[i]);
                  if ((b.ativo == 1) && (strcmp(b.curso, curs) == 0))
		           { achou= 1;
		             printf("\nNome: %s", b.nome);
		             printf("\n\nTecle enter ... \n");
		             getchar();
		           }
	            fread(&b, sizeof(aluno), 1, classe);
	          }
	      }
       fclose(classe);
       if (achou == 0)
	      { printf("\nNao existem alunos neste curso");
	        getchar();
	      }
     }
   return 0;
}
