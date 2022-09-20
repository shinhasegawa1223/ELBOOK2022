# ELBOOK2022


```sql
CREATE  TABLE EL_USER  (
    user_id int(4)  auto_increment not null primary key
  , user_name varchar(30) not null
  , admin_flg varchar(10)
  , mail varchar(60) not null
  , pass varchar(20) default '9999' not null
  , create_time timestamp
  , update_time datetime
 ) ;
 
 ```
