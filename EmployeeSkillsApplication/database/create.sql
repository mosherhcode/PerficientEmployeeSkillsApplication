BEGIN TRANSACTION;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE role_options AS ENUM ('Technical Consultant', 'Project Manager', 'Director', 'Chief');

CREATE TABLE employee (
        id UUID DEFAULT uuid_generate_v4 (),
        first_name varchar NOT NULL,
        last_name varchar NOT NULL,
        address_id UUID NOT NULL,
        contact_email varchar,
        company_email varchar NOT NULL,
        birth_date varchar NOT NULL,
        hired_date varchar NOT NULL,
        role role_options NOT NULL,
        business_unit varchar,
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
        PRIMARY KEY (employee_id, skill_id)
);

CREATE TABLE skill (
        id UUID DEFAULT uuid_generate_v4 (),
        experience integer NOT NULL,
        summary varchar,
        PRIMARY KEY (id)
);

CREATE TABLE skill_field (
        skill_id uuid NOT NULL,
        field_id uuid NOT NULL,
        PRIMARY KEY (skill_id, field_id)        
);

CREATE TABLE field (
        id UUID DEFAULT uuid_generate_v4 (),
        name varchar NOT NULL,
        type varchar NOT NULL,
        PRIMARY KEY (id)
);


ALTER TABLE employee
ADD FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE emp_skill
ADD FOREIGN KEY (employee_id) REFERENCES employee(id);

ALTER TABLE emp_skill
ADD FOREIGN KEY (skill_id) REFERENCES skill(id);

ALTER TABLE skill_field
ADD FOREIGN KEY (skill_id) REFERENCES skill(id);

ALTER TABLE skill_field
ADD FOREIGN KEY (field_id) REFERENCES field(id);

COMMIT TRANSACTION;