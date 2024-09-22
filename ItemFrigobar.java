public class ItemFrigobar {
    private String nome;
    private double preco = 0.00;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double calcularCusto(int quantidade) {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return "Item: " + nome + " | Preço: " + preco + " | Quantidade: " + quantidade;
    }
}
