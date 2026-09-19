import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valor;

    public Fatura(ArrayList<Item> itens) {
        this.setItens(itens);
        this.setValor(calcularValor());
    }

    public double calcularValor() {
        double valor = 0;

        for (Item item : this.getItens()) valor += item.getValor();

        return valor;
    }

    public boolean existeItem(String codigo) {
        for (Item item : this.getItens()) if (item.getProduto().getCodigo().equals(codigo)) return true;

        return false;
    }

    public void adicionarItem(Item item) {
        String itemCodigo = item.getProduto().getCodigo();

        if (existeItem(itemCodigo)) {
            for (Item faturaItem : this.getItens()) {
                if (faturaItem.getProduto().getCodigo().equals(itemCodigo)) {
                    faturaItem.realizarCompra(item.getQuantidade());

                    break;
                }
            }
        } else this.getItens().add(item);

        this.setValor(calcularValor());
    }

    public void removerItem(String codigo) {
        for (Item item : this.getItens()){
            if (item.getProduto().getCodigo().equals(codigo)) {
                this.getItens().remove(item);

                break;
            }
        }
    }

    public StringBuilder exibirItens() {
        StringBuilder itens = new StringBuilder();

        for (Item item : this.getItens()) {
            itens.append(item.getProduto().getNome()).append("\n")
                    .append("\tCódigo: ").append(item.getProduto().getCodigo()).append("\n")
                    .append("\tPreço: R$").append(item.getProduto().getPreco()).append("\n")
                    .append("\tQuantidade: ").append(item.getQuantidade()).append("\n")
                    .append("\tValor: R$").append(item.getValor());

            if (this.getItens().indexOf(item) < this.getItens().size() - 1) itens.append("\n");
        }

        return itens;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
