package com.restapi_practice.repository.board;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restapi_practice.domain.Board;
import com.restapi_practice.domain.QBoard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public class BoardQueryRepositoryV2 {

    private final JPAQueryFactory query;

    public BoardQueryRepositoryV2(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Board> findAll(BoardSearchReq requestParam) {

        return query.select(QBoard.board)
                .from(QBoard.board)
                .where(
                        LikeBoardName(requestParam.getSearchTitle()),
                        LikeBoardContent(requestParam.getSearchContent())
                )
                .fetch();
    }

    private BooleanExpression LikeBoardName(String searchTitle) {
        if(StringUtils.hasText(searchTitle)) {
            return QBoard.board.boardTitle.like("%" + searchTitle + "%");
        }
        return null;
    }


    private BooleanExpression LikeBoardContent(String searchContent) {
        if(StringUtils.hasText(searchContent)) {
            return QBoard.board.boardDetail.like("%" + searchContent + "%");
        }
        return null;
    }

}
