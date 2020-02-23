insert into roles( role)
values('ROLE_USER'), ('ROLE_ADMIN');


insert into user( name,age,email,password)
values('Frank',32,'Frank@gmail', '$2a$10$fcIPbKbPaG8qRcJOeCzjauYq00sFcaDcgEgVifp.zhBCCjs5YZmiG'),
('Ivan',32, 'Ivan@gmail', '$2a$10$fcIPbKbPaG8qRcJOeCzjauYq00sFcaDcgEgVifp.zhBCCjs5YZmiG'),
('Igor',32, 'Igor@gmail', '$2a$10$fcIPbKbPaG8qRcJOeCzjauYq00sFcaDcgEgVifp.zhBCCjs5YZmiG'),
('Vova',32, 'Vova@gmail', '$2a$10$fcIPbKbPaG8qRcJOeCzjauYq00sFcaDcgEgVifp.zhBCCjs5YZmiG'),
('Billy',32,'Billy@gmail', '$2a$10$fcIPbKbPaG8qRcJOeCzjauYq00sFcaDcgEgVifp.zhBCCjs5YZmiG');

insert into user_roles(user_id, role_id)
values(1,1), (2,2), (3,1), (4,2);

insert into articles( text, color,user_id)
values('Text', 'BLUE', 1),('Text', 'RED', 1),('Text', 'GREEN', 1),('Text', 'GREEN', 1);


