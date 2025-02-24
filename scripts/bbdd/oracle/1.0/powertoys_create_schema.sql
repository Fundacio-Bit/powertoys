create sequence pwt_aplicacio_seq start with 1000 increment by  1;
create sequence pwt_ear_seq start with 1000 increment by  1;
create sequence pwt_earinfo_seq start with 1000 increment by  1;
create sequence pwt_earsimple_seq start with 1000 increment by  1;
create sequence pwt_entorn_seq start with 1000 increment by  1;
create sequence pwt_entornaplicacio_seq start with 1000 increment by  1;
create sequence pwt_fitxer_seq start with 1000 increment by  1;
create sequence pwt_traduccio_seq start with 1000 increment by  1;
create sequence pwt_versio_seq start with 1000 increment by  1;

    create table pwt_aplicacio (
       aplicacioid number(19,0) not null,
        contextpath varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        primary key (aplicacioid)
    );

    create table pwt_ear (
       earid number(19,0) not null,
        data timestamp not null,
        fitxerid number(19,0) not null,
        nom varchar2(255 char) not null,
        primary key (earid)
    );

    create table pwt_earinfo (
       earinfoid number(19,0) not null,
        earid number(19,0) not null,
        errors long,
        filename long not null,
        jbossdeploymentstructure long,
        potencialcanvidejaramodul long,
        redhatjarstomodules long,
        primary key (earinfoid)
    );

    create table pwt_earsimple (
       earsimpleid number(19,0) not null,
        data timestamp not null,
        detall long not null,
        fitxerid number(19,0) not null,
        nom varchar2(255 char) not null,
        primary key (earsimpleid)
    );

    create table pwt_entorn (
       entornid number(19,0) not null,
        domini varchar2(255 char) not null,
        nom varchar2(100 char) not null,
        ordre number(10,0) default 0 not null,
        primary key (entornid)
    );

    create table pwt_entornaplicacio (
       entornaplicacioid number(19,0) not null,
        aplicacioid number(19,0) not null,
        entornid number(19,0) not null,
        primary key (entornaplicacioid)
    );

    create table pwt_fitxer (
       fitxerid number(19,0) not null,
        descripcio varchar2(1000 char),
        mime varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        tamany number(19,0) not null,
        primary key (fitxerid)
    );

    create table pwt_idioma (
       idiomaid varchar2(5 char) not null,
        nom varchar2(50 char) not null,
        ordre number(10,0) default 0 not null,
        suportat number(1,0) not null,
        primary key (idiomaid)
    );

    create table pwt_traduccio (
       traduccioid number(19,0) not null,
        primary key (traduccioid)
    );

    create table pwt_traducciomap (
       traducciomapid number(19,0) not null,
        valor varchar2(4000 char),
        idiomaid varchar2(255 char) not null,
        primary key (traducciomapid, idiomaid)
    );

    create table pwt_versio (
       versioid number(19,0) not null,
        altresdades long,
        build varchar2(100 char),
        data timestamp not null,
        entornaplicacioid number(19,0) not null,
        versio varchar2(100 char) not null,
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
