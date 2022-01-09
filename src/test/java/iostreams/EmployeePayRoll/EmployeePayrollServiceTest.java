package iostreams.EmployeePayRoll;

import java.util.Arrays;

import org.junit.Test;

import iostreams.EmployeePayRoll.EmployeePayrollService.IOService;

import org.junit.Assert;

public class EmployeePayrollServiceTest {
	
	private static final IOService FILE_IO = null;
	private int id;
	private String name;
	private double salary;

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(id , name , salary ),
				new EmployeePayrollData(id , name ,salary ),
				new EmployeePayrollData(id , name , salary ),
				
				
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(FILE_IO);
		employeePayrollService.printData(FILE_IO);
		long entries = employeePayrollService.countEntries(FILE_IO);
		Assert.assertEquals(3, entries);
		
	}
	
	@Test
	public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries =  employeePayrollService.readEmployeePayrollData(FILE_IO);
		Assert.assertEquals( 3, entries);
	}

}
