import java.util.Random;

public class Unit10 extends Unit{
  private String answer, mode, units;
  
  public Unit10() {
    answer = "";
    mode = "R";
    units = "radians";
  }
  
  public Unit10(String mode) {
    answer = "";
    this.mode = mode;
    if (mode.equals("D")) {
      units = "degrees";
    }
    else {
      units = "radians";
    }
  }

  public void setMode(String mode) {
    this.mode = mode;
    if (mode.equals("D")) {
      units = "degrees";
    }
    else {
      units = "radians";
    }
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer){
    this.answer=answer;
  }
  
  public int[] vectorGenerator(int numDigits) { //generates and returns vector with random numbers -10 through 10
    int[] vector = new int[numDigits];
    Random generator = new Random();
    for (int j=0; j<numDigits; j++) {
      vector[j]=generator.nextInt(21)-10;
    }
    return vector;
  }

  public String createDotProduct(int numDigits) { //creates and returns dot product problem and sets answer equal to the solution from solveDotProduct.  
    answer = "Answer: ";
    String str = "What is the dot product of <";
    int[] vector1 = vectorGenerator(numDigits); //creates vector
    int[] vector2 = vectorGenerator(numDigits);
    for (int i=0; i<numDigits-1; i++) { //formats vector1
      str+=vector1[i] + ", ";
    }
    str+=vector1[numDigits-1]+"> and <";
    for (int i=0; i<numDigits-1; i++) { //formats vector2
      str+=vector2[i] + ", ";
    }
    str+=vector2[numDigits-1] + ">?";
    answer += solveDotProduct(vector1, vector2);
    return str;
  }

  public String createCrossProduct(){ //creates and returns a cross product problem. Sets answer through solution of solveCrossProduct.
    answer = "Answer: ";
    int[] vector1 = vectorGenerator(3); //cross prodcuct is always 3D
    int[] vector2 = vectorGenerator(3);
    String str = "What is the cross product of <";
    for (int i=0; i<2; i++) { //formatting vector in output
      str+=vector1[i] + ", ";
    }
    str+=vector1[2]+"> and <";
    for (int i=0; i<2; i++) {
      str+=vector2[i] + ", ";
    }
    str+=vector2[2] + ">?";
    answer+="<";
    int[] temp = solveCrossProduct(vector1, vector2);
    for (int i=0; i<2; i++) {
      answer+=temp[i] + ", ";
    }
    answer+=temp[2]+">";
    return str;
  }
  
   public String createProjectionV(){ //creates and returns a projection vector problem. Sets answer through solution of solveProjectionV.
     answer = "Answer: ";
    int[] vector1 = vectorGenerator(3); //projection vector is always 3D using our formula
    int[] vector2 = vectorGenerator(3);
    String str = "What is the projection of <";
    for (int i=0; i<2; i++) { //formatting vector in output
      str+=vector1[i] + ", ";
    }
    str+=vector1[2]+"> onto <";
    for (int i=0; i<2; i++) {
      str+=vector2[i] + ", ";
    }
    str+=vector2[2] + ">?";
    double[] temp = solveProjectionV(vector1, vector2);
     answer+="<";
    for (int i=0; i<2; i++) {
      answer+=temp[i] + ", ";
    }
    answer+=temp[2]+">";
    return str;
  }

  public String createMagnitude(int numDigits) {//creates and returns a magnitude problem which takes in a parameter as the the dimension of the vector. Sets answer through the solution of magnitude.
    answer = "Answer: ";
    String str = "What is the magnitude of <";
    int[] vector = vectorGenerator(numDigits);
    for (int i=0; i<numDigits-1; i++) {
      str+=vector[i] + ", ";
    }
    str+=vector[numDigits-1]+">?";
    answer += magnitude(vector);
    return str;
  }

  public String createDistanceFormula(int numDigits) { //creates and returns a distance formula problem. Sets answer through solution of distance formula.
    answer = "Answer: ";
    String str = "What is the distance between (";
    int[] point1 = vectorGenerator(numDigits);
    int[] point2 = vectorGenerator(numDigits);
    for (int i=0; i<numDigits-1; i++) {
      str+=point1[i] + ", ";
    }
    str+=point1[numDigits-1]+") and (";
    for (int i=0; i<numDigits-1; i++) {
      str+=point2[i] + ", ";
    }
    str+=point2[numDigits-1] + ")?";
    answer += distanceFormula(point1, point2);
    return str;
  }
  
  public int solveDotProduct(int[] vector1, int[] vector2) { //solves and returns the dot product according to the formula
    int answer = 0;
    for (int i = 0; i<vector1.length; i++){ //can work for 2 or 3D vectors or more
      answer += vector1[i] * vector2[i];
    }
    return answer; 
  }

