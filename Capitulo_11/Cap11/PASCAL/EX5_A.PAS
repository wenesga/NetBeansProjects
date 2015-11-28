PROGRAM EX5;
USES CRT;
TYPE aluno = RECORD
	numero : INTEGER;
	nome : STRING[20];
	curso: STRING[15];
	nota1, nota2 : REAL;
	END;
classe = FILE OF aluno;
VAR 	ALUNOS, AUXILIAR: classe;
	A, AUX: aluno;
        K, I, P, POSICAO: INTEGER;
	ACHOU : BOOLEAN;
	NUMERO: INTEGER;
	NOME: STRING[20];
        CURSO: STRING[15];
        NOTA1,NOTA2: REAL;
BEGIN
CLRSCR;
ASSIGN(ALUNOS, 'C:\ALUNOS.DAT');
{$I-}
RESET(ALUNOS);
{$I+}
IF IORESULT = 2
   THEN REWRITE(ALUNOS);

ASSIGN(AUXILIAR, 'C:\AUXILIO.DAT');
REWRITE(AUXILIAR);
K := FILESIZE(ALUNOS);
IF K = 0
THEN WRITELN('N«O EXISTE ALUNO CADASTRADO')
ELSE BEGIN
     WRITE('DIGITE O NÈMERO DO ALUNO A SER EXCLU÷DO ');
     READLN(NUMERO);
     WHILE (ACHOU = FALSE) AND (NOT EOF(ALUNOS)) DO
     BEGIN
     READ(ALUNOS,A);
     IF A.NUMERO = NUMERO
     THEN BEGIN
          ACHOU := TRUE;
	  POSICAO := FILEPOS(ALUNOS) -1;
	  END;
     END;
     IF ACHOU = TRUE
     THEN BEGIN
	  IF K = 1
          THEN BEGIN
               REWRITE(ALUNOS);
               WRITELN('ALUNO EXCLU÷DO COM SUCESSO');
               END
          ELSE BEGIN
               ACHOU := FALSE;
               K := 0;
               SEEK(ALUNOS, K);
	       WHILE K < POSICAO DO
	       BEGIN
	       SEEK(ALUNOS, K);
	       READ(ALUNOS,A);
	       AUX.NUMERO := A.NUMERO;
	       AUX.NOME := A.NOME;
	       AUX.CURSO := A.CURSO;
	       AUX.NOTA1 := A.NOTA1;
	       AUX.NOTA2 := A.NOTA2;
	       WRITE(AUXILIAR, AUX);
	       K := K +1;
	       END;
	       K := POSICAO + 1;
	       WHILE K <= FILESIZE(ALUNOS) - 1 DO
	       BEGIN
	       SEEK(ALUNOS, K);
	       READ(ALUNOS,A);
               AUX.NUMERO := A.NUMERO;
	       AUX.NOME := A.NOME;
	       AUX.CURSO := A.CURSO;
	       AUX.NOTA1 := A.NOTA1;
	       AUX.NOTA2 := A.NOTA2;
	       WRITE(AUXILIAR, AUX);
	       K := K +1;
	       END;
	       REWRITE(ALUNOS);
	       RESET(AUXILIAR);
	       WHILE NOT EOF(AUXILIAR) DO
	       BEGIN
	       READ(AUXILIAR, AUX);
	       A.NUMERO := AUX.NUMERO;
	       A.NOME := AUX.NOME;
	       A.CURSO :=  AUX.CURSO;
	       A.NOTA1:= AUX.NOTA1;
	       A.NOTA2:= AUX.NOTA2;
	       WRITE(ALUNOS, A);
	       END;
	       WRITELN('ALUNO EXCLU÷DO');
	       END;
             END
        ELSE WRITELN('ESTE ALUNO N«O ESTµ CADASTRADO');
      END;
READLN;
CLOSE(ALUNOS);
CLOSE(AUXILIAR);
END.
