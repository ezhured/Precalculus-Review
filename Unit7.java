import java.util.Random;
public class Unit7 extends Unit{
  private String answer;
  private int side1, side2, side3;
  private double angle1, angle2, angle3;
  private String mode, units; //radians or degrees

  //automatically in radians
  public Unit7() {
    answer = "";
    mode = "R";
    units = "radians";
  }
  
  public Unit7(String mode) {
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

  public void triGenerator(){ // generates a triangle
    Random generator = new Random();
    side1 = 0;
    side2 = 0;
    side3 = 0;
    while (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 +side3 <= side2) { // rule that the two shorter sides of the triangle must have a sum greater than the third
    // generates all the side lengths of the triangle between 0-10
    side1 = generator.nextInt(10)+1;
    side2 = generator.nextInt(10)+1;
    side3 = generator.nextInt(10)+1;
    }
  //uses law of cosines formula with side lengths plugged in to calculate angles of triangle
    angle1 = Math.acos((Math.pow(side1,2)-Math.pow(side2,2)-Math.pow(side3,2))/(-2*side2*side3));
    angle2 = Math.acos((Math.pow(side2,2)-Math.pow(side1,2)-Math.pow(side3,2))/(-2*side1*side3));
    angle3 = Math.acos((Math.pow(side3,2)-Math.pow(side2,2)-Math.pow(side1,2))/(-2*side2*side1));
    if (mode.equals("D")) { //change to degrees if necessary
      angle1=angle1*180/Math.PI;
      angle2=angle2*180/Math.PI;
      angle3=angle3*180/Math.PI;
    }
  }

  public String createLOS(){ //law of sines problem generator - we already know the sides and angles but the user does not
    answer="Answer: ";
    triGenerator(); // creates triangle
    String problem = "Find all angles and side length given side length 1 = " + side1 + ", angle 1 = " + super.round(angle1) + " " + units + ", and angle 2 = " + super.round(angle2) + " "+units+". The answer is in order of side length 2, side length 3, and angle 3.";
    answer+= side2 + ", " + side3 + ", " + super.round(angle3)+" "+units;
    return problem;
  }

  public String createLOC(){ //law of cosines problem generator: there are two options with a 50/50 chance of either
    answer="Answer: ";
    triGenerator();
    String problem = "";
    if (Math.random() > 0.5){ //option 1 with all sides given
      problem = "Find the angles given side lengths " + side1 + ", " + side2 + ", " + side3 + ".";
answer += super.round(angle1) + " " + units+ ", " + super.round(angle2) + " " + units + ", " + super.round(angle3) + " " + units;
    }
    else{ //option 2 with two sides and an angle given
      problem = "Find all angles and side length given side length 1 = " + side1 + ", side length 2 = " + side2 + ", and angle 3 (the angle between side 1 and 2) = " + super.round(angle3) + " " + units + ". The answer is in order of side length 3, angle 1, and angle 2."; 
      answer += side3 + ", " + super.round(angle1) + " " + units + ", " + super.round(angle2) + " " + units;
    }
    return problem; //will display problem in MathIsHard.java
  }

  public double solveArea() { //solves for the area of the triangle
    double tempA = angle3;
    if (mode.equals("D")){ // changes to degrees if neccesary
      tempA = (angle3 * Math.PI)/180;
    }
    return super.round(0.5*side1*side2*Math.sin(tempA)); //area formula: 1/2absinC
  }

  public String createArea(){// area problem generator
    answer="Answer: ";
    triGenerator();
    answer+=solveArea();
    return "What is the area of a triangle with side length 1 = " + side1 + ", side length 2 = " + side2 + ", and angle 3 (the angle between side 1 and 2) = " + super.round(angle3) + " "+units+"?";
  }
}