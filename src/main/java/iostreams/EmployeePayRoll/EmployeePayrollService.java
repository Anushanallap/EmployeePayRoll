package iostreams.EmployeePayRoll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
		 
		private List<EmployeePayrollData> employeePayrollList;
		public enum IOService {CONSOLE_IO, FILE_IO,DB_IO,REST_IO}

		
		public EmployeePayrollService() {}
			public EmployeePayrollService(List<EmployeePayrollData>employeePayrollList) { this.employeePayrollList = employeePayrollList;
			
	}
		public static void main(String[] args) {
			ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
			EmployeePayrollService employeePayrollservice = new EmployeePayrollService();
			Scanner consoleInputReader = new Scanner(System.in);
			employeePayrollservice.readEmployeePayrollData(consoleInputReader);
			employeePayrollservice.writeEmployeePayrollData();
		}

		/* UC1 Emply payroll service to read and write employeepayroll to console*/
		
		private void writeEmployeePayrollData() {
			// TODO Auto-generated method stub
			
		}
		public void readEmployeePayrollData(Scanner consoleInputReader) {
			System.out.println("Enter Employee ID :");
			int id = consoleInputReader.nextInt();
			System.out.println("Enter Employee Name :");
			String name = consoleInputReader.next();
			System.out.println("Enter Employee salary :");
			double salary = consoleInputReader.nextDouble();
			employeePayrollList.add(new EmployeePayrollData(id, name, salary));
			
		}
		void writeEmployeePayrollData(IOService ioService) {
			if(ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster toConsole\n" + employeePayrollList);
			else if(ioService.equals(IOService.FILE_IO))
				new EmployeePayrollFileIOService().writeData(employeePayrollList);
			
		}
		public long readEmployeePayrollData(IOService ioService) {  ioService: "FILE_IO"
			if(ioService.equals(IOService.FILE_IO))   ioService: "FILE_IO"
				this.employeePayrollList = new EmployeePayrollFileIOService().readDATA();
				return employeePayrollList.size();
				
		}
		public void printData(IOService ioService) {
			if(ioService.equals(ioService.FILE_IO))
				new EmployeePayrollFileIOService().printData();
		}
		public long countries(IOService ioService) {
			if(ioService.equals(IOService.FILE_IO))
				return new EmployeePayrollFileIOService().countEntries();
			return 0;
		}
		public long countEntries(IOService fileIo) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		}
		



