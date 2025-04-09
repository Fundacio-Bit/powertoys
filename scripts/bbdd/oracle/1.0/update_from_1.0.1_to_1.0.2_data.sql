DELETE FROM pwt_versio WHERE entornaplicacioid = 1000;
DELETE FROM pwt_entornaplicacio WHERE entornaplicacioid = 1000;
DELETE FROM pwt_aplicacio WHERE aplicacioid = 1000;
INSERT INTO pwt_aplicacio(aplicacioid, nom, contextpath) VALUES (1010, 'PowerToys', '/powertoysback');
INSERT INTO pwt_entornaplicacio(entornaplicacioid, aplicacioid, entornid) VALUES (1047, 1010, 1000);
INSERT INTO pwt_versio(versioid, entornaplicacioid, versio, build, data, altresdades) VALUES (20173, 1047, '1.0.0', '2025-03-05T08:58:52Z', '2025-04-09T08:58:52Z', NULL);
INSERT INTO pwt_versio(versioid, entornaplicacioid, versio, build, data, altresdades) VALUES (20174, 1047, '1.0.1', '2025-02-24T08:58:52Z', '2025-04-09T08:58:52Z', NULL);
INSERT INTO pwt_versio(versioid, entornaplicacioid, versio, build, data, altresdades) VALUES (20175, 1047, '1.0.2', '2025-04-09T08:58:52Z', '2025-04-09T08:58:52Z', NULL);
