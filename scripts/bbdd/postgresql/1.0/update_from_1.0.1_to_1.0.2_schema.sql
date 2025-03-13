create sequence pwt_repocompilacio_seq start 1000 increment 1;
create sequence pwt_compilacio_seq start 1000 increment 1;

    create table pwt_repocompilacio (
       repocompilacioid int8 not null,
        nom varchar(255) not null,
        organitzaciogithub varchar(255) not null,
        repositorigithub varchar(255) not null,
        ordre int8,
        deshabilitat boolean not null,
        primary key (repocompilacioid)
    );

    create table pwt_compilacio (
       compilacioid int8 not null,
        repocompilacioid int8 not null,
        tagurl varchar(255) not null,
        datainici timestamp not null,
        datafi timestamp not null,
        exitcode int2 not null,
        output text,
        primary key (compilacioid)
    );
create index pwt_repocompilacio_pk_i on pwt_repocompilacio (repocompilacioid);
create index pwt_compilacio_pk_i on pwt_compilacio (compilacioid);

    alter table pwt_compilacio 
       add constraint pwt_compilacio_repocompilacio_fk 
       foreign key (repocompilacioid) 
       references pwt_repocompilacio;
