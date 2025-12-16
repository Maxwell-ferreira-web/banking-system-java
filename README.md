# 🏦 Sistema Bancário CLI - Java

## Descrição
Sistema bancário desenvolvido em Java com interface CLI (Command Line Interface) que permite gerenciar contas bancárias e realizar operações financeiras completas.

## Funcionalidades
- ✅ **Criar conta bancária** - Cadastro de novos clientes e contas
- ✅ **Depositar valores** - Adicionar dinheiro à conta
- ✅ **Sacar valores** - Retirar dinheiro respeitando saldo e limite
- ✅ **Transferir entre contas** - Movimentação entre diferentes contas
- ✅ **Consultar saldo** - Verificar saldo atual e limite disponível
- ✅ **Listar contas** - Visualizar todas as contas cadastradas
- ✅ **Exportar transações** - Gerar relatório CSV com histórico

## Como executar

### Pré-requisitos
- Java 11 ou superior
- Git

### Passo a passo
1. **Clone o repositório:**
```bash
git clone https://github.com/Maxwell-ferreira-web/banking-cli.git
cd banking-cli
```

2. **Compile o projeto:**
```bash
javac -cp . src/**/*.java
```

3. **Execute a aplicação:**
```bash
java -cp . -cp src Main
```

**⚠️ IMPORTANTE:** Execute o arquivo `Main.java` que está na pasta `src` para iniciar o sistema!

### Alternativa usando IDE
1. Abra o projeto no Eclipse ou IntelliJ
2. Navegue até `src/Main.java`
3. Clique com botão direito → **"Run as Java Application"**
4. O sistema será iniciado no console

## Interface do usuário
```
=== SISTEMA BANCÁRIO ===
1. Criar conta
2. Depositar
3. Sacar
4. Transferir
5. Consultar saldo
6. Listar contas
7. Exportar transações
0. Sair

Escolha uma opção: 
```

## Estrutura do projeto
```
banking-cli/
├── src/
│   └── (default package)/
│       ├── Main.java                 # 🎯 ARQUIVO PRINCIPAL - Execute este!
│       ├── entities/
│       │   ├── Cliente.java          # Entidade cliente
│       │   ├── ContaBancaria.java    # Entidade conta bancária
│       │   └── Transacao.java        # Entidade transação
│       ├── services/
│       │   ├── BancoService.java     # Lógica de negócio principal
│       │   └── MenuService.java      # Gerenciamento do menu CLI
│       └── utils/
│           └── CsvExporter.java      # Utilitário para exportação CSV
└── JRE System Library                # Bibliotecas Java
```

## Tecnologias utilizadas
- **Java 11+** - Linguagem principal
- **Collections Framework** - Gerenciamento de dados em memória
- **File I/O** - Manipulação de arquivos CSV
- **Scanner** - Interface de entrada do usuário
- **LocalDateTime** - Controle de data/hora das transações

## Exemplo de operações

### Criar conta
```
=== CRIAR CONTA ===
Nome do cliente: João Silva
CPF: 123.456.789-00
Email: joao@email.com
Número da conta: 1001
Número da agência: 100
Limite: 500.00
Tipo de conta (CORRENTE/POUPANCA): CORRENTE
```

### Realizar depósito
```
=== DEPOSITAR ===
Número da conta: 1001
Valor do depósito: R$ 1000.00
Depósito realizado com sucesso!
Saldo atual: R$ 1000.00
```

### Exportar transações
```
=== EXPORTAR TRANSAÇÕES ===
Transações exportadas para: transacoes.csv
Total de transações: 4
```

## Formato do arquivo CSV gerado
```csv
tipo;valor;data;origem;destino
DEPÓSITO;1000.0;2025-12-11T09:49:01;Conta 1001 | Agência 100 | Cliente: Maxwell Ferreira;-
SAQUE;200.0;2025-12-11T09:49:17;Conta 1001 | Agência 100 | Cliente: Maxwell Ferreira;-
TRANSFERÊNCIA;150.0;2025-12-11T09:57:15;Conta 1001 | Agência 100 | Cliente: Maxwell Ferreira;Conta 1002 | Agência 100 | Cliente: Ana Costa
```

## Quick Start
1. Clone o projeto
2. Execute: `java -cp . -cp src Main`
3. Escolha opção **1** para criar sua primeira conta
4. Explore as demais funcionalidades!

## Como testar
1. Execute o arquivo `Main.java`
2. Crie pelo menos 2 contas diferentes
3. Realize depósitos em ambas as contas
4. Faça saques respeitando os limites
5. Execute transferências entre as contas
6. Consulte saldos para verificar as operações
7. Exporte as transações e verifique o arquivo CSV

## Funcionalidades técnicas
- **Validação de dados** - CPF, valores, contas existentes
- **Controle de saldo** - Verificação de limite e saldo disponível
- **Histórico de transações** - Registro completo de operações
- **Persistência em CSV** - Exportação de dados para arquivo
- **Interface amigável** - Menu intuitivo e mensagens claras

## Regras de negócio implementadas
- Não permite saque superior ao saldo + limite
- CPF deve ser único no sistema
- Números de conta devem ser únicos
- Valores devem ser positivos
- Transferências validam conta de origem e destino

## 👨‍💻 Desenvolvedor
**Maxwell Ferreira**
- GitHub: [@Maxwell-ferreira-web](https://github.com/Maxwell-ferreira-web)
