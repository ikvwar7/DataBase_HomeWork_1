--liquibase formatted sql logicalFilePath:V1_010_STUDENT.sql
--changeset carrol:1.10 runOnChange:true context:prod
Alter Table liga.student Add department_id INTEGER
