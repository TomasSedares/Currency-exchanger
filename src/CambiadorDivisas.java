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
        String url = "https://v6.exchangerate-api.com/v6/57742dc9edc66acb688b0561/latest/" + monedaBase;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject conversiones = jsonObject.getAsJsonObject("conversion_rates");

            valorDivisa = conversiones.get(monedaDestino).getAsDouble();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
        }
    }

    public void calcularDivisas(int cantidad) {
        total = cantidad * valorDivisa;
    }

    @Override
    public String toString() {
        return "El total de la conversión es: " + total;
    }
}