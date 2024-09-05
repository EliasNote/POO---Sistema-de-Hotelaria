
import java.util.Arrays;
import java.util.List;

public class Quarto {
    private Integer numero;
    private String categoria;
    private Double preco;
    private List<Pessoa> hospede;
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

    public Quarto(Integer numero, String categoria) {
        this.numero = numero;
        this.categoria = categoria;
        definirPreco();
    }

    public Quarto() {}

    public List<String> getCategorias() {
        return categorias;
    }

    public List<Pessoa> getHospede() {
        return hospede;
    }

    public void setHospede(List<Pessoa> hospede) {
        this.hospede = hospede;
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
}
