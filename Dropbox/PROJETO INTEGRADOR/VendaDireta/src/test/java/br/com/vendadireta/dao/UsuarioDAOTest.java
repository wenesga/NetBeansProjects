package br.com.vendadireta.dao;

import br.com.vendadireta.entidade.Usuario;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @Cometario:
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 09/04/2016 - Classe: UsuarioDAOTest
 */
public class UsuarioDAOTest {

    @Test
    @Ignore
    public void salvar() {

        Usuario usuario = new Usuario();
        usuario.setNome("Joattann Gomes Aquino");
        usuario.setCpf("11111111111");
        usuario.setSenha("123");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usuario);

        System.out.println();
        System.out.println("Usuario salvo com sucesso!");

        System.out.println();
        System.out.println(usuario.getNome());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getSenha());
        System.out.println();
    }

    @Test
    @Ignore
    public void listar() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> resultado = usuarioDAO.listar();

        for (Usuario usuario : resultado) {
            System.out.println("CÓDIGO: " + usuario.getCodigo());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SENHA" + usuario.getSenha());
        }
    }

    @Test
    @Ignore
    public void buscar() {
        Integer codigoUsuario = 1;

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscar(codigoUsuario);

        if (usuario == null) {
            System.out.println("\nNenhum registro encontrado!\n");
        } else {
            System.out.println("CÓDIGO: " + usuario.getCodigo());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SENHA" + usuario.getSenha());
        }
    }

    @Test
    @Ignore
    public void excluir() {
        Integer codigoUsuario = 2;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscar(codigoUsuario);

        if (usuario == null) {
            System.out.println("\nNenhum registro encontrado!\n");

        } else {

            usuarioDAO.excluir(usuario);

            System.out.println("\nRegistro removido:");

            System.out.println("CÓDIGO: " + usuario.getCodigo());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SENHA" + usuario.getSenha());
        }
    }

    @Test
    @Ignore
    public void editar() {
        Integer codigo = 4;

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscar(codigo);

        if (usuario == null) {
            System.out.println("\nNenhum registro encontrado!\n");
        } else {
            System.out.println("\nRegistro editado - Antes:");

            System.out.println("CÓDIGO: " + usuario.getCodigo());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SENHA: " + usuario.getSenha());

            usuario.setNome("Uziel Gomes Aquino");
            usuario.setCpf("333333333");
            usuario.setSenha("142536");

            usuarioDAO.editar(usuario);

            System.out.println();
            System.out.println("CÓDIGO: " + usuario.getCodigo());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("SENHA: " + usuario.getSenha());
        }
    }
}
