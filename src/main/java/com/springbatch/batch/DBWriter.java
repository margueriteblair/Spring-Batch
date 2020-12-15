package com.springbatch.batch;

import com.springbatch.model.Anime;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Anime> {
    @Override
    public void write(List<? extends Anime> list) throws Exception {

    }
}
