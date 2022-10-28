public class MinHeap{
    private int[] Heap; //The array
    private int size; //current Array size
    private int maxsize; //MAximum array size


    private static final int root = 1;

    public MinHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = 0;
    }
    
    /*
     *this is to return the position of the 
     *parent for the node currently at "pos"
     */
    private int parent(int pos){
        return pos/2;
    }

    /*
     * This returns the position of the left child 
     * for the node currently at pos
     */

    private int leftChild(int pos){
        return (2*pos);
    }

    /*
     * This returns the position of the right child
     * for the node currently at pos
     */

    private int rightChild(int pos){
        return (2*pos) + 1;
    }

    /*
     * This returns true if the passed node is a
     * leaf node
     */

    private boolean isLeaf(int pos){
        if(pos >= (size/2) && pos <= size){
            return true;
        }
        return false;
    }

    /*
     * This swaps nodes of the heap
     */

    private void swap(int firstPos, int secPos){
        int tmp;
        tmp = Heap[firstPos];
        Heap[firstPos]= Heap[secPos];
        Heap[secPos] = tmp;
    }

    /*
     * Heapify at pos
     */

    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            if(Heap[pos] > Heap[leftChild(pos)]
                || Heap[pos] > Heap[rightChild(pos)]){
                    if(Heap[leftChild(pos)]< Heap[rightChild(pos)]){
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }else{
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
        }
    }

    /*
     * To insert a node into the heap
     */

    public void insert(int element){
        if(size >= maxsize){
            //The heap is full.
            System.out.println(element + " wasn't inserted.");
            System.out.println("The heap is full.");
            return;
        }

        Heap[++size] = element;
        int current = size;

        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /*
     * To return the contents of heap
     */

    public String toString(){
        String temp = "";
        for(int i = 1; i < size+1; i++){
            temp += Integer.toString(Heap[i]) + " ";
        }
        return temp;
    }

    /*
     * To build the min heap using minHeapify
     */

    public void minHeap(){
        for(int pos = (size/2); pos >= 1; pos--){
            minHeapify(pos);
        }
    }

    public int getRoot(){
        return Heap[1];
    }

    public int[] getHeap(){
        int[] trim = new int[Heap.length-2];
        for(int i = 0; i < trim.length; i++){
            trim[i] = Heap[i+1];
        }
        return trim;
    }

    /*
     * To remove and return root(min element)
     */

    public int remove(){
        int popped = Heap[root];
        Heap[root] = Heap[size--];
        minHeapify(root);
        return popped;
    }

    /*
     * Attempt to draw the tree :|
     */
    public String drawTree(){
        return drawTree(Heap);
    }

    public String drawTree(int[] arr){
        String tree = "";
        int i =0;
        if(arr == Heap){i++;}
        tree += String.format("%11s",Integer.toString(arr[i++])) + "\n";
        tree += String.format("%8s %4s", "/", "\\") + "\n";
        tree += String.format("%7s %6s", Integer.toString(arr[i++]), 
                Integer.toString(arr[i++])) + "\n";
        tree += String.format("%6s %2s %3s %2s", "/", "\\", "/", "\\") + "\n";
        tree += String.format("%5s %4s %2s %3s", Integer.toString(arr[i++]),
                Integer.toString(arr[i++]), Integer.toString(arr[i++]),
                Integer.toString(arr[i]));

        return tree;
    }
    // Main to test code
    public static void main(String[] arg){
        System.out.println("Its running :(");
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap();

        System.out.println(minHeap.toString());
        /*minHeap.remove();
        System.out.println(minHeap.toString());
        minHeap.remove();
        System.out.println(minHeap.toString());
        minHeap.remove();
        System.out.println(minHeap.toString());*/

        System.out.println(minHeap.drawTree());
        System.out.println();
        Randomize rand = new Randomize(7);
        int[] AAA = rand.Array();
        System.out.println(minHeap.drawTree(AAA));
        System.out.println();

        rand = new Randomize(7);
        AAA = rand.Array();
        System.out.println(minHeap.drawTree(AAA));
        System.out.println();

        rand = new Randomize(7);
        AAA = rand.Array();
        System.out.println(minHeap.drawTree(AAA));

    }
}