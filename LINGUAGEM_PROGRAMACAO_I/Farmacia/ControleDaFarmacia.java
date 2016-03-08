package Farmacia;
import javax.swing.JOptionPane;
public class ControleDaFarmacia {
    public static void main(String[] args) { 
        Produto produto[] = new Produto[15];
        int opcao, contador = 0;
        
        do { opcao = menu();
            switch (opcao) {
                case 1: 
                    if (contador == produto.length)
                    JOptionPane.showMessageDialog(null, "Vetor completamente preenchido");
                    else contador = cadastrarProduto(produto, contador); break;

                case 2: 
                    if (contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
                    else mostrarMaisCaro(produto, contador); break;

                case 3: 
                    if (contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
                    else mostrarProdutosEmEstoque(produto, contador); break; 

                case 4: if (contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
                    else alterarDadosDeUmProduto(produto, contador);
                } 
        } while (opcao != 5);
    }
    
    public static int menu(){ 
        int opcao;
        String mensagem;
        mensagem  = "1- Cadastrar produto\n";
        mensagem += "2- Mostrar detalhes do produto mais caro\n";
        mensagem += "3- Mostrar produtos em estoque\n";
        mensagem += "4- Alterar dados de um produto\n";
        mensagem += "5- Finalizar programa";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
        return opcao;
    }
    
    public static int cadastrarProduto(Produto p[], int c){ 
        int tipo;
        do { 
            tipo = Integer.parseInt(JOptionPane.showInputDialog("1- para cadastrar Remedio "
            + "ou 2- para cadastrar produto de Higiene"));
        } while (tipo != 1 && tipo != 2);
        
        
        
        if (tipo == 1){ 
            Remedio auxiliar = new Remedio();
            auxiliar.setCodigo(c+1);
            auxiliar.setDescricao(JOptionPane.showInputDialog("Digite descricao do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco de "
                    + "compra do produto")));
            auxiliar.definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Preco de Venda = " + auxiliar.gerarPrecoDeVenda());
            p[c] = auxiliar;
        } else { 
            Higiene auxiliar = new Higiene();
            auxiliar.setCodigo(c+1);
            auxiliar.setDescricao(JOptionPane.showInputDialog("Digite descricao do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco de "
                    + "compra do produto")));
            auxiliar.setPercentualDeLucro(30);
            JOptionPane.showMessageDialog(null, "Preco de Venda = " + auxiliar.gerarPrecoDeVenda());
            p[c] = auxiliar;
        }
        c++;
        return c;
    }
    
    public static void alterarDadosDeUmProduto(Produto p[], int c) { 
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto "
                + "a ter seus dados alterados"));
        if (codigo < 1 || codigo-1 >= c)
            JOptionPane.showMessageDialog(null, "Produto inexistente!");
        else {
            p[codigo-1].setDescricao(JOptionPane.showInputDialog("Digite nova descricao"));
            int codigo1 = 0;
            p[codigo1].setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog ("Digite "
                    + "novo preco de compra")));
            p[codigo-1].definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Novo lucro = " + p[codigo-1].gerarPrecoDeVenda());
        }
    }

    public static void mostrarProdutosEmEstoque(Produto p[], int c) {
        int cont;
        String msg = "";
        for (cont = 0; cont < c; cont++) { 
            msg = msg + "\nCodigo: " + p[cont].getCodigo();
            msg = msg + "\nDescricao: " + p[cont].getDescricao();
            msg = msg + "\nPreco de compra: " + p[cont].getPrecoDeCompra();
            msg += "\n% lucro: " + p[cont].getPercentualDeLucro();
            msg += "\nPreco de venda: " + p[cont].gerarPrecoDeVenda();
            JOptionPane.showMessageDialog(null, msg);
            msg = "";
        }
    }

    public static void mostrarMaisCaro(Produto p[], int c) { 
        float maiorPreco;
        int indiceDoMaior, cont;
        String msg = "";
        maiorPreco = p[0].getPrecoDeCompra();
        indiceDoMaior = 0;
        
        for (cont = 1; cont < c; cont++) { 
            if (p[cont].getPrecoDeCompra() > maiorPreco) { 
                maiorPreco = p[cont].getPrecoDeCompra();
                indiceDoMaior = cont;
            }
        }

        msg += "Codigo: " + p[indiceDoMaior].getCodigo();
        msg += "\nDescricao: " + p[indiceDoMaior].getDescricao();
        msg += "\nPreco de compra: " + p[indiceDoMaior].getPrecoDeCompra();
        msg += "\n% lucro: " + p[indiceDoMaior].getPercentualDeLucro();
        msg += "\nPreco de venda: " + p[indiceDoMaior].gerarPrecoDeVenda();
        JOptionPane.showMessageDialog(null, msg);
    }
}