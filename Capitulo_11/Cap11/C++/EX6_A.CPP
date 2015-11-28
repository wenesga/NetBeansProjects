#include <stdio.h>
int main()
{ struct aluno
    { int numero;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe;
  aluno b;
  int numero;
  float m;
  classe = fopen("c:\\alunos.dat", "ab+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { fread(&b, sizeof(aluno), 1, classe);
       if (feof(classe))
          { printf("\nArquivo vazio !");
	        getchar();
	      }
       else
	     { while (!feof(classe))
	         { printf("\nNome: %s", b.nome);
	           printf("\nCurso: %s", b.curso);
	           printf("\nNota 1: %5.2f", b.nota1);
	           printf("\nNota 2: %5.2f", b.nota2);
	           m = (b.nota1 + b.nota2)/2;
	           printf("\nMedia: %5.2f", m);
	           printf("\n\nTecle enter ... \n");
	           getchar();
	           fread(&b, sizeof(aluno), 1, classe);
             }
	     }
       fclose(classe);
     }
  return 0;
}
