CREATE TABLE events(
    id bigserial primary key,
    name varchar(100) not null,
    description varchar(500),
    event_type varchar(50) not null,
    occurred_at TIMESTAMP WITH TIME ZONE not null,
    created_at TIMESTAMP WITH TIME ZONE not null DEFAULT now()
);