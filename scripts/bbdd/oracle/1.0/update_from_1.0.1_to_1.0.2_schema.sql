-- sequences
create sequence pwt_compilacio_seq start with 1000 increment by  1;
create sequence pwt_repocompilacio_seq start with 1000 increment by  1;

-- tables
    create table pwt_compilacio (
       compilacioid number(19,0) not null,
        datafi timestamp not null,
        datainici timestamp not null,
        exitcode number(5,0) not null,
        output long,
        repocompilacioid number(19,0) not null,
        tagurl varchar2(255 char) not null,
        primary key (compilacioid)
    );
    create table pwt_repocompilacio (
       repocompilacioid number(19,0) not null,
        actiu number(1,0) not null,
        nom varchar2(255 char) not null,
        ordre number(19,0),
        organitzaciogithub varchar2(255 char) not null,
        repositorigithub varchar2(255 char) not null,
        primary key (repocompilacioid)
    );

-- constraints
    alter table pwt_compilacio 
       add constraint pwt_compilacio_repocomp_rid_fk 
       foreign key (repocompilacioid) 
       references pwt_repocompilacio;

-- indexes
create index pwt_compilacio_pk_i on pwt_compilacio (compilacioid);
create index pwt_compilacio_repocompid_fk_i on pwt_compilacio (repocompilacioid);
create index pwt_repocompilacio_pk_i on pwt_repocompilacio (repocompilacioid);
