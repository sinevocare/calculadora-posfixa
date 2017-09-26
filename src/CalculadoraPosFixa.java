/*
 * A implementação da calculadora será baseada na estrutura de dados: PILHA.
 */
import java.util.Arrays;
import java.util.Stack;



class CalculadoraPosFixa {

    private Stack entradas;

    public CalculadoraPosFixa() {
        entradas = new Stack();
    }

    public int getTamanho() {
        return this.entradas.size();
    }

    public boolean estaVazia() {
        return this.entradas.isEmpty();
    }

    public void empilha(String entrada) {

        this.entradas.push(entrada);

    }

    public String topo() {

        return this.entradas.peek().toString();

    }

    public String exibirExpressao() {
        
      
        return String.join(" ", this.entradas);
    }

}
