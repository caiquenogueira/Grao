create database bdProjetoModelo

use bdProjetoModelo

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
        ON DELETE CASCADE 
        ON UPDATE CASCADE
);

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL
);

CREATE TABLE Estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    localizacao VARCHAR(255) NOT NULL
);

CREATE TABLE Contem (
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade > 0),
    preco DECIMAL(10, 2) NOT NULL CHECK (preco >= 0),
    PRIMARY KEY (pedido_id, produto_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
        ON DELETE CASCADE 
        ON UPDATE CASCADE
);

ALTER TABLE Pedido
ADD CONSTRAINT fk_pedido_usuario
FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Contem
ADD CONSTRAINT fk_contem_pedido
FOREIGN KEY (pedido_id) REFERENCES Pedido(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Contem
ADD CONSTRAINT fk_contem_produto
FOREIGN KEY (produto_id) REFERENCES Produto(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

INSERT INTO Usuario (id, nome, cpf, senha) VALUES
(1, 'João Silva', '123.456.789-01', 'senha123'),
(2, 'Maria Oliveira', '987.654.321-02', 'senha456'),
(3, 'Carlos Santos', '456.123.789-03', 'senha789'),
(4, 'Ana Costa', '789.456.123-04', 'senhaabc'),
(5, 'Lucas Souza', '321.654.987-05', 'senha123'),
(6, 'Fernanda Lima', '654.789.321-06', 'senha456'),
(7, 'Paulo Ribeiro', '963.852.741-07', 'senha789'),
(8, 'Carolina Martins', '741.852.963-08', 'senhaabc'),
(9, 'Roberto Gomes', '852.741.963-09', 'senha123'),
(10, 'Juliana Alves', '159.357.258-10', 'senha456');

INSERT INTO Produto (nome, preco, estoque) VALUES
('Amêndoa torrada', 9.90, 100),
('Castanha de caju', 98.90, 200),
('Semente de urucum', 98.90, 150),
('Mostarda em grãos', 98.90, 50),
('Semente de chia', 98.90, 300),
('Castanha do pará', 98.90, 180),
('Granola', 98.90, 120),
('Lentilha', 98.90, 250),
('Aveia flocos finos', 98.90, 90),
('Guaraná em pó', 98.90, 60);

INSERT INTO Estoque (status, localizacao) VALUES
('Disponível', 'Armazém A'),
('Disponível', 'Armazém B'),
('Baixo', 'Armazém C'),
('Disponível', 'Armazém D'),
('Indisponível', 'Armazém E'),
('Disponível', 'Armazém F'),
('Baixo', 'Armazém G'),
('Disponível', 'Armazém H'),
('Indisponível', 'Armazém I'),
('Disponível', 'Armazém J');

INSERT INTO Pedido (data, status, usuario_id) VALUES
('2024-12-01', 'Pendente', 1),
('2024-12-02', 'Enviado', 2),
('2024-12-03', 'Entregue', 3),
('2024-12-04', 'Cancelado', 4),
('2024-12-05', 'Pendente', 5),
('2024-12-06', 'Enviado', 6),
('2024-12-07', 'Entregue', 7),
('2024-12-08', 'Pendente', 8),
('2024-12-09', 'Enviado', 9),
('2024-12-10', 'Entregue', 10);

INSERT INTO Contem (pedido_id, produto_id, quantidade, preco) VALUES
(1, 1, 2, 21.00),
(1, 2, 3, 26.70),
(2, 3, 1, 4.50),
(2, 4, 2, 51.80),
(3, 5, 4, 12.00),
(3, 6, 3, 15.60),
(4, 7, 2, 30.60),
(4, 8, 1, 4.80),
(5, 9, 5, 33.50),
(5, 10, 2, 15.00);
