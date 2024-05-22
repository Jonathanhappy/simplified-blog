CREATE TABLE "posts" (
    "id" serial NOT NULL,
    PRIMARY KEY ("id"),
    "title" character varying(30),
    "post_content" character varying(50),
    "date_posted" date NOT NULL
);