package github.wyt.sample.dao;

import github.wyt.sample.domain.Emp;
import github.wyt.sample.util.MyBaitsUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

@DisplayName("EmpMapper测试用例")
class EmpMapperTest {

  @BeforeEach
  void init() {}

  @Test
  @DisplayName("查询一个Emp")
  void selectEmp() {
    SqlSession session = MyBaitsUtils.openSession();
    EmpMapper mapper = session.getMapper(EmpMapper.class);
    Emp emp = mapper.selectEmp(7369);
    Assertions.assertEquals("SMITH", emp.getEname());
  }

  @AfterEach
  void destroy() {}
}
