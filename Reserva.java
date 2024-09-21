import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private Quarto quarto;
    private LocalDate dataReserva = LocalDate.now();
    private LocalDate dataSaida;
    private Pessoa cliente;

    public Reserva(Quarto quarto, LocalDate dataSaida, Pessoa cliente) {
        this.quarto = quarto;
        this.dataSaida = dataSaida;
        this.cliente = cliente;
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
}
