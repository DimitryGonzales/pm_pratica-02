public class Item {
    private Produto produto;
    private int quantidade;
    private double valor;

    public Item(Produto produto, int quantidade) {
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        this.setValor(calcularValor());
    }

    public double calcularValor() {
        return this.getProduto().getPreco() * this.getQuantidade();
    }

    public void alterarQuantidade(int quantidade) {
        this.setQuantidade(quantidade);

        this.setValor(calcularValor());
    }

    public void realizarCompra(int quantidade) {
        this.alterarQuantidade(this.getQuantidade() + quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
