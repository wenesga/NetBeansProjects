package orientacaoobjeto;
public class TestFuncionario {
    
    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Elizande");
        funcionario.setEndereco("Bem Bom");
        funcionario.setEndereco("Campos Belos");
        funcionario.setIdade(15);
        funcionario.setCargo("Professor");
        System.out.println(funcionario.informaDados());
    }
}
