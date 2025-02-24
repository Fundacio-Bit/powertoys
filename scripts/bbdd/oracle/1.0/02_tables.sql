
    create table pwt_aplicacio (
       aplicacioid number(19,0) not null,
        contextpath varchar2(255 char) not null,
        nom varchar2(255 char) not null
    );

    create table pwt_ear (
       earid number(19,0) not null,
        data timestamp not null,
        fitxerid number(19,0) not null,
        nom varchar2(255 char) not null
    );

    create table pwt_earinfo (
       earinfoid number(19,0) not null,
        earid number(19,0) not null,
        errors clob,
        filename clob not null,
        jbossdeploymentstructure clob,
        potencialcanvidejaramodul clob,
        redhatjarstomodules clob
    );

    create table pwt_earsimple (
       earsimpleid number(19,0) not null,
        data timestamp not null,
        detall clob not null,
        fitxerid number(19,0) not null,
        nom varchar2(255 char) not null
    );

    create table pwt_entorn (
       entornid number(19,0) not null,
        domini varchar2(255 char) not null,
        nom varchar2(100 char) not null,
        ordre number(10,0) default 0 not null
    );

    create table pwt_entornaplicacio (
       entornaplicacioid number(19,0) not null,
        aplicacioid number(19,0) not null,
        entornid number(19,0) not null
    );

    create table pwt_fitxer (
       fitxerid number(19,0) not null,
        descripcio varchar2(1000 char),
        mime varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        tamany number(19,0) not null
    );

    create table pwt_idioma (
       idiomaid varchar2(5 char) not null,
        nom varchar2(50 char) not null,
        ordre number(10,0) default 0 not null,
        suportat number(1,0) not null
    );

    create table pwt_traduccio (
       traduccioid number(19,0) not null
    );

    create table pwt_traducciomap (
       traducciomapid number(19,0) not null,
        valor varchar2(4000 char),
        idiomaid varchar2(255 char) not null
    );

    create table pwt_versio (
       versioid number(19,0) not null,
        altresdades clob,
        build varchar2(100 char),
        data timestamp not null,
        entornaplicacioid number(19,0) not null,
        versio varchar2(100 char) not null
    );



