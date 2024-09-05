import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private Quarto quarto;
    private LocalDate dataReserva;
    private LocalDate dataSaida;
    private Pessoa cliente;

    public Reserva(Quarto quarto, LocalDate dataReserva, LocalDate dataSaida, Pessoa cliente) {
        this.quarto = quarto;
        this.dataReserva = dataReserva;
        this.dataSaida = dataSaida;
        this.cliente = cliente;
    }

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

    public void setPessoa(Pessoa cliente) {
        this.cliente = cliente;
    }
}
