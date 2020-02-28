DROP DATABASE IF EXISTS swerts_db;

CREATE DATABASE swerts_db;

USE swerts_db;

CREATE TABLE IF NOT EXISTS usuario(
	nome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    sexo VARCHAR(9) NOT NULL,
    data_de_nascimento VARCHAR(10) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(45) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL,
    rua VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(45),
    cep VARCHAR(9) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    estado VARCHAR(45) NOT NULL,
    PRIMARY KEY(cpf, email)
);

CREATE TABLE produto(
	codigo INT NOT NULL PRIMARY KEY,
    tipo VARCHAR(45) NOT NULL,
    preco FLOAT NOT NULL,
    marca VARCHAR(45) NOT NULL,
    modelo VARCHAR(45) NOT NULL,
    cor VARCHAR(45) NOT NULL,
    titulo VARCHAR(1000) NOT NULL,
    quantidade INT NOT NULL,
    imagem LONGBLOB NOT NULL
);

CREATE TABLE carrinho(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email_usuario VARCHAR(45) NOT NULL UNIQUE,
    CONSTRAINT fk_carrinho_usuario FOREIGN KEY (email_usuario) REFERENCES usuario(email) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);

CREATE TABLE carrinho_has_produto(
	email_usuario VARCHAR(45) NOT NULL,
    codigo_produto INT NOT NULL,
    quantidade INT NOT NULL,
    CONSTRAINT fk_carrinho_produto1 FOREIGN KEY (codigo_produto) REFERENCES produto(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_carrinho_produto2 FOREIGN KEY (email_usuario) REFERENCES carrinho(email_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE compras(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    codigo INT NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    preco FLOAT NOT NULL,
    marca VARCHAR(45) NOT NULL,
    modelo VARCHAR(45) NOT NULL,
    cor VARCHAR(45) NOT NULL,
    titulo VARCHAR(1000) NOT NULL,
    quantidade INT NOT NULL,
    imagem LONGBLOB NOT NULL,
    data_compra VARCHAR(45),
    email_usuario VARCHAR(45) NOT NULL,
    CONSTRAINT fk_compras_usuario FOREIGN KEY (email_usuario) REFERENCES usuario(email) ON DELETE CASCADE
);

#Store Procedure para verificar se o usuario ja adicionou um determinado produto ao seu carrinho
DELIMITER $$
DROP PROCEDURE IF EXISTS verificaProduto $$
CREATE PROCEDURE verificaProduto (IN codigo INT, IN email VARCHAR(45), OUT resposta INT)
BEGIN
	DECLARE aux INT;

    SELECT codigo_produto INTO aux FROM carrinho_has_produto WHERE email_usuario = email && codigo_produto = codigo;
    
    IF aux IS NULL THEN SET resposta = 0;
		ELSE SET resposta = 1;
	END IF;
END $$
DELIMITER ;

#Store Procedure para verificar se o preço do produto comprado é igual ao preço do produto disponivel
DELIMITER $$
DROP PROCEDURE IF EXISTS verificaQuantidadeCompra $$
CREATE PROCEDURE verificaQuantidadeCompra(IN codigo_produto INT, IN quantidade_compra INT)
BEGIN 
	DECLARE quantidade_produto INT;

    SELECT quantidade INTO quantidade_produto FROM produto WHERE codigo = codigo_produto;
    
    IF quantidade_produto = quantidade_compra
		THEN
			DELETE FROM produto WHERE codigo = codigo_produto;
		ELSE
			UPDATE produto SET quantidade = quantidade_produto - quantidade_compra WHERE codigo = codigo_produto;
	END IF;
END $$
DELIMITER ;

SELECT * FROM produto;
SELECT * FROM usuario;;
SELECT *  FROM carrinho;
SELECT * FROM carrinho_has_produto;
SELECT * FROM compras;

CREATE VIEW produtos_carrinho AS (SELECT produto.*, carrinho_has_produto.quantidade AS quantidadeCarrinho FROM carrinho_has_produto
INNER JOIN produto ON carrinho_has_produto.codigo_produto = produto.codigo AND carrinho_has_produto.email_usuario =  'alexanderaugusto@gec.inate.br');
SELECT * FROM produtos_carrinho;

CREATE VIEW busca_compras AS (SELECT compras.*, usuario.nome AS nome_usuario FROM compras, usuario 
WHERE usuario.email = compras.email_usuario ORDER BY compras.data_compra DESC);
SELECT * FROM busca_compras;


			

                
		