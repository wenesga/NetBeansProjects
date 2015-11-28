#include <stdio.h>
int main()
{ struct aluno
    { int numero;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe, *auxi;
  aluno a, b;
  classe = fopen("c:\\alunos.dat", "ab+");

  if (classe == NULL)
     { printf("\nErro na criacao dos arquivos");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno a ser incluido: ");
       scanf("%d%*c", &a.numero);
	   fread(&b, sizeof(aluno), 1, classe);
       while ((!feof(classe)) && (a.numero != b.numero))
	     { fread(&b, sizeof(aluno), 1, classe);
         }
	   if (!feof(classe))
	      { printf("\nNumero ja cadastrado !");
		    getchar();
		    fclose(classe);
		  }
	   else
		{ printf("Digite o nome do aluno a ser incluido: ");
          scanf("%s%*c", a.nome);
	      printf("Digite o curso do aluno a ser incluido: ");
	      scanf("%s%*c", a.curso);
		  printf("Digite a primeira nota do aluno a ser incluido: ");
	      scanf("%f%*c", &a.nota1);
		  printf("Digite a segunda nota do aluno a ser incluido: ");
	      scanf("%f%*c", &a.nota2);
		  while ((a.nota1 < 0) || (a.nota1 > 10))
			{ printf("\nPRIMEIRA NOTA INVALIDA. DIGITE NOVAMENTE ");
              scanf("%f%*c", &a.nota1);
			}
		  while ((a.nota2 < 0) || (a.nota2 > 10))
			{ printf("\nSEGUNDA NOTA INVALIDA. DIGITE NOVAMENTE ");
              scanf("%f%*c", &a.nota2);
			}
		  auxi = fopen("c:\\auxi.dat", "ab+");
		  fclose(classe);
		  classe = fopen("c:\\alunos.dat", "rb");
		  fread(&b, sizeof(aluno), 1, classe);
		  while ((!feof(classe)) && (b.numero < a.numero))
		    { fwrite(&b, sizeof(aluno), 1, auxi);
		      fread(&b, sizeof(aluno), 1, classe);
		    }
		  fwrite(&a, sizeof(aluno), 1, auxi);
		  while (!feof(classe))
		    { fwrite(&b, sizeof(aluno), 1, auxi);
              fread(&b, sizeof(aluno), 1, classe);
		    }
          fclose(classe);
		  fclose(auxi);
		  remove("c:\\alunos.dat");
		  rename("c:\\auxi.dat", "c:\\alunos.dat");
		  printf("\nAluno incluido com sucesso !");
		  getchar();
		}
	 }
   return 0;
}


