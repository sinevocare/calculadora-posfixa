# Calculadora Posfixa


## Objetivo
- Projetar testes uniários para uma terceira equipe implementar

## Problema
- Receber uma string contendo uma expressão matemática em [notação polonesa reversa](https://pt.wikipedia.org/wiki/Notação_polonesa_inversa) e retornar o valor de resultado da expressão.

- Exemplos
"3 2 5 + *" => 21

- [Calculadora online](https://epxx.co/ctb/hp12c.html)


## Atividades
- segunda-feira 25-09
   1. forkar este repositório
   1. atualizar README.md com
      - equipe (lembrar de colocar link para o github dos membros)
      - tecnologia usada
      - plano de teste (definir se vai usar top-down ou bottom-up)
      - implementar os testes unitários
      - como executar teste
   1. apresentar em sala o plano de teste
- quinta-feira 28-09
   1. sortear repositório e equipe
   1. forkar repositório
   1. desenvolver solução para os testes
   1. apresentar plano de teste e solução

# Plano de teste
   - equipe ( [Yuri Jordan](https://github.com/Yuri-Jordan), [Thomas Nogueira](https://github.com/Thomas-Nogueira) )
      - Java 8 com JUnit Versão [4](http://junit.org/junit4), IDE Netbeans 8.2, SO Windows 10.
      - plano de teste (bottom-up)
      - implementar os testes unitários
      - como executar teste
## Identificação
### Objetivo
- Projetar testes uniários para uma terceira equipe implementar

### Problema
- Receber uma string contendo uma expressão matemática em [notação polonesa reversa](https://pt.wikipedia.org/wiki/Notação_polonesa_inversa) e retornar o valor de resultado da expressão.

- Exemplos
"3 2 5 * +" => 21

### Casos equivalentes
| Entrada   |               Condição             |    Classes válidas               |         Classes inválidas        |
|-----------|------------------------------------|----------------------------------|----------------------------------|
| polonesa  | É do tipo string.                  |(1) expressao(polonesa) == String |(4) expressao(polonesa) != String |
|           | Dentro da string cada elemento é um número(s) inteiro com caractere(s) usados em expressões matemáticas: + - * /          |(2) polonesa = "3 2 5 * +"        |(5) polonesa = "3 2 5 * + d -"    |
|           | A operação matemática RPN opera de forma que: o(s) número(s) é(são) inseridos numa pilha, quando algum caractere de expressão númerica é inserido é calculado os dois últimos números, assim sucessivamente até que todos os números sejam calculados e retirada da pilha o resultado.               |(3) polonesa = "5 1 2 + 4 × + 3 −" calculando = 5 + (1 + 2) × 4 - 3 |(6) polonesa = "5 1 2 + 4 × + 3 −" calculando = 5 + 1 + 8 - 3 |

### Casos de testes
| Sequência   |               Entrada           |            Saída                |
|-------------|---------------------------------|---------------------------------|
| 1 - válida  |      "5 1 2 + 4 × + 3 −"        |              14                 |
| 1 - inválida|               5                 |        Lança uma exceção        |
| 2 - válida  |           "3 2 5 * +"           |              21                 |
| 2 - inválida|         "3 2 5 * + d -"         |        Lança uma exceção        |
| 3 - válida  |      "5 1 2 + 4 × + 3 −"        |              14                 |
| 3 - inválida|      "5 1 2 + 4 × + 3 −"        |              11                 |

#### Calculando
|Próximo valor	|    Operação     	| Pilha  |
|--------------|--------------------|--------|
|      5	      |  adicionar valor	|    5   |
|      1     	|  adicionar valor   |	5, 1  |
|      2	      |  adicionar valor   | 5, 1, 2|
|      +	      |        somar       |	5, 3  |
|      4	      |  adicionar valor   | 5, 3, 4|
|      ×	      |  multiplicar       |  5, 12 |
|      +	      |        somar       |	 17   |
|      3	      |  adicionar valor   |  17, 3 |
|      −	      |     subtrair       |	 14   |
|Resultado	14|







