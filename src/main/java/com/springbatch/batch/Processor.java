package com.springbatch.batch;

import com.springbatch.model.Anime;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<Anime, Anime> {

    @Override
    public Anime process(Anime anime) throws Exception {
        return anime;
    }
}
