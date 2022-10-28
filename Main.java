import java.util.Scanner; //For user imput
import java.io.*; //For writing to file
import java.lang.Math; //For random number generation

public class Main{
    static int numberOfQuestions = 0;
    static String filename = "Questions.txt";
    public static void main(String[] args){

        String filenames = "";
        int in = 0;
        int count; //for number of questions

        Questions questions;
        try{
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();

        }catch (IOException e){
            System.out.println("Exception Occurred" + e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the CSC2001F(Data Structures) Quiz Generator! :)");
        System.out.println("To start, Select the section you would like to generate.");

        
        while(true){
            System.out.println("Enter only the number for the given options\n"+
                            "1. Data Structures 1\n"+
                            "2. Data Structures 2\n"+
                            "3. To quit.");
        
            in = scanner.nextInt();
            if(in > 3 || in < 1){
                System.out.println("Error: The number you have entered is not in the given options :(");
                System.out.println("Correct number is 1, 2 or 3(To quit!)");
                System.out.println("Please try again :) \n");

                System.out.println("Enter only the number for the given options\n"+
                            "1. Data Structures 1\n"+
                            "2. Data Structures 2\n"+
                            "3. To quit.");
                in = scanner.nextInt();
                continue;
            }
            if(in == 3){
                System.out.println(numberOfQuestions + " Questions saved to "+ filenames);
                System.out.println("Done...");
                break;
            }

            else if(in == 1){
                System.out.println("You have chosen DST 1:");

                while(true){
                    System.out.println("Below are options of DSTs in DST 1.");
                    System.out.println("Enter only the number for the given options\n"+
                            "1. BST\n"+
                            "2. AVL\n"+
                            "3. Red-Black Trees.\n"+
                            "4. Hash Table\n"+
                            "5. To quit.");
                            in = scanner.nextInt();
                            
                    if(in > 5 || in < 1){
                        System.out.println("Error: The number you have entered is not in the given options :(");
                        System.out.println("Correct number is (1~4) or 5(To quit!)");
                        System.out.println("Please try again :) \n");
                        
                        System.out.println("Enter only the number for the given options\n"+
                            "1. BST\n"+
                            "2. AVL\n"+
                            "3. Red-Black Trees.\n"+
                            "4. Hash Table\n"+
                            "5. To go back.");
                        
                        in = scanner.nextInt();
                    }
                    if(in == 5){
                        break;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if(in == 1){
                        System.out.println("You have chosen BST:");

                        while(true){
                            System.out.println("Below are options of operations for BST.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Root of the tree\n"+
                                "6. Back");

                            in = scanner.nextInt();

                            if(in == 6){
                                System.out.println("Back to DST 1 menu...\n");
                                break;
                            }

                            else if(in < 1 || in > 6){
                                System.out.println("Error: The number you have entered is not in the given options :(");
                                System.out.println("Correct number is (1~5) or 6(To go back!)");
                                System.out.println("Please try again :) \n");

                                System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Tree Root\n"+
                                "6. Back");

                                in = scanner.nextInt();
                                continue;
                            }
                            
                            /*
                             * For BST operations.
                             */
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            questions = new Questions("BST");
                            if(in == 1){ //insertion

                                //number of questions the user want to generate.
                                System.out.println("\nHow many BST insertion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "BSTInsertionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("BST");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " BST insertioin questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("insert");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to BSTInsertionQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 2){ //deletion

                                //number of questions the user want to generate.
                                System.out.println("\nHow many BST deletion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "BSTDeletionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("BST");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " BST Deletion questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("Deletion");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to BSTDeletionQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 3){ //True or False

                                //number of questions the user want to generate.
                                System.out.println("\nHow many BST True/False questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "BSTTrueFalseQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("BST");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " BST True/False questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("TF");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to BSTTrueFalseQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if (in == 4){ //Tree height

                                //number of questions the user want to generate.
                                System.out.println("\nHow many BST Tree height questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "BSTHeightQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("BST");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " BST Tree height questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("height");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to BSTHeightQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 5){ //Tree root

                                //number of questions the user want to generate.
                                System.out.println("\nHow many BST Tree root questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "BSTRootQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("BST");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(i + " BST Tree root questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("root");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to BSTRootQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }
                        }
                    }

                    else if(in == 2){
                        System.out.println("You have chosen AVL:");

                        while(true){
                            System.out.println("Below are options of operations for AVL.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Root of the tree\n"+
                                "6. Back");

                            in = scanner.nextInt();

                            if(in == 6){
                                System.out.println("Back to DST 1 menu...\n");
                                break;
                            }

                            else if(in < 1 || in > 6){
                                System.out.println("Error: The number you have entered is not in the given options :(");
                                System.out.println("Correct number is (1~5) or 6(To go back!)");
                                System.out.println("Please try again :) \n");

                                System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Tree Root\n"+
                                "6. Back");

                                in = scanner.nextInt();
                                continue;
                            }

                            /*
                             * For AVL operations.
                             */
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            questions = new Questions("AVL");
                            if(in == 1){ //insertion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many AVL insertion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "AVLInsertionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("AVL");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " AVL insertioin questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("insert");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to AVLInsertionQuestions.txt");
                                System.out.println("Done...");
                                break;
                                }

                            else if(in == 2){ //deletion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many AVL deletion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "AVLDeletionQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("AVL");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " AVL Deletion questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("Deletion");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to AVLDeletionQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 3){ //True False
                                //number of questions the user want to generate.
                                System.out.println("\nHow many AVL True/False questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "AVLTrueFalseQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("AVL");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " AVL True/False questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("TF");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to AVLTrueFalseQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if (in == 4){ //Tree height
                                //number of questions the user want to generate.
                                System.out.println("\nHow many AVL Tree height questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "AVLHeightQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("AVL");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " AVL Tree height questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("height");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to AVLHeightQuestions.txt");
                                System.out.println("Done...");
                                break;
                               
                            }

                            else if(in == 5){ //Tree root
                                //number of questions the user want to generate.
                                System.out.println("\nHow many AVL Tree root questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "AVLRootQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("AVL");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(i + " AVL Tree root questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("root");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to AVLRootQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    }

                    else if(in == 3){
                        System.out.println("You have chosen RBT(Red Black Tree):");

                        while(true){
                            System.out.println("Below are options of operations for RBT.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Root of the tree\n"+
                                "6. Back");

                            in = scanner.nextInt();

                            if(in == 6){
                                System.out.println("Back to DST 1 menu...\n");
                                break;
                            }

                            else if(in < 1 || in > 6){
                                System.out.println("Error: The number you have entered is not in the given options :(");
                                System.out.println("Correct number is (1~5) or 6(To go back!)");
                                System.out.println("Please try again :) \n");

                                System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Tree Height\n"+
                                "5. Tree Root\n"+
                                "6. Back");

                                in = scanner.nextInt();
                                continue;
                            }

                            /*
                             * For RBT operations.
                             */
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            questions = new Questions("RBT");
                            if(in == 1){ //insertion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Red Black Tree insertion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "RBTInsertionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("RBT");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " RBT insertioin questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("insert");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to RBTInsertionQuestions.txt");
                                System.out.println("Done...");
                                break;
                                }

                            else if(in == 2){ //deletion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Red Black Tree deletion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "RBTDeletionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("RBT");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " RBT Deletion questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("Deletion");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to RBTDeletionQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if(in == 3){ //True False
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Red Black Tree True/False questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "RBTTrueFalseQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("RBT");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " RBT True/False questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("TF");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to RBTTrueFalseQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if (in == 4){ //Tree height
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Red Black Tree height questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "RBTHeightQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("RBT");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " RBT Tree height questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("height");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to RBTHeightQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if(in == 5){ //Tree root
                                 //number of questions the user want to generate.
                                 System.out.println("\nHow many Red Black Tree root questions would you like to generate?");
                                 count = scanner.nextInt();
                                 filename = "RBTRootQuestions.txt";
                                 
                                 //Keeping track of the names of the files generated
                                 String[] names = filenames.split(" ");
                                 boolean exist = false;
                                 for(int i = 0; i < names.length; i++){
                                     if(filename.equals(names[i])){
                                         exist = true;
                                     }
                                 }
                                 if(!exist){
                                     filenames += (filename + " ");
                                 }
                                 
                                 for(int i = 1; i < count+1; i++){
                                     questions = new Questions("RBT");
                                     System.out.print("\033[H\033[2J");
                                     System.out.flush();
                                     System.out.println(i + " RBT Tree root questions generated...");
                                     numberOfQuestions++;
                                     questions.generate("root");
                                 }
                                 System.out.println(numberOfQuestions + " Questions saved to RBTRootQuestions.txt");
                                 System.out.println("Done...");
                                 break;
                                
                            }
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    }

                    else if(in == 4){
                        System.out.println("You have chosen Hash Table:");

                        while(true){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("Below are options of operations for Hash table.");
                            System.out.println("Enter only the number of the given options\n"+
                            "1. Insertion\n"+
                            "2. Insertion Sequence\n"+
                            "3. True/False\n"+
                            "4. Collisions\n"+
                            "5. Back");

                            in = scanner.nextInt();

                            if(in == 5){
                                System.out.println("Back to DST 1 menu...\n");
                                break;
                            }

                            else if(in < 1 || in > 6){
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Error: The number you have entered is not in the given options :(");
                                System.out.println("Correct number is (1~4) or 5(To go back!)");
                                System.out.println("Please try again :) \n");

                                System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Insertion Sequence\n"+
                                "3. True/False\n"+
                                "4. Collisions\n"+
                                "5. Back");

                                in = scanner.nextInt();
                                continue;
                            }

                            /*
                             * For Hash operations.
                             */
                            questions = new Questions("Hash");
                            if(in == 1){ //insertion
                                 //number of questions the user want to generate.
                                System.out.println("\nHow many Hash Table insertion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HashTableInsertionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Hash");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Hash Table insertioin questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("insert");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HashTableInsertionQuestions.txt");
                                System.out.println("Done...");
                                break;
                                }

                            else if(in == 2){ //Insertion Sequence
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Hash Table insertion sequence questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HashTableInsertion_SeqQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Hash");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Hash Table insertioin sequence questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("IS");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HashTableInsertion_SeqQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if(in == 3){ //True/False
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Hash Table True/False questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HashTableTrueFalseQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Hash");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Hash Table True/False questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("TF");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HashTableTrueFalseQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if (in == 4){ //Collisions
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Hash Table collision questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HashTableCollisionQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Hash");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Hash Table collision questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("collisions");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HashTableCollisionQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    }
                }
            }
            else if(in == 2){
                System.out.println("You have chosen DST 2:");

                while(true){
                    System.out.println("Below are options of DSTs in DST 2.");
                    System.out.println("Enter only the number for the given options\n"+
                            "1. Heap\n"+
                            "2. B+-Trees\n"+
                            "3. Graphs\n"+
                            "4. To quit.\n");
                            in = scanner.nextInt();

                    if(in > 4 || in < 1){
                        System.out.println("Error: The number you have entered is not in the given options :(");
                        System.out.println("Correct number is (1~3) or 4(To quit!)");
                        System.out.println("Please try again :) \n");
                                
                        System.out.println("Enter only the number for the given options\n"+
                                "1. Heap\n"+
                                "2. B+-Trees\n"+
                                "3. Graphs\n"+
                                "4. To quit.\n");
                                
                        in = scanner.nextInt();
                    }

                    if(in == 4){
                        break;
                    }

                    else if(in == 1){
                        System.out.println("You have chosen Heap:");
                        System.out.println("NB: it is chosen at random whether min or max");

                        while(true){
                            System.out.println("Below are options of operations for Heap DST.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. Insertion\n"+
                                "2. Deletion\n"+
                                "3. True/False\n"+
                                "4. Heap Root\n"+
                                "5. Back");
                            in = scanner.nextInt();

                            if(in > 5 || in < 1){
                                System.out.println("Error: The number you have entered is not in the given options :(");
                                System.out.println("Correct number is (1~4) or 5(To quit!)");
                                System.out.println("Please try again :) \n");

                                System.out.println("Below are options of operations for Heap DST.");
                                System.out.println("Enter only the number of the given options\n"+
                                    "1. Insertion\n"+
                                    "2. Deletion\n"+
                                    "3. True/False\n"+
                                    "4. Heap Root\n"+
                                    "5. Back");
                                in = scanner.nextInt();
                                continue;
                            }

                            else if(in == 5){
                                break;
                            }

                            /*
                             * For Heap operations.
                             */
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            questions = new Questions("Heap");

                            if(in == 1){ //insertion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Heap insertion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HeapInsertionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }

                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Heap");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Heap insertioin questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("insert");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HeapInsertionQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 2){ //deletion
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Heap deletion questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HeapDeletionQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Heap");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Heap Deletion questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("Deletion");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HeapDeletionQuestions.txt");
                                System.out.println("Done...");
                                break;
                            }

                            else if(in == 3){ //True or False
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Heap True/False questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HeapTrueFalseQuestions.txt";

                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Heap");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(i + " Heap True/False questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("TF");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HeapTrueFalseQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }

                            else if (in == 4){ //Tree root
                                //number of questions the user want to generate.
                                System.out.println("\nHow many Heap Tree root questions would you like to generate?");
                                count = scanner.nextInt();
                                filename = "HeapRootQuestions.txt";
                                
                                //Keeping track of the names of the files generated
                                String[] names = filenames.split(" ");
                                boolean exist = false;
                                for(int i = 0; i < names.length; i++){
                                    if(filename.equals(names[i])){
                                        exist = true;
                                    }
                                }
                                if(!exist){
                                    filenames += (filename + " ");
                                }
                                
                                for(int i = 1; i < count+1; i++){
                                    questions = new Questions("Heap");
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(i + " Heap Tree root questions generated...");
                                    numberOfQuestions++;
                                    questions.generate("root");
                                }
                                System.out.println(numberOfQuestions + " Questions saved to HeapRootQuestions.txt");
                                System.out.println("Done...");
                                break;
                                
                            }
                        }
                }
                else if(in==2){
                    System.out.println("You have chosen B+-Tree:");

                    while(true){
                        System.out.println("Below are options of operations for B+-Tree DST.");
                        System.out.println("Enter only the number of the given options\n"+
                                "1. True/False\n"+
                                "2. General Questions\n"+
                                "3. Back");
                        in = scanner.nextInt();

                        if(in > 3 || in < 1){
                            System.out.println("Error: The number you have entered is not in the given options :(");
                            System.out.println("Correct number is (1~2) or 3(To quit!)");
                            System.out.println("Please try again :) \n");

                            System.out.println("Below are options of operations for B+-Tree DST.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. True/False\n"+
                                "2. General Questions\n"+
                                "3. Back");
                            in = scanner.nextInt();
                            continue;
                        }

                        else if(in == 3){
                            break;
                            }

                        /*
                         * For B+-Trees operations.
                         */
                        if(in == 1){ //True/False
                            //number of questions the user want to generate.
                            System.out.println("\nHow many B+-Tree True/False questions would you like to generate?");
                            count = scanner.nextInt();
                            filename = "BTreeTrueFalseQuestions.txt";

                            //Keeping track of the names of the files generated
                            String[] names = filenames.split(" ");
                            boolean exist = false;
                            for(int i = 0; i < names.length; i++){
                                if(filename.equals(names[i])){
                                    exist = true;
                                }
                            }
                            if(!exist){
                                filenames += (filename + " ");
                            }
                            
                            for(int i = 1; i < count+1; i++){
                                questions = new Questions("B+-Tree");
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println(i + " B+-Tree True/False questions generated...");
                                numberOfQuestions++;
                                questions.generate("TF");
                            }
                            System.out.println(numberOfQuestions + " Questions saved to BTreeTrueFalseQuestions.txt");
                            System.out.println("Done...");
                            break;
                        }
                        if(in == 2){ //General Questions
                            //number of questions the user want to generate.
                            System.out.println("\nHow many B+-Tree MCQ questions would you like to generate?");
                            count = scanner.nextInt();
                            filename = "BTreeMCQQuestions.txt";

                            //Keeping track of the names of the files generated
                            String[] names = filenames.split(" ");
                            boolean exist = false;
                            for(int i = 0; i < names.length; i++){
                                if(filename.equals(names[i])){
                                    exist = true;
                                }
                            }
                            if(!exist){
                                filenames += (filename + " ");
                            }
                            
                            for(int i = 1; i < count+1; i++){
                                questions = new Questions("B+-Tree");
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println(i + " B+-Tree MCQ questions generated...");
                                numberOfQuestions++;
                                questions.generate("general");
                            }
                            System.out.println(numberOfQuestions + " Questions saved to BTreeMCQQuestions.txt");
                            System.out.println("Done...");
                            break;
                        }
                        }   
                }
                else if(in == 3){
                    System.out.println("You have chosen Graphs:");

                    while(true){
                        System.out.println("Below are options of operations for Graphs DST.");
                        System.out.println("Enter only the number of the given options\n"+
                                "1. True/False\n"+
                                "2. General Questions\n"+
                                "3. Back");
                        in = scanner.nextInt();

                        if(in > 3 || in < 1){
                            System.out.println("Error: The number you have entered is not in the given options :(");
                            System.out.println("Correct number is (1~2) or 3(To quit!)");
                            System.out.println("Please try again :) \n");

                            System.out.println("Below are options of operations for Graphs DST.");
                            System.out.println("Enter only the number of the given options\n"+
                                "1. True/False\n"+
                                "2. General Questions\n"+
                                "3. Back");
                            in = scanner.nextInt();
                            continue;
                        }

                        else if(in == 3){
                            break;
                            }

                        /*
                         * For Graphs operations.
                         */
                        if(in == 1){ //True/False
                            //number of questions the user want to generate.
                            System.out.println("\nHow many Graphs True/False questions would you like to generate?");
                            count = scanner.nextInt();
                            filename = "GraphTrueFalseQuestions.txt";

                            //Keeping track of the names of the files generated
                            String[] names = filenames.split(" ");
                            boolean exist = false;
                            for(int i = 0; i < names.length; i++){
                                if(filename.equals(names[i])){
                                    exist = true;
                                }
                            }
                            if(!exist){
                                filenames += (filename + " ");
                            }
                            
                            for(int i = 1; i < count+1; i++){
                                questions = new Questions("Graph");
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println(i + " Graph True/False questions generated...");
                                numberOfQuestions++;
                                questions.generate("TF");
                            }
                            System.out.println(numberOfQuestions + " Questions saved to GraphTrueFalseQuestions.txt");
                            System.out.println("Done...");
                            break;
                        }
                        if(in == 2){ //General Questions
                            //number of questions the user want to generate.
                            System.out.println("\nHow many Graph MCQ questions would you like to generate?");
                            count = scanner.nextInt();
                            filename = "GraphMCQQuestions.txt";

                            //Keeping track of the names of the files generated
                            String[] names = filenames.split(" ");
                            boolean exist = false;
                            for(int i = 0; i < names.length; i++){
                                if(filename.equals(names[i])){
                                    exist = true;
                                }
                            }
                            if(!exist){
                                filenames += (filename + " ");
                            }
                            
                            for(int i = 1; i < count+1; i++){
                                questions = new Questions("Graph");
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println(i + " Graph MCQ questions generated...");
                                numberOfQuestions++;
                                questions.generate("general");
                            }
                            System.out.println(numberOfQuestions + " Questions saved to GraphMCQQuestions.txt");
                            System.out.println("Done...");
                            break;
                        }
                        }
                }

        System.out.println("Main menu.");
    }
    }
}
}
}