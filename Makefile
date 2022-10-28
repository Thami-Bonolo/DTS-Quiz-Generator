JFLAGS = -g
JC = javac

.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Randomize.java \
		HashTable.java \
		MinHeap.java \
		MaxHeap.java \
		BinarySearchTree.java \
		AVLTree.java \
		RedBlackTree.java \
		Questions.java \
		Main.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java Main

clean:
		$(RM) *.class
		$(RM) *.txt