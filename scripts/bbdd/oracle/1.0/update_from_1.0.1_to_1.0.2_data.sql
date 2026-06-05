DELETE FROM pwt_versio WHERE entornaplicacioid = 1000;
DELETE FROM pwt_entornaplicacio WHERE entornaplicacioid = 1000;
DELETE FROM pwt_aplicacio WHERE aplicacioid = 1000;
INSERT INTO pwt_aplicacio(aplicacioid, nom, contextpath) VALUES (1010, 'PowerToys', '/powertoysback');
INSERT INTO pwt_entornaplicacio(entornaplicacioid, aplicacioid, entornid) VALUES (1047, 1010, 1000);
