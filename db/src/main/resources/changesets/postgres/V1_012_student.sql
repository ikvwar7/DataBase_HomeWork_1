--liquibase formatted sql logicalFilePath:V1_012_STUDENT.sql
--changeset carrol:1.12 runOnChange:true context:prod
Alter TABLE liga.tmp Drop COLUMN department_name;
DROP TABLE student;
ALTER TABLE liga.tmp RENAME TO student;