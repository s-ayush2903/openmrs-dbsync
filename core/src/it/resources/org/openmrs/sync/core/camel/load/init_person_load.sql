insert into person(person_id, gender, birthdate, birthdate_estimated, dead, death_date, cause_of_death, creator, date_created, changed_by, date_changed, voided, voided_by, date_voided, void_reason, uuid, deathdate_estimated, birthtime)
values ('1', 'M', NULL, false, false, NULL, NULL, NULL, '2005-01-01 00:00:00', NULL, NULL, false, NULL, NULL, NULL, 'dd279794-76e9-11e9-8cd9-0242ac1c000b', false, NULL);

insert into users(user_id, system_id, creator, date_created, person_id)
values ('1', 'admin', '1', '2005-01-01 00:00:00', '1');
