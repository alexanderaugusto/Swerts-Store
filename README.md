# Swerts-Store

<h4> O Swerts Store é um projeto desenvolvido para as disciplinas de Programaçao Orientada a Objetos (Java) e Banco de Dados (MySQL) da graduação, ele se resume em uma loja virtual, com aspectos parecidos com qualquer site de compras, porém tudo isso em um software. Deixo aqui todo código do projeto, para aproveitamento, utilização ou feedbacks. Abaixo segue algumas instruções básicas de configurações para utilização: </h4>

* Login de admistrador para visualizar estoque e cadastrar produtos: <br>
  > usuario: admin  
  > senha: admin 

* O banco de dados está configurado em: "localhost:3306", usuario: "root" e senha: "root". Caso o MySQL instalado em sua máquina tenha configurações diferentes, será necessário mudar alguns dados na classe connection do pacote controller: <br>
  > private String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false"; <br>
  > private String user = "root"; <br>
  > private String password = "root";
  
OBS: Sem configurar o Banco de Dados e rodar o arquivo swerts_db.sql o projeto não irá funcionar da maneira esperada. Caso possua alguma dúvida, sugestão ou crítica entre em contato pelo meu email ;)


alexaasf_10@hotmail.com


