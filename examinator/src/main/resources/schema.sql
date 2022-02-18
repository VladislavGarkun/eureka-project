create table tickets(id serial primary key,
                     subject varchar(50) not null,
                     number smallint not null,
                     content varchar(200) not null
);