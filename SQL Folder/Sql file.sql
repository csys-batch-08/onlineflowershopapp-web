create table user_details(user_id int  generated by default as identity(start with 10 increment by 1 ) primary key,
                          name varchar2(30)cre not null,
                          email_id varchar2(100) unique not null,
                          password varchar2(15) not null,
                          address varchar2(50),
                          mobile_number number);
select*from user_details;
desc user_details;
select email_id,flower_name,order_quantity,total_price,order_date from cart_items 
inner join user_details using (user_id)
inner join inventory using(flower_id) where user_id=30;

update  user_details set walllet=0 where user_id=10;
alter table user_details add walllet int default '50000';
alter table user_details add Role varchar2(20) default 'user';
insert into user_details (name,email_id,password,address,mobile_number,role) values ('Premalatha','prem@gmail.com','jeev0702','Madurai',6380869312,'Admin');



create table inventory(flower_id int generated by default as identity(start with 10 increment by 1),
flower_name varchar2(50),
flower_description varchar2(100),
color varchar2(50),
retail_price number,
category_name varchar2(50),
constraint pk_flowerid primary key(flower_id));
select*from inventory;
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('mixed roses bouquet','wrapped in pink cellophane,tied withpink rippon','mixed color flowers',
                                                                                              1100); 
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('pink carnivel','20 pink flowers,wrapped in pink paper,tied with rippon','pink color flowers',
                                                                                              726,'carnations');
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('blue orchids bunch','6 blue orchids and green leaves asserted','blue color flowers',899,'orchids');
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('colorful gerberas bunch','Bunch of 20 Mix Gerberas,Cellophane wrapping With Ribbon Bow Tied',
                                                                                              'mixed color flowers',894,'gerberas');
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('vase of red love',' 2 Red Rose,Glass Vase','red color flowers',895,'Roses');                                                                                           
 
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Lilies Passion','6 Yellow Lilies, Wrapped in Yellow Paper Packing,Tied With Orange Ribbon','Yellow Lilies flower',1165,'Lilies','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/h/o/home-flower-4.png');

insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Basket of 20 White Roses','20 White rose, A Round Basket, Seasonal Green Fillers','White Color Flowers',1233,'Roses','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/b/a/basket-of-20-white-roses-995.jpg');

insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Graceful Touch','5 Pink Carnations, 12 Red Roses and 8 White Gerberas A glass vase','Mixed color flowers',1180,'Roses and Orchids','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/g/r/graceful_touch.jpg'); 

insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Colourful Blooms','Basket Arrangement of 4 reds Roses, 4 Blue Orchid, 6 Pink Carnation and a 6 inch teddy','Mixed color flowers',1345,'mixed flowers','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/c/o/colourful_blooms.jpg');

insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Enchanting Red Carnation Bunch','8 Red Carnation Bunch,Wrapped in White PaperTied with Red RibbonSeasonal','Red Color Flowers',625,'carnations','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/e/n/enchanting_red_carnation_bunch.jpg');
insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Peaceful White Carnation','Bouquet of 12 White Carnations','White color Flowers',668,'carnations','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/p/e/peaceful_white_carnation.jpg');

insert into inventory(flower_name,flower_description,color,retail_price,category_name,picture) values('Lovely Pink Posy','30 Pink Rose,Green Fillers,One Cane Basket','pink color Flowers',1567,'Roses','https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/l/o/lovely_pink_posy.jpg');

select distinct category_name from inventory;


update inventory set rating=5 where flower_id=13;
select rating from inventory where flower_name='pink carnivel';
select*from inventory;

s




update inventory set picture='https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x/11c945e9b0d7a3e2da798549b111dafd/m/f/mfa1747.jpg' where flower_id=10;
update inventory set picture='https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/p/i/pink_carnival.jpg' where flower_id=11;
update inventory set picture='https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/b/l/blue-orchids-bunch-541.jpg' where flower_id=12;
update inventory set picture='https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/m/i/mixed-gerbera-bunch-645.jpg' where flower_id=13;
update inventory set picture='https://225495-687452-raikfcquaxqncofqfm.stackpathdns.com/media/catalog/product/cache/1/small_image/300x300/1aca54b891ac709216cb88c50180f5e9/v/a/vase_of_red_love.jpg' where flower_id=14;

alter table inventory add rating number default 0;
alter table inventory add picture varchar2(2000);
alter table inventory drop column picture;


desc inventory;                                                                                           
 select*from inventory; 
 
 select*from user_details;
 commit;                                                                                             


create table cart_items(cart_id int generated by default as identity (start with 100 increment by 1),
                        flower_id int,
                        user_id int,
                        order_quantity int not null,
                        total_price number(10,2),
                        foreign key(user_id) references user_details(user_id),
                        foreign key(flower_id) references inventory(flower_id),
                        constraint pk_cartid primary key(cart_id));
                        
alter table cart_items add order_date date; 
alter table cart_items drop column order_date;
alter table cart_items add order_date date default sysdate;

insert into cart_items(flower_id,user_id,order_quantity,total_price) values(11,11,1,726);
delete from cart_items where cart_id=106;
select*from cart_items;




                   
                        
drop table cart_items cascade constraints;                        
                       

                 
                        

commit;

select * from user_details where email_id='prem@gmail.com' and password='jeev0702';