-- CREATE DATABASE shop;

CREATE TABLE public.goods
(
    id SERIAL PRIMARY KEY NOT NULL,
    price BIGINT
);
CREATE UNIQUE INDEX goods_id_uindex ON public.goods (id);


CREATE TABLE public.orders
(
    id SERIAL PRIMARY KEY NOT NULL,
    address VARCHAR(1024) NOT NULL,
    date DATE,
    phone BIGINT NOT NULL,
    customer_name VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX orders_id_uindex ON public.orders (id);


CREATE TABLE public.good_order
(
    id SERIAL PRIMARY KEY NOT NULL,
    good_id INT NOT NULL,
    order_id INT NOT NULL,
    CONSTRAINT good_order_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id),
    CONSTRAINT good_order_orders_id_fk FOREIGN KEY (order_id) REFERENCES orders (id)
);
CREATE UNIQUE INDEX good_order_id_uindex ON public.good_order (id);


CREATE TABLE public.shirts
(
  size VARCHAR(10) NOT NULL,
  color VARCHAR(255) NOT NULL,
  good_id INT NOT NULL PRIMARY KEY NOT NULL,
  CONSTRAINT shirts_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id)
);
CREATE UNIQUE INDEX shirts_pkey ON public.shirts (good_id);


CREATE TABLE public.cups
(
  good_id INT PRIMARY KEY NOT NULL,
  capacity INT NOT NULL,
  CONSTRAINT cups_goods_id_fk FOREIGN KEY (good_id) REFERENCES goods (id)
);
CREATE UNIQUE INDEX cups_good_id_uindex ON public.cups (good_id);