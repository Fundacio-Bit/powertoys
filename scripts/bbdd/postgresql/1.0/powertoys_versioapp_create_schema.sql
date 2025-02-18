--
-- Name: pwt_aplicacio_seq; Type: SEQUENCE; Schema: public; Owner: powertoys
--

CREATE SEQUENCE pwt_aplicacio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: pwt_aplicacio; Type: TABLE; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE TABLE pwt_aplicacio (
    aplicacioid bigint DEFAULT nextval('pwt_aplicacio_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    contextpath character varying(255) NOT NULL
);


--
-- Name: pwt_entorn_seq; Type: SEQUENCE; Schema: public; Owner: powertoys
--

CREATE SEQUENCE pwt_entorn_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: pwt_entorn; Type: TABLE; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE TABLE pwt_entorn (
    entornid bigint DEFAULT nextval('pwt_entorn_seq'::regclass) NOT NULL,
    nom character varying(100) NOT NULL,
    domini character varying(255) NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


--
-- Name: pwt_entornaplicacio_seq; Type: SEQUENCE; Schema: public; Owner: powertoys
--

CREATE SEQUENCE pwt_entornaplicacio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: pwt_entornaplicacio; Type: TABLE; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE TABLE pwt_entornaplicacio (
    entornaplicacioid bigint DEFAULT nextval('pwt_entornaplicacio_seq'::regclass) NOT NULL,
    aplicacioid bigint NOT NULL,
    entornid bigint NOT NULL
);


--
-- Name: pwt_versio_seq; Type: SEQUENCE; Schema: public; Owner: powertoys
--

CREATE SEQUENCE pwt_versio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: pwt_versio; Type: TABLE; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE TABLE pwt_versio (
    versioid bigint DEFAULT nextval('pwt_versio_seq'::regclass) NOT NULL,
    entornaplicacioid bigint NOT NULL,
    versio character varying(100) NOT NULL,
    build character varying(100),
    data timestamp without time zone NOT NULL,
    altresdades character varying(4096)
);


--
-- Name: pwt_aplicacio_pk; Type: CONSTRAINT; Schema: public; Owner: powertoys; Tablespace: 
--

ALTER TABLE ONLY pwt_aplicacio
    ADD CONSTRAINT pwt_aplicacio_pk PRIMARY KEY (aplicacioid);


--
-- Name: pwt_entorn_pk; Type: CONSTRAINT; Schema: public; Owner: powertoys; Tablespace: 
--

ALTER TABLE ONLY pwt_entorn
    ADD CONSTRAINT pwt_entorn_pk PRIMARY KEY (entornid);


--
-- Name: pwt_entornapli_entorn_apli_uk; Type: CONSTRAINT; Schema: public; Owner: powertoys; Tablespace: 
--

ALTER TABLE ONLY pwt_entornaplicacio
    ADD CONSTRAINT pwt_entornapli_entorn_apli_uk UNIQUE (aplicacioid, entornid);


--
-- Name: pwt_entornaplicacio_pk; Type: CONSTRAINT; Schema: public; Owner: powertoys; Tablespace: 
--

ALTER TABLE ONLY pwt_entornaplicacio
    ADD CONSTRAINT pwt_entornaplicacio_pk PRIMARY KEY (entornaplicacioid);


--
-- Name: pwt_versio_pk; Type: CONSTRAINT; Schema: public; Owner: powertoys; Tablespace: 
--

ALTER TABLE ONLY pwt_versio
    ADD CONSTRAINT pwt_versio_pk PRIMARY KEY (versioid);


--
-- Name: pwt_aplicacio_pk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_aplicacio_pk_i ON pwt_aplicacio USING btree (aplicacioid);


--
-- Name: pwt_entorn_pk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_entorn_pk_i ON pwt_entorn USING btree (entornid);


--
-- Name: pwt_entornapli_aplica_fk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_entornapli_aplica_fk_i ON pwt_entornaplicacio USING btree (aplicacioid);


--
-- Name: pwt_entornapli_entornid_fk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_entornapli_entornid_fk_i ON pwt_entornaplicacio USING btree (entornid);


--
-- Name: pwt_entornaplicacio_pk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_entornaplicacio_pk_i ON pwt_entornaplicacio USING btree (entornaplicacioid);


--
-- Name: pwt_versio_entornapli_fk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_versio_entornapli_fk_i ON pwt_versio USING btree (entornaplicacioid);


--
-- Name: pwt_versio_pk_i; Type: INDEX; Schema: public; Owner: powertoys; Tablespace: 
--

CREATE INDEX pwt_versio_pk_i ON pwt_versio USING btree (versioid);


--
-- Name: pwt_entornapli_aplicacio_fk; Type: FK CONSTRAINT; Schema: public; Owner: powertoys
--

ALTER TABLE ONLY pwt_entornaplicacio
    ADD CONSTRAINT pwt_entornapli_aplicacio_fk FOREIGN KEY (aplicacioid) REFERENCES pwt_aplicacio(aplicacioid);


--
-- Name: pwt_entornapli_entorn_entor_fk; Type: FK CONSTRAINT; Schema: public; Owner: powertoys
--

ALTER TABLE ONLY pwt_entornaplicacio
    ADD CONSTRAINT pwt_entornapli_entorn_entor_fk FOREIGN KEY (entornid) REFERENCES pwt_entorn(entornid);


--
-- Name: pwt_versio_entornapli_fk; Type: FK CONSTRAINT; Schema: public; Owner: powertoys
--

ALTER TABLE ONLY pwt_versio
    ADD CONSTRAINT pwt_versio_entornapli_fk FOREIGN KEY (entornaplicacioid) REFERENCES pwt_entornaplicacio(entornaplicacioid);
