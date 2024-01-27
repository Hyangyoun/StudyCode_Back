package com.STC.StudyCode.Entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Commit
class PostEntityTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    public void test() {
        PostEntity postEntity = em.find(PostEntity.class, 1L);

        postEntity.setContent("바꾼디");
    }
}