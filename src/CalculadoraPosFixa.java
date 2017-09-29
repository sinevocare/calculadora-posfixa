/*
 * A implementação da calculadora será baseada na estrutura de dados: PILHA.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

class CalculadoraPosFixa {
    private Map<String, BiFunction<Integer, Integer, Number>> operadores;

    private Stack<String> entradas;

    public CalculadoraPosFixa() {
        entradas = new Stack<>();

        operadores = new HashMap<>();

        operadores.put("+", (a, b) -> a + b);
    }

    public int getTamanho() {
        return this.entradas.size();
    }

    public boolean estaVazia() {
        return this.entradas.isEmpty();
    }

    public void empilhar(String entrada) {
        this.entradas.push(entrada);
    }

    public String topo() {
        return this.entradas.peek();
    }

    public String exibirExpressao() {
        if (entradas.size() > 0 && entradas.firstElement().equals("+")) {
            throw new CalculadoraPosFixaException("");
        }

        return String.join(" ", this.entradas);
    }

    public String resolverExpressao() {
        Stack<String> tokens = new Stack<>();

        for (String token: entradas) {
            if (operadores.containsKey(token)) {
                Integer ultimo = Integer.valueOf(tokens.pop());
                Integer penultimo = Integer.valueOf(tokens.pop());

                tokens.push(operadores.get(token).apply(ultimo, penultimo).toString());
            } else {
                tokens.push(token);
            }
        }

        return tokens.pop();
    }
}
