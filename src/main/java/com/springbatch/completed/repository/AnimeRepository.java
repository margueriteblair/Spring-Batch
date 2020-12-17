package com.springbatch.completed.repository;

import com.springbatch.completed.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, String> {
}
