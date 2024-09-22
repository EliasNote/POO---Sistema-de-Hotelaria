import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private List<Quarto> quartos = Quarto.gerarQuartos(5);
    private List<Reserva> reservas = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Menu() {
        int escolha = -1;

        while (escolha != 0) {
            System.out.println("\n---- Acesso ----");
            System.out.println("1 - Acessar");
            System.out.println("2 - Cadastrar Funcionário");

            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número do cpf: ");
                    String cpf = sc.nextLine();

                    Funcionario funcionario = buscarFuncionario(cpf);

                    if (funcionario != null) {
                        menuHotel(funcionario);
                    } else {
                        System.out.println("Nenhum funcionário com esse CPF encontrado!");
                    }

                    break;

                case 2:
                    cadastroFuncionario();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public void menuHotel(Funcionario funcionario) {
        int escolha = -1;
        while (escolha != 0) {
            System.out.println("\n---- Menu ----");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Cadastrar Hóspedes");
            System.out.println("3 - Opções do Quarto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    cadastroReserva(funcionario);
                    break;

                case 2:
                    cadastroHospede();
                    break;

                case 3:
                    acessarQuarto();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public void cadastroReserva(Funcionario funcionario) {
        // CADASTRO RESERVA
        int numeroQuarto = 0;
        while (numeroQuarto == 0 || Quarto.estaReservado(reservas, numeroQuarto)) {
            System.out.println("---- Quartos Disponíveis ----");
            Quarto.listarQuartosDisponiveis(quartos, reservas);

            System.out.print("Escolha: ");
            numeroQuarto = sc.nextInt();
            sc.nextLine();

            if (numeroQuarto <= 0 || numeroQuarto > quartos.size()) {
                System.out.println("\nNúmero do quarto inválido. Por favor, escolha um quarto entre 1 e " + quartos.size() + ".\n");
            } else if (Quarto.estaReservado(reservas, numeroQuarto)) {
                System.out.println("\nQuarto já reservado\n");
            }
        }

        Pessoa cliente =  Pessoa.cadastrarCliente();

        System.out.print("Data da provável saída (formato AAAA-MM-DD): ");
        LocalDate dataSaida = LocalDate.parse(sc.nextLine());

        reservas.add(new Reserva(quartos.get(numeroQuarto-1), dataSaida, cliente, funcionario));
    }

    public void cadastroHospede() {
        // CADASTRO HÓSPEDE
        System.out.println("---- Cadastro de Hóspedes ----");
        Pessoa hospede = Pessoa.cadastrarCliente();

        int numeroQuartoHospede = 0;
        while (!Quarto.estaReservado(reservas, numeroQuartoHospede)) {
            System.out.print("Número do quarto: ");
            numeroQuartoHospede = sc.nextInt();
            sc.nextLine();
        }

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuartoHospede) {
                quarto.getHospedes().add(hospede);
                break;
            }
        }

        int escolha = 0;
        while (escolha != 1 && escolha != 2) {
            System.out.print("Deseja cadastrar mais hóspedes?\n" +
                    "1 - Sim\n" +
                    "2 - Não\n" +
                    "Escolha: ");
            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha != 1 && escolha != 2) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        if (escolha == 1) {
            cadastroHospede();
        }
    }

    public void acessarQuarto() {






    }

    public void cadastroFuncionario() {
        // CADASTRO FUNCIONÁRIO
        System.out.println("\n---- Cadastro de Funcionário ----");
        funcionarios.add(Funcionario.cadastrarFuncionario());

        int escolha = 0;
        while (escolha != 1 && escolha != 2) {
            System.out.print("\nDeseja cadastrar mais funcionarios?\n" +
                    "1 - Sim\n" +
                    "2 - Não\n" +
                    "Escolha: ");
            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha != 1 && escolha != 2) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        if (escolha == 1) {
            cadastroFuncionario();
        }
    }

    public Funcionario buscarFuncionario(String cpf) {
        Funcionario funcionario = null;

        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                funcionario = f;
            }
        }
        return funcionario;
    }
}
