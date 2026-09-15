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

    public boolean existeItem(String codigo) {
        for (Item item : this.getItens()) if (item.getProduto().getCodigo().equals(codigo)) return true;

        return false;
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
