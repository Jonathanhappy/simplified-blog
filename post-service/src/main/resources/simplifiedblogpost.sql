CREATE TABLE "posts" (
    "postId" serial NOT NULL,
    PRIMARY KEY ("postId"),
    "title" character varying(30),
    "post_content" character varying(50),
    "date_posted" date NOT NULL
);