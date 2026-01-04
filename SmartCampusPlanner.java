import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCampusPlanner extends JFrame {

    JTextArea inputArea, outputArea;
    JButton generateButton;

    public SmartCampusPlanner() {
        setTitle("Smart Campus Planner");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Task"));

        inputArea = new JTextArea(4, 20);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputPanel.add(inputScroll, BorderLayout.CENTER);

        generateButton = new JButton("Generate Plan");
        inputPanel.add(generateButton, BorderLayout.SOUTH);

        // Output Panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("AI Generated Plan"));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputPanel.add(outputScroll, BorderLayout.CENTER);

        // Add Panels
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);

        // Button Action
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePlan();
            }
        });
    }

    private void generatePlan() {
        String task = inputArea.getText().trim();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a task!");
            return;
        }

        String plan =
                "Task: " + task + "\n\n" +
                "Step 1: Understand the task requirements.\n" +
                "Step 2: Break the task into smaller achievable goals.\n" +
                "Step 3: Collect required resources (notes, tools, teammates).\n" +
                "Step 4: Create a timeline and assign deadlines.\n" +
                "Step 5: Start execution step-by-step.\n" +
                "Step 6: Review progress and make improvements.\n" +
                "Step 7: Finalize and submit or present the work.\n\n" +
                "✅ Plan generated successfully!";

        outputArea.setText(plan);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SmartCampusPlanner().setVisible(true);
        });
    }
}
