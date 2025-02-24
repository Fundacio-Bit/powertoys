-- create index pwt_aplicacio_pk_i on pwt_aplicacio (aplicacioid);
create index pwt_ear_fitxerid_fk_i on pwt_ear (fitxerid);
create index pwt_earinfo_earid_fk_i on pwt_earinfo (earid);
create index pwt_earsimple_fitxerid_fk_i on pwt_earsimple (fitxerid);
-- create index pwt_entornaplicacio_pk_i on pwt_entornaplicacio (entornaplicacioid);
create index pwt_entornapli_entornid_fk_i on pwt_entornaplicacio (entornid);
-- create index pwt_idioma_pk_i on pwt_idioma (idiomaid);
-- create index pwt_versio_pk_i on pwt_versio (versioid);
