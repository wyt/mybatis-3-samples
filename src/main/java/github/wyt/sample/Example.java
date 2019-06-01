package github.wyt.sample;

import github.wyt.sample.util.MyBaitsUtils;
import org.apache.ibatis.session.SqlSession;

public class Example {

  private static final String MYBATIS_CONFIG = "mybatis-config.xml";

  public static void main(String[] args) {
    SqlSession session = MyBaitsUtils.openSession();
    if (session != null) {
      System.out.println(session);
      MyBaitsUtils.closeSession();
    }
  }
}
