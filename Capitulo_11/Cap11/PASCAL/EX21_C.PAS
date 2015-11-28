PROGRAM EX21_C;
USES CRT;
TYPE cliente = RECORD
	numero : INTEGER;
	nome : STRING[20];
	END;
clientes = FILE OF cliente;

TYPE conta = RECORD
	numero_conta : INTEGER;
	numero_cli : INTEGER;
	saldo : REAL;
END;
contas = FILE OF conta;
VAR 	con: contas;
	co: conta;
	cli: clientes;
	cl: cliente;
K, I, P, POSICAO : INTEGER;
ACHOU : BOOLEAN;
NUM_CONTA, NUM_CLIENTE: INTEGER;
SALDO: REAL;
BEGIN
CLRSCR;
ASSIGN(CON, 'C:\CONTAS.DAT');
{$I-}
RESET(CON);
{$I+}
IF IORESULT = 2
   THEN REWRITE(CON);
ASSIGN(CLI, 'C:\CLIENTES.DAT');
{$I-}
RESET(CLI);
{$I+}
IF IORESULT = 2
   THEN REWRITE(CLI);
K := FILESIZE(CON);
WRITE('DIGITE O NÈMERO DA CONTA A SER INCLU÷DA ');
READLN(NUM_CONTA);
WRITE('DIGITE O NÈMERO DO CLIENTE DA CONTA ');
READLN(NUM_CLIENTE);
WRITE('DIGITE O SALDO ');
READLN(SALDO);
ACHOU:=FALSE;
WHILE NOT EOF(CLI) DO
BEGIN
READ(CLI,CL);
IF CL.NUMERO = NUM_CLIENTE
THEN ACHOU:=TRUE;
END;
IF ACHOU = FALSE
THEN WRITELN('ESTE CLIENTE N«O ESTµ CADASTRADO')
ELSE BEGIN
     ACHOU:=FALSE;
     IF K = 0
        THEN BEGIN
	     CO.NUMERO_CONTA := NUM_CONTA;
             CO.NUMERO_CLI := NUM_CLIENTE;
             CO.SALDO:= SALDO;
	     WRITE(CON,CO);
	     WRITELN('CONTA INCLU÷DA');
             END
        ELSE BEGIN
             I := 0;
             ACHOU := FALSE;
             POSICAO := 0;
             RESET(CON);
             WHILE ( I <= (K-1)) DO
             BEGIN
             	READ(CON, CO);
                IF CO.NUMERO_CONTA = NUM_CONTA
                   THEN BEGIN
                        ACHOU := TRUE;
                        I := K + 2;
                        END
                   ELSE BEGIN
                        IF NUM_CONTA < CO.NUMERO_CONTA
                           THEN BEGIN
                                POSICAO := FILEPOS(CON) - 1;
                                I := K + 2;
                                END
                           ELSE BEGIN
                                I := I+1;
                                SEEK(CON, I);
                                END;
                        END;
             END;
             IF ACHOU = TRUE
             	THEN WRITELN('JA EXISTE CONTA CADASTRADA COM ESTE NUMERO ')
                ELSE BEGIN
                     IF I = FILESIZE(CON)
                        THEN BEGIN
                             SEEK(CON, FILESIZE(CON));
                             CO.NUMERO_CONTA := NUM_CONTA;
                             CO.NUMERO_CLI := NUM_CLIENTE;
                             CO.SALDO:= SALDO;
                             WRITE(CON, CO);
                             WRITELN('CONTA INCLU÷DA');
                             END
                        ELSE BEGIN
                             P := FILESIZE(CON) - 1;
                             WHILE P >= POSICAO DO
			     BEGIN
			     SEEK(CON,P);
                             READ(CON,CO);
                             WRITE(CON,CO);
                             P := P - 1 ;
			     END;
		     SEEK(CON, POSICAO);
                     CO.NUMERO_CONTA := NUM_CONTA;
                     CO.NUMERO_CLI := NUM_CLIENTE;
                     CO.SALDO:= SALDO;
		     WRITE(CON, CO);
		     WRITELN('CONTA INCLU÷DA');
		     END;
		END;
             END;
	END;
READLN;
CLOSE(CLI);
CLOSE(CON);
END.
