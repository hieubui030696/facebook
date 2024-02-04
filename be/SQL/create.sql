CREATE TABLE `comments` (
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `content` longtext,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`post_id`, `user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `likes` (
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`post_id`, `user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `privacy` tinyint NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10000001 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `shares` (
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`post_id`, `user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` tinyint DEFAULT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE = InnoDB AUTO_INCREMENT = 1000001 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- fake data users
insert into
  users with recursive cte(
    id,
    usern,
    username,
    pass,
    password,
    gender,
    created_time
  ) as (
    select
      10000000 as id,
      'username' as usern,
      'username10000000' as username,
      'password' as pass,
      'password 10000000' as password,
      floor(RAND() * 3) as gender,
      '2020-01-01 00:00:00' as created_time
    union
    select
      cte.id - 1,
      cte.usern,
      concat(cte.usern, cte.id - 1) as username,
      cte.pass,
      concat(cte.pass, cte.id - 1) as password,
      floor(RAND() * 3) as gender,
      DATE_SUB(cte.created_time, INTERVAL 25 second)
    from
      cte
    where
      cte.id > 1
  )
select
  /*+ SET_VAR(cte_max_recursion_depth = 10M) */
  id,
  username,
  password,
  gender,
  created_time
from
  cte
order by
  id;

-- fake data posts
insert into
  posts with recursive cte(
    id,
    l10,
    user_id,
    privacy,
    content,
    created_time
  ) as (
    select
      1 as id,
      1 as l10,
      1 as user_id,
      floor(RAND() * 3) as privacy,
      'this is content' as content,
      '2020-01-01 00:00:00' as created_time
    union
    select
      cte.id + 1,
      if(cte.l10 = 10, 1, cte.l10 + 1) as l10,
      if(cte.l10 = 10, cte.user_id + 1, cte.user_id) as user_id,
      floor(RAND() * 3) as privacy,
      'this is content' as content,
      DATE_add(cte.created_time, interval 5 second) as created_time
    from
      cte
    where
      cte.id < 1000000
  )
select
  /*+ SET_VAR(cte_max_recursion_depth = 10M) */
  id,
  user_id,
  privacy,
  content,
  created_time
from
  cte;

-- fake data comments
insert into
  comments with recursive cte(id, content, created_time) as (
    select
      1 as id,
      'this is content' as content,
      '2022-01-01 01:00:00' as created_time
    union
    select
      cte.id + 1,
      'this is content' as content,
      date_add(cte.created_time, interval 1 second) as created_time
    from
      cte
    where
      cte.id < 20000000
  )
select
  /*+ SET_VAR(cte_max_recursion_depth = 20M) */
  tbl2.id1 post_id,
  tbl2.id2 user_id,
  cte.content,
  cte.created_time
from
  cte
  inner join (
    select
      row_number() over (
        order by
          s1.id
      ) as rowNumber,
      s1.id id1,
      s2.id id2
    from
      posts s1
      inner join posts s2
    where
      s1.id >= 9990001
      and s2.id >= 9990001
  ) tbl2 on cte.id = tbl2.rowNumber;

-- fake data likes
insert into
  likes
select
  post_id,
  user_id
from
  comments;

--fake data shares
insert into
  shares
select
  *
from
  likes;