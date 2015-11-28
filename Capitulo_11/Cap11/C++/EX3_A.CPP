#include <stdio.h>
int main()
{ struct aluno
    { int numero;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe, *auxi;
  aluno b;
  int numero, c;
  classe = fopen("c:\\alunos.dat", "rb+");

  if (classe == NULL)
     { printf("\nErro na criacao dos arquivos");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno ");
       scanf("%d%*c", &numero);
       c=0;
       fread(&b, sizeof(aluno), 1, classe);
       while ((!feof(classe)) && (numero != b.numero))
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
	        printf("\nNome do aluno: %s", b.nome);
	        printf("\nCurso do aluno: %s ", b.curso);
	        printf("\nA primeira nota: %5.2f", b.nota1);
	        printf("\nDigite o novo valor da primeira nota: ");
            scanf("%f%*c", &b.nota1);
	        printf("\nA segunda nota: %5.2f", b.nota2);
	        printf("\nDigite o novo valor da segunda nota: ");
            scanf("%f%*c", &b.nota2);
	        while ((b.nota1 < 0) || (b.nota1 > 10))
	          { printf("\nPRIMEIRA NOTA INVALIDA. DIGITE NOVAMENTE ");
	            scanf("%f%*c", &b.nota1);
	          }
	        while ((b.nota2 < 0) || (b.nota2 > 10))
	          { printf("\nSEGUNDA NOTA INVALIDA. DIGITE NOVAMENTE ");
		        scanf("%f%*c", &b.nota2);
	          }
	        fwrite(&b, sizeof(aluno), 1, classe);
	        printf("\nAlteracao realizada com sucesso !");
	        getchar();
	    }
       fclose(classe);
     }
   return 0;
}
