INSERT INTO statuses(id,status)
VALUES
('42b6d1ed-c893-4543-99de-b8afc0174a5e', 'Завершено'),
('e7c002ef-3da8-48b9-9835-d228cc6ecb0c', 'В процесі');

INSERT INTO companies(id,company)
VALUES
('d610997c-6dda-40e4-8cf3-cb2d8fe2ebc5','ТОВ Зернова компанія'),
('17c065a2-6a57-4e18-bf56-c89981c3b564','ТОВ Компанія 1'),
('c89bfe2a-feb1-44e6-8112-deacb9f0461a','ТОВ Компанія 2');

INSERT INTO drivers(id, first_name, last_name)
VALUES
('f8cceeac-0bc8-4cfe-8514-0e798aeb6775','Вася','Пупкін'),
('792ee5d7-ff33-438f-bc78-0041183c512d','Іван','Іванов'),
('2b022650-2fd6-4ce9-9f62-be2e15d1985a','Джеремі','Кларксон'),
('791532fb-1e9d-4975-9728-7f5731361ed5','Річард','Хаммонд');

INSERT INTO trucks(id,truck)
VALUES
('a399c5cb-1580-4e94-a2e2-6ec37d5b3498','ВН4510ВР'),
('71da9345-7d3f-4ea8-abee-86cbc84771ab','СА0000АС'),
('13a529e7-0255-4f8a-b89a-a03c075d6640','СА4810СА'),
('ea5302be-4677-4752-a5d2-c09c6dabe47a','КА4210АК');

INSERT INTO products(id,product)
VALUES
('2899b67a-ac35-40d4-a7e6-af73164ab0fa','Куккурудза'),
('d11a09c4-6d3f-4eab-8b04-fd849620d8aa','Пшениця'),
('36afc426-934a-4271-bc94-d46bf8cde1ce','Соняшник'),
('32ad8a7e-c7b2-45ba-a4be-2a28004d538e','Ріпак');

INSERT INTO chemicals(id,product_id, humidity)
VALUES
('c81848fa-3707-471a-a2be-8d64f0eeae55','2899b67a-ac35-40d4-a7e6-af73164ab0fa','10'),
('56fdd082-e27d-4aa1-a487-4be724779349','d11a09c4-6d3f-4eab-8b04-fd849620d8aa','12'),
('32ad8a7e-c7b2-45ba-a4be-2a28004d538e','36afc426-934a-4271-bc94-d46bf8cde1ce','15');


INSERT INTO directions(id,direction)
VALUES
('4dbfbc5d-723e-4bcb-af6b-f54accad7961','Зі складу'),
('fba578b8-471e-45a8-9777-7ae7d93dcb0c','На склад'),
('76b4550a-c790-41e8-95ee-7117614c86d5','Транзит');

INSERT INTO weightings(id,brutto_time,brutto,tara_time,tara,netto)
VALUES
('0a58e231-5e68-44e3-bb37-352abcb78c08','2022-12-18 12:32:01','10820','2022-12-18 12:32:01','5120','5700'),
('df3472c9-7a80-44db-9402-4441d63a94dc','2022-12-18 12:32:01','42140','2022-12-18 12:32:01','9180','32960'),
('caf375b5-26a1-4ed5-999b-b84fe16bc1c7','2022-12-18 12:32:01','15480','2022-12-18 12:32:01','5040','10440');


INSERT INTO events(id,user_id,date_time,status_id,company_id,driver_id,
truck_id,product_id,chemical_id,weighting_id,direction_id)
VALUES
('a5166e59-ff56-4b43-b20f-d73237ece9b4','bd7f5245-f212-4530-a83a-2861d0786356','2022-12-18 12:32:01','42b6d1ed-c893-4543-99de-b8afc0174a5e',
'd610997c-6dda-40e4-8cf3-cb2d8fe2ebc5','791532fb-1e9d-4975-9728-7f5731361ed5','a399c5cb-1580-4e94-a2e2-6ec37d5b3498',
'2899b67a-ac35-40d4-a7e6-af73164ab0fa','c81848fa-3707-471a-a2be-8d64f0eeae55','0a58e231-5e68-44e3-bb37-352abcb78c08','4dbfbc5d-723e-4bcb-af6b-f54accad7961'),

('14eb8b0d-2508-4b15-ab27-4e2c2eeb2edf','bd7f5245-f212-4530-a83a-2861d0786356','2022-12-18 12:32:01','42b6d1ed-c893-4543-99de-b8afc0174a5e',
'17c065a2-6a57-4e18-bf56-c89981c3b564','2b022650-2fd6-4ce9-9f62-be2e15d1985a','71da9345-7d3f-4ea8-abee-86cbc84771ab',
'd11a09c4-6d3f-4eab-8b04-fd849620d8aa','56fdd082-e27d-4aa1-a487-4be724779349','df3472c9-7a80-44db-9402-4441d63a94dc','4dbfbc5d-723e-4bcb-af6b-f54accad7961'),

('97f0c7cb-07fc-4ac0-b261-83798545f600','bd7f5245-f212-4530-a83a-2861d0786356','2022-12-18 12:32:01','42b6d1ed-c893-4543-99de-b8afc0174a5e',
'c89bfe2a-feb1-44e6-8112-deacb9f0461a','f8cceeac-0bc8-4cfe-8514-0e798aeb6775','13a529e7-0255-4f8a-b89a-a03c075d6640',
'2899b67a-ac35-40d4-a7e6-af73164ab0fa','32ad8a7e-c7b2-45ba-a4be-2a28004d538e','caf375b5-26a1-4ed5-999b-b84fe16bc1c7','76b4550a-c790-41e8-95ee-7117614c86d5');






