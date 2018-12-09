INSERT INTO Organization (name, fullName, address, phone, inn, kpp, isActive)
VALUES ('Biline', 'BEELINE LTD', 'ул.Цюрупы, 16', '8(499)123-45-67','beeline-inn', 'beeline-kpp', true);

INSERT INTO Organization (name, fullName, address, phone, inn, kpp, isActive)
VALUES ('Megafon', 'MEGAFON LTD', 'ул.Холмогоры, 16', '8(499)123-99-99','megafon-inn', 'megafon-kpp', true);

INSERT INTO Office (id, orgId, name, address, phone, isActive) VALUES (1, 1,'Билайн-отрадное' ,'ул.отрадная, 7','8(499)123-45-01', true);
INSERT INTO Office (id, orgId, name, address, phone, isActive) VALUES (2, 1,'Билайн-вднх' ,'ул.вднх, 7','8(499)123-45-02', true);

INSERT INTO Office (id, orgId, name, address, phone, isActive) VALUES (3, 2,'Мегафон-измайлово' ,'ул.измайлово, 7','8(499)123-99-01', true);
INSERT INTO Office (id, orgId, name, address, phone, isActive) VALUES (4, 2,'Мегафон-марьино' ,'ул.марьино, 7','8(499)123-99-02', true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
 VALUES (1, 1, 'Пётр', 'иванов', 'иванович', 'iii', 'менеджер', 3,1,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
 VALUES (2, 1, 'Яушев ', 'Юрий ', 'Мечиславович', 'iii', 'директор', 1,1,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
 VALUES (3, 2, ' Тимур ', 'Гавриленко', 'Фомевич', 'iii', 'менеджер', 5,2,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
  VALUES (4, 2, 'Кондрат ', 'Катасонов ', 'Владимирович', 'iii', 'директор', 2,1,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
  VALUES (5, 3, ' Севастьян ', 'Рождественский', 'Касьянович', 'iii', 'менеджер', 8,2,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
   VALUES (6, 3, ' Никанор ', 'Ябловский', 'Сидорович', 'iii', 'директор', 6,1,true);

INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
    VALUES (7, 4, ' Роман ', 'Потапов', ' Аникитевич', 'iii', 'менеджер', 4,1,true);


INSERT INTO User_man (id, officeId, firstName, lastName, secondName, middleName, user_position, docId, citizenshipId, isIdentified)
    VALUES (8, 4, ' Ираклий ', 'Макаров', 'Сергеевич', 'iii', 'уборщик', 7,1,true)

INSERT INTO docs (id, name, number, docDate, code) VALUES (1,'паспорт', '123123123','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (2,'воен.билет', '73753573','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (3,'паспорт', '73793345','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (4,'вод.удост.', '8634334364','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (5,'паспорт', '123123123','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (6,'воен. билет', '986737343','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (7,'паспорт', '6884534334','2010-10-10', 25);
INSERT INTO docs (id, name, number, docDate, code) VALUES (8,'паспорт', '3333333333','2010-10-10', 25);

INSERT INTO Citizenship (id, name, code) VALUES (1, 'РФ', 323);

INSERT INTO Citizenship (id, name, code) VALUES (2, 'ЕС',584);