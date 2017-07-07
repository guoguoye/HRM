package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Employee;
import mapper.EmployeeMapper;

public class EmployeeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		EmployeeTest employeeTest = new EmployeeTest();
		employeeTest.testSelectEmployeeByIdLike(session);
		
		session.commit();
		session.close();
	} 
	
	public void testSelectEmployeeByIdLike(SqlSession session){
		//获得EmployeeMapper接口的代理
		EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("state", "active");
		param.put("id", 1);
		/*param.put("loginname", "May");
		param.put("password", "May");*/
		
		List<Employee> list =eMapper.selectEmployeeByIdLike(param);
		list.forEach(employee -> System.out.println(employee));
	}

}
