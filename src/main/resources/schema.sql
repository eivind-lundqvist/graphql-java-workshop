create table activity
(
  id                             bigint  not null,
  average_heartrate              float   not null,
  description                    varchar(255),
  distance_in_meters             double  not null,
  elapsed_time_in_seconds        integer not null,
  max_heartrate                  integer not null,
  moving_time_in_seconds         integer not null,
  name                           varchar(255),
  total_elevation_gain_in_meters double  not null,
  primary key (id)
);

create table athlete
(
  id         bigint not null,
  first_name varchar(255),
  last_name  varchar(255),
  primary key (id)
);

create table athlete_activities
(
  athletes_id   bigint not null,
  activities_id bigint not null
);

create table athlete_clubs
(
  athletes_id bigint not null,
  clubs_id    bigint not null
);

create table club
(
  id   bigint not null,
  name varchar(255),
  primary key (id)
);

alter table athlete_activities
  add constraint FKg1o3psluggtqu5nkr4x4c6lgy foreign key (activities_id) references activity;
alter table athlete_activities
  add constraint FKsrcfiwfheib6jtgeevda6i219 foreign key (athletes_id) references athlete;
alter table athlete_clubs
  add constraint FKbnqr0cqy6edtmjr2jmdnq8ij2 foreign key (clubs_id) references club;
alter table athlete_clubs
  add constraint FKl80aumxqnpqtl7412ffj91xsr foreign key (athletes_id) references athlete;

