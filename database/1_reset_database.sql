-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA suvepidu CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA suvepidu
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA suvepidu TO postgres;
GRANT ALL ON SCHEMA suvepidu TO PUBLIC;