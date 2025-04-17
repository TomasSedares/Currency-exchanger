import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scan;

    public static void main(String[] args) throws IOException, InterruptedException {
        scan = new Scanner(System.in);

        int respuesta;
        int monto;

        //instancio mis 2 clases para poder ustilizar sus respectivos metodos
        Menues menues = new Menues();
        CambiadorDivisas currencyExchanger = new CambiadorDivisas();

        //creo un ciclo while que ejecute continuamente los menues mientras el usuario elija una opcion valida
        while (true) {
            System.out.println(menues.menuInicial());
            respuesta = scan.nextInt();

            if (respuesta < 1 || respuesta > 7) {
                System.out.println("Saliendo...");
                break;
            }

            //el switch analiza que opcion se elijio y actua en consecuencia
            switch (respuesta) {
                case 1:
                    //muestro el menu
                    System.out.println(menues.textoIngresarDivisas());
                    //permito al usuario elegir la disvisa
                    monto = scan.nextInt();
                    //le paso por parametro las monedas que posteriormente se le consultara a la id
                    //la moneda base pide una requset en la que agarra todos los tipos de cambio que tiene en este caso el dolar
                    //posteriormente me da un objeto para que despues pueda buscar con monedaDestino la moneda la cual quiero calcular
                    currencyExchanger.cambiarDivisas("USD", "ARS");
                    //realizo el calculo multiplicando la cantidad de divisas ingresadas con el valor de la divisa que me dio el json
                    currencyExchanger.calcularDivisas(monto);
                    //muestro el resultado final
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