    INSERT INTO squaremeals.dish
    (active,
     description,
     name,
    price,
    url_image,
    id_category,
    id_restaurant)
    VALUES
    (1,
    'Fish Blue',
    'Fish Blue',
     15,
    'https://www.shutterstock.com/image-photo/salad-avocado-pecans-260nw-398328580.jpg',
    1,
    1);

    INSERT INTO squaremeals.category
    (description, name)
    VALUES
    (
    'Main dish',
    'Main dish'
    );

    INSERT INTO squaremeals.restaurant
    (address, id_owner, name, phone, tin, url_logo)
    VALUES(
    'Old West Street',
    5, 'The Buffalo',
    '+573104567878',
    '910101101',
    'https://img.lalr.co/cms/2020/12/03171752/LOCACIONES-DESCORTES-NOV-2020-1.jpg?size=xl'
    );