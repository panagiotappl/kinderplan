--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: parent_entity; Type: TABLE; Schema: public; Owner: kinderplan
--

CREATE TABLE parent_entity (
    id integer NOT NULL,
    points integer,
    user_id integer
);


ALTER TABLE parent_entity OWNER TO kinderplan;

--
-- Name: parents_id_seq; Type: SEQUENCE; Schema: public; Owner: kinderplan
--

CREATE SEQUENCE parents_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE parents_id_seq OWNER TO kinderplan;

--
-- Name: provider_entity; Type: TABLE; Schema: public; Owner: kinderplan
--

CREATE TABLE provider_entity (
    id integer NOT NULL,
    company_name character varying(255),
    vat_number integer,
    user_id integer
);


ALTER TABLE provider_entity OWNER TO kinderplan;

--
-- Name: providers_id_seq; Type: SEQUENCE; Schema: public; Owner: kinderplan
--

CREATE SEQUENCE providers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE providers_id_seq OWNER TO kinderplan;

--
-- Name: user_entity; Type: TABLE; Schema: public; Owner: kinderplan
--

CREATE TABLE user_entity (
    id integer NOT NULL,
    created_date timestamp without time zone,
    email character varying(255),
    last_login timestamp without time zone,
    name character varying(255),
    password character varying(255),
    role character varying(255),
    surname character varying(255),
    updated_date timestamp without time zone,
    validated boolean
);


ALTER TABLE user_entity OWNER TO kinderplan;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: kinderplan
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO kinderplan;

--
-- Data for Name: parent_entity; Type: TABLE DATA; Schema: public; Owner: kinderplan
--

COPY parent_entity (id, points, user_id) FROM stdin;
\.


--
-- Name: parents_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kinderplan
--

SELECT pg_catalog.setval('parents_id_seq', 1, false);


--
-- Data for Name: provider_entity; Type: TABLE DATA; Schema: public; Owner: kinderplan
--

COPY provider_entity (id, company_name, vat_number, user_id) FROM stdin;
\.


--
-- Name: providers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kinderplan
--

SELECT pg_catalog.setval('providers_id_seq', 1, false);


--
-- Data for Name: user_entity; Type: TABLE DATA; Schema: public; Owner: kinderplan
--

COPY user_entity (id, created_date, email, last_login, name, password, role, surname, updated_date, validated) FROM stdin;
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kinderplan
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- Name: parent_entity parent_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY parent_entity
    ADD CONSTRAINT parent_entity_pkey PRIMARY KEY (id);


--
-- Name: provider_entity provider_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY provider_entity
    ADD CONSTRAINT provider_entity_pkey PRIMARY KEY (id);


--
-- Name: user_entity uk4xad1enskw4j1t2866f7sodrx; Type: CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY user_entity
    ADD CONSTRAINT uk4xad1enskw4j1t2866f7sodrx UNIQUE (email);


--
-- Name: user_entity user_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY user_entity
    ADD CONSTRAINT user_entity_pkey PRIMARY KEY (id);


--
-- Name: parent_entity fkafey7lht3v509ssetqwip39vr; Type: FK CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY parent_entity
    ADD CONSTRAINT fkafey7lht3v509ssetqwip39vr FOREIGN KEY (user_id) REFERENCES user_entity(id);


--
-- Name: provider_entity fkbtxyp4yvetjvy16pw5nnaghsm; Type: FK CONSTRAINT; Schema: public; Owner: kinderplan
--

ALTER TABLE ONLY provider_entity
    ADD CONSTRAINT fkbtxyp4yvetjvy16pw5nnaghsm FOREIGN KEY (user_id) REFERENCES user_entity(id);


--
-- PostgreSQL database dump complete
--

