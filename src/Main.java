import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Abobora", "1", 15));
        produtos.add(new Produto("Batata", "2", 2.50));
        produtos.add(new Produto("Cenoura", "3", 3));

        int opcao = 0;
        while (opcao != 5) {
            System.out.print("Menu:\n" +
                    "\t1 - Comprar\n" +
                    "\t2 - Ver fatura\n" +
                    "\t3 - Excluir item\n" +
                    "\t4 - Alterar item\n" +
                    "\t5 - Finalizar\n" +
                    "\t> ");
            opcao = sc.nextInt();

            if (opcao == 1) {
                for (Produto produto : produtos) {

                }
            }
        }
    }
}
