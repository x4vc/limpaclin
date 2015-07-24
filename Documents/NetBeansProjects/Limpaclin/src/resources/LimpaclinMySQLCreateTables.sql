
CREATE TABLE 'tb_cliente' (
  'id_cliente' int(11) NOT NULL AUTO_INCREMENT,
  'nome_cliente' varchar(100) NOT NULL,
  'sobnome_cliente' varchar(100) DEFAULT NULL,
  PRIMARY KEY ('id_cliente')
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Tabela cliente';

CREATE TABLE 'tb_laudo_paciente_detail' (
  'id_tb_laudo_detail' int(11) NOT NULL AUTO_INCREMENT,
  'id_tb_laudo_master' int(11) NOT NULL,
  'id_tipo_exame' int(11) NOT NULL,
  'nome_tipo_exame' varchar(150) NOT NULL,
  'fator_tipo_exame' decimal(7,2) NOT NULL,
  PRIMARY KEY ('id_tb_laudo_detail')
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela Detail dos Laudos';

CREATE TABLE 'tb_laudo_paciente_master' (
  'id_tb_laudo_master' int(11) NOT NULL AUTO_INCREMENT,
  'id_laudo_paciente' varchar(10) NOT NULL,
  'id_paciente' int(11) NOT NULL,
  'dt_coleta_material' date NOT NULL,
  'valor_total_laudo' decimal(7,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY ('id_tb_laudo_master'),
  KEY 'id_paciente_idx' ('id_paciente'),
  CONSTRAINT 'id_paciente' FOREIGN KEY ('id_paciente') REFERENCES 'tb_paciente' ('id_paciente') ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela Master dos Laudos';

CREATE TABLE 'tb_paciente' (
  'id_paciente' int(11) NOT NULL AUTO_INCREMENT,
  'nome_paciente' varchar(100) NOT NULL,
  'dt_nascimento_paciente' date DEFAULT NULL,
  'sexo_paciente' varchar(1) DEFAULT NULL,
  'rg_paciente' varchar(20) DEFAULT NULL,
  'CPF_paciente' varchar(14) DEFAULT NULL,
  PRIMARY KEY ('id_paciente')
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE 'tb_tipo_exame' (
  'id_tipo_exame' int(11) NOT NULL AUTO_INCREMENT,
  'nome_tipo_exame' varchar(150) NOT NULL,
  'fator_tipo_exame' decimal(7,2) NOT NULL DEFAULT '0.00',
  'tipo_exame_ativo' varchar(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY ('id_tipo_exame')
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

CREATE TABLE 'tb_username' (
  'id_username' int(11) NOT NULL AUTO_INCREMENT,
  'nome_usuario' varchar(45) NOT NULL,
  'senha' varchar(45) NOT NULL,
  PRIMARY KEY ('id_username')
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabela de usuários';

CREATE TABLE 'pessoas' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'email' varchar(255) DEFAULT NULL,
  'nome' varchar(255) DEFAULT NULL,
  'telefone' varchar(255) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

