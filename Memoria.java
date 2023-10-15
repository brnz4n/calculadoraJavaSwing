package negocio;

import java.util.ArrayList;

public class Memoria {

    public ArrayList<String> numeros;

    public Memoria() {
        numeros = new ArrayList<String>();
    }

    public String getNumeros() {
        StringBuilder resultado = new StringBuilder();

        for (String num : numeros) {
            if (isOperador(num)) {
                resultado.append(" ").append(num).append(" ");
            } else {
                resultado.append(num);
            }
        }

        return resultado.toString().trim();
    }

    public void setNumero(String numero) {
        numeros.add(numero);
    }

    public double calcResultado(double p1, String operador, double p2) {
        
    	switch (operador) {
            case "+":
                return p1 + p2;
            case "-":
                return p1 - p2;
            case "*":
                return p1 * p2;
            case "/":
                if (p2 != 0) {
                    return p1 / p2;
                } else {
                    return 0;
                }
            default:
            return 0;
        }
    }
    private boolean isOperador(String token) {
    	return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    public String resultado() {
        String conta = getNumeros();
        String[] partes = conta.trim().split(" ");
        String resul = "";

        if (partes.length == 3) {
            double p1 = Double.parseDouble(partes[0]);
            String operacao = partes[1];
            double p2 = Double.parseDouble(partes[2]);

            double resultado = calcResultado(p1, operacao, p2);

            resul = Double.toString(resultado);

            return resul;
        }
        return resul;
    }

}
