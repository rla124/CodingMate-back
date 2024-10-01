package com.creativesemester.SejongCodingMate.domain.dialogue.repository;

import com.creativesemester.SejongCodingMate.domain.dialogue.entity.Dialogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialogueRepository extends CrudRepository<Dialogue, Long> {
    List<Dialogue> findByStoryId(Long id);
}
