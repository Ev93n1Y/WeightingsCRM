insert into roles(id,role)
values
('6adc7b2b-7b5f-40f1-9638-f44d3ff55e9d', 'ROLE_ADMIN'),
('9ca9dce6-65df-4648-a732-6dbb75164489', 'ROLE_USER');

insert into users(id,name,password, first_name, last_name)
values
('bd7f5245-f212-4530-a83a-2861d0786356','admin', '$2a$10$oHm5ZM8iHxh7KZKSRwK7hukYTst/qYSegA/60GEHtYP8kQz3dsLXq', 'Admin', 'Admin'),
('7b9e48e6-9c39-4d95-87eb-39381746557e','user', '$2a$10$8PMEvzIIatqAOvyWWD5YMuujHDnoI3iui4GZhD.kG7ft30fdgYPu2', 'first 1', 'last 1');

insert into user_roles(role_id,user_id)
values
('6adc7b2b-7b5f-40f1-9638-f44d3ff55e9d', 'bd7f5245-f212-4530-a83a-2861d0786356'),
('9ca9dce6-65df-4648-a732-6dbb75164489', '7b9e48e6-9c39-4d95-87eb-39381746557e');







