#include <stdio.h>
int main()
{ struct aluno
    { int numero, ativo;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe;
  aluno b;
  int numero, c;
  classe = fopen("c:\\alunos.dat", "rb+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno: ");
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
	       printf("\nNome do aluno: %s ", b.nome);
	       printf("\nCurso do aluno: %s ", b.curso);
	       printf("\nDigite o novo curso: ");
	       scanf("%s%*c", b.curso);
	       fwrite(&b, sizeof(aluno), 1, classe);
	       printf("\nAlteracao realizada com sucesso !");
	       getchar();
	     }
       fclose(classe);
     }
  return 0;   
}

