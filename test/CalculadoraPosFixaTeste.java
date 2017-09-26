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
    }

    @Test
    public void acrescentar1Operando() {

        cpf.empilha("5");

        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 1);
        assertEquals("5", cpf.topo());
    }
    
    @Test
    public void acrescentar2Operandos() {

        cpf.empilha("5");
        cpf.empilha("2");
        
        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 2);
        assertEquals("2", cpf.topo());
    }
    
    @Test
    public void acrescentarOperandoComMaisDeUmAlgarismo() {

        cpf.empilha("50");
        
        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 1);
        assertEquals("50", cpf.topo());
    }
    
    
    @Test
    public void exibeDoisOperandosAcrescentados() {

        cpf.empilha("5");
        cpf.empilha("2");
        
        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 2);
        assertEquals("5 2", cpf.exibirExpressao());
    }
    
     @Test
    public void acrescentar5Operandos() {

        cpf.empilha("5");
        cpf.empilha("2");
        cpf.empilha("5");
        cpf.empilha("2");
        cpf.empilha("10");
        
        assertFalse(cpf.estaVazia());
        assertEquals(cpf.getTamanho(), 5);
        assertEquals("5 2 5 2 10", cpf.exibirExpressao());
        assertEquals("10", cpf.topo());
    }
    
}
