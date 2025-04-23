import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    private static final String FILE_PATH = "historico.json";

    public static void salvarDados(String moedaOrigem, String moedaDestino, double valorEntrada, double valorConvertido) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("moeda_origem", moedaOrigem);
        jsonObject.addProperty("moeda_destino", moedaDestino);
        jsonObject.addProperty("valor_entrada", valorEntrada);
        jsonObject.addProperty("valor_convertido", valorConvertido);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(jsonObject);

        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(jsonString + "\n");
            System.out.println("Conversão salva com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}



