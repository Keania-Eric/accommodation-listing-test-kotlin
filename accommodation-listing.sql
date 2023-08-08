-- -------------------------------------------------------------
-- TablePlus 5.3.8(500)
--
-- https://tableplus.com/
--
-- Database: accommodation-listing
-- Generation Time: 2023-08-08 22:33:44.5160
-- -------------------------------------------------------------


DROP TABLE IF EXISTS "public"."hoteliers";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."hoteliers" (
    "id" int4 NOT NULL,
    "name" varchar(255),
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."items";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."items" (
    "id" int4 NOT NULL,
    "availability" int4 NOT NULL,
    "category" varchar(255),
    "image" varchar(255),
    "name" varchar(255),
    "price" int4 NOT NULL,
    "rating" int4,
    "reputation" int4 NOT NULL,
    "reputation_badge" varchar(255),
    "hotelier_id" int4 NOT NULL,
    PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public"."locations";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."locations" (
    "id" int4 NOT NULL,
    "address" varchar(255),
    "city" varchar(255),
    "country" varchar(255),
    "state" varchar(255),
    "zipcode" varchar(255),
    "item_id" int4 NOT NULL,
    PRIMARY KEY ("id")
);

ALTER TABLE "public"."items" ADD FOREIGN KEY ("hotelier_id") REFERENCES "public"."hoteliers"("id");
ALTER TABLE "public"."locations" ADD FOREIGN KEY ("item_id") REFERENCES "public"."items"("id");
