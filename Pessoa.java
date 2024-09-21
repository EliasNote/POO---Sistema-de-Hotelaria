import java.time.LocalDate;
import java.util.Scanner;


public class Pessoa {
   private String nome;
   private String cpf;
   private String telefone;
   private LocalDate data_nascimento;


   public Pessoa(String nome, String cpf, String telefone, LocalDate data_nascimento) {
       this.nome = nome;
       this.cpf = cpf;
       this.telefone = telefone;
       this.data_nascimento = data_nascimento;
   }


   public Pessoa(){}


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


   public String getTelefone() {
       return telefone;
   }


   public void setTelefone(String telefone) {
       this.telefone = telefone;
   }


   public LocalDate getData_nascimento() {
       return data_nascimento;
   }


   public void setData_nascimento(LocalDate data_nascimento) {
       this.data_nascimento = data_nascimento;
   }


   public static Pessoa cadastrarCliente(){
       Scanner sc = new Scanner(System.in);
       Pessoa pessoa = new Pessoa();

       System.out.print("Digite o seu nome: ");
       pessoa.nome = sc.nextLine();

       System.out.print("Digite o seu CPF: ");
       pessoa.cpf = sc.nextLine();

       System.out.print("Digite o seu telefone: ");
       pessoa.telefone = sc.nextLine();

       System.out.print("Digite a sua data de nascimento (formato AAAA-MM-DD): ");
       pessoa.data_nascimento = LocalDate.parse(sc.nextLine());

       return pessoa;
   }




   public String toString() {
       return "Pessoa{" +
               "nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", telefone='" + telefone + '\'' +
               ", data_nascimento=" + data_nascimento +
               '}';
   }
}
