import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class MathIsHard {
  private Scanner input;
  
  public MathIsHard() {
    int dim;
    String unit;
    int count=0;
    input = new Scanner(System.in);
    Random generator = new Random();
    ArrayList<String> grader = new ArrayList<String>();
    int option = 16; //will hold input for the outer loop
    int innerOp = 16; //will hold input for the inner loop
    System.out.print("Welcome to the Precalculus Math Review - because math is hard!\n\nAll answers are rounded.\n");
    //outer loop for the units
    //inner loops for the problems within the units
    while (option != 0) {
      innerOp = 1;
      System.out.print("\nWhat would you like to review?\n0. Quit\n1. Geometric Trigonometry\n2. Vectors\n3. Matrices\n4. Random Unit\n\nPlease choose a number: ");
      option = input.nextInt();
      if (option == 4) { //chooses one of the other units through random generator
        option = generator.nextInt(3)+1;
      }
      if (option == 1) { //geo trig unit
        System.out.print("\nThis is the geometric trigonometry unit!\n");
        unit = units(); // calls on method that asks the user what units they would like: degrees or radians
        Unit7 problem = new Unit7(unit);
        while (innerOp != 0) {
          System.out.print("\n0. Leave this unit\n1. Law of Sines\n2. Law of Cosines\n3. Area\n4. Random\n\nChoose a type of problem: "); //problem menu
          innerOp = input.nextInt();
          System.out.print("\n");
          if (innerOp == 4) { //chooses one of the other problems using random generator
            innerOp = generator.nextInt(3)+1;
          }
          if (innerOp == 1) { //law of sines
            System.out.print(problem.createLOS());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next(); //It doesn't store the input; it just creates a pause for the user to do the problem before continuing
            System.out.print("\n"+problem.getAnswer()+"\n"); //shows the answer
            addAnswer(grader); //calls method that asks if the answer is correct or not and then adds that to the arrayList
          }
          else if (innerOp == 2) { //law of cosines
            System.out.print(problem.createLOC());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 3) { //area
            System.out.print(problem.createArea());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
        }
      }
      else if (option == 2) { //vectors unit
        System.out.print("\nThis is the vectors unit!\n");
        unit = units();
        Unit10 problem = new Unit10(unit);
        while (innerOp != 0) {
          System.out.print("\n0. Leave this unit\n1. Dot Product\n2. Cross Product\n3. Projection Vector\n4. Magnitude\n5. Distance Formula\n6. Angle Between Plane or Vector\n7. Determine the Equation of the Plane\n8. Random\n\nChoose a type of problem: ");
          innerOp = input.nextInt();
          System.out.print("\n");
          if (innerOp == 8) { //chooses one of the other problems
            innerOp = generator.nextInt(7)+1;
          }
          if (innerOp == 1) { //dot product
            System.out.print("How many dimensions should the vector have? "); //user can choose the number of dimensions
            dim = input.nextInt();
            System.out.print(problem.createDotProduct(dim));
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 2) { //cross product
            System.out.print(problem.createCrossProduct());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 3) { //projection vector
            System.out.print(problem.createProjectionV());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 4) { //magnitude
            System.out.print("How many dimensions should the vector have? ");
            dim = input.nextInt();
            System.out.print(problem.createMagnitude(dim));
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 5) { //distance formula
            System.out.print("How many dimensions should the vector have? ");
            dim = input.nextInt();
            System.out.print(problem.createDistanceFormula(dim));
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 6) { //angle between planes or vectors
            System.out.print(problem.createAngleVectors());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 7) { //find the equation of the plane given points
            System.out.print(problem.findPlane());
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
        }
      }
      else if (option == 3) { //matrix unit
        System.out.print("\nThis is the matrices unit!\n");
        Unit11 problem = new Unit11();
        while (innerOp != 0) {
          System.out.print("\n0. Leave this unit\n1. Determinant\n2. Matrix Multiplication\n3. Reflection\n4. Inverse\n5. Random\n\nChoose a type of problem: ");
          innerOp = input.nextInt();
          System.out.print("\n");
          if (innerOp == 5) { //chooses one of the other problems
            innerOp = generator.nextInt(3)+1;
          }
          if (innerOp == 1) { //determinant
            dim = 0;
            while (dim != 2 && dim != 3) { //continues looping until the user inputs either 2 or 3
              System.out.print("How many dimensions should the matrix have? (2 / 3) ");
              dim = input.nextInt();
            }
            problem.createDet(dim);
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer()+"\n");
            addAnswer(grader);
          }
          else if (innerOp == 2) { //matrix multiplication
            int[][] matrix1 = problem.createMult();
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer());
            problem.displayMatrix(matrix1);
            System.out.print("\n");
            addAnswer(grader);
          }
          else if (innerOp == 3) { //transformations
            int[][] matrix1 = problem.createTransformations();
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer());
            problem.displayMatrix(matrix1);
            System.out.print("\n");
            addAnswer(grader);
          }  
          else if (innerOp == 4) { //inverse of matrix
            double [][] matrix1 = problem.createInverse();
            System.out.print("\nType 'Y' when you have an answer... ");
            input.next();
            System.out.print("\n"+problem.getAnswer());
            problem.displayMatrixDouble(matrix1);
            System.out.print("\n");
            addAnswer(grader);
          }
        }
      }
    }
    //counting number correct from arrayList
    for (int i=0; i<grader.size();i++) {
      if (grader.get(i).equals("Yes")) {
        count++;
      }
    }
    // calculating percent correct
    double correct = (double)count/grader.size()*100;
    correct = Math.round(correct *100.0) /100.0; //rounding
    System.out.print("\nYou got " + correct + "% of the problems correct!\n\nThank you for using the Precalculus Math Review! Hopefully, it helped you!");
  }

  public void addAnswer(ArrayList<String> grader) { //asks user if their solution matches the solution outputted by the program and then adds that answer to the arrayList
    System.out.print("\nDoes your answer match this answer? (Y / N) ");
    String response = input.next();
    if (response.equals("Y")) {
      grader.add("Yes");
    }
    else {
      grader.add("No");
    }
  }

  public String units() { //changes the units depending on the user's input: radians or degrees
    System.out.print("Would you like to work in degrees or radians? (D / R) ");
    String unit = input.next();
    if (unit.equals("D") == false && unit.equals("R")==false) {
      System.out.print("You did not choose a valid option, so the automatic selection is radians.\n"); //default is radians
      unit = "R";
    }
    else if (unit.equals("D")) {
      unit = "D";
    }
    else {
      unit = "R";
    }
    return unit;
  }
}