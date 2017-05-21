


-- ----------------------------
--  Table structure for parents
-- ----------------------------
-- Table: public.parents

-- DROP TABLE public.parents;
DROP TABLE IF EXISTS public.parents CASCADE ;
CREATE TABLE public.parents
(
    id integer NOT NULL DEFAULT nextval('parents_id_seq'::regclass),
    points integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT "parents_pkey" PRIMARY KEY (id),
    CONSTRAINT parent_user_id_unique UNIQUE (user_id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.parents
    OWNER to kinderplan;

-- Index: parents_id_key

-- DROP INDEX public."parents_id_key";

CREATE UNIQUE INDEX "parents_id_key"
    ON public.parents USING btree
    (id)
    TABLESPACE pg_default;

-- ----------------------------
--  Table structure for providers
-- ----------------------------
-- Table: public.providers

-- DROP TABLE public.providers;
DROP TABLE IF EXISTS public.providers CASCADE;
CREATE TABLE public.providers
(
    id integer NOT NULL DEFAULT nextval('providers_id_seq'::regclass),
    vat_number integer NOT NULL,
    company_name character varying COLLATE pg_catalog."default" NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT providers_pkey PRIMARY KEY (id),
    CONSTRAINT user_id_unique UNIQUE (user_id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.providers
    OWNER to kinderplan;

-- ----------------------------
--  Table structure for users_entity
-- ----------------------------
DROP TABLE IF EXISTS public.users_entity CASCADE;
CREATE TABLE public.users_entity
(
    id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    validated boolean NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    updated_date timestamp(6) without time zone NOT NULL,
    last_login timestamp(6) without time zone NOT NULL,
    role character varying COLLATE pg_catalog."default",
    CONSTRAINT users_entity_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users_entity
    OWNER to kinderplan;




		--SEQUENCE for parents
		DROP SEQUENCE IF EXISTS "public"."parents_id_seq" CASCADE;
		CREATE SEQUENCE public.parents_id_seq
		    INCREMENT 1
		    START 1
		    MINVALUE 1
		    MAXVALUE 9223372036854775807
		    CACHE 1;

		ALTER SEQUENCE public.parents_id_seq
		    OWNER TO postgres;

		GRANT SELECT, USAGE ON SEQUENCE public.parents_id_seq TO kinderplan;

		GRANT ALL ON SEQUENCE public.parents_id_seq TO postgres;


		--SEQUENCE FOR providers
		DROP SEQUENCE IF EXISTS public.providers_id_seq CASCADE;
		CREATE SEQUENCE public.providers_id_seq
		    INCREMENT 1
		    START 10
		    MINVALUE 1
		    MAXVALUE 9223372036854775807
		    CACHE 1;

		ALTER SEQUENCE public.providers_id_seq
		    OWNER TO postgres;

		GRANT SELECT, USAGE ON SEQUENCE public.providers_id_seq TO kinderplan;

		GRANT ALL ON SEQUENCE public.providers_id_seq TO postgres;

		--SEQUENCE FOR users_entity
		DROP SEQUENCE IF EXISTS public.user_id_seq CASCADE;
		CREATE SEQUENCE public.user_id_seq
		    INCREMENT 1
		    START 16
		    MINVALUE 1
		    MAXVALUE 9223372036854775807
		    CACHE 1;

		ALTER SEQUENCE public.user_id_seq
		    OWNER TO postgres;

		GRANT SELECT, USAGE ON SEQUENCE public.user_id_seq TO kinderplan;

		GRANT ALL ON SEQUENCE public.user_id_seq TO postgres;


		-- ----------------------------
		--  Table structure for categories
		-- ----------------------------
		DROP TABLE IF EXISTS "public"."categories";
		CREATE TABLE "public"."categories" (
			"id" int4 NOT NULL,
			"category" varchar NOT NULL COLLATE "default"
		)
		WITH (OIDS=FALSE);
		ALTER TABLE "public"."categories" OWNER TO "kinderplan";
-- ----------------------------
--  Table structure for events
-- ----------------------------
DROP TABLE IF EXISTS "public"."events";
CREATE TABLE "public"."events" (
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
ALTER TABLE "public"."events" OWNER TO "kinderplan";

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
--  Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS "public"."transactions";
CREATE TABLE "public"."transactions" (
	"id" int4 NOT NULL,
	"user" int4 NOT NULL,
	"ammount" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"event" int4
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."transactions" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for comments_events
-- ----------------------------
DROP TABLE IF EXISTS "public"."comments_events";
CREATE TABLE "public"."comments_events" (
	"id" int4 NOT NULL,
	"comment" varchar NOT NULL COLLATE "default",
	"event" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"user_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."comments_events" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for comments_provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."comments_provider";
CREATE TABLE "public"."comments_provider" (
	"id" int4 NOT NULL,
	"comment" varchar NOT NULL COLLATE "default",
	"provider" int4 NOT NULL,
	"date" timestamp(6) NOT NULL,
	"user_id" int4 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."comments_provider" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for event_dates
-- ----------------------------
DROP TABLE IF EXISTS "public"."event_dates";
CREATE TABLE "public"."event_dates" (
	"id" int4 NOT NULL,
	"event" int4 NOT NULL,
	"start_date" timestamp(6) NOT NULL,
	"end_date" timestamp(6) NOT NULL,
	"available_tickets" int4 NOT NULL,
	"tickets_sold" int4 NOT NULL DEFAULT 0,
	"note" varchar COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."event_dates" OWNER TO "kinderplan";

-- ----------------------------
--  Table structure for invoices
-- ----------------------------
DROP TABLE IF EXISTS "public"."invoices";
CREATE TABLE "public"."invoices" (
	"id" int4 NOT NULL,
	"ammount" float4 NOT NULL,
	"provider" int4 NOT NULL,
	"date_issued" timestamp(6) NOT NULL,
	"date_send" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."invoices" OWNER TO "kinderplan";

-- ----------------------------
--  Primary key structure for table categories
-- ----------------------------
ALTER TABLE "public"."categories" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;




-- ----------------------------
--  Indexes structure for table providers
-- ----------------------------
CREATE UNIQUE INDEX  "providers_id_key" ON "public"."providers" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);



-- ----------------------------
--  Indexes structure for table users_entity
-- ----------------------------
CREATE UNIQUE INDEX  "Users_id_key" ON "public"."users_entity" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table events
-- ----------------------------
ALTER TABLE "public"."events" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table events
-- ----------------------------
CREATE UNIQUE INDEX  "events_id_key" ON "public"."events" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table event_category
-- ----------------------------
ALTER TABLE "public"."event_category" ADD PRIMARY KEY ("event_id", "category_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table transactions
-- ----------------------------
ALTER TABLE "public"."transactions" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table comments_events
-- ----------------------------
ALTER TABLE "public"."comments_events" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table comments_provider
-- ----------------------------
ALTER TABLE "public"."comments_provider" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table event_dates
-- ----------------------------
ALTER TABLE "public"."event_dates" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table event_dates
-- ----------------------------
CREATE UNIQUE INDEX  "event_dates_id_key" ON "public"."event_dates" USING btree("id" "pg_catalog"."int4_ops" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table invoices
-- ----------------------------
ALTER TABLE "public"."invoices" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table events
-- ----------------------------
ALTER TABLE "public"."events" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."providers" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table event_category
-- ----------------------------
ALTER TABLE "public"."event_category" ADD CONSTRAINT "event_category_category_id_fkey" FOREIGN KEY ("category_id") REFERENCES "public"."categories" ("id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."event_category" ADD CONSTRAINT "event_category_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "public"."events" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table transactions
-- ----------------------------
ALTER TABLE "public"."transactions" ADD CONSTRAINT "user" FOREIGN KEY ("user") REFERENCES "public"."parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."transactions" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."event_dates" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table comments_events
-- ----------------------------
ALTER TABLE "public"."comments_events" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."comments_events" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."events" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table comments_provider
-- ----------------------------
ALTER TABLE "public"."comments_provider" ADD CONSTRAINT "user_id" FOREIGN KEY ("user_id") REFERENCES "public"."parents" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."comments_provider" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."providers" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table event_dates
-- ----------------------------
ALTER TABLE "public"."event_dates" ADD CONSTRAINT "event" FOREIGN KEY ("event") REFERENCES "public"."events" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table invoices
-- ----------------------------
ALTER TABLE "public"."invoices" ADD CONSTRAINT "provider" FOREIGN KEY ("provider") REFERENCES "public"."providers" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
