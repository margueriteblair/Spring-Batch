package com.springbatch.batch;

import com.springbatch.model.Anime;
import com.springbatch.repository.AnimeRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Anime> {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public void write(List<? extends Anime> listOfAnimes) throws Exception {
        System.out.println("Data being saved for animes: " + listOfAnimes);
        animeRepository.saveAll(listOfAnimes);
    }
}
