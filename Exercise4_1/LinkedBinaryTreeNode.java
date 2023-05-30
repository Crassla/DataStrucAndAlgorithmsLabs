/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise4_1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author alex
 */
public class LinkedBinaryTreeNode<E> implements MutableTreeNode {

    private E element;
    private MutableTreeNode parent;
    private MutableTreeNode leftChild;
    private MutableTreeNode rightChild;

    public LinkedBinaryTreeNode() {
        this(null);
    }

    public LinkedBinaryTreeNode(E element) {
        this.element = element;
        parent = null;
        leftChild = null;
        rightChild = null;
    }

    // returns that this node allows children
    public boolean getAllowsChildren() {
        return true;
    }

    // return the child at specified index
    public TreeNode getChildAt(int childIndex)
            throws IndexOutOfBoundsException {
        if (childIndex > 1) {
            throw new IndexOutOfBoundsException();
        } else if (childIndex == 0) {
            return leftChild;
        } else if (childIndex == 1) {
            return rightChild;
        } else {
            return null;
        }
    }

    // returns the number of children of this node
    public int getChildCount() {
        int tempCount = 0;

        if (leftChild != null) {
            tempCount++;
        }
        if (rightChild != null) {
            tempCount++;
        }

        return tempCount;
    }

    // returns the index of node or -1 if node not found
    public int getIndex(TreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException();
        } else if (leftChild.equals(node)) {
            return 0;
        } else if (rightChild.equals(node)) {
            return 1;
        }

        return -1;
    }

    // return the parent node or null if this node is the root
    public TreeNode getParent() {
        return parent;
    }

    // returns whether this node is a leaf   
    public boolean isLeaf() {
        return (getChildCount() == 0);
    }

    // add the child node at specified index, updating this node 
    // and child node to reflect the change
    public void insert(MutableTreeNode child, int index)
            throws IllegalArgumentException {
        if (child == null) {
            throw new IllegalArgumentException("null child");
        }
        if (index < 0 || index > 1) {
            throw new IllegalArgumentException("index out of bounds");
        }
        child.removeFromParent(); // remove child from its existing parent
        if (index == 0) {
            leftChild = child;
        }
        if (index == 1) {
            rightChild = child;
        }
        child.setParent(this); // update the child node
    }

    // removes the child at index from this node, updating this
    // node and child node to reflect the change
    public void remove(int index) {
        if (index == 0 && leftChild != null) {
            remove(leftChild);
        }
        if (index == 1 && rightChild != null) {
            remove(rightChild);
        }
    }

    // remove the specified child from this node, updating this
    // node and child node to reflect the change
    public void remove(MutableTreeNode node) {
        if (leftChild != null) {
            if (leftChild.equals(node)) {
                leftChild = null;
            }
        }

        if (rightChild != null) {
            if (rightChild.equals(node)) // node found and removed
            {
                rightChild = null;
            }
        }

    }

    // remove this node from its parent, updating this
    // node and its parent node
    public void removeFromParent() {
        if (this.parent != null) {
            parent.remove(this);
            this.parent = null;
        }
    }

    // sets the parent of this node to be newParent
    // but does not update newParent
    public void setParent(MutableTreeNode newParent) {
        removeFromParent(); // remove this node from its existing parent
        this.parent = newParent;
    }

    // set the element held in this node
    public void setUserObject(Object object) {
        this.element = (E) object; // unchecked, could throw exception
    }

    public E getUserObject() {
        return element;
    }

    // returns a string representation of the node and its child nodes
    // in preorder notation
    public String toString() {
        String output = "" + this.element;
        if (!isLeaf()) {
            output += "[ ";
            if (leftChild != null) {
                output += leftChild;
            }
            output += " ";
            if (rightChild != null) {
                output += rightChild;
            }
            output += "]";
        }
        return output;
    }

    public static void main(String[] args) {  // create some sample nodes
        MutableTreeNode root = new LinkedBinaryTreeNode<String>("A");
        MutableTreeNode nodeB = new LinkedBinaryTreeNode<String>("B");
        MutableTreeNode nodeC = new LinkedBinaryTreeNode<String>("C");
        MutableTreeNode nodeD = new LinkedBinaryTreeNode<String>("D");
        MutableTreeNode nodeE = new LinkedBinaryTreeNode<String>("E");
        MutableTreeNode nodeF = new LinkedBinaryTreeNode<String>("F");
        // build the tree
        nodeB.insert(nodeD, 0);
        nodeB.insert(nodeE, 1);
        nodeC.insert(nodeF, 0);
        root.insert(nodeB, 0);
        root.insert(nodeC, 1);
        System.out.println("Original Tree: " + root);
        root.remove(nodeC);
        nodeB.insert(nodeC, 1);
        System.out.println("Modified Tree: " + root);
    }

    public Enumeration<MutableTreeNode> children() {
        List<MutableTreeNode> children = new ArrayList<>();
        if (leftChild != null) {
            children.add(leftChild);
        }
        if (rightChild != null) {
            children.add(rightChild);
        }
        return (new Enumerator(children.iterator()));
    }
}

// utility class to wrap an Iterator object as an Enumeration object
class Enumerator<E> implements Enumeration<E> {

    private Iterator<E> iterator;

    public Enumerator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    public E nextElement() {
        return iterator.next();
    }
}
