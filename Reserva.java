import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private Quarto quarto;
    private LocalDate dataReserva;
    private Date dataEntrada;
    private Date dataSaida;
    private Cliente cliente;

    public Reserva(Quarto quarto, Date dataEntrada, Date dataSaida, Cliente cliente) {
        this.quarto = quarto;
        this.dataReserva = LocalDate.now();
        this.dataEntrada = dataEntrada;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
