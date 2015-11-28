PROGRAM EX2;
USES CRT;
TYPE aluno = RECORD
	numero : INTEGER;
	nome : STRING[20];
	curso: STRING[15];
	nota1, nota2 : REAL;
	END;
classe = FILE OF aluno;
VAR 	ALUNOS: classe;
	A: aluno;
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
K := FILESIZE(ALUNOS);
WRITE('DIGITE O NéMERO DO ALUNO A SER INCLUÖDO ');
READLN(NUMERO);
IF K = 0
	THEN BEGIN
        WRITE('DIGITE  O NOME DO ALUNO A SER INCLUÖDO ');
        READLN(NOME);
        WRITE('DIGITE O CURSO DO ALUNO A SER INCLUÖDO ');
        READLN(CURSO);
        REPEAT
        WRITE('DIGITE A PRIMEIRA NOTA DO ALUNO A SER INCLUÖDO ');
        READLN(NOTA1);
        UNTIL (NOTA1 >= 0) AND (NOTA1 <= 10);
        REPEAT
        WRITE('DIGITE A SEGUNDA NOTA DO ALUNO A SER INCLUÖDO ');
        READLN(NOTA2);
        UNTIL (NOTA2 >= 0) AND (NOTA2 <= 10);
        A.NUMERO := NUMERO;
	A.NOME := NOME;
	A.CURSO := CURSO;
	A.NOTA1:= NOTA1;
	A.NOTA2 := NOTA2;
	WRITE(ALUNOS, A);
	WRITELN(' ALUNO INCLUÖDO');
	END
	ELSE BEGIN
		I := 0;
		ACHOU := FALSE;
	        POSICAO := 0;
		RESET(ALUNOS);
		WHILE ( I <= (K-1)) DO
			BEGIN
			READ(ALUNOS, A);
			IF A.NUMERO = NUMERO
			THEN BEGIN
				ACHOU := TRUE;
				I := K + 2;
				END
			ELSE BEGIN
				IF NUMERO < A.NUMERO
					THEN BEGIN
                                               POSICAO := FILEPOS(ALUNOS) - 1;
						I := K + 2;
						END
					ELSE BEGIN
                                                I := I+1;
						SEEK(ALUNOS, I);
						END;
				END;
			END;
		IF ACHOU = TRUE
		THEN WRITELN(' ESTE ALUNO Jµ ESTµ CADASTRADO ')
		ELSE BEGIN
			IF I = FILESIZE(ALUNOS)
			THEN BEGIN
                             WRITE('DIGITE  O NOME DO ALUNO A SER INCLUÖDO ');
                             READLN(NOME);
                             WRITE('DIGITE O CURSO DO ALUNO A SER INCLUÖDO ');
                             READLN(CURSO);
                             REPEAT
                             WRITE('DIGITE A PRIMEIRA NOTA DO ALUNO A SER INCLUÖDO ');
                             READLN(NOTA1);
                             UNTIL (NOTA1 >= 0) AND (NOTA1 <= 10);
                             REPEAT
                             WRITE('DIGITE A SEGUNDA NOTA DO ALUNO A SER INCLUÖDO ');
                             READLN(NOTA2);
                             UNTIL (NOTA2 >= 0) AND (NOTA2 <= 10);
			     SEEK(ALUNOS, FILESIZE(ALUNOS));
			     A.NUMERO := NUMERO;
			     A.NOME := NOME;
			     A.CURSO := CURSO;
			     A.NOTA1:= NOTA1;
			     A.NOTA2 := NOTA2;
			     WRITE(ALUNOS, A);
			     WRITELN(' ALUNO INCLUÖDO');
			     END
			ELSE BEGIN
                             P := FILESIZE(ALUNOS) - 1;
			     WHILE P >= POSICAO DO
				BEGIN
				SEEK(ALUNOS,P);
                                READ(ALUNOS,A);
                                WRITE(ALUNOS,A);
				P := P - 1 ;
				END;
			     SEEK(ALUNOS, POSICAO);
                             WRITE('DIGITE  O NOME DO ALUNO A SER INCLUÖDO ');
                             READLN(NOME);
                             WRITE('DIGITE O CURSO DO ALUNO A SER INCLUÖDO ');
                             READLN(CURSO);
                             REPEAT
                             WRITE('DIGITE A PRIMEIRA NOTA DO ALUNO A SER INCLUÖDO ');
                             READLN(NOTA1);
                             UNTIL (NOTA1 >= 0) AND (NOTA1 <= 10);
                             REPEAT
                             WRITE('DIGITE A SEGUNDA NOTA DO ALUNO A SER INCLUÖDO ');
                             READLN(NOTA2);
                             UNTIL (NOTA2 >= 0) AND (NOTA2 <= 10);
                             A.NUMERO := NUMERO;
			     A.NOME := NOME;
			     A.CURSO := CURSO;
			     A.NOTA1:= NOTA1;
			     A.NOTA2 := NOTA2;
			     WRITE(ALUNOS, A);
			     WRITELN(' ALUNO INCLUÖDO');
			     END;
		END;
	END;
READLN;
CLOSE(ALUNOS);
END.
