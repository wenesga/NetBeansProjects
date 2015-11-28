#include <stdio.h>
int main()
{ struct aluno
    { int numero, ativo;
      char nome[20], curso[15];
      float nota1, nota2;
    };
  FILE *classe;
  aluno a, b;
  classe = fopen("c:\\alunos.dat", "a+");

  if (classe == NULL)
     { printf("\nErro na criacao do arquivo");
       getchar();
     }
  else
     { printf("\nDigite o numero do aluno a ser incluido: ");
       scanf("%d%*c", &a.numero);
	   fread(&b, sizeof(aluno), 1, classe);
	   while ((!feof(classe)) && ((a.numero != b.numero) || ((a.numero == b.numero) && (b.ativo != 1))))
	      fread(&b, sizeof(aluno), 1, classe);
	   if (feof(classe))
	    { printf("Digite o nome do aluno a ser incluido: ");
          scanf("%s%*c", a.nome);
	      printf("Digite o curso do aluno a ser incluido: ");
          scanf("%s%*c", &a.curso);
	      printf("Digite a primeira nota do aluno a ser incluido: ");
          scanf("%f%*c", &a.nota1);
	      printf("Digite a segunda nota do aluno a ser incluido: ");
          scanf("%f%*c", &a.nota2);
	      a.ativo = 1;
	      while ((a.nota1 < 0) || (a.nota1 > 10))
	       { printf("\nPRIMEIRA NOTA INVALIDA. DIGITE NOVAMENTE ");
	         scanf("%f%*c", &a.nota1);
	       }
	      while ((a.nota2 < 0) || (a.nota2 > 10))
	       { printf("\nSEGUNDA NOTA INVALIDA. DIGITE NOVAMENTE ");
	         scanf("%f%*c", &a.nota2);
	       }
	      fwrite(&a, sizeof(aluno), 1, classe);
	      printf("\nAluno incluido com sucesso !");
	    }
       else
	     printf("\nNumero ja cadastrado !");
       getchar();
       fclose(classe);
     }
   return 0;  
}
