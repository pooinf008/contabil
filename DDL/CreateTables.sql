CREATE TABLE CONTA(
  nome varchar(250),
  saldo double,
  tipo int
);

CREATE TABLE LANCAMENTO(
  descricao varchar(250),
  valor double,
  nomeCredito varchar(250),
  nomeDebito varchar(250)
);
