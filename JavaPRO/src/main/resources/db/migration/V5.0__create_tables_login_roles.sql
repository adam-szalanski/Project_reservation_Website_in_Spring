DROP TABLE IF EXISTS projekty.login CASCADE;
DROP TABLE IF EXISTS projekty.login_roles CASCADE;
DROP TABLE IF EXISTS projekty.role CASCADE;
CREATE TABLE projekty.login
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username VARCHAR(255)                            NOT NULL,
    email    VARCHAR(255)                            NOT NULL,
    password VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_login PRIMARY KEY (id)
);

CREATE TABLE projekty.login_roles
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login_id BIGINT NOT NULL,
    role_id  BIGINT NOT NULL,
    CONSTRAINT pk_login_roles PRIMARY KEY (login_id, role_id)
);

CREATE TABLE projekty.role
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE projekty.login
    ADD CONSTRAINT uc_c14c098c82a9f5647aa3c5491 UNIQUE (username);

ALTER TABLE projekty.login
    ADD CONSTRAINT uc_e19e039cac26a4f8aaa2699d1 UNIQUE (email);

ALTER TABLE projekty.login
    ADD CONSTRAINT uc_login_id UNIQUE (id);

ALTER TABLE projekty.login_roles
    ADD CONSTRAINT uc_login_roles_login UNIQUE (id);

ALTER TABLE projekty.studenci
    ADD CONSTRAINT FK_STUDENCI_ON_LOGIN FOREIGN KEY (login_id) REFERENCES projekty.login (id);

ALTER TABLE projekty.login_roles
    ADD CONSTRAINT fk_logrol_on_login FOREIGN KEY (login_id) REFERENCES projekty.login (id);

ALTER TABLE projekty.login_roles
    ADD CONSTRAINT fk_logrol_on_role FOREIGN KEY (role_id) REFERENCES projekty.role (id);
