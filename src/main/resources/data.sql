insert into users(username,password,enabled) values ("admin","123",true)
insert into users(username,password,enabled) values ("moderator","123",true)
insert into users(username,password,enabled) values ("user","123",true)

insert into authorities(username,authority) values ("admin","ROLE_ADMIN")
insert into authorities(username,authority) values ("admin","ROLE_USER")
insert into authorities(username,authority) values ("moderator","ROLE_MODERATOR")
insert into authorities(username,authority) values ("user","ROLE_USER")