# 📊 Relatório de Produtos

O sistema lê um arquivo `.txt` contendo os produtos no seguinte formato:   

Nome do produto, preço, categoria, estoque(true ou false)

E gera relatório `.txt` com o filtro especificado.

---

## 🚀 Tecnologias Utilizadas
- Java 17+  
- Streams API  
- Lambda Expressions  
- Enums  
- Programação Orientada a Objetos (POO)
- Tratamento de Exceções

---

## 📂 Estrutura do Projeto

```bash
/src
 ├── application/
 │   └── Program.java                 # Classe principal
 │
 ├── model/
 │   ├── entities/
 │   │   └── Produto.java             # Entidade Produto
 │   ├── enums/
 │   │   └── Categoria.java           # Enum de categorias de produtos
 │
 ├── service/
 │   ├── ExportadorDeProdutos.java    # Exportação de relatórios
 │   └── FiltroProdutoService.java    # Filtros com Streams e Lambdas
 │
 └── utils/
     ├── ArquivoProdutoReader.java    # Leitura de dados
     └── ArquivoProdutoWriter.java    # Escrita de dados 
