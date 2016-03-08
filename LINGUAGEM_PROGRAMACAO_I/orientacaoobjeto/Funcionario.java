package orientacaoobjeto;

public class Funcionario extends Pessoa{
    private double salario;
    private String cargo;
    private String funcionario;

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String informaDados(){
        String inf = String.format("%s reside em %s e tem %d anos com cargo %s", getNome(), getEndereco(), getIdade(), cargo, salario);
        return inf;
    }
}
