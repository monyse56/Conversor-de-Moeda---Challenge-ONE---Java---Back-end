# 💱 Conversor de Moedas - Java

Este é um projeto simples de conversão de moedas utilizando Java, integração com a API [ExchangeRate](https://www.exchangerate-api.com/), e salvamento do histórico em JSON.

## 🚀 Funcionalidades
- Conversão entre:
  - Dólar ↔ Real
  - Euro ↔ Real
  - Bitcoin ↔ Real
- Consulta de taxa em tempo real
- Salvamento do histórico em `historico.json`

## 📦 Tecnologias
- Java 17+
- Gson (Google)
- API HTTP nativa (Java 11+)
- API ExchangeRate

## 📁 Estrutura
- `ClienteHttp`: realiza a chamada para API
- `ConversorDeMoeda`: interação com o usuário
- `Util`: formatação e extração da taxa
- `GeradorArquivo`: salva o histórico no JSON
- `Conversao`: classe de mapeamento JSON

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/conversor-moedas.git

Compile e execute:
javac -d bin src/*.java
java -cp bin Main

👤 Autor
Monyse Moura
