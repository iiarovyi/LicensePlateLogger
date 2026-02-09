create table Booth (
                       id IDENTITY PRIMARY KEY,
                       boothType VARCHAR(20),
                       latitude DOUBLE,
                       longitude DOUBLE,
                       direction CHAR(1)
);

create table Log (
                     id IDENTITY PRIMARY KEY,
                     timestamp BIGINT,
                     licencePlate VARCHAR(20),
                     booth_id BIGINT NOT NULL,
                     CONSTRAINT fk_booth
                         FOREIGN KEY(booth_id)
                             REFERENCES booth(id)
);

/*
1770576103506   TNT123XT    ENTRY   89.1234,123.3212    E
1770576203506   TNT123XT    PASS    89.1234,123.3313    E
1770576303506   TNT123XT    PASS    89.1234,123.3414    E
1770576403506   TNT123XT    PASS    89.1234,123.3515    E
1770576503506   TNT123XT    PASS    89.1234,123.3616    E
1770576603506   TNT123XT    EXIT    89.1234,123.3717    E
 */
INSERT INTO Booth
(boothtype, latitude, longitude, direction)
VALUES
    ('ENTRY', 89.1234, 123.3212, 'E'),
    ('PASS', 89.1234, 123.3313, 'E'),
    ('PASS', 89.1234, 123.3413, 'E'),
    ('PASS', 89.1234, 123.3513, 'E'),
    ('PASS', 89.1234, 123.3613, 'E'),
    ('EXIT', 89.1234, 123.3713, 'E');


INSERT INTO Log
(timestamp, licenceplate, booth_id)
VALUES
    ( 1770576103506, 'TNT123XT', 1 ),
    ( 1770576203506, 'TNT123XT', 2 ),
    ( 1770576303506, 'TNT123XT', 3 ),
    ( 1770576403506, 'TNT123XT', 4 ),
    ( 1770576503506, 'TNT123XT', 5 ),
    ( 1770576603506, 'TNT123XT', 6 );

/*
 To check records correctly joined
 */
-- SELECT l.timestamp, l.licencePlate, b.boothtype, b.latitude, b.longitude, b.direction FROM Log l left join Booth b on l.booth_id = b.id;