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

class SelectableTree extends JFrame implements TreeSelectionListener, ActionListener{  
	protected DefaultTreeModel treeModel;
	protected DefaultMutableTreeNode root;
	private JTree tree;         // Reference tree that will be created.
	private JLabel selectField;  // Reference label for messages.
	private JScrollPane scrollArea;   // Reference scroll area to display tree.
	private JPanel a,b,c;
	private int childName = 1;// Node name.
	private Button addButton,removeButton,changeButton,expandAllButton,expandUnderButton,	collapseAllButton,collapseUnderButton;
	

	// The constructor method.
	public SelectableTree(){  
		super("JTree Selections"); // Set the title line.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Enable the exit button.
		// Create the tree nodes.
		DefaultMutableTreeNode grandGrand, grandChild, child;     // References to tree nodes.
		root = new DefaultMutableTreeNode("Root Node");
		treeModel = new DefaultTreeModel(root);

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


		/*Button aButton = new Button("Add");
    	Button bButton = new Button("Change");
    	Button cButton = new Button("Remove");
    	a.add(aButton);
		a.add(bButton);
		a.add(cButton);*/

		a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
		//a.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		//a.add(Box.createHorizontalBox());
		//b.add(Box.createRigidArea(new Dimension(10, 0)));
		//b.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		addButton = new Button("Add");
		removeButton=new Button("Remove");
		changeButton=new Button("Change");
		a.add(addButton);
		addButton.addActionListener(this);
		//a.add(new Button("Change"));
		a.add(changeButton);

		removeButton.addActionListener(this);
		a.add(removeButton);
		changeButton.addActionListener(this);
		b = new JPanel();
		b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS));
		expandAllButton=new Button("Expand All");

		b.add(expandAllButton);
		expandAllButton.addActionListener(this);
		expandUnderButton=new Button("Expand Selected");
		b.add(expandUnderButton);
		expandUnderButton.addActionListener(this);
		
		
		collapseAllButton=new Button("Collapse All");
		b.add(collapseAllButton);
		collapseAllButton.addActionListener(this);
		
		
		collapseUnderButton=new Button("Collapse Selected");
		b.add(collapseUnderButton);
		collapseUnderButton.addActionListener(this);
	

		// Add the scroll pane and the text field to the JFrame container.
		Box s= new Box(BoxLayout.LINE_AXIS) ;
		s.add(a);
		s.add(b);
	
		//content.add(b, Box.createHorizontalGlue());
		content.add(s,BorderLayout.NORTH);

		content.add(scrollArea, BorderLayout.CENTER);
		content.add(selectField, BorderLayout.SOUTH);


		setSize(250, 275);  // Set the JFrame window size.
		setVisible(true);   // Make everything visible.
	}
	// Method to respond to tree selection changes.
	public void valueChanged(TreeSelectionEvent event){
		selectField.setText( "Current Selection: " + tree.getLastSelectedPathComponent().toString());
	}

	public void removeNode(DefaultMutableTreeNode selection){


		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selection.getParent();
		tree.setSelectionPath(new TreePath(parent.getPath()));
		treeModel.removeNodeFromParent(selection);
		TreePath t = new TreePath(parent.getPath());
		tree.scrollPathToVisible(t);

	}

	public void changeNode(DefaultMutableTreeNode selection){

		System.out.println("changeNode");
		selection.setUserObject("Changed"+ childName++);
		treeModel.nodeChanged(selection);

	}

	public void expandAll(){
		for (int row = 0; row < tree.getRowCount(); row++){
			tree.expandRow(row);
		}
	}
	
	


	public void expandSelected(DefaultMutableTreeNode selection){
		 tree.expandPath(new TreePath(selection.getPath()));
	}
	
	public void collapseAll(){
		for (int row = 0; row < tree.getRowCount(); row++){
			tree.collapseRow(row);
		}
	}
	
	
	public void collapseSelected(DefaultMutableTreeNode selection){
		tree.collapsePath(new TreePath(selection.getPath()));
		
	}


	public void addNode(DefaultMutableTreeNode selection){
		DefaultMutableTreeNode newChild = new DefaultMutableTreeNode("Node " + childName++);
		treeModel.insertNodeInto(newChild, selection, treeModel.getChildCount(selection));
		TreePath t = new TreePath(newChild.getPath());
		tree.scrollPathToVisible(t);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selection =  (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	
		if(e.getSource()==addButton) addNode(selection);
		else if(e.getSource()==removeButton) removeNode(selection);
		else if(e.getSource()==changeButton) changeNode(selection);
		else if(e.getSource()==expandAllButton) expandAll();
		else if(e.getSource()==expandUnderButton) expandSelected(selection);
		else if(e.getSource()==collapseAllButton) collapseAll();
		else if(e.getSource()==collapseUnderButton) collapseSelected(selection);



	}

}
