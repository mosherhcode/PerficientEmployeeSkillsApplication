BEGIN TRANSACTION;

DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS emp_skill CASCADE;
DROP TABLE IF EXISTS skill CASCADE;
DROP TABLE IF EXISTS field CASCADE;

DROP TYPE IF EXISTS role_options;
DROP TYPE IF EXISTS business_unit_options;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--CREATE TYPE role_options AS ENUM ('Technical Consultant', 'Project Manager', 'Director', 'Chief');

--CREATE TYPE business_unit_options AS ENUM ('Digital Experience Group', 'Adobe', 'IBM NBU', 'API Management');

CREATE TABLE employee (
        id UUID DEFAULT uuid_generate_v4 (),
        first_name varchar NOT NULL,
        last_name varchar NOT NULL,
        address_id UUID NOT NULL,
        contact_email varchar,
        company_email varchar NOT NULL,
        birth_date varchar NOT NULL,
        hired_date varchar NOT NULL,
        role varchar NOT NULL CHECK (role IN ('Technical Consultant', 'Project Manager', 'Director', 'Chief')),
        business_unit varchar CHECK (business_unit IN ('Digital Experience Group', 'Adobe', 'IBM NBU', 'API Management')),
        assigned_to UUID,
        PRIMARY KEY (id)
);

CREATE TABLE address (
        id UUID DEFAULT uuid_generate_v4 (),
        street varchar NOT NULL,
        suite varchar,
        city varchar NOT NULL,
        region varchar NOT NULL,
        postal varchar NOT NULL,
        country varchar NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE emp_skill (
        employee_id uuid NOT NULL,
        skill_id uuid NOT NULL,
        experience integer NOT NULL,
        PRIMARY KEY (employee_id, skill_id)
);

CREATE TABLE skill (
        id UUID DEFAULT uuid_generate_v4 (),
        summary varchar,
        field_id UUID NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE field (
        id UUID DEFAULT uuid_generate_v4 (),
        name varchar NOT NULL,
        type varchar NOT NULL,
        PRIMARY KEY (id)
);


ALTER TABLE employee
ADD FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE employee
ADD FOREIGN KEY (assigned_to) REFERENCES employee(id);

ALTER TABLE emp_skill
ADD FOREIGN KEY (employee_id) REFERENCES employee(id);

ALTER TABLE emp_skill
ADD FOREIGN KEY (skill_id) REFERENCES skill(id);

ALTER TABLE skill
ADD FOREIGN KEY (field_id) REFERENCES field(id);

COMMIT TRANSACTION;