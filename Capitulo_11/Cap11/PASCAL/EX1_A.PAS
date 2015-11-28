PROGRAM EX1;
USES CRT;
TYPE aluno = RECORD
	numero : INTEGER;
	nome : STRING[20];
	curso: STRING[15];
	nota1, nota2 : REAL;
	END;
classe = FILE OF aluno;
VAR ALUNOS: classe;
    A: aluno;
BEGIN
CLRSCR;
ASSIGN(ALUNOS, 'C:\ALUNOS.DAT');
REWRITE(ALUNOS);
CLOSE(ALUNOS);
WRITELN('Arquivo de ALUNOS criado com sucesso!!!');
READLN;
END.
