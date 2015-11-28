#include <stdio.h>
int main()
{ struct aluno
    { int numero, ativo;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe, *auxi;
  aluno b;
  int numero, c;
  classe = fopen("c:\\alunos.dat", "rb+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno ");
       scanf("%d%*c", &numero);
       c=0;
       fread(&b, sizeof(aluno), 1, classe);
       while ((!feof(classe)) && ((numero != b.numero) || ((numero == b.numero) && (b.ativo != 1))))
	     { fread(&b, sizeof(aluno), 1, classe);
	       c++;
	     }
       if (feof(classe))
	      { printf("\nAluno nao cadastrado ! ");
	        getchar();
	      }
       else
	      { rewind(classe);
	        fseek(classe, c * sizeof(aluno), SEEK_SET);
	        b.ativo = 0;
	        fwrite(&b, sizeof(aluno), 1, classe);
	        printf("\nExclusao realizada com sucesso !");
	        getchar();
	      }
       fclose(classe);
     }
   return 0;
}

