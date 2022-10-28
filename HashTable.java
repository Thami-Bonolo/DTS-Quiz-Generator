/**
*
* @author Bonolo
*/

class HashTable{
    /*
     * Variables we need in the program.
     * Tried to make them as self explanatory as 
     * possible.
     */
    private int tableSize = 7;
    int[] tableArray;
    int collisions;
    String probing = "";

    /*
     * Constructor. 
     * Variables initialization
     */
    public HashTable(int tableSize){
        this.tableSize = tableSize;
        tableArray = new int[tableSize];
        for(int i = 0; i < tableSize; i++){
            tableArray[i] = 0;
        }
        collisions = 0;

        if((Main.numberOfQuestions % 2) == 0){
            probing = "quadratic";
        }
        else{
            probing = "linear";
        }
    }

    /*
     * Insert function. Our data is integers
     * so I'll just call it number.
     */
    public void insert(int number){
        int h = hash(number); // hashFunction
        /*
         * Randomly choosing the collision resolution.
         */
        if(probing.equals("quadratic")){
            h = quadratic(h);
        }
        else{
            h = linear(h);
        }
        tableArray[h] = number;
    }

    /*
     * Collision resolution functions.
     */
    public int linear(int h){
        while(tableArray[h] != 0){
            h = (h+1) % tableSize;
            collisions++;
        }
        return h;
    }

    public int quadratic(int h){
        int i = 1;
        while(tableArray[h] != 0){
            h = (h+(i*i))%tableSize;
            i++;
            collisions++;
        }
        return h;
    }

    public int hash(int h){
        return h % tableSize;
    }

    public int getCollisions(){
        return collisions;
    }

    public int getTableSize(){
        return tableSize;
    }

    public String getProbing(){
        return probing;
    }

    public int[] getTable(){
        return tableArray;
    }
}