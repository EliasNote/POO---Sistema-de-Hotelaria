public class ItemFrigobar {
    private String nome;
    private double preco;
    private int quantidade;

    public ItemFrigobar(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void consumirItem(int quantidadeConsumida) {
        if (quantidadeConsumida <= quantidade) {
            quantidade -= quantidadeConsumida;
        } else {
            System.out.println("Quantidade consumida maior do que disponível.");
        }
    }

    @Override
    public String toString() {
        return "Item: " + nome + " | Preço: " + preco + " | Quantidade: " + quantidade;
    }
}
