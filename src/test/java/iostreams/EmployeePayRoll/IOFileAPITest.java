package iostreams.EmployeePayRoll;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;


public class IOFileAPITest {
	 private static String HOME = System.getProperty("user.home");
	    private static String PERFORM_FILE_IO = "TestIOBasicOperations";

	    @Test
	    public void givenPathWhenCheckedThenConfirm() throws IOException {
	        // check if file exists
	        Path homePath = Path.of(HOME);
	        Assert.assertTrue(Files.exists(homePath));

	        // Delete file and check file not exist
	        Path performOperationsPath = Path.of(HOME+"/"+PERFORM_FILE_IO);
	        if (Files.exists(performOperationsPath))  {
	            FileUtils.deleteFiles(performOperationsPath.toFile());
	        }
	        Assert.assertTrue(Files.notExists(performOperationsPath));

	        // Create directory
	        Files.createDirectory(performOperationsPath);
	        Assert.assertTrue(Files.exists(performOperationsPath));

	        // Create file
	        IntStream.range(1,10).forEach(i->{
	            Path testFile = Path.of(performOperationsPath+"/test"+i);
	            Assert.assertTrue(Files.notExists(testFile));
	            try{
	                Files.createFile(testFile);
	            }catch(IOException e){}
	            Assert.assertTrue(Files.exists(testFile));

	        });

	        // List Files, Directories as well as Files with extension
	        Files.list(performOperationsPath).filter(Files::isRegularFile).forEach(System.out::println);
	        Files.newDirectoryStream(performOperationsPath).forEach(System.out::println);
	        Files.newDirectoryStream(performOperationsPath, path -> path.toFile().isFile() &&
	               path.toString().startsWith("test")).forEach(System.out::println);
	    }

	    @Test
	    public void givenDirectoryWhenWatchedListsAllTheActivities() throws IOException{
	        Path dir = Path.of(HOME+"/"+PERFORM_FILE_IO);
	        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
	        new Java8FileWatchService(dir).processEvents();
	    }
	

}
