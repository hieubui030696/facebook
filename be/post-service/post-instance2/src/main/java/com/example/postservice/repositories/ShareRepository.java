package com.example.postservice.repositories;

import com.example.postservice.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {

}
