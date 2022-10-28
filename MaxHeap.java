public class MaxHeap{
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int root = 1;

    /*
     * Constructor!
     */
    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
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

    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            if(Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]){
                    if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                        swap(pos, leftChild(pos));
                        maxHeapify(leftChild(pos));
                    }else{
                        swap(pos, rightChild(pos));
                        maxHeapify(rightChild(pos));
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

        while(Heap[current] > Heap[parent(current)]){
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

    public int[] getHeap(){
        int[] trim = new int[Heap.length-2];
        for(int i = 0; i < trim.length; i++){
            trim[i] = Heap[i+1];
        }
        return trim;
    }

    public int getRoot(){
        return Heap[1];
    }
    /*
     * To build the max heap using maxHeapify
     */

    public void maxHeap(){
        for(int pos = (size/2); pos >= 1; pos--){
            maxHeapify(pos);
        }
    }

    /*
     * To remove and return root(max element)
     */

    public int remove(){
        int popped = Heap[root];
        Heap[root] = Heap[size--];
        maxHeapify(root);
        return popped;
    }

    // Main to test code
    public static void main(String[] arg){
        System.out.println("Its running :(");
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        maxHeap.maxHeap();

        System.out.println(maxHeap.toString());
        maxHeap.remove();
        System.out.println(maxHeap.toString());
        maxHeap.remove();
        System.out.println(maxHeap.toString());
        maxHeap.remove();
        System.out.println(maxHeap.toString());
    }
}