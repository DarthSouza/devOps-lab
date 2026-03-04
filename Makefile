# Makefile for DevOps Lab (Windows)
# Use: make <target> or mingw32-make <target>

.PHONY: help clean compile test package run docker-build docker-run verify coverage checkstyle

help:
	@echo "DevOps Lab - Comandos Disponíveis:"
	@echo ""
	@echo "  make compile       - Compila o projeto"
	@echo "  make test          - Executa os testes"
	@echo "  make package       - Gera o JAR"
	@echo "  make run           - Executa a aplicação"
	@echo "  make clean         - Limpa o diretório target"
	@echo "  make verify        - Executa verificação completa"
	@echo "  make coverage      - Gera relatório de cobertura"
	@echo "  make checkstyle    - Verifica estilo de código"
	@echo "  make docker-build  - Build da imagem Docker"
	@echo "  make docker-run    - Executa container Docker"
	@echo "  make validate      - Validação completa do projeto"

clean:
	mvn clean

compile:
	mvn clean compile

test:
	mvn test

package:
	mvn clean package

run:
	mvn spring-boot:run

verify:
	mvn verify

coverage:
	mvn clean verify jacoco:report
	@echo "Relatório disponível em: target/site/jacoco/index.html"

checkstyle:
	mvn checkstyle:check

docker-build:
	docker build -t devops-lab:latest -f docker/Dockerfile .

docker-run:
	docker run -p 8080:8080 devops-lab:latest

docker-compose-up:
	cd docker && docker-compose up -d

docker-compose-down:
	cd docker && docker-compose down

validate:
	@echo "Executando validação completa..."
	powershell -ExecutionPolicy Bypass -File scripts/validate.ps1

install:
	mvn clean install

all: clean compile test package
	@echo "Build completo finalizado!"

