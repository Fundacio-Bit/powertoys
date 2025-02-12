

CREATE SEQUENCE pwt_fitxer_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;
CREATE SEQUENCE pwt_traduccio_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;

CREATE TABLE pwt_fitxer (
    fitxerid bigint DEFAULT nextval('pwt_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);

CREATE TABLE pwt_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);

CREATE TABLE pwt_traduccio (
    traduccioid bigint DEFAULT nextval('pwt_traduccio_seq'::regclass) NOT NULL
);

CREATE TABLE pwt_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);

ALTER TABLE ONLY pwt_fitxer
    ADD CONSTRAINT pwt_fitxer_pk PRIMARY KEY (fitxerid);

ALTER TABLE ONLY pwt_idioma
    ADD CONSTRAINT pwt_idioma_pk PRIMARY KEY (idiomaid);

ALTER TABLE ONLY pwt_traduccio
    ADD CONSTRAINT pwt_traduccio_pk PRIMARY KEY (traduccioid);

ALTER TABLE ONLY pwt_traducciomap
    ADD CONSTRAINT pwt_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);

CREATE INDEX pwt_fitxer_pk_i ON pwt_fitxer USING btree (fitxerid);

CREATE INDEX pwt_idioma_pk_i ON pwt_idioma USING btree (idiomaid);

CREATE INDEX pwt_traduccio_pk_i ON pwt_traduccio USING btree (traduccioid);

CREATE INDEX pwt_traducciomap_idiomaid_fk_i ON pwt_traducciomap USING btree (idiomaid);

CREATE INDEX pwt_traducciomap_pk_i ON pwt_traducciomap USING btree (traducciomapid);

ALTER TABLE ONLY pwt_traducciomap
    ADD CONSTRAINT pwt_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES pwt_traduccio(traduccioid);

INSERT INTO pwt_idioma(idiomaid, nom, ordre) VALUES ('ca', 'Català', 0);
INSERT INTO pwt_idioma(idiomaid, nom, ordre) VALUES ('es', 'Castellano', 1);
INSERT INTO pwt_idioma(idiomaid, nom, ordre) VALUES ('en', 'English', 2);
    
    
