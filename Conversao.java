public class Conversao {
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public double getResultado() {
        return conversion_rate;
    }

    public String getMoedaBase() {
        return base_code;
    }

    public String getMoedaDestino() {
        return target_code;
    }
}
