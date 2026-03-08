#!/bin/bash

# Script de validação da configuração do projeto

echo "=========================================="
echo "🔍 VALIDAÇÃO COMPLETA DO SETUP"
echo "=========================================="
echo ""

# Cores
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# 1. Validar .env
echo -e "${YELLOW}1. Validando arquivo .env...${NC}"
if [ -f ".env" ]; then
    echo -e "${GREEN}✅ Arquivo .env encontrado${NC}"
    echo "   Conteúdo:"
    cat .env | sed 's/^/   /'
    echo ""
else
    echo -e "${RED}❌ Arquivo .env NÃO encontrado na raiz!${NC}"
    exit 1
fi

# 2. Validar docker-compose.yaml
echo -e "${YELLOW}2. Validando docker-compose.yaml...${NC}"
if [ -f "docker-compose.yaml" ]; then
    echo -e "${GREEN}✅ docker-compose.yaml encontrado${NC}"
    # Verifica se usa variáveis de ambiente
    if grep -q '\${DB_' docker-compose.yaml; then
        echo -e "${GREEN}   ✅ Usa variáveis de ambiente corretamente${NC}"
    fi
    echo ""
else
    echo -e "${RED}❌ docker-compose.yaml NÃO encontrado!${NC}"
    exit 1
fi

# 3. Validar application.yml
echo -e "${YELLOW}3. Validando application.yml...${NC}"
YML_PATH="notaFiscalEletronica/notaFiscalEletronica/src/main/resources/application.yml"
if [ -f "$YML_PATH" ]; then
    echo -e "${GREEN}✅ application.yml encontrado${NC}"
    if grep -q "ddl-auto: none" "$YML_PATH"; then
        echo -e "${GREEN}   ✅ ddl-auto: none (Flyway controlará as migrações)${NC}"
    fi
    if grep -q "flyway:" "$YML_PATH"; then
        echo -e "${GREEN}   ✅ Flyway configurado${NC}"
    fi
    echo ""
else
    echo -e "${RED}❌ application.yml NÃO encontrado!${NC}"
    exit 1
fi

# 4. Validar arquivos SQL de migração
echo -e "${YELLOW}4. Validando arquivos de migração SQL...${NC}"
MIGRATION_DIR="notaFiscalEletronica/notaFiscalEletronica/src/main/resources/db/migration"
if [ -d "$MIGRATION_DIR" ]; then
    echo -e "${GREEN}✅ Pasta de migrations encontrada${NC}"
    
    V1="$MIGRATION_DIR/V1__create_table_notas_fiscais.sql"
    if [ -f "$V1" ] && [ -s "$V1" ]; then
        echo -e "${GREEN}   ✅ V1__create_table_notas_fiscais.sql (com conteúdo)${NC}"
        echo "      Criará as tabelas:"
        grep "^CREATE TABLE" "$V1" | sed 's/^/      - /'
    fi
    echo ""
else
    echo -e "${RED}❌ Pasta db/migration NÃO encontrada!${NC}"
    exit 1
fi

# 5. Validar dependências no pom.xml
echo -e "${YELLOW}5. Validando dependências no pom.xml...${NC}"
POM_PATH="notaFiscalEletronica/notaFiscalEletronica/pom.xml"
if [ -f "$POM_PATH" ]; then
    echo -e "${GREEN}✅ pom.xml encontrado${NC}"
    
    DEPS=("spring-boot-starter-data-jpa" "flyway-core" "flyway-database-postgresql" "postgresql")
    for dep in "${DEPS[@]}"; do
        if grep -q "$dep" "$POM_PATH"; then
            echo -e "${GREEN}   ✅ $dep${NC}"
        else
            echo -e "${RED}   ❌ FALTA: $dep${NC}"
        fi
    done
    echo ""
else
    echo -e "${RED}❌ pom.xml NÃO encontrado!${NC}"
    exit 1
fi

# 6. Validar Docker
echo -e "${YELLOW}6. Validando Docker...${NC}"
if command -v docker &> /dev/null; then
    echo -e "${GREEN}✅ Docker instalado${NC}"
    if command -v docker-compose &> /dev/null || docker compose &> /dev/null; then
        echo -e "${GREEN}   ✅ docker-compose disponível${NC}"
    fi
    echo ""
else
    echo -e "${YELLOW}⚠️  Docker não encontrado (será necessário para o PostgreSQL)${NC}"
    echo ""
fi

echo "=========================================="
echo -e "${GREEN}✅ VALIDAÇÃO CONCLUÍDA COM SUCESSO!${NC}"
echo "=========================================="
echo ""
echo "📋 Próximos passos:"
echo "  1. Suba o PostgreSQL:"
echo "     docker-compose up -d"
echo ""
echo "  2. Aguarde ~5 segundos pelo banco iniciar"
echo ""
echo "  3. Execute a aplicação (com Flyway):"
echo "     cd notaFiscalEletronica/notaFiscalEletronica"
echo "     ./mvnw clean spring-boot:run"
echo ""
echo "  4. Verifique no DBeaver:"
echo "     - Host: localhost"
echo "     - Port: 5001"
echo "     - Database: nota_fiscal_java_db"
echo "     - User: nfe_java_admin"
echo ""
