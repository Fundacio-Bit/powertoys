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
