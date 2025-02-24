
 -- INICI PKs
    alter table pwt_aplicacio add constraint pwt_aplicacio_pk primary key (aplicacioid);

    alter table pwt_ear add constraint pwt_ear_pk primary key (earid);

    alter table pwt_earinfo add constraint pwt_earinfo_pk primary key (earinfoid);

    alter table pwt_earsimple add constraint pwt_earsimple_pk primary key (earsimpleid);

    alter table pwt_entorn add constraint pwt_entorn_pk primary key (entornid);

    alter table pwt_entornaplicacio add constraint pwt_entornaplicacio_pk primary key (entornaplicacioid);

    alter table pwt_fitxer add constraint pwt_fitxer_pk primary key (fitxerid);

    alter table pwt_idioma add constraint pwt_idioma_pk primary key (idiomaid);

    alter table pwt_traduccio add constraint pwt_traduccio_pk primary key (traduccioid);

    alter table pwt_traducciomap add constraint pwt_traducmap_pk primary key (traducciomapid, idiomaid);

    alter table pwt_versio add constraint pwt_versio_pk primary key (versioid);

 -- FINAL PKs


 -- INICI FKs

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
 -- FINAL FKs


 -- INICI UNIQUEs

    alter table pwt_entornaplicacio 
       add constraint pwt_entornapli_entorn_apli_uk unique (aplicacioid, entornid);
 -- FINAL UNIQUEs

