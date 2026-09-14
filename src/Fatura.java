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
