package com.crio.buildouts.repository;

import com.crio.buildouts.models.QuizEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<QuizEntity, String> {

}