  public int[] solveCrossProduct(int[] vector1, int[] vector2){//solves and returns the cross product according to the formula
    int[] answer = new int[3]; //only works for 3D vectors
    answer[0] = vector1[1]*vector2[2] - vector1[2]*vector2[1];
    answer[1] = vector1[2]*vector2[0] - vector1[0]*vector2[2];
    answer[2] = vector1[0]*vector2[1] - vector1[1]*vector2[0];
    return answer;
  }

  public double[] solveProjectionV(int[] vector1, int[] vector2) { //solves and returns a new vector of the projection of vector 1 onto vector 2 according to the formula
    double[] temp = new double[vector2.length];
    for (int i=0; i<vector2.length; i++) {
      temp[i]=vector2[i];
    }
    double factor = solveDotProduct(vector1, vector2)/(Math.pow(magnitude(vector2),2)); //uses magnitude and dot product to solve part of the formula  
    for (int i=0; i<temp.length; i++) {
      temp[i] *= factor;
      double temp2 = super.round(temp[i]);
      temp[i] = temp2;
    } // multipied each term in the vector by the factor
    return temp;
  }

  public double magnitude(int[] vector){
    //solves and returns the magnitude according to the formula
    double sum = 0.0;
    for (int i=0; i<vector.length; i++){
      sum += Math.pow(vector[i], 2);
    }
    return super.round(Math.sqrt(sum));
  }

  public double distanceFormula(int[] point1, int[] point2) {
    //solves and returns the distance formula according to the formula
    int[] temp = new int[point1.length];
    for (int i=0; i<temp.length; i++) {
      temp[i] = point1[i]-point2[i]; // diffence between points
    }
    return magnitude(temp); // after finding the difference between the points, the next steps are the same as the magnitude
  }

  public String createAngleVectors(){ // creates and solves a problem that asks the user to find the angle between two vectors or two planes. There is a 50/50 chance to get either type of problem: vectors or planes;
    answer = "Answer: ";
    int[] vector1 = vectorGenerator(3); //only works for 3D
    int[] vector2 = vectorGenerator(3);
    String problem = "";
    if (Math.random() > 0.5 ){
    problem = "Find the angle in " + units + " between vectors <";
    for (int i=0; i<2; i++) { 
      problem+=vector1[i] + ", ";
    }
    problem+=vector1[2]+"> and <";
    for (int i=0; i<2; i++) {
      problem+=vector2[i] + ", ";
    }
    problem+=vector2[2] + ">.";
    }
    else{
      problem = "Find the angle " + units + " between the planes ";
      char var = 'x' ; //used to format the vectors into plane equations with x,y, and z
      for (int i=0; i<2; i++) {
        problem+=vector1[i] + "" + var + " + ";
        var++;
      }
      problem+=vector1[2] + "" + var + " = 0 and ";
      var = 'x' ;
      for (int i=0; i<2; i++) {
        problem+=vector2[i] + "" + var + " + ";
        var++;
      }
      problem+=vector2[2] + "" + var + " = 0.";
    }
    double a = Math.acos(solveDotProduct(vector1, vector2)/(magnitude(vector1) * magnitude(vector2))); // method to solve these problems is the same and uses a formula
    if (mode.equals("D")) { // accounts for degrees/radian
      answer+=super.round(a*180/Math.PI);
    }
    else{
      answer+=super.round(a);
    } 
    answer+=" "+units;
    return problem;
  }

  public String findPlane(){ // creates and solves a problem that gives three points and the user has to the find the plane that is determined by those 3 points
    answer = "";
    String str = "What is plane formed by (";
    int[] point1 = vectorGenerator(3); // generating points (x,y,z)
    int[] point2 = vectorGenerator(3);
    int[] point3 = vectorGenerator(3);
    for (int i=0; i<2; i++) { //formats points
      str+=point1[i] + ", ";
    }
    str+=point1[2]+"), (";
    for (int i=0; i<2; i++) {
      str+=point2[i] + ", ";
    }
    str+=point2[2] + "), and (";
    for (int i=0; i<2; i++) {
      str+=point3[i] + ", ";
    }
    str+=point3[2] + ")?"; 
    
    // solves the problem by determining the vectors and taking the cross product
    int[] vector1 = new int[3];
    int[] vector2 = new int[3];
    for (int i=0; i<3; i++){
      vector1[i] = point1[i] - point2[i];
    }
    for (int i=0; i<3; i++){
      vector2[i] = point1[i] - point3[i];
    }
    int[] pvector = solveCrossProduct(vector1, vector2); 
    char var = 'x' ;
    answer += "Answers may vary. One example is "; //There are varing equivalant answers for this problem, we just give one.
      for (int i=0; i<2; i++) { //formats answer
        answer+=pvector[i] + "(" + var + " - " + point1[i] + ") + ";
        var++;
      }
      answer+=pvector[2] + "(" + var + " - " + point1[2] + ") = 0";
    return str;
  }
}
