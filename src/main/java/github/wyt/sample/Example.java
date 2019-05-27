package github.wyt.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Example {

  private static final String MYBATIS_CONFIG = "mybatis-config.xml";

  public static void main(String[] args) {
    SqlSession session = null;
    try {
      // 从xml中构建SqlSessionFactory
      InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      session = sqlSessionFactory.openSession();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }
}
