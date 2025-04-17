import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CambiadorDivisas {

    private double total = 0;
    private double valorDivisa;

    public void cambiarDivisas(String monedaBase, String monedaDestino) throws IOException, InterruptedException {
        //concateno la divisa que quiero buscar con la parte de la URL de la API
        String url = "https://v6.exchangerate-api.com/v6/57742dc9edc66acb688b0561/latest/" + monedaBase;

        try {
            //creo el cliente y la request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            //creo el response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //creo el gson, el cual sera mi intermediario entre el json y un objeto de java
            Gson gson = new Gson();

            //convierto el json en un objeto java
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            //creo un objeto el cual va a contener SOLAMENTE las partes del converio_rates
            JsonObject conversiones = jsonObject.getAsJsonObject("conversion_rates");

            //guardo en una variable la moneda a la cual queria convertir mis divisas (monedaDestino) extrayendolas directamente del objeto json
            valorDivisa = conversiones.get(monedaDestino).getAsDouble();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
        }
    }

    //calculo el valor final al transformar de una divisa a otra
    public void calcularDivisas(int cantidad) {
        total = cantidad * valorDivisa;
    }

    @Override
    public String toString() {
        return "El total de la conversión es: " + total;
    }
}