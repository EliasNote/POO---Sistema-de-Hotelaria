public class Servico {
    private String tipo;

    public Servico(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Serviço: " + tipo;
    }
}
