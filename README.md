# Calculadora Pósfixa


## Objetivo

Projetar testes uniários para uma terceira equipe implementar


## Problema

Receber uma string contendo uma expressão matemática em [notação polonesa](https://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa) e retornar o valor de resultado da expressão.

Exemplos
`"3 2 5 + *" => 21`

[Calculadora online](https://epxx.co/ctb/hp12c.html)


## Equipe

Este projeto foi desenvolvido por [Albert Morato](https://github.com/albert06/) e [Guilherme Portela](https://github.com/sinevocare/).


## Tecnologia utilizada

O projeto será desenvolvido em Python.


## Plano de teste

### Classes de equivalência

| Entrada   | Condição                                                                             | Classes válidas                                                                                          | Classes inválidas                                                                                         |
|-----------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| expressao | É uma string                                                                         | (1) `type(expressao) is str`                                                                             | (6) `type(expressao) is not str`                                                                          |
|           | É separada por espaços                                                               | (2) `len(expressao.split(' ')) > 1`                                                                      | (7) `len(expressao.split(' ') <= 1`                                                                       |
|           | Começa com dois números                                                              | (3) `bool(re.match('^\d+(.\d+)? \d+(.\d+)?')')) is True`                                                 | (8) `bool(re.match('^\d+(.\d+)? \d+(.\d+)?')')) is False`                                                 |
|           | Só possui números, espaços, e os operadores aritméticos básicos ('+', '-', '/', '*') | (4) `bool(re.match('^\d+(.\d+)?( (\d+(\.\d+)?\|\+\|\-\|\/\|\*))*$', expressao)) is True`                 | (9) `bool(re.match('^\d+(.\d+)?( (\d+(\.\d+)?\|\+\|\-\|\/\|\*))*$', expressao)) is False`                 |
|           | A quantidade de operadores aritméticos é igual à quantidade de números menos um      | (5) `sum(map(expressao.count, ['+', '-', '*', '/'])) == len(re.findall('(\d+(\.\d+)?)', expressao)) - 1` | (10) `sum(map(expressao.count, ['+', '-', '*', '/'])) != len(re.findall('(\d+(\.\d+)?)', expressao)) - 1` |

### Casos de teste

| #  |Método                            | Classes       | Chamada                             | Resultado esperado
|----|-----------------------------------|---------------|-------------------------------------|------------------------------|
| 1  | `Analisador#eh_valida(expressao)` | 6             | `Analisador.eh_valida(2)`           | Lança exceção (`TypeError`)  |
| 2  |                                   | 7             | `Analisador.eh_valida('23*')`       | `False`                      |
| 3  |                                   | 8             | `Analisador.eh_valida('2 + 3')`     | `False`                      |
| 4  |                                   | 9             | `Analisador.eh_valida('2 3 x')`     | `False`                      |
| 5  |                                   | 10            | `Analisador.eh_valida('2 3 4 +')`   | `False`                      |
| 6  |                                   | 1, 2, 3, 4, 5 | `Analisador.eh_valida('2 3 +')`     | `True`                       |
| 7  |                                   | 1, 2, 3, 4, 5 | `Analisador.eh_valida('3 2 5 + *')` | `True`                       |
| 8  |                                   | 1, 2, 3, 4, 5 | `Analisador.eh_valida('3.1 1.1 +')` | `True`                       |
| 9  | `Analisador#tokenizar(expressao)` | 6             | `Analisador.tokenizar(2)`           | Lança exceção (`TypeError`)  |
| 10 |                                   | 7             | `Analisador.tokenizar('23*')`       | Lança exceção (`ValueError`) |
| 11 |                                   | 8             | `Analisador.tokenizar('2 + 3')`     | Lança exceção (`ValueError`) |
| 12 |                                   | 9             | `Analisador.tokenizar('2 3 x')`     | Lança exceção (`ValueError`) |
| 13 |                                   | 10            | `Analisador.tokenizar('2 3 4 +')`   | Lança exceção (`ValueError`) |
| 14 |                                   | 1, 2, 3, 4, 5 | `Analisador.tokenizar('2 3 +')`     | `['2', '3', '+']`            |
| 15 |                                   | 1, 2, 3, 4, 5 | `Analisador.tokenizar('3 2 5 + *')` | `['3', '2', '5', '+', '*']`  |
| 16 |                                   | 1, 2, 3, 4, 5 | `Analisador.tokenizar('3.1 1.1 +')` | `['3.1', '1.1', '+']`        |
| 17 | `Avaliador#avaliar(expressao)`    | 6             | `Avaliador.avaliar(2)`              | Lança exceção (`TypeError`)  |
| 18 |                                   | 7             | `Avaliador.avaliar('23*')`          | Lança exceção (`ValueError`) |
| 19 |                                   | 8             | `Avaliador.avaliar('2 + 3')`        | Lança exceção (`ValueError`) |
| 20 |                                   | 9             | `Avaliador.avaliar('2 3 x')`        | Lança exceção (`ValueError`) |
| 21 |                                   | 10            | `Avaliador.avaliar('2 3 4 +')`      | Lança exceção (`ValueError`) |
| 22 |                                   | 1, 2, 3, 4, 5 | `Avaliador.avaliar('2 3 +')`        | `5`                          |
| 23 |                                   | 1, 2, 3, 4, 5 | `Avaliador.avaliar('3 2 5 + *')`    | `21`                         |
| 24 |                                   | 1, 2, 3, 4, 5 | `Avaliador.avaliar('3.1 1.1 +')`    | `4.2`                        |


## Como executar teste

Com o Python 3.5+ instalado, rode:

`python3 -m unittest discover tests "*_test.py"`

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
