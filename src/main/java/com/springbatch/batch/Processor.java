package com.springbatch.batch;

import com.springbatch.model.Anime;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Anime, Anime> {

    @Override
    public Anime process(Anime anime) throws Exception {
        return anime;
    }
}