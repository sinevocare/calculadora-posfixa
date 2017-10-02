import unittest

from calculadora import Analisador, Avaliador


class AnalisadorTestCase(unittest.TestCase):
    def test_caso_um(self):
        with self.assertRaises(TypeError):
            Analisador.eh_valida(2)
    
    def test_caso_dois(self):
        self.assertIs(False, Analisador.eh_valida('23*'))
    
    def test_caso_tres(self):
        self.assertIs(False, Analisador.eh_valida('2 + 3'))
    
    def test_caso_quatro(self):
        self.assertIs(False, Analisador.eh_valida('2 3 x'))
    
    def test_caso_cinco(self):
        self.assertIs(False, Analisador.eh_valida('2 3 4 +'))
    
    def test_caso_seis(self):
        self.assertIs(True, Analisador.eh_valida('2 3 +'))
    
    def test_caso_sete(self):
        self.assertIs(True, Analisador.eh_valida('3 2 5 + *'))
    
    def test_caso_oito(self):
        self.assertIs(True, Analisador.eh_valida('3.1 1.1 +'))
        
    def test_caso_nove(self):
        with self.assertRaises(TypeError):
            Analisador.tokenizar(2)
    
    def test_caso_dez(self):
        with self.assertRaises(ValueError):
            Analisador.tokenizar('23*')
    
    def test_caso_onze(self):
        with self.assertRaises(ValueError):
            Analisador.tokenizar('2 + 3')
    
    def test_caso_doze(self):
        with self.assertRaises(ValueError):
            Analisador.tokenizar('2 3 x')
    
    def test_caso_treze(self):
        with self.assertRaises(ValueError):
            Analisador.tokenizar('2 3 4 +')
    
    def test_caso_quatorze(self):
        self.assertListEqual(['2', '3', '+'], Analisador.tokenizar('2 3 +'))
    
    def test_caso_quinze(self):
        self.assertListEqual(
            ['3', '2', '5', '+', '*'],
            Analisador.tokenizar('3 2 5 + *')
        )
    
    def test_caso_dezesseis(self):
        self.assertListEqual(
            ['3.1', '1.1', '+'],
            Analisador.tokenizar('3.1 1.1 +')
        )

    def test_caso_dezessete(self):
        with self.assertRaises(TypeError):
            Avaliador.avaliar(2)

    def test_caso_dezoito(self):
        with self.assertRaises(ValueError):
            Avaliador.avaliar('23*')

    def test_caso_dezenove(self):
        with self.assertRaises(ValueError):
            Avaliador.avaliar('2 + 3')

    def test_caso_vinte(self):
        with self.assertRaises(ValueError):
            Avaliador.avaliar('2 3 x')

    def test_caso_vinte_e_um(self):
        with self.assertRaises(ValueError):
            Avaliador.avaliar('2 3 4 +')

    def test_caso_vinte_e_dois(self):
        self.assertEqual(5, Avaliador.avaliar('2 3 +'))

    def test_caso_vinte_e_tres(self):
        self.assertEqual(21, Avaliador.avaliar('3 2 5 + *'))

    def test_caso_vinte_e_quatro(self):
        self.assertAlmostEqual(4.2, Avaliador.avaliar('3.1 1.1 +'), 7)


if __name__ == '__main__':
    unittest.main()
