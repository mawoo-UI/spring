package cokr.oneweeks.jdbc.service;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cokr.oneweeks.jdbc.dao.MemberDao;
import cokr.oneweeks.jdbc.dao.PostDao;
import cokr.oneweeks.jdbc.dao.ReplyDao;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
  private MemberDao memberDao;
  private PostDao postDao;
  private ReplyDao replyDao;
  private DataSourceTransactionManager manager;
  private TransactionDefinition definition; 

  // public void quitMember(String id) {
  //   TransactionStatus status = manager.getTransaction(null);
  //   manager.commit(status);
  //   manager.rollback(status);
  //   try {
  //     replyDao.updateToWriterNull(id);
  //     postDao.updateToWriterNull(id);
  //     memberDao.delete(id);
  //     manager.commit(status);
  //   }
  //   catch(DataAccessException e) {
  //     manager.rollback(status);
  //   }

  //   replyDao.updateToWriterNull(id);
  //   postDao.updateToWriterNull(id);
  //   memberDao.delete(id);
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
  public void quitMember(String id) {
      replyDao.updateToWriterNull(id);
      postDao.updateToWriterNull(id);
      memberDao.delete(id);
      

  }
}
