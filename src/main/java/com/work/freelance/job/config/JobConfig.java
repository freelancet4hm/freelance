package com.work.freelance.job.config;

import com.sun.tools.javac.util.List;
import com.work.freelance.job.model.Job;
import com.work.freelance.job.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class JobConfig {

    @Bean
    CommandLineRunner commandLineRunner(JobRepository jobRepository) {
        return args -> {
            Job firstJob = new Job(
                    1L,
                    "A fashion ecommerce store",
                    "I need an ecommerce website for fashion store",
                    200,
                    "AVAILABLE",
                    LocalDateTime.now().plusDays(2)
            );

            Job secondJob = new Job(
                    2L,
                    "A book ecommerce store",
                    "I need an ecommerce website for book store",
                    100,
                    "EXPIRED",
                    LocalDateTime.now().minusDays(2)
            );

            jobRepository.saveAll(List.of(firstJob, secondJob));
        };
    }
}
