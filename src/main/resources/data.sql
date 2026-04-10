--passwords are "1111"
INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('worker@warehouse.ca', '$2a$12$88UzWYqtLsl3918w7qCiYOJ/woshfWQjdYStSsgiXHcwCa07KpTXS', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('manager@warehouse.ca', '$2a$12$88UzWYqtLsl3918w7qCiYOJ/woshfWQjdYStSsgiXHcwCa07KpTXS', 1);

INSERT INTO sec_role (roleName) VALUES ('ROLE_STAFF');
INSERT INTO sec_role (roleName) VALUES ('ROLE_MANAGER');

INSERT INTO user_role (userId, roleId) VALUES (1, 1);
INSERT INTO user_role (userId, roleId) VALUES (2, 1);
INSERT INTO user_role (userId, roleId) VALUES (2, 2);