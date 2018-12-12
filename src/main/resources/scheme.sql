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

CREATE TABLE IF NOT EXISTS User ( -- таблица работник
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, -- id работника
    officeId   INTEGER NOT NULL, -- в каком офисе работает работник
    firstName  VARCHAR(50) NOT NULL, --Имя работника
    lastName   VARCHAR(50) NOT NULL, -- Фамилия работника
    secondName VARCHAR(50) NOT NULL, -- Отчество работника
    middleName VARCHAR(50) NOT NULL, -- Среднее имя(В англоязычных именах)
    position  VARCHAR(50)  NOT NULL, -- должность работника
    docId      VARCHAR(50) NOT NULL, -- id документа
    citizenshipId       INTEGER NOT NULL, -- id страны.
    isIdentified  BOOLEAN --индивицирован лм работник
    );

CREATE TABLE IF NOT EXISTS docs( -- таблица документов
    id         INTEGER PRIMARY KEY AUTO_INCREMENT, -- id документа
    name       VARCHAR (100) NOT NULL, -- Название документа
    number     VARCHAR(50) NOT NULL, -- номер документа
    docDate    DATE, -- дата создания документа
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

CREATE INDEX IX_User_firstName ON Office (firstName);
CREATE INDEX IX_User_secondName ON Office (secondName);
CREATE INDEX IX_User_lastName ON Office (lastName);
CREATE INDEX IX_User_user_position ON Office (position);


CREATE INDEX IX_Office_orgId ON Office(orgId);
ALTER TABLE Office ADD FOREIGN KEY (orgId) REFERENCES Organization(id);
-- orgId в таблице Office ссылыется по внешнему ключу
-- на  id организации Organization(id)

CREATE INDEX IX_User_OfficeId ON User (officeId);
ALTER TABLE User ADD FOREIGN KEY (officeId) REFERENCES Office(id);
 -- officeId в таблице User_man ссылыется по внешнему ключу
 -- на  id офиса Office(id)
CREATE INDEX IX_User_docId ON User (docId);
ALTER TABLE User_man ADD FOREIGN KEY (docId) REFERENCES docs(id);

CREATE INDEX IX_User_citizenshipId ON User (citizenshipId);
ALTER TABLE User ADD FOREIGN KEY (citizenshipId) REFERENCES Citizenship(id);

-- КОММЕНТАРИИ
COMMENT ON TABLE Organization IS 'таблица организаци';
COMMENT ON COLUMN Organization.id IS 'id организации';
COMMENT ON COLUMN Organization.name IS 'название организации';
COMMENT ON COLUMN Organization.fullName IS 'Полное название организации';
COMMENT ON COLUMN Organization.address  IS 'Юридический адрес организации';
COMMENT ON COLUMN Organization.phone IS 'телефон организации';
COMMENT ON COLUMN Organization.inn IS 'инн организации';
COMMENT ON COLUMN Organization.kpp  IS 'кпп организации';
COMMENT ON COLUMN Organization.isActive IS 'активна ли организация';

COMMENT ON TABLE Office IS 'офис организации';
COMMENT ON COLUMN Office.orgId IS 'id организации';
COMMENT ON COLUMN Office.name IS 'название офиса';
COMMENT ON COLUMN Office.address IS 'адрес офиса';
COMMENT ON COLUMN Office.phone  IS 'телефоный номер офиса';
COMMENT ON COLUMN Office.isActive IS 'активный ли офис';

COMMENT ON TABLE User IS 'таблица работник';
COMMENT ON COLUMN User.id IS 'id работника';
COMMENT ON COLUMN User.officeId  IS 'в каком офисе работает работник';
COMMENT ON COLUMN User.firstName IS 'Имя работника';
COMMENT ON COLUMN User.lastName  IS 'Фамилия работника';
COMMENT ON COLUMN User.secondName IS 'Отчество работника';
COMMENT ON COLUMN User.middleName IS 'Среднее имя(В англоязычных именах)';
COMMENT ON COLUMN User.position  IS 'должность работника';
COMMENT ON COLUMN User.docId IS 'id документа';
COMMENT ON COLUMN User.citizenshipId IS 'id страны.';
COMMENT ON COLUMN User.isIdentified IS 'аиндивицирован лм работник';

COMMENT ON TABLE docs IS 'таблица документов';
COMMENT ON COLUMN docs.id IS 'id документа';
COMMENT ON COLUMN docs.name IS 'Название документа';
COMMENT ON COLUMN docs.number IS 'номер документа';
COMMENT ON COLUMN docs.docDate  IS 'дата создания документа';
COMMENT ON COLUMN docs.code IS 'код документа';

COMMENT ON TABLE Citizenship IS 'таблица -Страна';
COMMENT ON COLUMN Citizenship.id IS 'id Страны';
COMMENT ON COLUMN Citizenship.name IS 'Название страны';
COMMENT ON COLUMN Citizenship.code IS 'Код страны';



