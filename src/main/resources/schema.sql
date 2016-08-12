CREATE TABLE USER (
  LOGIN varchar(50) PRIMARY KEY NOT NULL,
  PASSWORD varchar(50) NOT NULL
);

CREATE TABLE USER_SETTINGS (
  LOGIN varchar(50) PRIMARY KEY NOT NULL,
  VALUE varchar(255) NOT NULL,
  DATE_EDIT TIMESTAMP NOT NULL,
  CONSTRAINT FK_LOGIN FOREIGN KEY (LOGIN) REFERENCES USER (LOGIN)
);