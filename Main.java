import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Quarto quartoMenu = new Quarto();
            System.out.println("------------ MENU ------------");
            // EXIBE OS QUARTOS DISPONÍVEIS

            Cliente cliente = new Cliente("Elias", "123121231", "971293123", LocalDate.of(2003, 05, 23));

            quartoMenu.getCategorias().forEach(x -> System.out.println(x));
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            if (escolha >= 1 && escolha <= 5) {
                Quarto quarto = new Quarto(1, "simples");
                // DEFINE O QUARTO DE ACORDO COM A ESCOLHA
            }


        }
}