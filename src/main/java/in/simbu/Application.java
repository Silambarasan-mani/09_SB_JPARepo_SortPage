package in.simbu;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.simbu.Entities.Employee;
import in.simbu.Repo.EmpRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmpRepository bean = context.getBean(EmpRepository.class);
		
	//	List<Employee> all = bean.findAll(Sort.by("empName"));
	//	List<Employee> all = bean.findAll(Sort.by("empSalary").descending());
	//	all.forEach(s -> System.out.println(s));
		
		int pageSize=2;
		int pageno=0;
		
		PageRequest pageRequest = PageRequest.of(pageno, pageSize);	
		
		Page<Employee> page = bean.findAll(pageRequest);
		List<Employee> list = page.getContent();
		list.forEach(s -> System.out.println(s));
		
		context.close();
		
	}

}
