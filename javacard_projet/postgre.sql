create table  contact(

    id serial primary key,
    "name" varchar(100) not null,
    surname varchar (200) not null,
    city varchar (100),
    adress varchar(200),
    gender varchar(10),
    birthdate date,
     phone_number varchar(50),
     phone_number_profesionnal varchar(50),
     nickname varchar(200),
     email varchar(250) not null,
     postal_code int not null,
     github varchar(250)
     

)