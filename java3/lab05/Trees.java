// Trees.java
// Program to demonstrate implementation of trees.
// Provides the framework for cs258 lab number 5.

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class Trees{  
	public static void main(String[] args){
		SelectableTree tree = new SelectableTree();
   }
}


// The tree class to be used as the framework for cs258 lab3.

class SelectableTree extends JFrame implements TreeSelectionListener{  
	private JTree tree;         // Reference tree that will be created.
    private JLabel selectField;  // Reference label for messages.
    private JScrollPane scrollArea;   // Reference scroll area to display tree.
    private int childName = 1;// Node name.
    
    // The constructor method.
    public SelectableTree(){  
    	super("JTree Selections"); // Set the title line.
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Enable the exit button.
    	// Create the tree nodes.
    	DefaultMutableTreeNode grandChild, child;     // References to tree nodes.
    	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root"); 
    	// In a loop create children and grandchildren. 
    	// Link the children to the root and the grandchildren to the children.

    	for (int childX=1; childX<=4; childX++){
    		child = new DefaultMutableTreeNode("Node " + childName++);
    		root.add(child);
    		for (int grandX=1; grandX<=4; grandX++){
    			grandChild = new DefaultMutableTreeNode("Node " + childName++);
    			child.add(grandChild);
    			}
    		}
    	
    	// Instantiate the tree and add the selection listener.
    	tree = new JTree(root);
    	tree.addTreeSelectionListener(this);
    	for (int row = 0; row < tree.getRowCount(); row++){
    		tree.expandRow(row);
    		}
    	// Construct the frame that will be displayed.
    	Container content = getContentPane();         // JFrame default root panel.
    	scrollArea        = new JScrollPane(tree);    // Instantiate scroll area.
    	selectField       = new JLabel("Current Selection: NONE"); // Output Label.
    	// Add the scroll pane and the text field to the JFrame container.
    	content.add(scrollArea, BorderLayout.CENTER);
    	content.add(selectField, BorderLayout.SOUTH);
    	setSize(250, 275);  // Set the JFrame window size.
    	setVisible(true);   // Make everything visible.
    	}
    // Method to respond to tree selection changes.
    public void valueChanged(TreeSelectionEvent event){
    	selectField.setText( "Current Selection: " + tree.getLastSelectedPathComponent().toString());
    	}
    }