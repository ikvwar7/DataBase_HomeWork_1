--liquibase formatted sql logicalFilePath:V1_011_STUDENT.sql
--changeset carrol:1.11 runOnChange:true context:prod
CREATE TABLE tmp(
id                 BIGSERIAL PRIMARY KEY,
  fio                VARCHAR(400),
  gender             VARCHAR(100),
  department_name    VARCHAR(100),
  course             SMALLINT,
  birthday           TIMESTAMP NOT NULL,
  department_id INTEGER
);
INSERT INTO tmp (id, fio, gender, department_name, course, birthday,department_id)
SELECT
liga.student.id, liga.student.fio,liga.student.gender,liga.student.department_name,
liga.student.course, liga.student.birthday,
liga.department.id
FROM
liga.student LEFT JOIN liga.department ON liga.student.department_name = liga.department.title;

