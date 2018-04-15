--liquibase formatted sql logicalFilePath:V1_008_EMPLOYEE_DATA.sql
--changeset sanasov:1.10 runOnChange:true context:prod
ALTER TABLE student ADD department_id INTEGER;


