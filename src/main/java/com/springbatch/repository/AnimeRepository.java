package com.springbatch.repository;

import com.springbatch.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, String> {
}
