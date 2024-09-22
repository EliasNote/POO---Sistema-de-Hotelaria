import java.util.List;
import java.util.Scanner;

public class Funcionario {

    private String nome;
    private String cpf;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Funcionario() {}

    public static Funcionario cadastrarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o seu CPF: ");
        String cpf = sc.nextLine();

        return new Funcionario(nome, cpf);
    }

    public static Funcionario buscarFuncionario(List<Funcionario> funcionarios, String cpf) {
        return funcionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
