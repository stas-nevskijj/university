package com.example.test.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
//        Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
//            @Override
//            public LocalDate get() {
//                return LocalDate.now();
//            }
//        };
//
//        Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
//            @Override
//            protected LocalDate convert(String source) {
//                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                return LocalDate.parse(source, format);
//            }
//        };
//
//        mapper.createTypeMap(String.class, LocalDate.class);
//        mapper.addConverter(toStringDate);
//        mapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }

}
