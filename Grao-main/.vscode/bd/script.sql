create database bdProjetoModelo

use bdProjetoModelo

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(14) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(10) NOT NULL
);

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL
);

CREATE TABLE ItemPedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

CREATE TABLE Estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    localizacao VARCHAR(255) NOT NULL
);

CREATE TABLE Armazena (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estoque_id INT NOT NULL,
    produto_id INT NOT NULL,
    FOREIGN KEY (estoque_id) REFERENCES Estoque(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

ALTER TABLE Pedido
ADD CONSTRAINT FK_Pedido_Usuario FOREIGN KEY (usuario_id) REFERENCES Usuario(id);

ALTER TABLE ItemPedido
ADD CONSTRAINT FK_ItemPedido_Pedido FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
ADD CONSTRAINT FK_ItemPedido_Produto FOREIGN KEY (produto_id) REFERENCES Produto(id);

ALTER TABLE Armazena
ADD CONSTRAINT FK_Armazena_Estoque FOREIGN KEY (estoque_id) REFERENCES Estoque(id),
ADD CONSTRAINT FK_Armazena_Produto FOREIGN KEY (produto_id) REFERENCES Produto(id);

INSERT INTO Usuario (id, nome, cpf, email, senha) VALUES
(1, 'João Silva', '123.456.789-01', 'joao@gmail.com', 'senha123'),
(2, 'Maria Oliveira', '987.654.321-09', 'maria@hotmail.com', 'maria123'),
(3, 'Pedro Santos', '456.789.123-11', 'pedro@yahoo.com', 'pedro456'),
(4, 'Ana Costa', '321.654.987-22', 'ana@gmail.com', 'ana456'),
(5, 'Lucas Lima', '111.222.333-44', 'lucas@hotmail.com', 'lucas789'),
(6, 'Carla Almeida', '555.666.777-55', 'carla@gmail.com', 'carla101'),
(7, 'Tiago Mendes', '888.999.000-66', 'tiago@yahoo.com', 'tiago202'),
(8, 'Paula Souza', '123.123.123-77', 'paula@hotmail.com', 'paula303'),
(9, 'Bruno Rocha', '987.987.987-88', 'bruno@gmail.com', 'bruno404'),
(10, 'Camila Ramos', '654.321.987-99', 'camila@yahoo.com', 'camila505');

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

INSERT INTO Estoque (data, status, localizacao) VALUES
('2024-12-01', 'Disponível', 'A1'),
('2024-12-02', 'Disponível', 'B1'),
('2024-12-03', 'Em Reposição', 'C1'),
('2024-12-04', 'Disponível', 'D1'),
('2024-12-05', 'Em Reposição', 'E1'),
('2024-12-06', 'Disponível', 'F1'),
('2024-12-07', 'Disponível', 'G1'),
('2024-12-08', 'Disponível', 'H1'),
('2024-12-09', 'Em Reposição', 'I1'),
('2024-12-10', 'Disponível', 'J1');

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

INSERT INTO ItemPedido (pedido_id, produto_id, quantidade, preco) VALUES
(1, 1, 1, 3500.00),
(2, 2, 2, 100.00),
(3, 3, 1, 120.00),
(4, 4, 1, 800.00),
(5, 5, 2, 1200.00),
(6, 6, 1, 150.00),
(7, 7, 1, 200.00),
(8, 8, 5, 150.00),
(9, 9, 1, 900.00),
(10, 10, 1, 450.00); 

INSERT INTO Armazena (estoque_id, produto_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
