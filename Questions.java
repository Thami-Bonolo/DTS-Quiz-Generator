import java.lang.Math; //For random number generation
import java.util.*;
import java.lang.Object;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Questions{
    Randomize rand;
    int[] Array, hashArray;
    String dataStructure;


    BinarySearchTree bst;
    AVLTree avl;
    RedBlackTree rbt;
    MinHeap minheap;
    MaxHeap maxheap;
    HashTable hash;

    public Questions(){

    }

    public Questions(String DST){
        this.dataStructure = DST;
        rand = new Randomize(10);
        Array = rand.Array();
        if(DST == "BST"){BST();}
        else if(DST == "AVL"){AVL();}
        else if(DST == "RBT"){RBT();}
        else if(DST == "Heap"){Heap();}
        else if(DST == "Hash"){Hash();}
    }

    /*
     * These method are to create the data structures
     */

    private void BST(){
        /*
         * Insert the data into the tree
         */ 
        bst = new BinarySearchTree();
        for(int i = 0; i < Array.length; i++){
            bst.insert(Array[i]);
        }
        
    }

    private void AVL(){
        avl = new AVLTree();
        for(int i = 0; i < Array.length; i++){
            avl.insert(Array[i]);
        }
    }

    private void RBT(){
        rbt = new RedBlackTree();
        for(int i = 0; i < Array.length; i++){
            rbt.insert(Array[i]);
        }
    }

    private void Hash(){
        rand = new Randomize(5);
        hashArray = rand.Array();
        /*
         * Randomly choose table size
         */
        int[] tablesizes = {7, 11, 13};
        int tablesize = tablesizes[Main.numberOfQuestions%3];
        hash = new HashTable(tablesize);

        for(int i = 0; i < hashArray.length; i++){
            hash.insert(hashArray[i]);
        }
    }

    private void Heap(){
        /*
         * Create both min and max heap
         */
        minheap = new MinHeap(11);
        for(int i = 0; i < Array.length; i++){
            minheap.insert(Array[i]);
        }
        maxheap = new MaxHeap(11);
        for(int i = 0; i < Array.length; i++){
            maxheap.insert(Array[i]);
        }
    }

    public void generate(String Qtype){
        if(dataStructure.equalsIgnoreCase("BST")){
            generateBST(Qtype);
        }

        else if(dataStructure.equalsIgnoreCase("AVL")){
            generateAVL(Qtype);
        }

        else if(dataStructure.equalsIgnoreCase("RBT")){
            generateRBT(Qtype);
        }

        else if(dataStructure.equalsIgnoreCase("Hash")){
            generateHash(Qtype);
        }

        else if(dataStructure.equalsIgnoreCase("Heap")){
            generateHeap(Qtype);
        }
        else if(dataStructure.equalsIgnoreCase("B+-Tree")){
            generateBTree(Qtype);
        }
        else if(dataStructure.equalsIgnoreCase("Graph")){
            generateGraph(Qtype);
        }
    }

    private void generateGraph(String QType){
        String que = "";

        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "In an undirected graph, the order of the vertices in the "+
                    "pairs in the Edge set does not matter.";
            String two = "A path is a sequence of vertices connected by edges.";
            String three = "A weighted path length is the number of edges on a path.";
            String four = "A Cycle in a directed graph is a path that begins and ends at the same " +
                    "vertex and contains at least one edge.";
            String five = "A cyclic graph is a directed graph with at least one cycle”.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\n*a. True \nb. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\n*a. True \nb. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }

        else if(QType.equalsIgnoreCase("general")){
            int randomQuestion = Main.numberOfQuestions % 5;
            if(randomQuestion == 0){
                que = "A directed acyclic graph (DAG) is a...";
                String a = "directed graph having no cycles";
                String b = "simple path";
                String c = "In an undirected graph";
                String d = "shortest path";

                String[] choices = {a, b, c, d};
                reshuffle(choices, a, que);
            }
            if(randomQuestion == 1){
                que = "A path is a sequence of vertices connected by...";
                String a = "vertices";
                String b = "digraphs";
                String c = "edges";
                String d = "shortest path";

                String[] choices = {a, b, c, d};
                reshuffle(choices, c, que);
            }
            if(randomQuestion == 2){
                que = "what is the number of edges on a path";
                String a = "vertices";
                String b = "cost";
                String c = "cycle";
                String d = "unweighted path length";

                String[] choices = {a, b, c, d};
                reshuffle(choices, d, que);
            }
            if(randomQuestion == 3){
                que = "A _____ is one in which the edge pair is ordered";
                String a = "simple path";
                String b = "digraph";
                String c = "cycle";
                String d = "unweighted path length";

                String[] choices = {a, b, c, d};
                reshuffle(choices, b, que);
            }
            if(randomQuestion == 4){
                que = "Agraph consists of a set of...";
                String a = "simple path";
                String b = "cost and weight";
                String c = "Vertices and Edges";
                String d = "A cycle";

                String[] choices = {a, b, c, d};
                reshuffle(choices, c, que);
            }
        }
    }

    private void generateBTree(String QType){
        String que = "";

        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "In a B+-Tree any key can be found in logarithmic time.";
            String two = "A leaf node has between [(n–1)/2] and n–1 values (keys).";
            String three = "A root of a B+-Tree with n=5 can have 0 children.";
            String four = "The topmost nodes in a B+-Tree are called leaf nodes.";
            String five = "The root of a B+-Tree, if it is not a leaf, has at least 2 children..";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\n*a. True \nb. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\n*a. True \nb. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("general")){
                int randomQuestion = Main.numberOfQuestions % 5;
                if(randomQuestion == 0){
                    que = "A non leaf node can hold up to _____ pointers.";
                    String a = "n";
                    String b = "0";
                    String c = "2";
                    String d = "It depends";
    
                    String[] choices = {a, b, c, d};
                    reshuffle(choices, a, que);
                }
                if(randomQuestion == 1){
                    que = "B+-Trees are widely used in...";
                    String a = "Games";
                    String b = "operating Systems";
                    String c = "Databases";
                    String d = "Quizzes";
    
                    String[] choices = {a, b, c, d};
                    reshuffle(choices, c, que);
                }
                if(randomQuestion == 2){
                    que = "Data in B+-Tree can be accessed in ___ order";
                    String a = "leaf";
                    String b = "children";
                    String c = "nodes";
                    String d = "key";
    
                    String[] choices = {a, b, c, d};
                    reshuffle(choices, d, que);
                }
                if(randomQuestion == 3){
                    que = "A B+ tree can contain a maximum of 7 pointers in a node."+
                    " What is the minimum number of keys in leaves?";
                    String a = "n";
                    String b = "3";
                    String c = "4";
                    String d = "The question is incomplete";
    
                    String[] choices = {a, b, c, d};
                    reshuffle(choices, b, que);
                }
                if(randomQuestion == 4){
                    que = "Which of the following is true?";
                    String a = "B+-Tree allows only the rapid random access";
                    String b = "B+-Tree allows only the rapid sequential access";
                    String c = "B+-Tree allows rapid random access as well as rapid sequential access";
                    String d = "B+-Tree allows rapid random access and slower sequential access";
    
                    String[] choices = {a, b, c, d};
                    reshuffle(choices, c, que);
                }
            }
        }

    private void generateBST(String QType){
        String que = "";

        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "A binary tree has a self balancing property.";
            String two = "A balanced binary tree has a O(n) search time.";
            String three = "Sorted data fed into a binary tree causes the tree to degenerate into a Linked List.";
            String four = "Pre order tree traversal sorts the data.";
            String five = "A binary tree has a O(log(n)) insert time.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\na. True \n*b. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\n*a. True \nb. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("height")){ //Tree height
            que = "The following data " + Arrays.toString(Array) +
                    " is inserted into a binary tree respectively. "+
                    "What is the height of the tree?";
            int a = (int)Math.random()*10;
            if(a == bst.height()){
                a =(a + 3)%10;
            }
            
            int b = (int)Math.random()*10;
            if(b == bst.height() || b == a){
                b =(b + 6)%10;
            }
            int c = (int)Math.random()*10;
            if(c == bst.height() || c == a || c == b){
                c = (c + 2)%10;
            }
            int d = bst.height();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("root")){ //tree root
            que = "A binary tree is created from numbers given in this order: "+
                    Arrays.toString(Array) + " what is the root node of the tree?";
            
            int i = indexOf(Array, bst.getRoot());

            int a = Array[(i + 3)%10];        
            int b = Array[(i + 5)%10];
            int c = Array[(i + 7)%10];
            int d = bst.getRoot();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("Insert")){
            String order = "";
            int[] answer;
            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                bst.levelOrder();
                answer = convertArray(bst.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                bst.inorder();
                answer = convertArray(bst.in);
            }
            else if((Main.numberOfQuestions%4) == 2){
                order = "post-order";
                bst.postOrder();
                answer = convertArray(bst.post);
            }
            else{
                order = "pre-order";
                bst.preOrder();
                answer = convertArray(bst.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array) + " are inserted into a binary tree "+
                    "in that given order. What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
            
        }

        else if(QType.equalsIgnoreCase("Deletion")){
            String order = "";
            int[] answer;
            int deletedKey = Array[Main.numberOfQuestions%10];
            bst.deleteKey(deletedKey);

            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                bst.levelOrder();
                answer = convertArray(bst.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                bst.inorder();
                answer = convertArray(bst.in);
            }
            else if((Main.numberOfQuestions%5) == 2){
                order = "post-order";
                bst.postOrder();
                answer = convertArray(bst.post);
            }
            else{
                order = "pre-order";
                bst.preOrder();
                answer = convertArray(bst.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array) + " are inserted into a binary tree "+
                    "in that given order. The key "+ deletedKey+ " is then deleted from the tree."+
                    " What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
        }


    }

    private void generateAVL(String QType){
        String que = "";
        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "An AVL tree has a self balancing property.";
            String two = "An AVL tree has a O(n) search time.";
            String three = "Sorted data fed into an AVL tree causes the tree to degenerate into a Linked List.";
            String four = "Pre order tree traversal sorts the data.";
            String five = "An AVL tree has a O(log(n)) insert time.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\n*a. True \nb. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\n*a. True \nb. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("height")){ //Tree height
            que = "The following data " + Arrays.toString(Array) +
                    " is inserted into a AVL tree respectively. "+
                    "What is the height of the tree?";
            int a = (int)Math.random()*10;
            if(a == avl.height()){
                a =(a + 3)%10;
            }
            
            int b = (int)Math.random()*10;
            if(b == avl.height() || b == a){
                b =(b + 6)%10;
            }
            int c = (int)Math.random()*10;
            if(c == avl.height() || c == a || c == b){
                c = (c + 2)%10;
            }
            int d = avl.height();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("root")){ //tree root
            que = "An AVL tree is created from numbers given in this order: "+
                    Arrays.toString(Array) + " what is the root node of the tree?";
            
            int i = indexOf(Array, avl.getRoot());

            int a = Array[(i + 3)%10];        
            int b = Array[(i + 5)%10];
            int c = Array[(i + 7)%10];
            int d = avl.getRoot();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("Insert")){
            String order = "";
            int[] answer;

            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                avl.levelOrder();
                answer = convertArray(avl.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                avl.inorder();
                answer = convertArray(avl.in);
            }
            else if((Main.numberOfQuestions%4) == 2){
                order = "post-order";
                avl.postOrder();
                answer = convertArray(avl.post);
            }
            else{
                order = "pre-order";
                avl.preOrder();
                answer = convertArray(avl.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array) + " are inserted into an AVL tree "+
                    "in that given order. What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
            
        }

        else if(QType.equalsIgnoreCase("Deletion")){
            String order = "";
            int[] answer;
            int deletedKey = Array[Main.numberOfQuestions%10];
            avl.deleteKey(deletedKey);

            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                avl.levelOrder();
                answer = convertArray(avl.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                avl.inorder();
                answer = convertArray(avl.in);
            }
            else if((Main.numberOfQuestions%4) == 2){
                order = "post-order";
                avl.postOrder();
                answer = convertArray(avl.post);
            }
            else{
                order = "pre-order";
                avl.preOrder();
                answer = convertArray(avl.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array) + " are inserted into an AVL tree "+
                    "in that given order. The key "+ deletedKey+ " is then deleted from the tree."+
                    " What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
        }

    }

    private void generateRBT(String QType){
        String que = "";
        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "A Red-Black tree has a self balancing property.";
            String two = "A Red-Black tree has a faster search time than AVL.";
            String three = "Red-Black tree got it's name because the author likes the colors Red and Black.";
            String four = "The nodes of a Red-Black tree are given colors(i.e Red and Black).";
            String five = "Red-Black tree black node cannot be a parent node for a black child.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\n*a. True \nb. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\na. True \n*b. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\n*a. True \nb. False\n\n";
            }
            else{
                que = five + "\n*a. True \nb. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("height")){ //Tree height
            que = "The following data " + Arrays.toString(Array) +
                    " is inserted into a Red-Black binary tree respectively. "+
                    "What is the height of the tree?";
            int a = (int)Math.random()*10;
            if(a == rbt.height()){
                a =(a + 3)%10;
            }
            
            int b = (int)Math.random()*10;
            if(b == rbt.height() || b == a){
                b =(b + 6)%10;
            }
            int c = (int)Math.random()*10;
            if(c == rbt.height() || c == a || c == b){
                c = (c + 2)%10;
            }
            int d = rbt.height();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("root")){ //tree root
            que = "A Red Black tree is created from numbers given in this order: "+
                    Arrays.toString(Array) + " what is the root node of the tree?";
            
            int i = indexOf(Array, rbt.getRoot());

            int a = Array[(i + 3)%10];        
            int b = Array[(i + 5)%10];
            int c = Array[(i + 7)%10];
            int d = rbt.getRoot();

            int[] choices = {a, b, c, d};
            reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("Insert")){
            String order = "";
            int[] answer;

            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                rbt.levelOrder();
                answer = convertArray(rbt.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                rbt.inorder();
                answer = convertArray(rbt.in);
            }
            else if((Main.numberOfQuestions%4) == 2){
                order = "post-order";
                rbt.postOrder();
                answer = convertArray(rbt.post);
            }
            else{
                order = "pre-order";
                rbt.preOrder();
                answer = convertArray(rbt.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array) + " are inserted into a Red Black tree "+
                    "in that given order. What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
            
        }

        else if(QType.equalsIgnoreCase("Deletion")){
            String order = "";
            int[] answer;
            int[] Array1 = Array;
            int deletedKey = Array[Main.numberOfQuestions%10];
            rbt.deleteNode(deletedKey);

            if((Main.numberOfQuestions%4) == 0){
                order = "level-order";
                rbt.levelOrder();
                answer = convertArray(rbt.Level);
            }
            else if((Main.numberOfQuestions%4) == 1){
                order = "in-order";
                rbt.inorder();
                answer = convertArray(rbt.in);
            }
            else if((Main.numberOfQuestions%4) == 2){
                order = "post-order";
                rbt.postOrder();
                answer = convertArray(rbt.post);
            }
            else{
                order = "pre-order";
                rbt.preOrder();
                answer = convertArray(rbt.pre);
            }
            
            que = "The numbers: " + Arrays.toString(Array1) + " are inserted into a Red Black tree "+
                    "in that given order. The key "+ deletedKey+ " is then deleted from the tree."+
                    " What will the "+ order + " tree traversal be?";

            int[] a = ShufflingArray(answer);
            int[] b = ShufflingArray(a);
            int[] c = ShufflingArray(b);
            int[] d = answer;
            int[][] choices = {a, b, c, d};

            reshuffle(choices, d, que);
        }

    }

    private void generateHash(String QType){
        String que = "";
        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "Collision in a hash table refers to when a hash function fails to insert/find an element.";
            String two = "Usage of extra memory is one of the disadvantages chaining has over open addressing.";
            String three = "Collision in hash table refers to several elements hashed to the same location.";
            String four = "Load factor is another name for the table size.";
            String five = "Binary trees are used in simple chaining.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\na. True \n*b. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\na. True \n*b. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("insert")){
            que = "The numbers: " + Arrays.toString(hashArray) + " are inserted into a hash table in that given order of table size"+
                    hash.getTableSize() + 
                    " and a hash function of val mod tableSize with a " + 
                    hash.getProbing() + " probing colllision resolution." +
                    "what will the hash table look like?";

                int[] a = ShufflingArray(hash.getTable());
                int[] b = ShufflingArray(a);
                int[] c = ShufflingArray(b);
                int[] d = hash.getTable();
                int[][] choices = {a, b, c, d};

                reshuffle(choices, d, que);
        }

        else if(QType.equalsIgnoreCase("IS")){
            que = Integer.toString(hashArray.length) + " numbers are inserted into a hash table of size "+
                hash.getTableSize()+ " with a hash function of hash(val) = val % tableSize; "+
                hash.getProbing() + " probing collision resolution was used. This is the resulted hash table\n" +
                Arrays.toString(hash.getTable()) +" what is the correct insertion sequence?";

                int[] a = ShufflingArray(hashArray);
                int[] b = hashArray;
                int[] c = ShufflingArray(a);
                int[] d = ShufflingArray(c);
                int[][] choices = {a, b, c, d};

                reshuffle(choices, b, que);

        }

        else if(QType.equalsIgnoreCase("collisions")){
            que = "The numbers: " + Arrays.toString(hashArray) + " are inserted into a hash table in that given order of table size "+
                    hash.getTableSize() + " and a hash function of val mod tableSize with a " + hash.getProbing() + " probing collision resolution." +
                    "how many collisions occured?";
                
                int a = hash.getCollisions();
                int b = a*2;
                int c = b + 3;
                int d = c*3;

                int[] choices = {a, b, c, d};
                reshuffle(choices, a, que);
        }
    }

    private void generateHeap(String QType){
        String que = "";
        if(QType.equalsIgnoreCase("TF")){ //true or false

            String one = "Heap exhibits the property of a binary tree?.";
            String two = "The compplexity of adding an element to a heap is O(logn) & O(n).";
            String three = "Heap can be a priority Queue.";
            String four = "Min Heap sorts the elements in decreasing order(i.e a >= b >= c...).";
            String five = "Heap extends the Binary tree class.";

            if((Main.numberOfQuestions%5) == 0){
                que = one + "\n*a. True \nb. False\n\n";

            }
            else if((Main.numberOfQuestions%5) == 1){
                que = two + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 2){
                que = three + "\n*a. True \nb. False\n\n";
            }
            else if((Main.numberOfQuestions%5) == 3){
                que = four + "\na. True \n*b. False\n\n";
            }
            else{
                que = five + "\na. True \n*b. False\n\n";
            }

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
        }
        else if(QType.equalsIgnoreCase("root")){ //tree root

            if((Main.numberOfQuestions%2) == 0){ //min
                que = "A min heap data structure is created from numbers given in this order: "+
                Arrays.toString(Array) + " what is the root node of the tree?";
        
                int i = indexOf(Array, minheap.getRoot());

                int a = Array[(i + 3)%10];        
                int b = Array[(i + 5)%10];
                int c = Array[(i + 7)%10];
                int d = minheap.getRoot();

                int[] choices = {a, b, c, d};
                reshuffle(choices, d, que);
            }

            else{
                que = "A max heap data structure is created from numbers given in this order: "+
                Arrays.toString(Array) + " what is the root node of the tree?";
        
                int i = indexOf(Array, maxheap.getRoot());

                int a = Array[(i + 3)%10];        
                int b = Array[(i + 5)%10];
                int c = Array[(i + 7)%10];
                int d = maxheap.getRoot();

                int[] choices = {a, b, c, d};
                reshuffle(choices, d, que);
            }
        }

        else if(QType.equalsIgnoreCase("insert")){

            if((Main.numberOfQuestions%2) == 0){ //min
                que = "The numbers: " + Arrays.toString(Array) + " are inserted into a min Heap data structure "+
                    "in that given order. What will the heap traversal be?";

                int[] a = ShufflingArray(minheap.getHeap());
                int[] b = maxheap.getHeap();
                int[] c = ShufflingArray(b);
                int[] d = minheap.getHeap();
                int[][] choices = {a, b, c, d};

                reshuffle(choices, d, que);
            }
            
            else{ //max
                que = "The numbers: " + Arrays.toString(Array) + " are inserted into a max Heap data structure "+
                    "in that given order. What will the heap traversal be?";

                int[] a = ShufflingArray(maxheap.getHeap());
                int[] b = minheap.getHeap();
                int[] c = ShufflingArray(b);
                int[] d = maxheap.getHeap();
                int[][] choices = {a, b, c, d};

                reshuffle(choices, d, que);
            }
        }

        else if(QType.equalsIgnoreCase("deletion")){
            if((Main.numberOfQuestions%2) == 0){
                int deletedKey = Array[Main.numberOfQuestions%10];
                que = "The numbers: " + Arrays.toString(Array) + " are inserted into a min Heap data structure "+
                    "in that given order. The root key is then deleted from the Heap."+
                    " What will the heap traversal be?";
                
                minheap.remove();
                int[] d = minheap.getHeap();
                int[] b = ShufflingArray(d);
                int[] c = ShufflingArray(b);
                int[] a = ShufflingArray(c);
                int[][] choices = {a, b, c, d};

                reshuffle(choices, d, que);
            }

            else{
                int deletedKey = Array[Main.numberOfQuestions%10];
                que = "The numbers: " + Arrays.toString(Array) + " are inserted into a max Heap data structure "+
                    "in that given order. The root key is then deleted from the Heap."+
                    " What will the heap traversal be?";
                
                maxheap.remove();
                int[] d = maxheap.getHeap();
                int[] b = ShufflingArray(d);
                int[] c = ShufflingArray(b);
                int[] a = ShufflingArray(c);
                int[][] choices = {a, b, c, d};

                reshuffle(choices, d, que);
            }
            
        }
    }

    /*
     * Method to shuffle the given choices in a quiz:
     */
    private void reshuffle(int[] choices, int d, String que){
        String e = "none of these is correct.";

            //choices.shuffle();

            /*
             * Shuffling the choices array using
             * Fisher-Yates shuffle array method
             */

            int index, temp;
            Random random = new Random();
            for(int i = choices.length - 1; i > 0; i--){
                index = random.nextInt(i+1);
                temp = choices[index];
                choices[index] = choices[i];
                choices[i] = temp;
            }

            for(int i = 0; i < 4; i++){
                if(i == 0){
                    if(choices[i] == d){
                        que += "\n*a. " + Integer.toString(d);
                    }
                    else{
                        que += "\na. " + Integer.toString(choices[i]);
                    }
                }
                if(i == 1){
                    if(choices[i] == d){
                        que += "\n*b. " + Integer.toString(choices[i]);
                    }
                    else{
                        que += "\nb. " + Integer.toString(choices[i]);
                    }
                }
                if(i == 2){
                    if(choices[i] == d){
                        que += "\n*c. " + Integer.toString(choices[i]);
                    }
                    else{
                        que += "\nc. " + Integer.toString(choices[i]);
                    }
                }
                if(i == 3){
                    if(choices[i] == d){
                        que += "\n*d. " + Integer.toString(choices[i]);
                    }
                    else{
                        que += "\nd. " + Integer.toString(choices[i]);
                    }
                }
            }
            que += "\ne. " + e +"\n\n";

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
    }

    private void reshuffle(String[] choices, String d, String que){
        String e = "none of these is correct.";

            //choices.shuffle();

            /*
             * Shuffling the choices array using
             * Fisher-Yates shuffle array method
             */

            int index;
            String temp;
            Random random = new Random();
            for(int i = choices.length - 1; i > 0; i--){
                index = random.nextInt(i+1);
                temp = choices[index];
                choices[index] = choices[i];
                choices[i] = temp;
            }

            for(int i = 0; i < 4; i++){
                if(i == 0){
                    if(choices[i].equals(d)){
                        que += "\n*a. " + d;
                    }
                    else{
                        que += "\na. " + choices[i];
                    }
                }
                if(i == 1){
                    if(choices[i].equals(d)){
                        que += "\n*b. " + choices[i];
                    }
                    else{
                        que += "\nb. " + choices[i];
                    }
                }
                if(i == 2){
                    if(choices[i].equals(d)){
                        que += "\n*c. " + choices[i];
                    }
                    else{
                        que += "\nc. " + choices[i];
                    }
                }
                if(i == 3){
                    if(choices[i].equals(d)){
                        que += "\n*d. " + choices[i];
                    }
                    else{
                        que += "\nd. " + choices[i];
                    }
                }
            }
            que += "\ne. " + e +"\n\n";

            //Writing to file
            try {
                FileWriter fw = new FileWriter(Main.filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
                bw.close();
                System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
            } catch (Exception ex) {
                //TODO: handle exception
                System.out.println("Exception Occured " + ex);
            }
    }

    private void reshuffle(int[][] choices, int[] d, String que){
        int index;
        int[] temp;
        Random random = new Random();
        String e = "none of these are correct";
        for(int i = choices.length - 1; i > 0; i--){
            index = random.nextInt(i+1);
            temp = choices[index];
            choices[index] = choices[i];
            choices[i] = temp;
        }

        for(int i = 0; i < 4; i++){
            if(i == 0){
                if(Arrays.equals(choices[i], d)){
                    que += "\n*a. " + Arrays.toString(d);
                }
                else{
                    que += "\na. " + Arrays.toString(choices[i]);
                }
            }
            if(i == 1){
                if(Arrays.equals(choices[i], d)){
                    que += "\n*b. " + Arrays.toString(choices[i]);
                }
                else{
                    que += "\nb. " + Arrays.toString(choices[i]);
                }
            }
            if(i == 2){
                if(Arrays.equals(choices[i], d)){
                    que += "\n*c. " + Arrays.toString(choices[i]);
                }
                else{
                    que += "\nc. " + Arrays.toString(choices[i]);
                }
            }
            if(i == 3){
                if(Arrays.equals(choices[i], d)){
                    que += "\n*d. " + Arrays.toString(choices[i]);
                }
                else{
                    que += "\nd. " + Arrays.toString(choices[i]);
                }
            }
        }
        que += "\ne. " + e +"\n\n";

        //Writing to file
        try {
            FileWriter fw = new FileWriter(Main.filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Question "+Main.numberOfQuestions +" (1 point)\n"+que);
            bw.close();
            System.out.println("Question "+ Main.numberOfQuestions +" written to output file...\n");
        } catch (Exception ex) {
            //TODO: handle exception
            System.out.println("Exception Occured " + ex);
        }

    }

    private int[] convertArray(List<Integer> array){
        int[] ret = new int[array.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = array.get(i).intValue();
        }
        return ret;
    }

    private int[] ShufflingArray(int[] array){
        int[] choices = array;

        int index, skip;
            int[] temp = new int[choices.length];
            if(choices.length%2==0){
                skip = 3;
            }else{
                skip = 2;
            }

            Random random = new Random();
            for(int i = 0; i<choices.length; i++){
                index = (i+skip)%choices.length;
                temp[index] = choices[i];
            }
            choices = temp;
        return choices;
    }

    private int indexOf(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    private Integer[] toObject(int[] array){
        Integer[] objArray = new Integer[array.length];
        for(int i = 0; i < array.length; i++){
            objArray[i] = Integer.valueOf(array[i]);
        }
        return objArray;
    }
}