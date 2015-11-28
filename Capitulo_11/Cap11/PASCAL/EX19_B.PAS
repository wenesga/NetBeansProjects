PROGRAM EX19;
USES CRT;
TYPE cliente = RECORD
	numero : INTEGER;
	nome : STRING[20];
	ativo: INTEGER;
	END;
clientes = FILE OF cliente;
TYPE conta = RECORD
	numero_conta : INTEGER;
	numero_cli : INTEGER;
	saldo : REAL;
	ativo: INTEGER;
	END;
contas = FILE OF conta;
VAR 	cli: clientes;
	cl: cliente;
	com: contas;
	co: conta;
BEGIN
CLRSCR;
ASSIGN(CLI, 'C:\CLIENTES.DAT');
REWRITE(CLI);
CLOSE(CLI);
WRITELN('ARQUIVO DE CLIENTES CRIADO COM SUCESSO ');
ASSIGN(COM, 'C:\CONTAS.DAT');
REWRITE(COM);
CLOSE(COM);
WRITELN('ARQUIVO DE CONTAS CRIADO COM SUCESSO ');
READLN;
END.
