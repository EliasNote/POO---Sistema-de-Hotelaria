import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quarto {
    private Integer numero;
    private String categoria;
    private Double preco;
    private List<Pessoa> hospedes;
    private List<String> categorias = Arrays.asList("simples", "duplo", "casal", "luxo");
    private List<ItemFrigobar> frigobar;
    private List<Servico> servicos;


    private static Integer contadorNumeroQuarto = 1;

    // Construtor que inicializa o número e a categoria do quarto
    public Quarto(String categoria) {
        this.numero = contadorNumeroQuarto;
        contadorNumeroQuarto++;
        this.categoria = categoria;
        this.hospedes = new ArrayList<>();
        this.frigobar = new ArrayList<>();
        this.servicos = new ArrayList<>();
        definirPreco();
        inicializarFrigobar();
    }

    public Quarto() {}

    // Define o preço do quarto de acordo com a categoria
    public void definirPreco() {
        if (categoria.equals("simples")){
            preco = 150.00;
        }
        if (categoria.equals("duplo")) {
            preco = 190.00;
        }
        if (categoria.equals("casal")) {
            preco = 230.00;
        }
        if (categoria.equals("luxo")) {
            preco = 450.00;
        }
    }

    // Inicia o frigobar com itens
    private void inicializarFrigobar() {
        frigobar.add(new ItemFrigobar("Água", 5.00, 10));
        frigobar.add(new ItemFrigobar("Refrigerante", 7.00, 5));
        frigobar.add(new ItemFrigobar("Cerveja", 10.00, 8));
    }

    // Consumir um item do frigobar
    public void consumirFrigobar(String nomeItem, int quantidade) {
        for (ItemFrigobar item : frigobar) {
            if (item.getNome().equals(nomeItem)) {
                item.consumirItem(quantidade);
                System.out.println("Item consumido: " + nomeItem + " | Quantidade: " + quantidade);
                return;
            }
        }
        System.out.println("Item não encontrado no frigobar.");
    }

    public void solicitarServico(String tipo) {
        Servico servico = new Servico(tipo);
        servicos.add(servico);
        System.out.println("Serviço solicitado: " + tipo);
    }

    public void listarFrigobar() {
        for (ItemFrigobar item : frigobar) {
            System.out.println(item);
        }
    }

    public void listarServicos() {
        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }

    public static List<Quarto> gerarQuartos(int quantidade) {
        List<Quarto> quartos = new ArrayList<>();
        List<String> categorias = List.of("simples", "duplo", "casal", "luxo");

        for (String categoria : categorias) {
            for (int i = 1; i <= quantidade; i++) {
                Quarto quarto = new Quarto(categoria);
                quartos.add(quarto);
            }
        }
        return quartos;
    }

    public static void listarQuartosDisponiveis(List<Quarto> quartos, List<Reserva> reservas) {
        quartos.forEach(quarto -> {
            if (!quarto.estaReservado(reservas, quarto.getNumero())) {
                System.out.println("Número: " + quarto.getNumero() + " | Categoria: " + quarto.getCategoria() + " | Preço: " + quarto.getPreco());
            }
        });
    }

    public static boolean estaReservado(List<Reserva> reservas, int numeroQuarto) {
        boolean verificar = false;
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero().equals(numeroQuarto)) {
                verificar = true;
            }
        }
        return verificar;
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

    public List<Pessoa> getHospedes() {
        return hospedes;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
}
