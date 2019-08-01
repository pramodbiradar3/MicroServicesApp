package com.example.demo1.serviceImpl;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Address;
import com.example.demo1.entity.BaseProperties;
import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;
import com.example.demo1.service.EmployeeService;
import com.example.demo1.utility.JpaResponseUtils;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	Employee employee = null;

	@Override
	public Employee saveEmployee() {
		BaseProperties baseProperties = new BaseProperties();
		baseProperties.setActive("Y");
		baseProperties.setCreatedBy(1);
		baseProperties.setCreatedOn(LocalDateTime.now());
		
		Employee employee = new Employee();
		employee.setFirstName("FirstName");
		employee.setLastName("LastName");
		employee.setBaseProperties(baseProperties);
		
		Address address1 = new Address();
		address1.setAddress1("Emp_Address1");
		address1.setAddress2("Emp_Address2");
		address1.setCity("Emp_City1");
		address1.setState("Emp_State1");
		address1.setZip("Emp_State1");
		address1.setBaseProperties(baseProperties);
		
		Address address2 = new Address();
		address2.setAddress1("Emp_Address3");
		address2.setAddress2("Emp_Address4");
		address2.setCity("Emp_City2");
		address2.setState("Emp_State2");
		address2.setZip("Emp_State2");
		address2.setBaseProperties(baseProperties);
		
		java.util.Set<Address> addressList = new HashSet<>();
		addressList.add(address1);
		addressList.add(address2);
		employee.setAddress(addressList);
		
		employee.getAddress().stream().forEach(d->{
			d.setEmployee(employee);
		});
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer employeeId) {
			try {
				employee = null;
				employee = JpaResponseUtils.optionalToObject(employeeRepository.findById(employeeId), Employee.class); 
				
				if(employee!=null) {
					BaseProperties baseProperties = new BaseProperties();
					baseProperties.setActive("Y");
					baseProperties.setCreatedBy(1);
					baseProperties.setCreatedOn(LocalDateTime.now());
					
					Address address3 = new Address();
					address3.setAddress1("Emp_Address5");
					address3.setAddress2("Emp_Address6");
					address3.setCity("Emp_City3");
					address3.setState("Emp_State3");
					address3.setZip("Emp_State3");
					//address3.setBaseProperties(baseProperties);
					java.util.Set<Address> addressList = employee.getAddress();
					
					//employee.getAddress().clear();
					employee.setAddress(addressList);
					employee.getAddress().add(address3);
					employee.getAddress().stream().forEach(d->{
						if(d.getBaseProperties()!=null && d.getBaseProperties().getCreatedOn()!=null) {
							baseProperties.setUpdatedBy(2);
							baseProperties.setUpdatedOn(LocalDateTime.now());
						}else {
							d.setBaseProperties(baseProperties);
						}
						d.setEmployee(employee);
					});
					return employeeRepository.save(employee);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
}
