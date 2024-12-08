# Empório Grão Natural

## 📋 Descrição do Projeto

O **Empório Grão Natural** é um sistema desenvolvido para auxiliar na gestão de operações, como cadastro de produtos, usuários, promoções e vendas, com foco em empresas que comercializam grãos naturais e produtos afins. O projeto combina uma interface gráfica intuitiva, um sistema de banco de dados e funcionalidades robustas para gerenciamento eficiente.

---

## 🚀 Funcionalidades

- **Gerenciamento de Produtos**: Cadastro, atualização e controle de estoque para produtos.
- **Gestão de Promoções**: Inserção de promoções para produtos específicos.
- **Cadastro de Vendas**: Registro de vendas com cálculo automático do total.
- **Cadastro de Usuários**: Possibilidade de criar novos usuários para acesso ao sistema.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Swing**: Criação da interface gráfica.
- **MySQL**: Banco de dados utilizado para persistência de informações.
- **Git**: Controle de versão.

---

## 📂 Estrutura do Projeto

```
/Grao-main
├── src/
│   ├── Model/
│   │   ├── Produto.java           # Classe base para produtos
│   │   ├── Usuario.java           # Classe para gerenciamento de usuários
│   │   ├── Farinaceos.java        # Subclasse de Produto
│   │   ├── Castanha.java          # Subclasse de Produto
│   │   ├── Suplemento.java        # Subclasse de Produto
│   │   └── Tempero.java           # Subclasse de Produto
│   ├── Controller/
│   │   ├── ProdutoController.java # Regras de negócio para produtos
│   │   └── UsuarioController.java # Regras de negócio para usuários
│   ├── View/
│   │   └── EmporioGrainUI.java    # Interface gráfica principal
├── resources/
│   ├── logo.png                   # Logotipo do sistema
│   └── styles.css                 # Estilos de interface (caso aplicável)
├── db/
│   └── script.sql                 # Script para criação do banco de dados
└── README.md                      # Arquivo de documentação
```

---

## 🎨 Arquitetura

O sistema utiliza uma arquitetura em camadas, separando as responsabilidades de modelagem, controle e visualização, conforme o esquema abaixo:

![Arquitetura do Sistema](./resources/arquitetura.png)

---

## 📜 Requisitos de Instalação

1. Certifique-se de ter o **Java 8** ou superior instalado em sua máquina.
2. Configure o **MySQL** e execute o script localizado em `db/script.sql` para criar o banco de dados necessário.
3. Importe o projeto em sua IDE de preferência (ex.: IntelliJ, Eclipse, VS Code com extensão para Java).

---

## 📈 Diagramas do Sistema

### Modelo Conceitual
![Modelo Conceitual](./resources/modelo_conceitual.png)

### Diagramas de Sequência

#### Cadastro de Produtos
![Diagrama de Sequência - Cadastro de Produtos](./resources/diagrama_cadastro_produto.png)

#### Inserção de Promoções
![Diagrama de Sequência - Inserção de Promoções](./resources/diagrama_insercao_promocao.png)

---

## 🧾 Licença

Este projeto é de uso livre para fins acadêmicos e profissionais, respeitando a devida atribuição aos autores.

---

## ✍️ Autores

- **Caique Nogueira Silva**  
  Email: caique-cns@hotmail.com

- **Joyce Gabriella da Silva Mesquita**  
  Email: joycegabriellamesquita@gmail.com  

- **Tiago Garcia do Carmo**  
  Email: tiagogarcia1321@gmail.com  

- **Joao Pedro Sanches**  
  Email: Joao.cervantes@fatec.sp.gov.br

