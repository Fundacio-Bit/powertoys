create sequence pwt_ear_seq start 1000 increment 1;
create sequence pwt_earinfo_seq start 1000 increment 1;
create sequence pwt_earsimple_seq start 1000 increment 1;
create sequence pwt_fitxer_seq start 1000 increment 1;
create sequence pwt_traduccio_seq start 1000 increment 1;

    create table pwt_ear (
       earid int8 not null,
        fitxerid int8 not null,
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
create index pwt_ear_pk_i on pwt_ear (earid);
create index pwt_ear_fitxerid_fk_i on pwt_ear (fitxerid);
create index pwt_earinfo_pk_i on pwt_earinfo (earinfoid);
create index pwt_earinfo_earid_fk_i on pwt_earinfo (earid);
create index pwt_earsimple_pk_i on pwt_earsimple (earsimpleid);
create index pwt_earsimple_fitxerid_fk_i on pwt_earsimple (fitxerid);
create index pwt_fitxer_pk_i on pwt_fitxer (fitxerid);
create index pwt_idioma_pk_i on pwt_idioma (idiomaid);
create index pwt_traduccio_pk_i on pwt_traduccio (traduccioid);

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

    alter table pwt_traducciomap 
       add constraint pwt_traducmap_traduccio_fk 
       foreign key (traducciomapid) 
       references pwt_traduccio;
