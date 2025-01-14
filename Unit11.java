import java.util.Random;
public class Unit11 extends Unit{
  
  private String answer;
  public Unit11() {
    answer = "";
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer){
    this.answer=answer;
  }
  
  public int[][] matrixGenerator(int size) { //generates random ints that go into a 2D array for our matrix
    int[][] matrix = new int[size][size]; // can be 2x2 or 3x3
    Random generator = new Random();
    for (int j=0; j<size; j++) {
      for (int i=0; i<size; i++) {
        matrix[j][i]=generator.nextInt(21)-10;
      }
    }
    return matrix;
  }

  public void displayMatrix(int[][] matrix) { //properly formats the matrix with integers with long brackets/special symbols
    System.out.print("┌");
    if (matrix.length == 3) { //prints first row with no numbers
      for (int i=0;i<14;i++) {
        System.out.print(" ");
      } 
    }
    else { //prints first row with no numbers
      for (int i=0;i<10;i++) {
        System.out.print(" ");
      }
    }
    System.out.print("┐\n│");
    //printing the rest of the rows
    for (int i=0; i<matrix.length;i++) {
      System.out.printf("% 4d", matrix[0][i]); //formats to 4 spaces
    }
    System.out.print("  │\n│");
    for (int i=0; i<matrix.length;i++) {
      System.out.printf("% 4d", matrix[1][i]);
    }
     if (matrix.length==3) {
      System.out.print("  │\n│");
      for (int i=0; i<matrix.length;i++) {
        System.out.printf("% 4d", matrix[2][i]);
      } 
       System.out.print("  │\n└");
       //last row with no numbers for 3D
       for (int i=0;i<14;i++) {
        System.out.print(" ");
      }
      System.out.printf("┘");
    }
    else {
      //last row with no numbers for 2D
      System.out.print("  │\n└");
       for (int i=0;i<10;i++) {
        System.out.print(" ");
      }
      System.out.printf("┘");
    }
  }

  public void displayMatrixDouble(double[][] matrix) { //properly formates and prints the matrix full of doubles - only used for the inverse matrix
    System.out.print("┌");
    if (matrix.length == 3) {
      for (int i=0;i<20;i++) {
        System.out.print(" ");
      } //prints first row with no numbers
    }
    else {
      for (int i=0;i<14;i++) {
        System.out.print(" ");
      } //prints first row with no numbers
    }
    System.out.print("┐\n│");
    //printing the rest of the rows
    for (int i=0; i<matrix.length;i++) {
      System.out.printf("%6.2f", super.round(matrix[0][i]));
    }  // formatting the rows with spaces & rounding the decimals in the matrix
    System.out.print("  │\n│");
    for (int i=0; i<matrix.length;i++) {
      System.out.printf("%6.2f", super.round(matrix[1][i]));
    }
     if (matrix.length==3) {
      System.out.print("  │\n│");
      for (int i=0; i<matrix.length;i++) {
        System.out.printf("%6.2f", super.round(matrix[2][i]));
      } 
       //last row with no numbers for 3D
       System.out.print("  │\n└");
       for (int i=0;i<20;i++) {
        System.out.print(" ");
      }
      System.out.printf("┘");
    }
    else { //last row with no numbers for 2D
      System.out.print("  │\n└");
       for (int i=0;i<14;i++) {
        System.out.print(" ");
      }
      System.out.printf("┘");
    }
  }

  public void createDet(int size){ // creates a determinant problem with a 2x2 or 3x3 matrix
    answer = "Answer: ";
    System.out.print("What is the determinant of the matrix down below?\n");
    int[][] matrix = matrixGenerator(size);
    displayMatrix(matrix);
    answer += solveDet(matrix); // solves and sets answer
  }

  public int[][] createMult() { //creates a matrix multiplication problem only with 2x2 matrices
    answer = "Answer: \n";
    System.out.print("Multiply the matrices down below:\n");
    int[][] matrix1 = matrixGenerator(2); //generates 2x2 matrix
    int[][] matrix2 = matrixGenerator(2);
    displayMatrix(matrix1);
    System.out.print("\n");
    displayMatrix(matrix2);
    return solveMult(matrix1, matrix2); //returns the solution
  }

