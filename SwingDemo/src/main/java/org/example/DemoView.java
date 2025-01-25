package org.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DemoView extends JFrame {
    JFrame frame;

    public DemoView() {
        //        Setting basic window properties
        this.setTitle("Swing App Demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        frame = this;

//        JPanel panel = new JPanel();
////        change panel colour
//        panel.setBackground(Color.BLACK);
//        this.add(panel, BorderLayout.CENTER);
        JTabbedPane tabbedPane = new JTabbedPane();
//        Creating tabs
        JPanel panelTab1 = new JPanel();
        panelTab1.add(new JLabel("This is the first tab."));
        panelTab1.setBackground(Color.GRAY);

        JPanel panelTab2 = new JPanel(new BorderLayout());
        JLabel tab2Label= new JLabel("This is the second tab.");
        panelTab2.add(tab2Label, BorderLayout.PAGE_START);
        JTextArea tab2TextArea = new JTextArea();
        panelTab2.add(tab2TextArea, BorderLayout.CENTER);
        JButton tab2Button = new JButton("Click Me");
        JTextField tab2TextField = new JTextField("Type your label");
        panelTab2.add(tab2TextField, BorderLayout.PAGE_END);
        panelTab2.add(tab2Button, BorderLayout.LINE_END);

        // events for tab 2
        tab2Button.addActionListener(e -> {
            if(!tab2TextField.getText().equals("Type your label")) {
                tab2Label.setText(tab2TextField.getText());
                tab2TextField.setText("Type your label");
            }
        });

        tab2TextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tab2TextField.getText().equals("Type your label")) {
                    tab2TextField.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(tab2TextField.getText().trim().isEmpty()){
                    tab2TextField.setText("Type your label");
                }
            }
        });


        JPanel panelTab3 = new JPanel();
        panelTab3.setLayout(new BorderLayout());
        panelTab3.add(new JLabel("This is the third tab."), BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(new JTextArea());
        panelTab3.add(scrollPane, BorderLayout.CENTER);

        // add panel 4 with JTree
        JPanel treePanel = new JPanel();
        treePanel.setLayout(new BorderLayout());

        //create nodes for tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Child 3");
        root.add(child1);
        root.add(child2);
        root.add(child3);

        DefaultMutableTreeNode subchild11 = new DefaultMutableTreeNode("Child of 1.1");
        DefaultMutableTreeNode subchild12 = new DefaultMutableTreeNode("Child of 1.2");
        child1.add(subchild11);
        child1.add(subchild12);

        DefaultMutableTreeNode subchild21 = new DefaultMutableTreeNode("Child of 2.1");
        DefaultMutableTreeNode subchild22 = new DefaultMutableTreeNode("Child of 2.2");
        child2.add(subchild21);
        child2.add(subchild22);

        DefaultMutableTreeNode subchild211 = new DefaultMutableTreeNode("Child of 2.1.1");
        subchild21.add(subchild211);

        // create JTree
        JTree tree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treePanel.add(treeScrollPane, BorderLayout.CENTER);

        // tab 5 drawing canvas
        JPanel canvasPanel = new JPanel(new BorderLayout());
        DrawingCanvas canvas = new DrawingCanvas();
        canvasPanel.add(canvas, BorderLayout.CENTER);

//        add click event to tree
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                if (path != null) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                    if(node.isLeaf()){
                        JOptionPane.showMessageDialog(frame, "You clicked on leaf:" + node.getUserObject(), "Leaf clicked", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        });







//        Adding tabs to the tabbedPane
        tabbedPane.addTab("Tab 1", panelTab1);
        tabbedPane.addTab("Tab 2", panelTab2);
        tabbedPane.addTab("Tab 3", panelTab3);
        tabbedPane.addTab("Tree", treePanel);
        tabbedPane.addTab("Canvas", canvasPanel);
        this.add(tabbedPane, BorderLayout.CENTER);


        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.LIGHT_GRAY);
        JLabel sideLabel = new JLabel("Left side area");
        sidePanel.add(sideLabel);
        this.add(sidePanel, BorderLayout.LINE_START);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.PINK);
        JLabel topLabel = new JLabel("Top area");
        topPanel.add(topLabel);
        this.add(topPanel, BorderLayout.PAGE_START);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.PINK);
        JLabel bottomLabel = new JLabel("Bottom area");
        bottomPanel.add(bottomLabel);
        this.add(bottomPanel, BorderLayout.PAGE_END);

    }
}
