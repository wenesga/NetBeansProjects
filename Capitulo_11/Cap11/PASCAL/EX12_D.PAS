PROGRAM EX12;
USES CRT;
TYPE vendedor = RECORD
	codigo_vendedor: INTEGER;
	nome_vendedor: STRING[20];
	mes: INTEGER;
	valor_venda: REAL;
	ativo: INTEGER;
END;
loja = FILE OF vendedor;
VAR L: loja;
    V: vendedor;
    CODIGO_VENDEDOR, MES: INTEGER;
    NOME_VENDEDOR: STRING[20];
    VALOR_VENDA: REAL;
    K, I, P, POSICAO: INTEGER;
    ACHOU : BOOLEAN;
BEGIN
CLRSCR;
ASSIGN(L, 'C:\VENDAS.DAT');
{$I-}
RESET(L);
{$I+}
IF IORESULT = 2
   THEN REWRITE(L);
K := FILESIZE(L);
WRITE('DIGITE O C‡DIGO DO VENDEDOR A SER INCLU÷DO ');
READLN(CODIGO_VENDEDOR);
WRITE('DIGITE  O M“S A SER INCLU÷DO ');
READLN(MES);
IF K = 0
THEN BEGIN
        WRITE('DIGITE O NOME DO VENDEDOR A SER INCLU÷DO ');
        READLN(NOME_VENDEDOR);
        WRITE('DIGITE O VALOR DA VENDA A SER INCLU÷DA ');
        READLN(VALOR_VENDA);
        V.CODIGO_VENDEDOR := CODIGO_VENDEDOR;
	V.MES := MES;
	V.NOME_VENDEDOR := NOME_VENDEDOR;
	V.VALOR_VENDA:= VALOR_VENDA;
	V.ATIVO:=1;
	WRITE(L, V);
	WRITELN('VENDEDOR INCLU÷DO');
	END
ELSE BEGIN
	I := 0;
	ACHOU := FALSE;
        POSICAO := 0;
	RESET(L);
	WHILE ( I <= (K-1)) DO
		BEGIN
		READ(L, V);
		IF (V.CODIGO_VENDEDOR = CODIGO_VENDEDOR) AND (V.MES  = MES) AND (V.ATIVO = 1)
		THEN BEGIN
			ACHOU := TRUE;
			I := K + 2;
		     END
		ELSE BEGIN
			IF CODIGO_VENDEDOR < V.CODIGO_VENDEDOR
			THEN BEGIN
                             POSICAO := FILEPOS(L) - 1;
			     I := K + 2;
                             END
			ELSE BEGIN
                             I := I+1;
			     SEEK(L, I);
			     END;
		     END;
		END;
		IF ACHOU = TRUE
		THEN WRITELN(' ESTE VENDEDOR Jµ ESTµ CADASTRADO ')
		ELSE BEGIN
			IF I = FILESIZE(L)
			THEN BEGIN
				SEEK(L, FILESIZE(L));
                                WRITE('DIGITE O NOME DO VENDEDOR A SER INCLU÷DO ');
                                READLN(NOME_VENDEDOR);
                                WRITE('DIGITE O VALOR DA VENDA A SER INCLU÷DA ');
                                READLN(VALOR_VENDA);
                                V.CODIGO_VENDEDOR := CODIGO_VENDEDOR;
	                        V.MES := MES;
                                V.NOME_VENDEDOR := NOME_VENDEDOR;
				V.VALOR_VENDA:= VALOR_VENDA;
                                V.ATIVO:=1;
                                WRITE(L, V);
                                WRITELN('VENDEDOR INCLU÷DO');
				END
			ELSE BEGIN
               			P := FILESIZE(L) - 1;
				WHILE P >= POSICAO DO
				BEGIN
				SEEK(L,P);
			        READ(L,V);
                                WRITE(L,V);
				P := P - 1 ;
				END;
				SEEK(L, POSICAO);
                                WRITE('DIGITE O NOME DO VENDEDOR A SER INCLU÷DO ');
                                READLN(NOME_VENDEDOR);
                                WRITE('DIGITE O VALOR DA VENDA A SER INCLU÷DA ');
                                READLN(VALOR_VENDA);
                                V.CODIGO_VENDEDOR := CODIGO_VENDEDOR;
                                V.MES := MES;
                                V.NOME_VENDEDOR := NOME_VENDEDOR;
                                V.VALOR_VENDA:= VALOR_VENDA;
                                V.ATIVO:=1;
                                WRITE(L, V);
                                WRITELN('VENDEDOR INCLU÷DO');
				END;
		END;
	END;
READLN;
CLOSE(L);
END.
