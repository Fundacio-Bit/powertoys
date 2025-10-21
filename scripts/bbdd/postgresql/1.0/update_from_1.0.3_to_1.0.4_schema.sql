

-- =======================================================================
--  Estudiar si és possible poder compilar productes per JBoss 7.2 i 7.4
--  a la vegada (https://github.com/GovernIB/maven/issues/9)
-- =======================================================================
ALTER TABLE pwt_ear ADD COLUMN jbossversion character varying(50) NOT NULL DEFAULT '7.2.0';
ALTER TABLE pwt_earsimple ADD COLUMN jbossversion character varying(50) NOT NULL DEFAULT '7.2.0';