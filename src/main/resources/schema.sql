-- CREATE DATABASE shop;


CREATE TABLE public.types
(
  id   INT SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(25)            NOT NULL,
);
CREATE UNIQUE INDEX types_pkey
  ON public.types (id);


CREATE TABLE public.goods
(
  id          BIGINT SERIAL PRIMARY KEY NOT NULL,
  name        VARCHAR(25)               NOT NULL,
  description VARCHAR(1024)             NOT NULL,
  type_id     INT                       NOT NULL,
  price       BIGINT                    NOT NULL,
  images      ARRAY,
  CONSTRAINT types_goods_id_fk FOREIGN KEY (type_id) REFERENCES types (id)
);
CREATE UNIQUE INDEX goods_id_uindex
  ON public.goods (id);

CREATE TABLE public.addresses (
  id     BIGINT SERIAL NOT NULL,
  zip    VARCHAR(25),
  street VARCHAR(255)  NOT NULL,
  rest   VARCHAR(255)  NOT NULL,
);
CREATE UNIQUE INDEX addresses_id_uindex
  ON public.addresses (id);

CREATE TABLE public.orders
(
  id            BIGINT SERIAL PRIMARY KEY NOT NULL,
  address_id    BIGINT,
  email         VARCHAR(255),
  creation_date TIMESTAMP                 NOT NULL,
  user_id       BIGINT,
  phone         VARCHAR(25)               NOT NULL
);
CREATE UNIQUE INDEX orders_id_uindex
  ON public.orders (id);


CREATE TABLE public.good_order
(
  id       BIGINT SERIAL PRIMARY KEY NOT NULL,
  good_id  BIGINT                    NOT NULL,
  order_id BIGINT                    NOT NULL,
  CONSTRAINT good_order_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id),
  CONSTRAINT good_order_orders_id_fk FOREIGN KEY (order_id) REFERENCES orders (id)
);
CREATE UNIQUE INDEX good_order_id_uindex
  ON public.good_order (id);

CREATE TABLE public.shirts
(
  size    VARCHAR(10)  NOT NULL,
  color   VARCHAR(255) NOT NULL,
  good_id BIGINT       NOT NULL PRIMARY KEY NOT NULL,
  CONSTRAINT shirts_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id)
);
CREATE UNIQUE INDEX shirts_pkey
  ON public.shirts (good_id);


CREATE TABLE public.cups
(
  good_id  BIGINT SERIAL PRIMARY KEY NOT NULL,
  capacity INT                       NOT NULL,
  CONSTRAINT cups_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id)
);
CREATE UNIQUE INDEX cups_good_id_uindex
  ON public.cups (good_id);

CREATE TABLE public.users (
  id         BIGINT UNIQUE NOT NULL,
  name       VARCHAR(255)  NOT NULL,
  surname    VARCHAR(255)  NOT NULL,
  email      VARCHAR(255)  NOT NULL,
  address_id BIGINT,
  rights     INT           NOT NULL,
  phone      VARCHAR(25)
);
CREATE UNIQUE INDEX users_id_uindex
  ON public.users (id);

CREATE TABLE public.good_images
(
  good_id BIGINT       NOT NULL,
  images  VARCHAR(255) NOT NULL
);