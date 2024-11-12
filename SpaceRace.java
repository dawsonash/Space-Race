
import java.util.*;

//Dawson Ash _____________________CS 1050 SpaceRace



public class SpaceRace {
//diceroll method to get random number 1-10
        public static int diceRoll(){
            System.out.println("Press enter to roll the dice.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            
            double r = (Math.random() * 10)+1;
            int roll = (int) r;
            System.out.println("You rolled a: " + roll);
            return roll;
        }
    
    


    


//method to turn our diceroll value into movement values
public static int[] movementValue(int DiceRoll, SpaceCraft[] fleet){
    int current = DiceRoll;
    SpaceCraft eagle5 = fleet[0];
    
            if (current <= 5){
                eagle5.position +=1;
                System.out.println("Eagle 5: Lightspeed");
            } else if(current == 6 || current == 7 ){
                eagle5.position -=3;
                System.out.println("Eagle 5: LudicrousDrive");
            } else if (current >= 8){
                eagle5.position +=5;
                System.out.println("Eagle 5: PlaidDrive");
            }
            //error catch to make sure position is always >0
           if (eagle5.position < 0){
            eagle5.position = 0;
           } 

    SpaceCraft ussEnterprise = fleet[1];
    
            if (current == 1){
                ussEnterprise.position +=0;
                System.out.println("USS Enterprise: Docked");
            } else if(current == 2 || current == 3 || current == 4){
                ussEnterprise.position +=7;
                System.out.println("USS Enterprise: Warp7");
            } else if (current == 5 || current == 6 || current == 7 || current == 8){
                ussEnterprise.position -=4;
                System.out.println("USS Enterprise: Impulse");
            } else if (current >= 9){
                ussEnterprise.position +=1;
                System.out.println("USS Enterprise: Warp1");
            }
            //error catch for the enterprise
            if (ussEnterprise.position < 0){
                ussEnterprise.position = 0;
            }

            return new int[]{eagle5.position, ussEnterprise.position};

        } //movementValue
    public static void main(String[] args) throws Exception {
    

//creating an array to identify our spaceship objects
SpaceCraft[] SpaceCrafts = new SpaceCraft[2];
//creating SpaceCraft objects
SpaceCrafts[0] = new SpaceCraft("Eagle_5","5", 0);
SpaceCrafts[1] = new SpaceCraft("USS Enterprise", "E", 0);


//creating an array of 70 dashes as our distance
String[] distance = new String[70];
// filling array with dashes


//initializing my array with both spacecrafts outside of the loop
int[] positions;
do {
int diceRoll = diceRoll();
positions = movementValue(diceRoll, SpaceCrafts);
System.out.println("Eagle 5 position: " + positions[0]);
System.out.println("USS Enterprise position: " + positions[1]);

//making sure our classes are updated with each loop,
//and we will be able to call their value outside the scope of this loop
SpaceCrafts[0].position = positions[0];

SpaceCrafts[1].position = positions[1];



for (int i = 0; i < distance.length; i++){
    distance[i] = "-";
  }
distance[positions[0]] = "5";
distance[positions[1]] = "E";

//printing BUMP! if they have the same position
if (SpaceCrafts[0].position == SpaceCrafts[1].position){
    int y = SpaceCrafts[0].position;
    distance[y] = "BUMP";
}

  //printing the contents of my array
  for (int i = 0; i < distance.length; i++){
      System.out.print(distance[i]);
  }
} while (SpaceCrafts[0].position <= distance.length-1 && SpaceCrafts[1].position <= distance.length-1);


//printing the winner message
if (SpaceCrafts[0].position >= distance.length-1){
    System.out.println("\n  Eagle 5 is the winner!");
} else if (SpaceCrafts[1].position >= distance.length-1){
    System.out.println("\n  USS Enterprise is the winner!");
}


    } //Main
} //SpaceRace Class

