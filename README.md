# ELBOOK2022


ELBOOK2022/src/main/resources/application.properties

```
server.port=8043　 #ポート番号の指定
spring.datasource.url=jdbc:mysql://localhost/ELBOOK2022　　#DB名　下記のSQLを使用する場合変更なし
spring.datasource.username=root　　　　        #ローカル環境のDBの名前
spring.datasource.password=hasegawa123   #ローカル環境のDBのパスワード
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


```sql

--DBが存在しない場合は、作成をする
CREATE DATABASE ELBOOK2022 ;



/* 下記テーブル作成文 */ 

-- 新テーブルの作成
CREATE  TABLE EL_USER  (
    user_id int(4)  auto_increment not null primary key
  , user_name varchar(30) not null
  , mail varchar(60) not null
  , pass varchar(20) default '9999' not null
  , create_time timestamp
  , delete_flg boolean default 0 not null
 ) ;

 
 ```
