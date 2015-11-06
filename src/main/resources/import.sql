insert into role(name) values ('ADMIN');

insert into user(name, active, username, password, num_login_failures, role_id) values ('Admin', 1, 'admin', '559aea7dd284ea1be0ad3c5db0f1e7a8', 0, 1);

insert into menu(name, link, display_order) values ('Dashboard', '/', 1);
insert into menu(name, link, display_order) values ('Logout', '/logout', 2);
insert into role_menu values (1, 1), (1, 2);