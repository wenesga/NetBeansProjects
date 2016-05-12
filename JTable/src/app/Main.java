package app;

import dao.Conexao;
import form.AlunoForm;

public class Main {
    public static void main(String[] args) {
        Conexao.createTable();
        new AlunoForm();
    }
}