  public int[][] createTransformations() { // creates a matrix transformation problem specifically with reflections
    answer = "Answer: \n";
    Random generator = new Random();
    int num = generator.nextInt(2); // randomly chooses either a relfection over the x-axis or over the y-axis
    int[][] matrix = matrixGenerator(2); // 50/50 chance
    if (num==0) {
      System.out.print("Reflect the matrix over the x-axis:\n");
      displayMatrix(matrix);
      System.out.print("\n");
      return solveTransformations(matrix, "Reflect over X-axis"); //returns the solution
    }
    else {
      System.out.print("Reflect the matrix over the y-axis:\n");
      displayMatrix(matrix);
      System.out.print("\n");
      return solveTransformations(matrix, "Reflect over Y-axis");
    }
  }

  public double[][] createInverse() { //creates an inverse matrix problem with a 2x2 matrix. 
    answer = "Answer: \n";
    System.out.print("What is the inverse of the matrix down below?:\n");
    int[][] matrix1 = matrixGenerator(2); //generates matrix
    displayMatrix(matrix1);
    System.out.print("\n");
    return solveInverse(matrix1); //returns solution
  }
  
  public int solveDet(int[][] matrix){ //solves the determinant with the formula depending on the size
    int det = 0;
    if (matrix.length == 2){ //2D
      det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    else{ //3D
      det = matrix[0][0] * matrix[1][1] * matrix[2][2] +       matrix[0][1] * matrix[1][2] * matrix[2][0] + matrix[0][2] * matrix[1][0] * matrix[2][1] - matrix[0][2] * matrix[1][1] * matrix[2][0] - matrix[0][0] * matrix[1][2] * matrix[2][1] - matrix[0][1] * matrix[1][0] * matrix[2][2];
    }
    return det;
  }

  public int[][] solveMult(int[][] matrix1, int[][] matrix2){ //solves a matrix multiplication problem using the formula and many for loops
    if (matrix1.length==2){
      int[][] product = new int[2][2]; //solution
        for (int i = 0; i<2; i++){ // goes through each row and column for both matricies and correctly multiplies them. 
          for (int a = 0; a<2; a++){
            product[i][a] = 0;
            for (int b = 0; b<2; b++){
              product[i][a] += matrix1[i][b] * matrix2[b][a];
            }
          }
        } 
      return product;
    }
    else{
      int[][] product = new int[3][3];
        for (int i = 0; i<2; i++){
          for (int a = 0; a<2; a++){
            product[i][a] = 0;
            for (int b = 0; b<2; b++){
              product[i][a] += matrix1[i][b] * matrix2[b][a];
            }
          }
        } 
      return product;
    }
  }

  public int[][] solveTransformations(int[][] matrix, String type){ //solves a transformation problem for a 2x2 matrix depending on the type of transformation
    int tmatrix[][] = new int[2][2]; //transformation matrix
    int amatrix[][] = new int[2][2]; //solution matrix
    if (type.equals("Reflect over X-axis")){
      //x-axis transformation matrix
      tmatrix[0][0] = 1;
      tmatrix[1][0] = 0;
      tmatrix[0][1] = 0;
      tmatrix[1][1] = -1;
      amatrix = solveMult(tmatrix, matrix);
      return amatrix;
    }
    else{
      //y-axis transformation matrix
      tmatrix[0][0] = -1;
      tmatrix[1][0] = 0;
      tmatrix[0][1] = 0;
      tmatrix[1][1] = 1;
      amatrix = solveMult(tmatrix, matrix);
      return amatrix;
    }
  }

  public double[][] solveInverse(int[][] matrix) { //solves an inverse problem for a 2x2 matrix according to the inverse formula using the determinant
    double factor = 1.0/solveDet(matrix);
    double[][] temp = new double[2][2]; 
    temp[0][0] = matrix [1][1];
    temp[1][1] = matrix[0][0];
    temp[0][1]=-matrix[0][1];
    temp[1][0]=-matrix[1][0];
    for (int i=0; i<2;i++) {
      for (int j=0; j<2;j++) {
        temp[i][j]*=factor;
      }
    }
    return temp;
  }
}