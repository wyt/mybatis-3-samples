package github.wyt.sample.dao;

import github.wyt.sample.domain.Emp;

public interface EmpMapper {

  Emp selectEmp(int empno);
}
