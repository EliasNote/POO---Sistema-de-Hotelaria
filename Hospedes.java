import java.time.LocalDate;
import java.util.List;

public class Hospedes extends Cliente{

    // Um hospede ou Cliente pode locar um ou diversos Quartos
    private List<Quarto> quartoUsado;
    private Integer diasUsando;

    public Hospedes(String nome, String cpf, String telefone, LocalDate data_nascimento, List<Quarto> quartoUsado, Integer diasUsando) {
        super(nome, cpf, telefone, data_nascimento);
        this.quartoUsado = quartoUsado;
        this.diasUsando = diasUsando;
    }


    public List<Quarto> getQuartoUsado() {
        return quartoUsado;
    }

    public void setQuartoUsado(List<Quarto> quartoUsado) {
        this.quartoUsado = quartoUsado;
    }

    public Integer getDiasUsando() {
        return diasUsando;
    }

    public void setDiasUsando(Integer diasUsando) {
        this.diasUsando = diasUsando;
    }
}
