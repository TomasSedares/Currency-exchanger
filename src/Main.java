import java.awt.*;
import java.util.Scanner;

public class Main {

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        int respuesta;
        int monto;

        Menues menues = new Menues();

        while (true) {
            System.out.println(menues.menuInicial());
            respuesta = scan.nextInt();

            if (respuesta < 1 || respuesta > 6) {
                System.out.println("Saliendo...");
                break;
            }

            switch (respuesta){
                case 1:
                    System.out.println(menues.textoIngresarDivisas());
                    monto = scan.nextInt();

                    break;
                case 2:
                    System.out.println(menues.textoIngresarDivisas());
                    break;
                case 3:
                    System.out.println(menues.textoIngresarDivisas());
                    break;
                case 4:
                    System.out.println(menues.textoIngresarDivisas());
                    break;
                case 5:
                    System.out.println(menues.textoIngresarDivisas());
                    break;
                case 6:
                    System.out.println(menues.textoIngresarDivisas());
                    break;
            }
        }
    }
}