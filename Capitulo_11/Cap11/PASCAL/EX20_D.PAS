PROGRAM EX20;
USES CRT;
TYPE cliente = RECORD
	numero, ativo : INTEGER;
	nome : STRING[20];
	END;
clientes = FILE OF cliente;
VAR 	cli: clientes;
	cl: cliente;
K, I, P, POSICAO: INTEGER;
ACHOU : BOOLEAN;
NUMERO: INTEGER;
NOME: STRING[20];

BEGIN
CLRSCR;
ASSIGN(CLI, 'C:\CLIENTES.DAT');
{$I-}
RESET(CLI);
{$I+}
IF IORESULT = 2
   THEN REWRITE(CLI);
K := FILESIZE(CLI);
WRITE('DIGITE O NÈMERO DO CLIENTE A SER INCLU÷DO ');
READLN(NUMERO);

IF K = 0
THEN BEGIN
     WRITE('DIGITE O NOME DO CLIENTE A SER INCLU÷DO ');
     READLN(NOME);
     CL.NUMERO := NUMERO;
     CL.NOME := NOME;
     CL.ATIVO := 1;
     WRITE(CLI, CL);
     WRITELN('CLIENTE INCLU÷DO');
     END
ELSE BEGIN
     I := 0;
     ACHOU := FALSE;
     POSICAO := 0;
     RESET(CLI);
     WHILE ( I <= (K-1)) DO
	BEGIN
	READ(CLI, CL);
	IF (CL.NUMERO = NUMERO) AND (CL.ATIVO = 1)
           THEN BEGIN
		ACHOU := TRUE;
		I := K + 2;
		END
	   ELSE BEGIN
		IF NUMERO < CL.NUMERO
		   THEN BEGIN
                        POSICAO := FILEPOS(CLI) - 1;
			I := K + 2;
			END
		   ELSE BEGIN
                        I := I+1;
			SEEK(CLI, I);
			END;
		END;
	END;
     IF ACHOU = TRUE
	THEN WRITELN('JA EXISTE CLIENTE CADASTRADO COM ESTE CODIGO ')
	ELSE BEGIN
	     IF I = FILESIZE(CLI)
		THEN BEGIN
                     WRITE('DIGITE O NOME DO CLIENTE A SER INCLU÷DO ');
                     READLN(NOME);
		     SEEK(CLI, FILESIZE(CLI));
		     CL.NUMERO := NUMERO;
		     CL.NOME := NOME;
                     CL.ATIVO := 1;
		     WRITE(CLI, CL);
		     WRITELN('CLIENTE INCLU÷DO');
		     END
		ELSE BEGIN
                     P := FILESIZE(CLI) - 1;
                     WHILE P >= POSICAO DO
			BEGIN
			SEEK(CLI,P);
                        READ(CLI,CL);
                        WRITE(CLI,CL);
			P := P - 1 ;
			END;
		     SEEK(CLI, POSICAO);
                     WRITE('DIGITE O NOME DO CLIENTE A SER INCLU÷DO ');
                     READLN(NOME);
                     CL.NUMERO := NUMERO;
		     CL.NOME := NOME;
                     CL.ATIVO := 1;
		     WRITE(CLI, CL);
		     WRITELN('CLIENTE INCLU÷DO');
		     END;
		END;
	END;
READLN;
CLOSE(CLI);
END.