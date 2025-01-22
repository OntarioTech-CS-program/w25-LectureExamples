import javax.swing.*;
import java.awt.*;

class CounterView extends JFrame {
    private JLabel label;
    private JButton button;

    public CounterView() {
        label = new JLabel("Count: 0");
        button = new JButton("Increment");

        this.setLayout(new FlowLayout());
        this.add(label);
        this.add(button);
        this.setSize(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }
}

class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}

public class CounterController {
    private Counter model;
    private CounterView view;

    public CounterController(Counter model, CounterView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(e -> {
            model.increment();
            view.getLabel().setText("Count: " + model.getCount());
        });
    }

    public static void main(String[] args) {
        Counter model = new Counter();
        CounterView view = new CounterView();
        new CounterController(model, view);
        view.setVisible(true);
    }
}