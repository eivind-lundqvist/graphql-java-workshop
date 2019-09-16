insert into athlete (first_name, last_name, id) values ('Jack', 'Bauer', 1);
insert into athlete (first_name, last_name, id) values ('Tyler', 'Durden', 2);
insert into athlete (first_name, last_name, id) values ('Conor', 'McGregor', 3);
insert into athlete (first_name, last_name, id) values ('Emil', 'Meek', 4);

insert into club (name, id) values ('Fight Club', 1);

insert into activity (name,id,average_heartrate,description,distance_in_meters,elapsed_time_in_seconds,max_heartrate,moving_time_in_seconds,total_elevation_gain_in_meters) values ('Fight!',1,0.0,null,0.0,0,0,0,0.0);

insert into athlete_activities (athletes_id, activities_id) values (1, 1);
insert into athlete_clubs (athletes_id, clubs_id) values (1, 1);
insert into athlete_activities (athletes_id, activities_id) values (2, 1);
insert into athlete_clubs (athletes_id, clubs_id) values (2, 1);