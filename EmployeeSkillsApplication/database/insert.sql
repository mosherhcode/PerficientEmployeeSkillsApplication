BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES  ('1234 Main St.', 'Ann Arbor', 'MI', '48105', 'USA'),
 ('5678 Elm Ave.', 'Detroit', 'MI', '48127', 'USA');

INSERT INTO employee (first_name, last_name, address_id, contact_email, company_email, birth_date, hired_date, role, business_unit, assigned_to)
VALUES ('James', 'Jameson', (SELECT id FROM address WHERE street = '5678 Elm Ave.'), 'jamjam@outlookcom', 'jamesonj@perficient.com', '05-07-1975', '03-30-2012', 'Director', 'Digital Experience Group', null);

INSERT INTO employee (first_name, last_name, address_id, contact_email, company_email, birth_date, hired_date, role, business_unit, assigned_to)
VALUES ('Harry', 'Mosher', (SELECT id FROM address WHERE street = '1234 Main St.'), 'mosherhcode@gmail.com', 'mosherh@perficient.com', '08-17-1987', '08-10-2020', 'Technical Consultant', 'Digital Experience Group', (SELECT id FROM employee WHERE company_email = 'jamesonj@perficient.com')),
('Samantha', 'Sampleton', (SELECT id FROM address WHERE street = '5678 Elm Ave.'), 'samsam@yahoo.com', 'sampletons@perficient.com', '02-01-1992', '01-15-2019', 'Technical Consultant', 'Adobe', (SELECT id FROM employee WHERE company_email = 'jamesonj@perficient.com'));

INSERT INTO field (name, type)
VALUES  ('Java', 'Software Development'),
        ('.Net', 'Software Development');

INSERT INTO skill (summary, field_id)
VALUES ('jUnit', (SELECT id FROM field WHERE name = 'Java')),
       ('RESTful APIs', (SELECT id FROM field WHERE name = 'Java')),
       ('RESTful APIs', (SELECT id FROM field WHERE name = '.Net'));
       
INSERT INTO emp_skill (employee_id, skill_id, experience)
VALUES ((SELECT id FROM employee WHERE company_email = 'mosherh@perficient.com'), (SELECT id FROM skill WHERE summary = 'jUnit'), 3);

COMMIT TRANSACTION;