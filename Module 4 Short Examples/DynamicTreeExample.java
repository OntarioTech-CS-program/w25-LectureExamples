// Java Program to demonstrate
// Java JTree
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class DynamicTreeExample {
    public static void main(String[] args)
    {
        // Creating the frame
        JFrame frame = new JFrame(
            "GeeksforGeeks - Java JTree Example");

        // Creating the root node
        DefaultMutableTreeNode root
            = new DefaultMutableTreeNode("Root");

        // Creating child nodes
        DefaultMutableTreeNode parent1
            = new DefaultMutableTreeNode("Parent 1");
        DefaultMutableTreeNode child1_1
            = new DefaultMutableTreeNode("Child 1.1");
        DefaultMutableTreeNode child1_2
            = new DefaultMutableTreeNode("Child 1.2");

        // Adding child nodes to the parent1
        parent1.add(child1_1);
        parent1.add(child1_2);

        // Creating another set of child nodes
        DefaultMutableTreeNode parent2
            = new DefaultMutableTreeNode("Parent 2");
        DefaultMutableTreeNode child2_1
            = new DefaultMutableTreeNode("Child 2.1");
        DefaultMutableTreeNode child2_2
            = new DefaultMutableTreeNode("Child 2.2");

        // Adding child nodes to the parent2
        parent2.add(child2_1);
        parent2.add(child2_2);

        // Adding parent nodes to the root
        root.add(parent1);
        root.add(parent2);

        // Creating the JTree
        JTree tree = new JTree(root);

        // Adding the JTree to the frame within a scroll
        // pane
        frame.add(new JScrollPane(tree));

        // Setting frame properties
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
