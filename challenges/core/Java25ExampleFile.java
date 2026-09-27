

/*
 * if you want to use jdk 25 feature where we want to use main function without class then follow these steps

1. create a class
2. remove package statement
3. file starts with import statement if any required
4. write void main(){}
5. put all your code inside main method or create methods in the file outside the main method and call it from main method
6. open terminal (bash)
7. go to your workspace location using cd command (ex - c/Users/rohit/rohit_folder/My_Folder/Technical_projects_program/workspace)
8. run this command "java -cp target/classes --source 25 challenges/src/stages/Java25ExampleFile.java"
   here location of my class "Java25ExampleFile.java" is "challenges/src/stages/Java25ExampleFile.java"
   
Note - if a class executed using this command - "java -cp target/classes --source 25 challenges/src/stages/TestProgram.java"
then this class will stop behaving as old named class, to bring it back old styled named class behavior, we have to run following command
on terminal - "javac -d target/classes challenges/src/stages/TestProgram.java"   
 */

/*

import java.util.*;
import stages.TestProgram;

void main() {
	TestProgram tp = new TestProgram();
	System.out.println(tp.findSum(Arrays.asList(1,2,3,4,5)));
}

String getValue(){
  
  return "Rohit";

}  

*/
