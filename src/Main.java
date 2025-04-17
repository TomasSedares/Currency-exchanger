import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scan;

    public static void main(String[] args) throws IOException, InterruptedException {
        scan = new Scanner(System.in);

        int respuesta;
        int monto;

        Menues menues = new Menues();
        CambiadorDivisas currencyExchanger = new CambiadorDivisas();

        while (true) {
            System.out.println(menues.menuInicial());
            respuesta = scan.nextInt();

            if (respuesta < 1 || respuesta > 7) {
                System.out.println("Saliendo...");
                break;
            }

            switch (respuesta) {
                case 1:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("USD", "ARS");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 2:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("ARS", "USD");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 3:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("USD", "BRL");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 4:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("BRL", "USD");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 5:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("USD", "COP");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 6:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();
                    currencyExchanger.cambiarDivisas("COP", "USD");
                    currencyExchanger.calcularDivisas(monto);
                    System.out.println(currencyExchanger);
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor :)");
                    return;
            }
        }
    }
}