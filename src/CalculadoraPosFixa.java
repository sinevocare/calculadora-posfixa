/*
 * A implementação da calculadora será baseada na estrutura de dados: PILHA.
 */

import java.util.Stack;

class CalculadoraPosFixa {
    private Stack<String> entradas;

    public CalculadoraPosFixa() {
        entradas = new Stack<>();
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
        return String.join(" ", this.entradas);
    }

    public String resolverExpressao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
