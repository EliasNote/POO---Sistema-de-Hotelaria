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
    private List<ItemQuarto> itensQuarto;
    private List<Servico> servicos;
    private Double custoTotal = 0.00;
    private List<String> historicoConsumo = new ArrayList<>();


    private static Integer contadorNumeroQuarto = 1;

    public Quarto(String categoria) {
        this.numero = contadorNumeroQuarto;
        contadorNumeroQuarto++;
        this.categoria = categoria;
        this.hospedes = new ArrayList<>();
        this.frigobar = new ArrayList<>();
        this.servicos = new ArrayList<>();
        definirPreco();
        inicializarFrigobar();
        inicializarItensQuarto();
        inicializarServicos();
    }

    public Quarto() {}

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

    public void registrarConsumo(String item, Double valor) {
        this.custoTotal += valor;
        historicoConsumo.add(item + ": " + valor);
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public List<String> getHistoricoConsumo() {
        return historicoConsumo;
    }

    private void inicializarFrigobar() {
        frigobar.add(new ItemFrigobar("Água", 5.00, 10));
        frigobar.add(new ItemFrigobar("Refrigerante", 7.00, 5));
        frigobar.add(new ItemFrigobar("Cerveja", 10.00, 8));

        if (categoria.equals("duplo") || categoria.equals("casal") || categoria.equals("luxo")) {
            frigobar.add(new ItemFrigobar("Suco", 8.00, 5));
            frigobar.add(new ItemFrigobar("Chocolate", 15.00, 10));
            frigobar.add(new ItemFrigobar("Amendoim", 12.00, 7));
        }
        if (categoria.equals("casal") || categoria.equals("luxo")) {
            frigobar.add(new ItemFrigobar("Vinho", 50.00, 2));
            frigobar.add(new ItemFrigobar("Biscoito", 10.00, 5));
        }
        if (categoria.equals("luxo")) {
            frigobar.add(new ItemFrigobar("Champanhe", 100.00, 1));
            frigobar.add(new ItemFrigobar("Whisky", 200.00, 1));
        }
    }

    private void inicializarItensQuarto() {
        itensQuarto = new ArrayList<>();

        itensQuarto.add(new ItemQuarto("Cama", "Cama confortável de casal"));
        itensQuarto.add(new ItemQuarto("TV", "Televisão de 42 polegadas"));
        itensQuarto.add(new ItemQuarto("Ar Condicionado", "Ar condicionado split"));

        if (categoria.equals("duplo") || categoria.equals("casal") || categoria.equals("luxo")) {
            itensQuarto.add(new ItemQuarto("Mesa", "Mesa de trabalho com cadeira"));
            itensQuarto.add(new ItemQuarto("Guarda-roupa", "Guarda-roupa espaçoso"));
        }
        if (categoria.equals("casal") || categoria.equals("luxo")) {
            itensQuarto.add(new ItemQuarto("Sofá", "Sofá confortável"));
            itensQuarto.add(new ItemQuarto("Frigobar", "Frigobar com bebidas e snacks"));
        }
        if (categoria.equals("luxo")) {
            itensQuarto.add(new ItemQuarto("Banheira", "Banheira de hidromassagem"));
            itensQuarto.add(new ItemQuarto("Cofre", "Cofre eletrônico"));
        }
    }

    private void inicializarServicos() {
        servicos = new ArrayList<>();

        servicos.add(new Servico("Passar Roupa", 20.00));
        servicos.add(new Servico("Lavanderia", 30.00));

        if (categoria.equals("duplo") || categoria.equals("casal") || categoria.equals("luxo")) {
            servicos.add(new Servico("Serviço de Quarto", 50.00));
        }
        if (categoria.equals("casal") || categoria.equals("luxo")) {
            servicos.add(new Servico("Massagem", 100.00));
        }
        if (categoria.equals("luxo")) {
            servicos.add(new Servico("Spa", 200.00));
            servicos.add(new Servico("Transporte Privado", 150.00));
        }
    }

    public void consumirFrigobar(String nomeItem, int quantidade) {
        for (ItemFrigobar item : frigobar) {
            if (item.getNome().equals(nomeItem)) {
                if (quantidade <= item.getQuantidade()) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    registrarConsumo(item.getNome(), item.getPreco() * quantidade);

                    System.out.println("Item consumido: " + nomeItem + " | Quantidade: " + quantidade);
                } else {
                    System.out.println("Quantidade consumida maior do que disponível.");
                }
                return;
            }
        }
        System.out.println("Item não encontrado no frigobar.");
    }

    public void solicitarServico(String tipo) {
        for (Servico servico : servicos) {
            if (servico.getTipo().equals(tipo)) {

                registrarConsumo(servico.getTipo(), servico.getPreco());

                System.out.println("Serviço: " + servico.getTipo() + " | Preço: " + servico.getPreco());
                return;
            }
        }
        System.out.println("Serviço não existente.");
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
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero().equals(numeroQuarto)) {
                return true;
            }
        }
        return false;
    }

    public static Quarto buscarQuarto(List<Reserva> reservas, int numero) {
        Quarto quarto = null;

        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero().equals(numero)) {
                quarto = reserva.getQuarto();
            }
        }

        return quarto;
    }

    public void listarItensQuarto() {
        itensQuarto.forEach(item -> System.out.println("Item: " + item.getNome() + " | Descrição: " + item.getDescricao()));
    }

    public void listarItensFrigobar() {
        frigobar.forEach(item -> {
            if (item.getQuantidade() != 0) {
                System.out.println("Item: " + item.getNome() + " | Preço: " + item.getPreco() + " | Quantidade: " + item.getQuantidade());
            }
        });
    }

    public void listarHospedes() {
        hospedes.forEach(hospede -> System.out.println(hospede));
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
