PROGRAM EX11;
USES CRT;
TYPE vendedor = RECORD
	codigo_vendedor: INTEGER;
	nome_vendedor: STRING[20];
	mes: INTEGER;
	valor_venda: REAL;
	END;
loja = FILE OF vendedor;
	VAR L: loja;
	V: vendedor;
BEGIN
CLRSCR;
ASSIGN(L, 'C:\VENDAS.DAT');
REWRITE(L);
CLOSE(L);
WRITELN('ARQUIVO DE VENDAS CRIADO COM SUCESSO');
READLN;
END.
