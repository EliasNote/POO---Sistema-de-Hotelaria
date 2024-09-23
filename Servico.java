public class Servico {
    private String tipo;
    private Double preco = 0.00;

    public Servico(String tipo, Double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Serviço: " + tipo + " | Preço: R$ " + preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
