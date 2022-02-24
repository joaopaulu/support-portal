CREATE TABLE public."user"
(
    id int8 not null,
    authorities bytea,
    email varchar(255),
    first_name varchar(255),
    is_active boolean not null,
    is_not_locked boolean not null,
    join_date timestamp,
    last_login_date timestamp,
    last_login_date_display timestamp,
    last_name varchar(255),
    password varchar(255),
    profile_image_url varchar(255),
    role varchar(255),
    user_id varchar(255),
    username varchar(255), primary key (id)
);
