import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private List<Quarto> quartos = Quarto.gerarQuartos(5);
    private List<Reserva> reservas = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Funcionario funcionarioAcesso = null;

    public Menu() {
        int escolha = -1;

        while (escolha != 0) {
            System.out.println("\n---- Acesso ----");
            System.out.println("1 - Acessar");
            System.out.println("2 - Cadastrar Funcionário");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número do cpf: ");
                    String cpf = sc.nextLine();

                    funcionarioAcesso = Funcionario.buscarFuncionario(funcionarios, cpf);

                    if (funcionarioAcesso != null) {
                        menuHotel();
                    } else {
                        System.out.println("Nenhum funcionário com esse CPF encontrado!");
                    }

                    break;

                case 2:
                    cadastroFuncionario();
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

    public void menuHotel() {
        int escolha = -1;
        while (escolha != 0) {
            System.out.println("\n---- Menu ----");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Cadastrar Hóspedes");
            System.out.println("3 - Opções do Quarto");
            System.out.println("4 - Encerrar Hospedagem");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    cadastroReserva();
                    break;

                case 2:
                    cadastroHospede();
                    break;

                case 3:
                    acessarQuarto();
                    break;

                case 4:
                    encerrarHospedagem();
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

    public void encerrarHospedagem() {
        System.out.print("Digite o número do quarto para checkout: ");
        int numeroQuarto = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getQuarto().getNumero() == numeroQuarto) {
                reservas.get(i).checkOut();
                reservas.remove(i);
                System.out.println("Hospedagem encerrada com sucesso!");
                return;
            }
        }
        System.out.println("Quarto não encontrado ou não reservado.");
    }

    public void acessarQuarto() {
        Quarto quarto = null;

        while (quarto == null) {
            System.out.print("Digite o número do quarto: ");
            int numeroQuarto = sc.nextInt();
            sc.nextLine();

            quarto = Quarto.buscarQuarto(reservas, numeroQuarto);

            if (quarto == null) {
                System.out.println("Quarto não reservado!");
                menuHotel();
            }
        }

        int escolha = -1;
        while (escolha != 0) {


            System.out.println("\n---- Quarto ----");
            System.out.println("1 - Listar itens do quarto");
            System.out.println("2 - Listar itens frigobar");
            System.out.println("3 - Listar cliente e hóspedes");
            System.out.println("4 - Listar Serviços");
            System.out.println("5 - Registrar consumo do frigobar");
            System.out.println("6 - Registrar serviço solicitado");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    quarto.listarItensQuarto();
                    break;

                case 2:
                    quarto.listarItensFrigobar();
                    break;

                case 3:
                    quarto.listarHospedes();
                    break;

                case 4:
                    quarto.listarServicos();
                    break;

                case 5:
                    System.out.print("Digite o nome do item que deseja consumir: ");
                    String item = sc.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    quarto.consumirFrigobar(item, quantidade);
                    break;

                case 6:
                    System.out.print("Digite o serviço que deseja solicitar: ");
                    String servico = sc.nextLine();

                    quarto.solicitarServico(servico);
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

    public void cadastroReserva() {
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

        reservas.add(new Reserva(quartos.get(numeroQuarto-1), dataSaida, cliente, funcionarioAcesso));
    }

    public void cadastroHospede() {
        System.out.println("---- Cadastro de Hóspedes ----");
        Pessoa hospede = Pessoa.cadastrarCliente();

        System.out.print("Número do quarto: ");
        int numeroQuartoHospede = sc.nextInt();
        sc.nextLine();

        if (Quarto.estaReservado(reservas, numeroQuartoHospede)) {
            for (Quarto quarto : quartos) {
                if (quarto.getNumero() == numeroQuartoHospede) {
                    quarto.getHospedes().add(hospede);
                    break;
                }
            }
        } else {
            System.out.println("\nQuarto não reservado!");

        }

        menuHotel();

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

    public void cadastroFuncionario() {
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
}
