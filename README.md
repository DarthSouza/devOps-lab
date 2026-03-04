# devOps-lab
Repositório destinado aos estudos de DevOps e CI/CD

## 📚 Sobre o Projeto

Este repositório contém exemplos práticos e estudos sobre CI/CD (Continuous Integration/Continuous Deployment) utilizando Java 21, Spring Boot e Maven.

## 🛠️ Tecnologias e Ferramentas

- **Java 21** - Linguagem de programação
- **Maven 3.6.3** - Gerenciamento de build e dependências
- **Spring Boot 3.2** - Framework web
- **JUnit 5** - Framework de testes
- **GitHub Actions** - Automação de workflows
- **Docker** - Containerização
- **Checkstyle** - Análise estática de código

## 📁 Estrutura do Projeto

```
devOps-lab/
├── .github/
│   └── workflows/          # Workflows do GitHub Actions
├── src/
│   ├── main/
│   │   ├── java/          # Código fonte da aplicação
│   │   └── resources/     # Arquivos de configuração
│   └── test/
│       └── java/          # Testes automatizados
├── docker/                 # Arquivos Docker
├── docs/                   # Documentação adicional
├── scripts/               # Scripts auxiliares
└── pom.xml               # Configuração do Maven
```

## 🚀 Workflows CI/CD

### 1. Integração Contínua (CI)
- ✅ Execução automática de testes
- ✅ Análise de código (Checkstyle)
- ✅ Build da aplicação
- ✅ Verificação de segurança de dependências
- ✅ Geração de relatórios de cobertura

### 2. Entrega Contínua (CD)
- ✅ Build de imagens Docker
- ✅ Deploy automatizado
- ✅ Versionamento semântico
- ✅ Publicação de artefatos

## 🏃 Como Executar

### Pré-requisitos
- Java 21 (JDK)
- Maven 3.6.3 ou superior
- Docker (opcional)
- Git

### Instalação
```bash
# Clone o repositório
git clone https://github.com/seu-usuario/devOps-lab.git

# Entre no diretório
cd devOps-lab

# Compile o projeto
mvn clean install

# Execute os testes
mvn test

# Execute a aplicação
mvn spring-boot:run
```

## 🧪 Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com cobertura
mvn verify

# Verificar qualidade do código
mvn checkstyle:check

# Gerar relatório de cobertura
mvn jacoco:report
```

## 🐳 Docker

```bash
# Build da imagem
docker build -t devops-lab -f docker/Dockerfile .

# Executar container
docker run -p 8080:8080 devops-lab
```

## 🌐 Endpoints da API

A aplicação expõe os seguintes endpoints:

- `GET /` - Mensagem de boas-vindas
- `GET /actuator/health` - Status da aplicação
- `GET /api/calculate?a={num1}&b={num2}` - Calculadora simples
- `GET /api/hello/{name}` - Saudação personalizada

## 📖 Conceitos Estudados

### CI/CD Pipeline
1. **Source** - Controle de versão com Git
2. **Build** - Compilação com Maven
3. **Test** - Testes automatizados com JUnit
4. **Package** - Geração de JAR/WAR
5. **Deploy** - Implantação automatizada

### Boas Práticas Java
- Uso de Streams e Records (Java 21)
- Testes unitários e de integração
- Injeção de dependências com Spring
- Princípios SOLID
- Clean Code

### DevOps
- Commits frequentes e pequenos
- Testes automatizados em cada commit
- Code review antes do merge
- Deploy automatizado após aprovação
- Monitoramento contínuo

## 📊 Relatórios

- **JaCoCo** - Cobertura de código em `target/site/jacoco/index.html`
- **Checkstyle** - Qualidade de código em `target/checkstyle-result.xml`
- **Surefire** - Relatório de testes em `target/surefire-reports/`

## 📝 Licença

Este projeto é para fins educacionais.

## 👨‍💻 Autor

Projeto desenvolvido para estudo de DevOps e CI/CD por Patrick Souza.
