package mapper;

import java.util.HashMap;
import java.util.List;

import domain.Employee;

public interface EmployeeMapper {
	List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);
}
