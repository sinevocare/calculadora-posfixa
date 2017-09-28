/*
 * Os teste serão executados, baseados nas operações da estrutura de dados: PILHA.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CalculadoraPosFixaTeste {

    CalculadoraPosFixa cpf;

    @Before
    public void setUp() {
        cpf = new CalculadoraPosFixa();
    }

    @Test
    public void calculadoraVazia() {
        assertTrue(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 0);
        assertEquals("", cpf.exibirExpressao());
    }

    /*
     * ===========================================================================   
     * TESTES APENAS INSERÇÃO DE OPERANDOS
     * ===========================================================================
     */
    @Test
    public void acrescentar1Operando() {

        cpf.empilhar("5");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 1);
        assertEquals("5", cpf.topo());
        assertEquals("5", cpf.exibirExpressao());
    }

    @Test
    public void acrescentar2Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 2);
        assertEquals("2", cpf.topo());
        assertEquals("5 2", cpf.exibirExpressao());
    }

    @Test
    public void acrescentarOperandoComMaisDeUmAlgarismo() {

        cpf.empilhar("50");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 1);
        assertEquals("50", cpf.topo());
        assertEquals("50", cpf.exibirExpressao());
    }

    @Test
    public void exibir3OperandosAcrescentados() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("50");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 3);
        assertEquals("5 2 50", cpf.exibirExpressao());
    }

    @Test
    public void acrescentar5Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("10");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 5);
        assertEquals("5 2 5 2 10", cpf.exibirExpressao());
        assertEquals("10", cpf.topo());
    }

    /*
     * ===========================================================================   
     * TESTES COM OPERADORES
     * ===========================================================================
     */
    @Test(expected = CalculadoraPosFixaException.class)
    public void entradaSemOperandos() {

        cpf.empilhar("+");
        cpf.exibirExpressao();

    }

    @Test
    public void soma2Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("+");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 3);
        assertEquals("2", cpf.topo());
        assertEquals("5 2 +", cpf.exibirExpressao());
        assertEquals("7", cpf.resolverExpressao());

    }

    @Test
    public void subtracao2Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("-");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 3);
        assertEquals("2", cpf.topo());
        assertEquals("5 2 -", cpf.exibirExpressao());
        assertEquals("3", cpf.resolverExpressao());

    }

    @Test
    public void multiplicacao2Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("*");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 3);
        assertEquals("2", cpf.topo());
        assertEquals("5 2 *", cpf.exibirExpressao());
        assertEquals("10", cpf.resolverExpressao());

    }

    @Test
    public void divisao2Operandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("/");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 3);
        assertEquals("2", cpf.topo());
        assertEquals("5 2 /", cpf.exibirExpressao());
        assertEquals("2.5", cpf.resolverExpressao());

    }

    @Test(expected = CalculadoraPosFixaException.class)
    public void divisaoPorZero() {

        cpf.empilhar("5");
        cpf.empilhar("0");
        cpf.empilhar("/");

        cpf.resolverExpressao();

    }
    
    @Test
    public void expressaoComVariosOperandos() {

        cpf.empilhar("5");
        cpf.empilhar("2");
        cpf.empilhar("-");
        cpf.empilhar("2");
        cpf.empilhar("*");
        
        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 5);
        assertEquals("*", cpf.topo());
        assertEquals("5 2 - 2 *", cpf.exibirExpressao());
        assertEquals("6", cpf.resolverExpressao());
    }

}
