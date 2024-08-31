import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Quarto {
    private Integer numero;
    private String categoria;
    private Double preco;
    private Cliente cliente;
    private LocalDate data_reserva = LocalDate.now();
    private LocalDate data_desocupado;
    private List<Cliente> hospedes;
    private List<String> categorias = Arrays.asList("simples", "duplo", "casal", "luxo");

    public void definirPreco() {
        if (categoria == "simples") {
            preco = 150.00;
        }
        if (categoria == "duplo") {
            preco = 190.00;
        }
        if (categoria == "casal") {
            preco = 230.00;
        }
        if (categoria == "luxo") {
            preco = 450.00;
        }
    }

    public Quarto(Integer numero, String categoria, Cliente cliente) {
        this.numero = numero;
        this.categoria = categoria;
        this.cliente = cliente;
        definirPreco();
    }

    public Quarto() {}

    public List<Cliente> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Cliente> hospedes) {
        this.hospedes = hospedes;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(LocalDate data_reserva) {
        this.data_reserva = data_reserva;
    }

    public LocalDate getData_desocupado() {
        return data_desocupado;
    }

    public void setData_desocupado(LocalDate data_desocupado) {
        this.data_desocupado = data_desocupado;
    }
}
