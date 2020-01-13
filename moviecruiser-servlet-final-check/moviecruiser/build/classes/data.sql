SELECT * FROM moviecruiser.movie_list;

use moviecruiser;

INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_teaser`) VALUES ('1', 'Avatar', '2787965087', 'Yes', '2017-03-15', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_teaser`) VALUES ('The Avengers', '1518812988', 'Yes', '2017-12-23', 'Superhero', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_teaser`) VALUES ('Titanic', '2187463944', 'Yes', '2020-08-21', 'Romance', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_teaser`) VALUES ('Jurassic World', '1671713208', 'No', '2020-07-02', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_teaser`) VALUES ('Avengers: End Game', '2750760348', 'Yes', '2022-11-02', 'Superhero', 'Yes');

insert into user(us_id,us_name) values(1,'Soumya');
insert into user(us_id,us_name) values(2,'Athira');

select * from moviecruiser.movie_list
where movie_list.mo_date_of_launch >= curdate() and mo_active = 'Yes';

select * from moviecruiser.movie_list
where mo_id = '5';

update moviecruiser.movie_list
set
mo_title = 'Sky High',
mo_gross = '1256487952',
mo_date_of_launch = '2018-03-03',
mo_genre = 'Superhero',
mo_teaser = 'No'
where mo_id = '1';

insert into moviecruiser.favorites(fv_us_id,fv_mo_id)values(1,1);
insert into moviecruiser.favorites(fv_us_id,fv_mo_id)values(1,2);
insert into moviecruiser.favorites(fv_us_id,fv_mo_id)values(1,3);
insert into moviecruiser.favorites(fv_us_id,fv_mo_id)values(2,3);

select movie_list.mo_title, movie_list.mo_teaser, movie_list.mo_gross from favorites
inner join movie_list on movie_list.mo_id = favorites.fv_mo_id
inner join user on user.us_id = favorites.fv_us_id
where user.us_id = '1';

select user.us_id,count(movie_list.mo_id) as 'No. of Favorites' from favorites
inner join movie_list on movie_list.mo_id = favorites.fv_mo_id
inner join user on user.us_id = favorites.fv_us_id
where user.us_id = '1';

delete from moviecruiser.favorites where fv_us_id = '2' and fv_mo_id = '3'; 



