package com.myhome.repository;

import com.myhome.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

}
