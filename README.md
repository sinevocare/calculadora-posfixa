# Calculadora Posfixa


## Objetivo
- Projetar testes uniários para uma terceira equipe implementar

## Problema
- Receber uma string contendo uma expressão matemática em [notação polonesa](https://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa) e retornar o valor de resultado da expressão.

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
   
## Equipe

- [Gustavo Guerino](https://github.com/gustavoguerino);
- [José Augusto](https://github.com/augusteiner);

## Tecnologias

- C#;
- xUnit;
- [dotnet/core](https://www.microsoft.com/net/download/linux);

## Plano de teste (*bottom-up*)

- &reals; : Conjunto dos número reais

| Entrada | Condição | Classes válidas | Classes inválidas|
|---------|----------|-----------------|------------------|
| expressao | tipo(expressao) | tipo(expressao) &equals; string | tipo(expressao) &ne; string |
|| IsValid(expressao) | IsValid(expressao) &equals; true | IsValid(expressao) &ne; true |
|| size(Operands(expressao)) | size(Operands(expressao)) &equals; size(Operators(expressao)) + 1 |size(Operands(expressao)) &ne; size(Operators(expressao)) + 1|
||Calculate(expressao) | Calculate(expressao) &isin; &real; | Calculate(expressao) &notin; &real; |

```csharp

char[] Operators(dynamic expressao)
int[] Operands(dynamic expressao)
bool IsValid(dynamic expressao)
double Calculate(dynamic expressao)

```

### Casos de teste

#### 1º caso de teste

```csharp
Calculate("1 + 1") // DON'T throw an ArgumentException
```

#### 2º caso de teste

```csharp
Calculate(1 + 1) // throw an ArgumentException
```

#### 3º caso de teste

```csharp
IsValid("1 + 1") // return true
```

#### 4º caso de teste

```csharp
IsValid(1 + 1) // return false
```

#### 5º caso de teste


```csharp

int sOperands = Operands("1 + 1") // return 2
int sOperators = Operators("1 + 1") // return 1

Assert.True(sOperands == sOperators + 1)

```

#### 6º caso de teste


```csharp

int sOperands = Operands("1 + 1") // return 2
int sOperators = Operators("1 + 1 +") // return 2

Assert.False(sOperands == sOperators + 1)

```

#### 7º caso de teste


```csharp
Calculate("1 + 1") // return 2
```

#### 8º caso de teste


```csharp
Calculate("0 / 0") // throw an ArithmeticException
```

## Como executar os testes

```bash
dotnet test
```

