INSERT INTO public.goods (id, price, name) VALUES (1, 100, 'cute t shirt');
INSERT INTO public.goods (id, price, name) VALUES (2, 200, 'cool sweetshot');
INSERT INTO public.goods (id, price, name) VALUES (3, 50, 'cup for coffee');

INSERT INTO public.cups (good_id, capacity) VALUES (3, 400);

-- INSERT INTO public.shirts (size, color, good_id) VALUES ('M', 'red', 2);
INSERT INTO public.shirts (size, color, good_id, images) VALUES ('M', 'red', 2, 'images/1.jpg');
INSERT INTO public.shirts (size, color, good_id) VALUES ('XXL', 'greed', 1);

INSERT INTO public.orders (id, address, date, phone, customer_name) VALUES (1, 'SPB nauki 17', '2017-03-14', 79111233456, 'Max');
INSERT INTO public.orders (id, address, date, phone, customer_name) VALUES (2, 'SPB ITMO', '2017-03-18', 79291234567, 'Den');

INSERT INTO public.good_order (id, good_id, order_id) VALUES (1, 2, 1);
INSERT INTO public.good_order (id, good_id, order_id) VALUES (2, 3, 1);
INSERT INTO public.good_order (id, good_id, order_id) VALUES (3, 1, 1);