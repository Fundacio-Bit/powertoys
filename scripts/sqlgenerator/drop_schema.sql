
    alter table pwt_ear 
       drop constraint pwt_ear_fitxer_fk;

    alter table pwt_earinfo 
       drop constraint pwt_earinfo_ear_fk;

    alter table pwt_earsimple 
       drop constraint pwt_earsimple_fitxer_fk;

    alter table pwt_traducciomap 
       drop constraint pwt_traducmap_traduccio_fk;

    drop table if exists pwt_ear cascade;

    drop table if exists pwt_earinfo cascade;

    drop table if exists pwt_earsimple cascade;

    drop table if exists pwt_fitxer cascade;

    drop table if exists pwt_idioma cascade;

    drop table if exists pwt_traduccio cascade;

    drop table if exists pwt_traducciomap cascade;

    drop sequence if exists pwt_ear_seq;

    drop sequence if exists pwt_earinfo_seq;

    drop sequence if exists pwt_earsimple_seq;

    drop sequence if exists pwt_fitxer_seq;

    drop sequence if exists pwt_traduccio_seq;
