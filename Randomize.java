import java.lang.Math; //For the random number generation

public class Randomize{
    int[] Rand;
    int size;
    
    /*
     * Constructor
     */
    Randomize(int size){
        this.size = size;
        Rand = new int[size];
        random();
    }

    /*
     * Method for Random number generation
     */
    private void random(){
        Rand[0] = (int)(Math.random()*100);
        for(int i = 1; i < size; i++){
            boolean Check = false;
            int number = (int)(Math.random()*100);
            for(int j = 0; j < i; j++){
                if(Rand[j] == number){
                    i--;
                    Check = true;
                    break;
                }
            }
            if(!Check){
                Rand[i] = number;
            }
            
        }
    }

    /*
     * Return the Array
     */
    public int[] Array(){
        return Rand;
    }

    public String toString(){
        String data = "";

        for(int i = 0; i < size; i++){

        }
        return data;
    }

}