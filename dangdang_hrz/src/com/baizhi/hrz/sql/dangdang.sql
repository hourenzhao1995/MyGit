drop table book
INSERT INTO ADMIN VALUES ('1', 'admin', 'admin');

drop table admin
CREATE TABLE ADMIN(
 ID VARCHAR2(36 BYTE) NOT NULL ,
 USERNAME" VARCHAR2(40 BYTE) NULL ,
 PASSWORD" VARCHAR2(40 BYTE) NULL 
)
create table Admin(
id varchar2(36) not null,
username varchar2(40) not null,
password varchar2(40) not null
)
select * from admin
select id,username,password from admin where username='admin' and password='admin'
select * from shop_user where username='admin' and password='123'

select * from admin where username='admin' and password='password'