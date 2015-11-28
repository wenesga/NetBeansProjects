#include <stdio.h>
int main()
{ struct aluno
    { int numero;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe, *auxi;
  aluno b;
  int numero;
  classe = fopen("c:\\alunos.dat", "ab+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno a ser excluido: ");
       scanf("%d%*c", &numero);
       fread(&b, sizeof(aluno), 1, classe);
       while ((!feof(classe)) && (numero != b.numero))
	     fread(&b, sizeof(aluno), 1, classe);
       if (!feof(classe))
	      { auxi = fopen("c:\\auxi.dat", "ab+");
	        fclose(classe);
	        classe = fopen("c:\\alunos.dat", "rb");
	        fread(&b, sizeof(aluno), 1, classe);
	        while (!feof(classe))
	          { if (b.numero != numero)
		           fwrite(&b, sizeof(aluno), 1, auxi);
	            fread(&b, sizeof(aluno), 1, classe);
	          }
	        fclose(classe);
	        fclose(auxi);
	        remove("c:\\alunos.dat");
	        rename("c:\\auxi.dat", "c:\\alunos.dat");
	        printf("\nAluno excluido com sucesso !");
	        getchar();
	      }
       else
	      { printf("\nNumero nao encontrado !");
	        getchar();
	        fclose(classe);
	      }
    }
  return 0;
}
