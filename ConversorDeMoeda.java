import java.util.Scanner;

public class ConversorDeMoeda {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteHttp clienteHttp = new ClienteHttp();
    private static final String API_KEY = "569116d677d3c66b4ad14968";

    public static void executar() {
        System.out.println("==== CONVERSOR DE MOEDAS ====");

        System.out.println("""
                Escolha uma opção:
                1 - Dólar (USD) para Real (BRL)
                2 - Real (BRL) para Dólar (USD)
                3 - Euro (EUR) para Real (BRL)
                4 - Real (BRL) para Euro (EUR)
                5 - Bitcoin (BTC) para Real (BRL)
                6 - Real (BRL) para Bitcoin (BTC)
                0 - Sair
                """);

        int opcao = scanner.nextInt();
        if (opcao == 0) {
            System.out.println("Programa encerrado.");
            return;
        }

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        String moedaBase = "";
        String moedaDestino = "";

        switch (opcao) {
            case 1 -> { moedaBase = "USD"; moedaDestino = "BRL"; }
            case 2 -> { moedaBase = "BRL"; moedaDestino = "USD"; }
            case 3 -> { moedaBase = "EUR"; moedaDestino = "BRL"; }
            case 4 -> { moedaBase = "BRL"; moedaDestino = "EUR"; }
            case 5 -> { moedaBase = "BTC"; moedaDestino = "BRL"; }
            case 6 -> { moedaBase = "BRL"; moedaDestino = "BTC"; }
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        try {
            String respostaJson = clienteHttp.buscaTaxaDeCambio(moedaBase, moedaDestino, API_KEY);
            if (respostaJson == null) {
                System.out.println("Erro ao obter dados da API.");
                return;
            }

            double taxa = Util.obterTaxa(respostaJson);
            double convertido = valor * taxa;
            System.out.println("Valor convertido: " + Util.formatar(convertido) + " " + moedaDestino);

            //  salvando os dados no arquivo
            GeradorArquivo.salvarDados(moedaBase, moedaDestino, valor, convertido);

        } catch (ErroConsulta e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
