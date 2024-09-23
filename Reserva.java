import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private Quarto quarto;
    private LocalDate dataReserva = LocalDate.now();
    private LocalDate dataSaida;
    private Pessoa cliente;
    private Funcionario funcionario;

    public Reserva(Quarto quarto, LocalDate dataSaida, Pessoa cliente, Funcionario funcionario) {
        this.quarto = quarto;
        this.dataSaida = dataSaida;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public void checkOut() {
        // Cálculo do custo total
        long diasEstadia = java.time.temporal.ChronoUnit.DAYS.between(dataReserva, dataSaida);
        double custoEstadia = quarto.getPreco() * diasEstadia;

        double custoTotal = custoEstadia + quarto.getCustoTotal();

        // Exibindo informações do checkout
        System.out.println("---- Checkout ----");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data de Reserva: " + dataReserva);
        System.out.println("Data de Saída: " + dataSaida);
        System.out.println("Quarto: " + quarto.getNumero() + " | Categoria: " + quarto.getCategoria());
        System.out.println("Custo da Estadia: " + custoEstadia);
        System.out.println("Itens e serviços consumidos:");
        for (String consumo : quarto.getHistoricoConsumo()) {
            System.out.println(" - " + consumo);
        }
        System.out.println("Custo Total: " + custoTotal);
        System.out.println("Funcionário responsável pelo checkout: " + funcionario.getNome());
    }


    public Reserva() {}

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
