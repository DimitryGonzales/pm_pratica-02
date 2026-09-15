import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Abobora", "1", 15));
        produtos.add(new Produto("Batata", "2", 2.50));
        produtos.add(new Produto("Cenoura", "3", 3));

        Fatura fatura = new Fatura(new ArrayList<Item>());

        int menuOpcao = 0;
        boolean menuRepetindo = false;
        while (menuOpcao != 5) {
            do {
                if (!menuRepetindo) System.out.println("Menu:");
                else System.out.println("\nMenu:");

                System.out.println("\t1 - Comprar\n" +
                        "\t2 - Ver fatura\n" +
                        "\t3 - Excluir item\n" +
                        "\t4 - Alterar item\n" +
                        "\t5 - Finalizar");
                System.out.print("\t> ");
                menuOpcao = sc.nextInt();

                if (menuOpcao < 1 || menuOpcao > 5) System.out.println("\nOpção inválida!\n");
            } while (menuOpcao < 1 || menuOpcao > 5);

            menuRepetindo = true;

            if (menuOpcao == 1) {
                System.out.println("\n1 - Comprar:\n");

                boolean produtoExiste = false;
                do {
                    for (Produto produto : produtos) {
                        System.out.printf("%s:\n\tCódigo = %s\n\tPreço = R$%.2f\n",
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

                            fatura.adicionarItem(new Item(produto, produtoQuantidade));

                            break;
                        }
                    }

                    if (!produtoExiste) System.out.println("\nCódigo de produto inválido!\n");
                } while (!produtoExiste);
            }

            if (menuOpcao == 2) {
                System.out.println("\n2 - Ver fatura:\n");

                if (!fatura.getItens().isEmpty()) {
                    System.out.printf("%s\n", fatura.exibirItens());

                    System.out.printf("\n\tValor final: R$%.2f\n", fatura.getValor());
                } else System.out.println("A fatura está vazia");
            }

            if (menuOpcao == 3) {
                System.out.println("\n3 - Excluir item:\n");

                if (!fatura.getItens().isEmpty()) {
                    String itemCodigo;

                    do {
                        System.out.printf("%s\n", fatura.exibirItens());

                        System.out.print("\nCódigo(0 para cancelar): ");
                        itemCodigo = sc.next();

                        if (itemCodigo.equals("0")) break;

                        if (!fatura.existeItem(itemCodigo)) System.out.println("\nCódigo de item inválido!\n");
                    } while (!fatura.existeItem(itemCodigo));

                    if (!itemCodigo.equals("0")) {
                        for (int i = 0; i < fatura.getItens().size(); i++) {
                            if (fatura.getItens().get(i).getProduto().getCodigo().equals(itemCodigo)) {
                                fatura.removerItem(itemCodigo);
                            }
                        }
                    }

                } else System.out.println("A fatura está vazia");
            }
        }
    }
}
