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

| Entrada | Método | Condição        | Classes válidas  | Classes inválidas |
|---------|--------|-----------------|------------------|-------------------|
| exp | Eval, IsValid, Operands, Operators | typeof(exp)     | typeof(exp) = string | typeof(exp) &ne; string |
|     | Eval | exp.IsValid()        | exp.IsValid() = true | exp.IsValid() &ne; true |
|     | Eval | size(exp.Operands()) | size(exp.Operands()) = size(exp.Operators()) + 1 | size(exp.Operands()) &ne; size(exp.Operators()) + 1|
|     | Eval | exp.Eval()           | exp.Eval() &isin; &reals; | exp.Eval() &notin; &reals; |

### Protótipos dos métodos

```csharp
public static double Eval(this object exp)
public static bool IsValid(this object exp)
public static char[] Operators(this object exp)
public static int[] Operands(this object exp)
```

### Casos de teste

#### 1º caso de teste

```csharp
"1 1 +".Eval() // DON'T throw an ArgumentException
```

#### 2º caso de teste

```csharp
1.Eval() // throw an ArgumentException
```

#### 3º caso de teste

```csharp
"1 1 +".IsValid() // DON'T throw an ArgumentException
```

#### 4º caso de teste

```csharp
1.IsValid() // throw an ArgumentException
```

#### 5º caso de teste

```csharp
"1 1 +".Operators() // DON'T throw an ArgumentException
```

#### 6º caso de teste

```csharp
1.Operators() // throw an ArgumentException
```

#### 7º caso de teste

```csharp
"1 1 +".Operands() // DON'T throw an ArgumentException
```

#### 8º caso de teste

```csharp
1.Operands() // throw an ArgumentException
```

#### 9º caso de teste

```csharp
"1 1 +".Eval() // DON'T throw an ArgumentException
```

#### 10º caso de teste

```csharp
"1 1 + +".Eval() // throw an ArgumentException
```

#### 11º caso de teste

```csharp
"1 1 +".Eval() // returns a number
```

#### 12º caso de teste

```csharp
"1 1 + +".Eval() // throw an ArgumentException
```

#### 13º caso de teste

```csharp
"1 1 +".Eval() // returns a number
```

#### 14º caso de teste

```csharp
"0 0 /".Eval() // throw an ArithmeticException
```

#### 15º caso de teste *extra*

```csharp
"3 2 5 + *".Eval() // return double(21)
```

## Como executar os testes

### Preparando o ambiente

- Verifique/instale os [pré-requisitos](https://docs.microsoft.com/pt-br/dotnet/core/linux-prerequisites?tabs=netcore2x);
- Execute os seguintes comandos e *espere alguns minutos*: (*linux **sem root***)

```bash
curl -sSL https://dot.net/v1/dotnet-install.sh -o dotnet-install.sh \
    && . dotnet-install.sh --channel 2.0 --install-dir $HOME/bin/dotnet
```

- Verifique a instalação:

```bash
dotnet --version
```

#### Instalações alternativas

1. [Instalação alternativa (requer root)](https://www.microsoft.com/net/core#linuxdebian);
1. Execute o comando abaixo (**ATENÇÃO!** o link pode ter expirado):

```bash
mkdir -p $HOME/bin/dotnet/ \
    && curl -sSL "https://dotnetcli.azureedge.net/dotnet/Sdk/2.0.0/dotnet-sdk-2.0.0-linux-x64.tar.gz" \
    | tar xfvz - -C $HOME/bin/dotnet/ \
    && export PATH=$PATH:$HOME/bin/dotnet
```

### Executando os testes

```bash
dotnet test tests/Calc.Tests
```

