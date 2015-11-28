#include <stdio.h>
int main()
{ struct aluno
    { int numero;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe;
  aluno b;
  int numero, achou=0;
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
		      { m = (b.nota1 + b.nota2) / 2;
			    if (m >= 7)
		           { achou = 1;
			         printf("\nNome: %s", b.nome);
			         printf("\nCurso: %s", b.curso);
			         printf("\nMedia: %5.2f", m);
			         printf("\n\nTecle enter ... \n");
			         getchar();
		           }
			    fread(&b, sizeof(aluno), 1, classe);
		      }
	      }
		fclose(classe);
		if (achou == 0)
           { printf("\nNao existem alunos nestas condicoes");
             getchar();
		   }
	  }
  return 0;
}
