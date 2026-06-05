

-- =======================================================================
--  Estudiar si és possible poder compilar productes per JBoss 7.2 i 7.4
--  a la vegada (https://github.com/GovernIB/maven/issues/9)
-- =======================================================================
ALTER TABLE pwt_ear ADD jbossversion varchar2(50) DEFAULT '7.2.0' NOT NULL;
ALTER TABLE pwt_earsimple ADD jbossversion varchar2(50) DEFAULT '7.2.0' NOT NULL;