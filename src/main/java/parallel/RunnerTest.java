package parallel;

import io.cucumber.core.cli.Main;

public class RunnerTest {
	
	public static void main(String[] args) {
		String[] params = new String[] { 
				"--threads", "3", "-g", "parallel",
				"-p", "timeline:reports/timeline", 
				"src/main/resources/Features"
				//,"src/main/java/stepDefinition"
				};
		Main.run(params, Thread.currentThread().getContextClassLoader());
	}
}
