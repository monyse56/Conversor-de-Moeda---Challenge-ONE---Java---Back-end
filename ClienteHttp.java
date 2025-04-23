import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public String buscaTaxaDeCambio(String moedaBase, String moedaDestino, String apiKey) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaBase + "/" + moedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new ErroConsulta("Erro ao consultar taxa de câmbio. Verifique a moeda ou a chave da API.");
            }

            return response.body(); // Retorna a string JSON bruta
        } catch (Exception e) {
            System.err.println("Erro ao consultar a API: " + e.getMessage());
        }

        return null;
    }
}
