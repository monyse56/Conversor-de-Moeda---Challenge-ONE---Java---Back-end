import com.google.gson.Gson;

public class Util {

    public static double obterTaxa(String json) {
        Gson gson = new Gson();
        Conversao conversao = gson.fromJson(json, Conversao.class);
        return conversao.getResultado();
    }

    public static String formatar(double valor) {
        return String.format("%.2f", valor);
    }
}
