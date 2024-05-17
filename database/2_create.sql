-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-04-10 12:02:03.122

-- tables
-- Table: business
CREATE TABLE business
(
    id            serial      NOT NULL,
    user_id       int         NOT NULL,
    company_name  varchar(50) NOT NULL,
    phone         varchar(50) NOT NULL,
    email         varchar(50) NOT NULL,
    registry_code varchar(50) NOT NULL,
    vat_number    varchar(50) NULL,
    status        char(1)     NOT NULL,
    CONSTRAINT ID PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county
(
    id     serial      NOT NULL,
    county varchar(50) NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: event_category
CREATE TABLE event_category
(
    id            serial NOT NULL,
    main_event_id int    NOT NULL,
    category_id   int    NOT NULL,
    CONSTRAINT event_category_pk PRIMARY KEY (id)
);

-- Table: event_detail
CREATE TABLE event_detail
(
    id            serial        NOT NULL,
    main_event_id int           NOT NULL,
    county_id     int           NOT NULL,
    date          date          NOT NULL,
    start_time    time          NOT NULL,
    end_time      time          NOT NULL,
    address       varchar(50)   NOT NULL,
    longitude     decimal(8, 6) NOT NULL,
    latitude      decimal(8, 6) NOT NULL,
    CONSTRAINT event_detail_pk PRIMARY KEY (id)
);

-- Table: event_feature
CREATE TABLE event_feature
(
    id            serial NOT NULL,
    main_event_id int    NOT NULL,
    feature_id    int    NOT NULL,
    CONSTRAINT event_feature_pk PRIMARY KEY (id)
);

-- Table: event_ticket
CREATE TABLE event_ticket
(
    id              serial  NOT NULL,
    event_detail_id int     NOT NULL,
    ticket_type_id  int     NOT NULL,
    total           int     NOT NULL,
    available       int     NOT NULL,
    status          char(1) NOT NULL,
    CONSTRAINT event_ticket_pk PRIMARY KEY (id)
);

-- Table: feature
CREATE TABLE feature
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT feature_pk PRIMARY KEY (id)
);

-- Table: main_event
CREATE TABLE main_event
(
    id          serial       NOT NULL,
    business_id int          NOT NULL,
    title       varchar(50)  NOT NULL,
    description varchar(255) NOT NULL,
    image_data  bytea        NOT NULL,
    status      char(1)      NOT NULL,
    CONSTRAINT main_event_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order"
(
    id              serial  NOT NULL,
    user_id         int     NOT NULL,
    event_ticket_id int     NOT NULL,
    status          char(1) NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: ticket_type
CREATE TABLE ticket_type
(
    id            serial      NOT NULL,
    main_event_id int         NOT NULL,
    name          varchar(50) NOT NULL,
    price         int         NOT NULL,
    CONSTRAINT ticket_type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial      NOT NULL,
    role_id  int         NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    status   char(1)     NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: business_user (table: business)
ALTER TABLE business
    ADD CONSTRAINT business_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_category_category (table: event_category)
ALTER TABLE event_category
    ADD CONSTRAINT event_category_category
        FOREIGN KEY (category_id)
            REFERENCES category (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_category_main_event (table: event_category)
ALTER TABLE event_category
    ADD CONSTRAINT event_category_main_event
        FOREIGN KEY (main_event_id)
            REFERENCES main_event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_detail_county (table: event_detail)
ALTER TABLE event_detail
    ADD CONSTRAINT event_detail_county
        FOREIGN KEY (county_id)
            REFERENCES county (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_detail_main_event (table: event_detail)
ALTER TABLE event_detail
    ADD CONSTRAINT event_detail_main_event
        FOREIGN KEY (main_event_id)
            REFERENCES main_event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_feature_feature (table: event_feature)
ALTER TABLE event_feature
    ADD CONSTRAINT event_feature_feature
        FOREIGN KEY (feature_id)
            REFERENCES feature (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_feature_main_event (table: event_feature)
ALTER TABLE event_feature
    ADD CONSTRAINT event_feature_main_event
        FOREIGN KEY (main_event_id)
            REFERENCES main_event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_ticket_event_detail (table: event_ticket)
ALTER TABLE event_ticket
    ADD CONSTRAINT event_ticket_event_detail
        FOREIGN KEY (event_detail_id)
            REFERENCES event_detail (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_ticket_ticket_type (table: event_ticket)
ALTER TABLE event_ticket
    ADD CONSTRAINT event_ticket_ticket_type
        FOREIGN KEY (ticket_type_id)
            REFERENCES ticket_type (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: main_event_business (table: main_event)
ALTER TABLE main_event
    ADD CONSTRAINT main_event_business
        FOREIGN KEY (business_id)
            REFERENCES business (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: order_event_ticket (table: order)
ALTER TABLE "order"
    ADD CONSTRAINT order_event_ticket
        FOREIGN KEY (event_ticket_id)
            REFERENCES event_ticket (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: order_user (table: order)
ALTER TABLE "order"
    ADD CONSTRAINT order_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: ticket_type_main_event (table: ticket_type)
ALTER TABLE ticket_type
    ADD CONSTRAINT ticket_type_main_event
        FOREIGN KEY (main_event_id)
            REFERENCES main_event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

