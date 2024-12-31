package cokr.oneweeks.guestbook.repository.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.QBoard;
import cokr.oneweeks.guestbook.domain.entity.QMember;
import cokr.oneweeks.guestbook.domain.entity.QReply;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{
  public SearchBoardRepositoryImpl() {
    super(Board.class);
  }

  @Override
  public Board search1() {
    log.info("search1 ...");
    QBoard board = QBoard.board;
    QReply reply = QReply.reply;
    QMember member = QMember.member;
    JPQLQuery<Board> jpqlQuery = from(board);

    jpqlQuery
      .leftJoin(member).on(board.member.eq(member))
      .leftJoin(reply).on(reply.board.eq(board));
    JPQLQuery<Tuple> tuple =
      jpqlQuery  
      .select(board, member.email, reply.count())
      .groupBy(board);
    log.info(tuple);
    List<Tuple> list = tuple.fetch();
    
    return null;
  }

  @Override
  public Page<Object[]> searPage(String type, String keword, Pageable pageable) {
    QBoard board = QBoard.board;
    QMember member = QMember.member;
    QReply reply = QReply.reply;

    JPQLQuery<Board> jpqlQuery = from(board);
    jpqlQuery
      .leftJoin(member).on(board.member.eq(member))
      .leftJoin(reply).on(reply.board.eq(board));

    JPQLQuery<Tuple> tuple =
      jpqlQuery  
      .select(board, member.email, reply.count());
      //    .groupBy(board);
      
      BooleanBuilder booleanBuilder = new BooleanBuilder();
      BooleanExpression expression = board.bno.gt(0L);

      booleanBuilder.and(expression);

      if (type != null) {
        BooleanBuilder containsBuilder = new BooleanBuilder();


        if (type.contains("T")) {
          containsBuilder.or(board.title.contains(keword));
        }
        if (type.contains("C")) {
          containsBuilder.or(board.content.contains(keword));
        }
        if (type.contains("W")) {
          containsBuilder.or(member.email.contains(keword));
        }
        booleanBuilder.and(containsBuilder);
      }

      tuple.where(booleanBuilder);
      //order by
      Sort sort = pageable.getSort();

      sort.stream().forEach(order ->{
        Order direction = order.isAscending() ? Order.ASC :Order.DESC;
        String prop = order.getProperty();

        PathBuilder<Board> orderByExpression = new PathBuilder(Board.class,"board");
        tuple.orderBy(new OrderSpecifier<>(direction, orderByExpression.get(prop, String.class)));

      });

      tuple.groupBy(board);
      //page
      tuple.offset(pageable.getOffset());
      tuple.limit(pageable.getPageSize());

      List<Tuple> result = tuple.fetch();

      long count = tuple.fetchCount();
      tuple.groupBy(board);
      
      return new PageImpl<>(result.stream().map(t->t.toArray()).toList(), pageable,count);
     
      
      


      // List<Tuple> result = tuple.fetch();


      // return null;
  }
  
}
