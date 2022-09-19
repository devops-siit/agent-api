
insert into account ( created_at, updated_at, uuid, name, username) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '7c20fb12-40d8-4322-ba33-9c05203868e9', 'Jane J', 'strawberry');

insert into account (created_at, updated_at, uuid, name, username) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '7c20fb12-50d8-4322-ba33-9c05203868e9','Claudia C', 'coco');

insert into account (created_at, updated_at, uuid, name, username) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '7c20fb12-60d8-4322-ba33-9c05203868e9',  'Elon Musk', 'spacex');

insert into company (created_at, updated_at, uuid, name, address, phone, description, owner_id) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '1c20fb12-60d8-4322-ba33-9c05203868e9', 'SpaceX', 'California', '0123', 'desc', 3);
insert into company (created_at, updated_at, uuid, name, address, phone, description, owner_id) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '1c20fb12-00d8-4322-ba33-9c05203868e9', 'Chanel', 'Paris', '0123', 'desc', 2);

insert into comment (created_at, updated_at, uuid, text, author_id, company_id ) values ( '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '2c20fb12-60d8-4322-ba33-9c05203868e9', 'Amazing company ewww', 1, 1);

insert into rate (created_at, updated_at, uuid, rate, account_id, company_id ) values('2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '2c20fb12-60d8-4322-ba43-9c05203868e9', 10, 1, 1);

insert into company_request (request_status, created_at, updated_at, uuid, name, address, phone, description, owner_id) values ('PENDING', '2022-07-15 14:52:49.065758', '2022-07-15 14:52:49.065813', '1c20fb12-60d8-4322-ba53-9c05203868e9', 'Fun travel', 'Belgrade', '0123', 'travel agency', 3);