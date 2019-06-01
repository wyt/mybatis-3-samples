package github.wyt.sample;

import github.wyt.sample.dao.EmpMapper;
import github.wyt.sample.domain.Emp;
import github.wyt.sample.util.MyBaitsUtils;
import org.apache.ibatis.session.SqlSession;

public class Example {

  private static final String MYBATIS_CONFIG = "mybatis-config.xml";

  public static void main(String[] args) {

    SqlSession session = MyBaitsUtils.openSession();
    System.out.println(session);
    EmpMapper mapper = session.getMapper(EmpMapper.class);
    Emp emp = mapper.selectEmp(7369);

    System.out.println(emp.getEname());
    MyBaitsUtils.closeSession();
  }
}
