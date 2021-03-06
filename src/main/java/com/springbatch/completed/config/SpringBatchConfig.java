package com.springbatch.completed.config;


import com.springbatch.completed.batch.DBWriter;
import com.springbatch.completed.batch.Processor;
import com.springbatch.completed.model.Anime;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig extends DefaultBatchConfigurer {

    @Autowired
    DBWriter dbWriter;

    @Autowired
    Processor processor;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Anime> itemReader) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<Anime, Anime>chunk(100)
                .reader(itemReader)
                .processor(processor)
                .writer(dbWriter)
                .build();

        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

    }

    @Bean
    public FlatFileItemReader<Anime> itemReader() {
        //@Value("${file.path}") Resource resource
        FlatFileItemReader<Anime> flatFileItemReader = new FlatFileItemReader<Anime>();
        flatFileItemReader.setResource(new FileSystemResource("/Users/margueriteblair/Desktop/anime.csv"));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1); //first line is the header so we can skip it!
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<Anime> lineMapper() {
        DefaultLineMapper<Anime> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(true);
        lineTokenizer.setNames("anime_id", "name", "genre", "type", "episodes", "ratings", "members");

        BeanWrapperFieldSetMapper<Anime> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Anime.class);
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        return defaultLineMapper;
    }

    @Override
    protected JobRepository createJobRepository() throws Exception {
        MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean();
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
