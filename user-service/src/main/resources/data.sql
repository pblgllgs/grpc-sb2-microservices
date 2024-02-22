DROP TABLE IF EXISTS "user";

-- INSERT INTO "user"(`login`, `name`, `genre`) VALUES ('matrix', 'neo', 'ACTION'), ('interstellar', 'max', 'DRAMA');

CREATE TABLE "user" AS SELECT * FROM CSVREAD('classpath:user.csv');