package github.wyt.sample.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBaitsUtils {

  static final String MYBATIS_CONFIG = "mybatis-config.xml";

  static SqlSessionFactory sqlSessionFactory = null;

  static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

  static {
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static SqlSession openSession() {
    SqlSession session = threadLocal.get();
    if (session == null) {
      session = sqlSessionFactory.openSession();
      threadLocal.set(session);
    }
    return session;
  }

  public static void closeSession() {
    SqlSession session = threadLocal.get();
    if (session != null) {
      session.close();
    }
  }
}
