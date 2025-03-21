create sequence pwt_aplicacio_seq start 1000 increment 1;
create sequence pwt_ear_seq start 1000 increment 1;
create sequence pwt_earinfo_seq start 1000 increment 1;
create sequence pwt_earsimple_seq start 1000 increment 1;
create sequence pwt_entorn_seq start 1000 increment 1;
create sequence pwt_entornaplicacio_seq start 1000 increment 1;
create sequence pwt_fitxer_seq start 1000 increment 1;
create sequence pwt_traduccio_seq start 1000 increment 1;
create sequence pwt_versio_seq start 1000 increment 1;

    create table pwt_aplicacio (
       aplicacioid int8 not null,
        contextpath varchar(255) not null,
        nom varchar(255) not null,
        primary key (aplicacioid)
    );

    create table pwt_ear (
       earid int8 not null,
        data timestamp not null,
        fitxerid int8 not null,
        nom varchar(255) not null,
        primary key (earid)
    );

    create table pwt_earinfo (
       earinfoid int8 not null,
        earid int8 not null,
        errors text,
        filename text not null,
        jbossdeploymentstructure text,
        potencialcanvidejaramodul text,
        redhatjarstomodules text,
        primary key (earinfoid)
    );

    create table pwt_earsimple (
       earsimpleid int8 not null,
        data timestamp not null,
        detall text not null,
        fitxerid int8 not null,
        nom varchar(255) not null,
        primary key (earsimpleid)
    );

    create table pwt_entorn (
       entornid int8 not null,
        domini varchar(255) not null,
        nom varchar(100) not null,
        ordre int4 default 0 not null,
        primary key (entornid)
    );

    create table pwt_entornaplicacio (
       entornaplicacioid int8 not null,
        aplicacioid int8 not null,
        entornid int8 not null,
        primary key (entornaplicacioid)
    );

    create table pwt_fitxer (
       fitxerid int8 not null,
        descripcio varchar(1000),
        mime varchar(255) not null,
        nom varchar(255) not null,
        tamany int8 not null,
        primary key (fitxerid)
    );

    create table pwt_idioma (
       idiomaid varchar(5) not null,
        nom varchar(50) not null,
        ordre int4 default 0 not null,
        suportat boolean not null,
        primary key (idiomaid)
    );

    create table pwt_traduccio (
       traduccioid int8 not null,
        primary key (traduccioid)
    );

    create table pwt_traducciomap (
       traducciomapid int8 not null,
        valor varchar(4000),
        idiomaid varchar(255) not null,
        primary key (traducciomapid, idiomaid)
    );

    create table pwt_versio (
       versioid int8 not null,
        altresdades varchar(4096),
        build varchar(100),
        data timestamp not null,
        entornaplicacioid int8 not null,
        versio varchar(100) not null,
        primary key (versioid)
    );
create index pwt_aplicacio_pk_i on pwt_aplicacio (aplicacioid);
create index pwt_ear_pk_i on pwt_ear (earid);
create index pwt_ear_fitxerid_fk_i on pwt_ear (fitxerid);
create index pwt_earinfo_pk_i on pwt_earinfo (earinfoid);
create index pwt_earinfo_earid_fk_i on pwt_earinfo (earid);
create index pwt_earsimple_pk_i on pwt_earsimple (earsimpleid);
create index pwt_earsimple_fitxerid_fk_i on pwt_earsimple (fitxerid);
create index pwt_entorn_pk_i on pwt_entorn (entornid);
create index pwt_entornaplicacio_pk_i on pwt_entornaplicacio (entornaplicacioid);
create index pwt_entornapli_aplica_fk_i on pwt_entornaplicacio (aplicacioid);
create index pwt_entornapli_entornid_fk_i on pwt_entornaplicacio (entornid);

    alter table pwt_entornaplicacio 
       add constraint pwt_entornapli_entorn_apli_uk unique (aplicacioid, entornid);
create index pwt_fitxer_pk_i on pwt_fitxer (fitxerid);
create index pwt_idioma_pk_i on pwt_idioma (idiomaid);
create index pwt_traduccio_pk_i on pwt_traduccio (traduccioid);
create index pwt_versio_pk_i on pwt_versio (versioid);
create index pwt_versio_entornapli_fk_i on pwt_versio (entornaplicacioid);

    alter table pwt_ear 
       add constraint pwt_ear_fitxer_fk 
       foreign key (fitxerid) 
       references pwt_fitxer;

    alter table pwt_earinfo 
       add constraint pwt_earinfo_ear_fk 
       foreign key (earid) 
       references pwt_ear;

    alter table pwt_earsimple 
       add constraint pwt_earsimple_fitxer_fk 
       foreign key (fitxerid) 
       references pwt_fitxer;

    alter table pwt_entornaplicacio 
       add constraint pwt_entornapli_aplicacio_fk 
       foreign key (aplicacioid) 
       references pwt_aplicacio;

    alter table pwt_entornaplicacio 
       add constraint pwt_entornapli_entorn_entor_fk 
       foreign key (entornid) 
       references pwt_entorn;

    alter table pwt_traducciomap 
       add constraint pwt_traducmap_traduccio_fk 
       foreign key (traducciomapid) 
       references pwt_traduccio;

    alter table pwt_versio 
       add constraint pwt_versio_entornapli_fk 
       foreign key (entornaplicacioid) 
       references pwt_entornaplicacio;



-----------------------------------------------------------------------------
-- compilador nocturn (v1.0.2)
-----------------------------------------------------------------------------

create sequence pwt_repocompilacio_seq start 1000 increment 1;
create sequence pwt_compilacio_seq start 1000 increment 1;


-- public.pwt_repocompilacio definition

    create table pwt_repocompilacio (
       repocompilacioid int8 default nextval('pwt_repocompilacio_seq'::regclass) not null,
        nom varchar(255) not null,
        organitzaciogithub varchar(255) not null,
        repositorigithub varchar(255) not null,
        ordre int8,
        actiu boolean not null,
        constraint pwt_repocompilacio_pk primary key (repocompilacioid)
    );
create index pwt_repocompilacio_pk_i on pwt_repocompilacio (repocompilacioid);


-- public.pwt_compilacio definition

    create table pwt_compilacio (
       compilacioid int8 default nextval('pwt_compilacio_seq'::regclass) not null,
        repocompilacioid int8 not null,
        tagurl varchar(255) not null,
        datainici timestamp not null,
        datafi timestamp,
        exitcode int2,
        output text,
        constraint pwt_compilacio_pk primary key (compilacioid)
    );
create index pwt_compilacio_pk_i on pwt_compilacio (compilacioid);
create index pwt_compilacio_repocompid_fk_i on pwt_compilacio (repocompilacioid);


-- pwt_compilacio foreign keys

    alter table pwt_compilacio 
       add constraint pwt_compilacio_repocomp_rid_fk 
       foreign key (repocompilacioid) 
       references pwt_repocompilacio(repocompilacioid);
