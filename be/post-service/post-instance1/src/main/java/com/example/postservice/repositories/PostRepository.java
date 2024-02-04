package com.example.postservice.repositories;

import com.example.postservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, value = "select\n" +
            "\ttbl2.*\n" +
            "from\n" +
            "\t(\n" +
            "\tselect\n" +
            "\t\tp.id,\n" +
            "\t\tmax(l.created_time) cmt_time_user\n" +
            "\tfrom\n" +
            "\t\tposts p\n" +
            "\tleft join comments l on\n" +
            "\t\tp.id = l.post_id\n" +
            "\twhere\n" +
            "\t\tp.user_id = :userId\n" +
            "\tgroup by\n" +
            "\t\tp.id) tbl1\n" +
            "inner join (\n" +
            "\tselect\n" +
            "\t\tp.id,\n" +
            "\t\tp.privacy,\n" +
            "\t\tp.content,\n" +
            "\t\tp.created_time,\n" +
            "\t\tp.number_like,\n" +
            "\t\tp.number_comment,\n" +
            "\t\tp.number_share,\n" +
            "\t\tl.user_id user_id_comment,\n" +
            "\t\tl.content cmt,\n" +
            "\t\tl.created_time cmt_time\n" +
            "\tfrom\n" +
            "\t\tposts p\n" +
            "\tleft join comments l on\n" +
            "\t\tp.id = l.post_id\n" +
            "\twhere\n" +
            "\t\tp.user_id = :userId) tbl2 on\n" +
            "\ttbl1.id = tbl2.id\n" +
            "\tand tbl1.cmt_time_user = tbl2.cmt_time\n" +
            "group by\n" +
            "\ttbl1.id order by tbl2.id desc limit 5")
    List<Map<String, Object>> getListPost(@Param("userId") String userId);
}
