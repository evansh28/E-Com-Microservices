-- -- Create the category table if it does not exist
-- create table if not exists category (
--     id integer not null primary key,
--     descricption varchar(255),  -- Note: Check the spelling of "descricption"; it seems like a typo.
--     name varchar(255)
-- );

-- -- Create the product table if it does not exist
-- create table if not exists product (
--     id integer not null primary key,
--     descricption varchar(255),  -- Same typo here if it's unintentional
--     name varchar(255),
--     available_quantity double precision not null,
--     price numeric(38, 2),
--     category_id integer 
--                 constraint fk_category references category (id)
-- );

-- -- Create sequences for primary key auto-increment, if needed
-- create sequence if not exists category_seq increment by 50;
-- create sequence if not exists product_seq increment by 50;

-- -- Add the available_quantity column to the category table if it doesn't already exist
-- DO $$
-- BEGIN
--     IF NOT EXISTS (SELECT 1 FROM information_schema.columns 
--                    WHERE table_name = 'category' AND column_name = 'available_quantity') THEN
--         ALTER TABLE category ADD COLUMN available_quantity double precision;
--     END IF;
-- END $$;
