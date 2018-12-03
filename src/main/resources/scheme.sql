CREATE TABLE IF NOT EXISTS Organization( -- таблица организаци
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, -- id организации.
    name       VARCHAR(50) NOT NULL, -- название организации.
    fullName   VARCHAR(50) UNIQUE NOT NULL, -- Полное название организации.
    address    VARCHAR(50) NOT NULL, -- Юридический адрес организации
     phone     VARCHAR(50) UNIQUE NOT NULL, -- телефон организации
     inn       VARCHAR(50) UNIQUE NOT NULL, -- инн организации
     kpp       VARCHAR(50) UNIQUE NOT NULL, -- кпп организации
     isActive  BOOLEAN -- активна ли организация.
    );

CREATE TABLE IF NOT EXISTS Office( --офис организации
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, --id офиса
    orgId      INTEGER NOT NULL, -- id организации
    name       VARCHAR(50) UNIQUE NOT NULL, --название офиса
    address    VARCHAR(50) NOT NULL,--адрес офиса
    phone      VARCHAR(50) UNIQUE NOT NULL, --телефоный номер офиса
    isActive   BOOLEAN --активный ли офис
    );

CREATE TABLE IF NOT EXISTS User_man( -- таблица работник
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, -- id работника
    officeId   INTEGER NOT NULL, -- в каком офисе работает работник
    firstName  VARCHAR(50) NOT NULL, --Имя работника
    lastName   VARCHAR(50) NOT NULL, -- Фамилия работника
    secondName VARCHAR(50) NOT NULL, -- Отчество работника
    middleName VARCHAR(50) NOT NULL, -- Среднее имя(В англоязычных именах)
    user_position  VARCHAR(50)  NOT NULL, -- должность работника
    docName    VARCHAR(50) NOT NULL, -- название документа удостоверяющего личность(например "паспорт")
    docNumber  VARCHAR(50) NOT NULL, -- номер документа
    docDate    DATE, -- дата создания документа
    docCode    VARCHAR(50) NOT NULL, --код документа, согластно таблице "СВЕДЕНИЯ О ВИДАХ ДОКУМЕНТОВ,
                                             -- УДОСТОВЕРЯЮЩИХ ЛИЧНОСТЬ ФИЗИЧЕСКОГО ЛИЦА"
    citizenshipCode       INTEGER NOT NULL, -- код страны, гражданином которой является работник.
    citizenshipName       INTEGER NOT NULL, -- Название страны, гражданином которой является работник.
    isIdentified  BOOLEAN --индивицирован лм работник
    );

CREATE TABLE IF NOT EXISTS docs( -- таблица документов
    id         INTEGER PRIMARY KEY AUTO_INCREMENT, -- id документа
    name       VARCHAR (100) NOT NULL, -- Название документа
    code       INTEGER UNIQUE NOT NULL, -- код документа
    );

CREATE TABLE IF NOT EXISTS Citizenship( -- таблица "Страна"
    id         INTEGER PRIMARY KEY AUTO_INCREMENT, -- id Страны
    name       VARCHAR (50) NOT NULL, -- Название страны
    code       INTEGER UNIQUE NOT NULL, -- Код страны
);

CREATE INDEX IX_Organization_fullName ON Organization (fullName);
CREATE INDEX IX_Organization_inn ON Organization (inn);
CREATE INDEX IX_Organization_kpp ON Organization (kpp);
CREATE INDEX IX_Organization_fullName ON Organization (fullName);
CREATE INDEX IX_Organization_isActive ON Organization (isActive);

CREATE INDEX IX_Office_name ON Office (name);
CREATE INDEX IX_Office_phone ON Office (phone);
CREATE INDEX IX_Office_isActive ON Office (isActive);

CREATE INDEX IX_User_man_firstName ON Office (firstName);
CREATE INDEX IX_User_man_secondName ON Office (secondName);
CREATE INDEX IX_User_man_lastName ON Office (lastName);
CREATE INDEX IX_User_man_user_position ON Office (user_position);


CREATE INDEX IX_Office_orgId ON Office(orgId);
ALTER TABLE Office ADD FOREIGN KEY (orgId) REFERENCES Organization(id);
-- orgId в таблице Office ссылыется по внешнему ключу
-- на  id организации Organization(id)

CREATE INDEX IX_User_man_OfficeId ON User_man (officeId);
ALTER TABLE User_man ADD FOREIGN KEY (officeId) REFERENCES Office(id);
 -- officeId в таблице User_man ссылыется по внешнему ключу
 -- на  id офиса Office(id)

CREATE INDEX IX_docs_name ON docs(name);
ALTER TABLE docs ADD FOREIGN KEY (name) REFERENCES User_man(docName);
 -- name в таблице docs ссылыется по внешнему ключу
 -- на  названия документа удовстоверяющего личность  User_man(docName)

CREATE INDEX IX_docs_code ON docs(code);
ALTER TABLE docs ADD FOREIGN KEY (code) REFERENCES User_man(docCode);
 -- code в таблице docs ссылыется по внешнему ключу
 -- на  код документа удовстоверяющего личность  User_man(docCode)

CREATE INDEX IX_Citizenship_name ON Citizenship(name);
ALTER TABLE Citizenship ADD FOREIGN KEY (name) REFERENCES User_man(citizenshipName);
 -- name в таблице Citizenship ссылыется по внешнему ключу
 -- на  названия страны, гражданства работника   User_man(citizenshipName)

CREATE INDEX IX_Citizenship_code ON Citizenship(code);
ALTER TABLE Citizenship ADD FOREIGN KEY (code) REFERENCES User_man(citizenshipCode);
 -- code в таблице Citizenship ссылыется по внешнему ключу
 -- на  код страны гражданства работника  User_man(citizenshipCode)
