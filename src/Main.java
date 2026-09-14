import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Abobora", "1", 15));
        produtos.add(new Produto("Batata", "2", 2.50));
        produtos.add(new Produto("Cenoura", "3", 3));

        ArrayList<Item> itens = new ArrayList<>();

        int menuOpcao = 0;
        while (menuOpcao != 5) {
            if (!itens.isEmpty()) {
                System.out.println("\nLista de itens:");

                for (Item item : itens)
                    System.out.printf("\t%s(%d) = R$%.2f\n", item.getProduto().getNome(), item.getQuantidade(), item.getValor());
            }

            do {
                System.out.print("""
                        Menu:
                            1 - Comprar
                            2 - Ver fatura
                            3 - Excluir item
                            4 - Alterar item
                            5 - Finalizar""");
                System.out.print("\n\t> ");
                menuOpcao = sc.nextInt();

                if (menuOpcao < 1 || menuOpcao > 5) System.out.println("\nOpção inválida!\n");
            } while (menuOpcao < 1 || menuOpcao > 5);

            if (menuOpcao == 1) {
                System.out.println("\n1 - Comprar:\n");

                boolean produtoExiste = false;
                do {
                    for (Produto produto : produtos) {
                        System.out.printf("""
                            %s:
                                Código = %s
                                Preço = R$%.2f
                            """,
                                produto.getNome(),
                                produto.getCodigo(),
                                produto.getPreco());
                    }

                    System.out.print("\nCódigo e quantidade(0 para cancelar): ");
                    String produtoCodigo = sc.next();
                    int produtoQuantidade = sc.nextInt();

                    if (produtoQuantidade <= 0) break;

                    for (Produto produto : produtos) {
                        if (produto.getCodigo().equals(produtoCodigo)) {
                            produtoExiste = true;

                            itens.add(new Item(produto, produtoQuantidade));

                            break;
                        }
                    }

                    if (!produtoExiste) System.out.println("\nCódigo de produto inválido!\n");
                } while (!produtoExiste);
            }
        }
    }
}
