/*
 Navicat PostgreSQL Data Transfer

 Source Server         : Kinderplan_PSQL
 Source Server Version : 90603
 Source Host           : localhost
 Source Database       : kinderplan_db
 Source Schema         : public

 Target Server Version : 90603
 File Encoding         : utf-8

 Date: 05/20/2017 13:39:40 PM
*/

-- ----------------------------
--  Table structure for Categories
-- ----------------------------
DROP TABLE IF EXISTS "public"."Categories";
CREATE TABLE "public"."Categories" (
	"id" int4 NOT NULL,
	"category" varchar NOT NULL COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Categories" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Parents
-- ----------------------------
DROP TABLE IF EXISTS "public"."Parents";
CREATE TABLE "public"."Parents" (
	"id" int4 NOT NULL,
	"name" varchar NOT NULL COLLATE "default",
	"surname" varchar NOT NULL COLLATE "default",
	"longitude" float8 NOT NULL,
	"latitude" float8 NOT NULL,
	"phone" varchar NOT NULL COLLATE "default",
	"user_id" int4 NOT NULL,
	"points" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Parents" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Providers
-- ----------------------------
DROP TABLE IF EXISTS "public"."Providers";
CREATE TABLE "public"."Providers" (
	"id" int4 NOT NULL,
	"name" varchar NOT NULL COLLATE "default",
	"surname" varchar NOT NULL COLLATE "default",
	"vat_number" int4 NOT NULL,
	"company_name" varchar NOT NULL COLLATE "default",
	"phone" varchar NOT NULL COLLATE "default",
	"address" varchar NOT NULL COLLATE "default",
	"longitude" float8 NOT NULL,
	"latitude" float8 NOT NULL,
	"user_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Providers" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for users_entity
-- ----------------------------
DROP TABLE IF EXISTS "public"."users_entity";
CREATE TABLE "public"."users_entity" (
	"id" int4 NOT NULL,
	"email" varchar NOT NULL COLLATE "default",
	"password" varchar NOT NULL COLLATE "default",
	"category" int4 NOT NULL,
	"user_id" int4 NOT NULL,
	"validated" bool NOT NULL,
	"date_created" timestamp(6) NOT NULL,
	"last_login" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."users_entity" OWNER TO "kinderplan";

COMMENT ON COLUMN "public"."users_entity"."user_id" IS '(null)';

-- ----------------------------
--  Table structure for Events
-- ----------------------------
DROP TABLE IF EXISTS "public"."Events";
CREATE TABLE "public"."Events" (
	"id" int4 NOT NULL,
	"name" varchar NOT NULL COLLATE "default",
	"provider" int4 NOT NULL,
	"address" varchar NOT NULL COLLATE "default",
	"longitude" float8 NOT NULL,
	"latitude" float8 NOT NULL,
	"age_from" int4 NOT NULL,
	"age_to" int4 NOT NULL,
	"ticket_price" int4 NOT NULL,
	"description" varchar NOT NULL COLLATE "default",
	"date_created" timestamp(6) NOT NULL,
	"date_ending" timestamp(6) NOT NULL,
	"date_starting" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Events" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for event_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."event_category";
CREATE TABLE "public"."event_category" (
	"event_id" int4 NOT NULL,
	"category_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."event_category" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Transactions
-- ----------------------------
DROP TABLE IF EXISTS "public"."Transactions";
CREATE TABLE "public"."Transactions" (
	"id" int4 NOT NULL,
	"user" int4 NOT NULL,
	"ammount" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"event" int4
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Transactions" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Comments_Events
-- ----------------------------
DROP TABLE IF EXISTS "public"."Comments_Events";
CREATE TABLE "public"."Comments_Events" (
	"id" int4 NOT NULL,
	"comment" varchar NOT NULL COLLATE "default",
	"event" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"user_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Comments_Events" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Comments_Provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."Comments_Provider";
CREATE TABLE "public"."Comments_Provider" (
	"id" int4 NOT NULL,
	"comment" varchar NOT NULL COLLATE "default",
	"provider" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"user_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Comments_Provider" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Event_Dates
-- ----------------------------
DROP TABLE IF EXISTS "public"."Event_Dates";
CREATE TABLE "public"."Event_Dates" (
	"id" int4 NOT NULL,
	"event" int4 NOT NULL,
	"start_date" timestamp(6) NOT NULL,
	"end_date" timestamp(6) NOT NULL,
	"available_tickets" int4 NOT NULL,
	"tickets_sold" int4 NOT NULL DEFAULT 0,
	"note" varchar COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Event_Dates" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for Invoices
-- ----------------------------
DROP TABLE IF EXISTS "public"."Invoices";
CREATE TABLE "public"."Invoices" (
	"id" int4 NOT NULL,
	"ammount" float4 NOT NULL,
	"provider" int4 NOT NULL,
	"date_issued" timestamp(6) NOT NULL,
	"date_send" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."Invoices" OWNER TO "kinderplan";

-- ----------------------------
--  Primary key structure for table Categories
-- ----------------------------
ALTER TABLE "public"."Categories" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table Parents
-- ----------------------------
ALTER TABLE "public"."Parents" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table Parents
-- ----------------------------
CREATE UNIQUE INDEX  "Parents_id_key" ON "public"."Parents" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table Providers
-- ----------------------------
ALTER TABLE "public"."Providers" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table Providers
-- ----------------------------
CREATE UNIQUE INDEX  "Providers_id_key" ON "public"."Providers" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table users_entity
-- ----------------------------
ALTER TABLE "public"."users_entity" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table users_entity
-- ----------------------------
CREATE UNIQUE INDEX  "Users_id_key" ON "public"."users_entity" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);
CREATE UNIQUE INDEX  "Users_user_id_key" ON "public"."users_entity" USING btree(user_id "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table Events
-- ----------------------------
ALTER TABLE "public"."Events" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table Events
-- ----------------------------
CREATE UNIQUE INDEX  "Events_id_key" ON "public"."Events" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table event_category
-- ----------------------------
ALTER TABLE "public"."event_category" ADD PRIMARY KEY ("event_id", "category_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table Transactions
-- ----------------------------
ALTER TABLE "public"."Transactions" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table Comments_Events
-- ----------------------------
ALTER TABLE "public"."Comments_Events" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table Comments_Provider
-- ----------------------------
ALTER TABLE "public"."Comments_Provider" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table Event_Dates
-- ----------------------------
ALTER TABLE "public"."Event_Dates" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table Event_Dates
-- ----------------------------
CREATE UNIQUE INDEX  "Event_Dates_id_key" ON "public"."Event_Dates" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table Invoices
-- ----------------------------
ALTER TABLE "public"."Invoices" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Parents
-- ----------------------------
ALTER TABLE "public"."Parents" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users_entity" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Providers
-- ----------------------------
ALTER TABLE "public"."Providers" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."users_entity" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Events
-- ----------------------------
ALTER TABLE "public"."Events" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."Providers" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table event_category
-- ----------------------------
ALTER TABLE "public"."event_category" ADD CONSTRAINT "event_category_category_id_fkey" FOREIGN KEY ("category_id") REFERENCES "public"."Categories" ("id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."event_category" ADD CONSTRAINT "event_category_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "public"."Events" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Transactions
-- ----------------------------
ALTER TABLE "public"."Transactions" ADD CONSTRAINT "user" FOREIGN KEY ("user") REFERENCES "public"."Parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."Transactions" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."Event_Dates" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Comments_Events
-- ----------------------------
ALTER TABLE "public"."Comments_Events" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."Parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."Comments_Events" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."Events" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Comments_Provider
-- ----------------------------
ALTER TABLE "public"."Comments_Provider" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."Parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."Comments_Provider" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."Providers" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Event_Dates
-- ----------------------------
ALTER TABLE "public"."Event_Dates" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."Events" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table Invoices
-- ----------------------------
ALTER TABLE "public"."Invoices" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."Providers" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

