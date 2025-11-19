import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class configGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class configGui extends GuiBase
{
    // instance variables - replace the example below with your own
    private int x;
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    /**
     * Constructor for objects of class configGui
     */
    public configGui()
    {   
        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setPreferredSize(new Dimension(500,50));
        JButton saveButton = new JButton("save");
        saveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    globalValues.save();
                }
            });
        ButtonsPanel.add(saveButton);
        JButton resetButton = new JButton("reset");
        resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    globalValues.reset();
                    GuiManager.refreshAllGuis();
                }
            });
        ButtonsPanel.add(resetButton);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10; 
        c.ipadx = 10; 
        frame.add(ButtonsPanel,c);
        // Create a JTabbedPane, which will hold the tabs
        JTabbedPane tabPanel = new JTabbedPane();
        // Create the first tab (page1) and add a JLabel to it
        JPanel page1 = new JPanel();
        page1.add(new JLabel("background color"));
        addSliders(page1, "backgroundColor");
        // Create the second tab (page2) and add a JLabel to it
        JPanel page2 = new JPanel();
        page2.add(new JLabel("text color"));
        addSliders(page2 , "textColor");
        // Create the third tab (page3) and add a JLabel to it
        JPanel page3 = new JPanel();
        page3.add(new JLabel("button color"));
        addSliders(page3, "buttonColor");
        // Add the three tabs to the JTabbedPane
        tabPanel.addTab("background color", page1);
        tabPanel.addTab("text color", page2);
        tabPanel.addTab("button color", page3);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 400; 
        c.ipadx = 0;
        c.weightx = 1.0;  
        frame.add(tabPanel,c);

        frame.pack();
    }

    private void addSliders(JPanel panel, String type)
    {   
        int redNum = 175;
        int blueNum = 175;
        int greenNum = 175;

        if(type == "textColor"){
            redNum = globalValues.textColor.getRed();
            blueNum = globalValues.textColor.getBlue();
            greenNum = globalValues.textColor.getGreen();
        }else if(type == "buttonColor"){
            redNum = globalValues.buttonColor.getRed();
            blueNum = globalValues.buttonColor.getBlue();
            greenNum = globalValues.buttonColor.getGreen();
        }else if(type == "backgroundColor"){
            redNum = globalValues.backgroundColor.getRed();
            blueNum = globalValues.backgroundColor.getGreen();
            greenNum = globalValues.backgroundColor.getBlue();
        }

        JPanel redPanel = new JPanel();
        redPanel.add(new JLabel("red"));
        redPanel.setPreferredSize(new Dimension(500,50));
        JSlider red = new JSlider();
        red.setValue((int)Math.round(redNum/2.55));
        redPanel.add(red);
        panel.add(redPanel);

        JPanel greenPanel = new JPanel();
        greenPanel.add(new JLabel("green"));
        greenPanel.setPreferredSize(new Dimension(500,50));
        JSlider green = new JSlider();
        green.setValue((int)Math.round(greenNum/2.55));
        greenPanel.add(green);
        panel.add(greenPanel);

        JPanel bluePanel = new JPanel();
        bluePanel.add(new JLabel("blue"));
        bluePanel.setPreferredSize(new Dimension(500,50));
        JSlider blue = new JSlider();
        blue.setValue((int)Math.round(blueNum/2.55));
        bluePanel.add(blue);
        panel.add(bluePanel);

        JPanel applyPanel = new JPanel();
        applyPanel.setPreferredSize(new Dimension(500,50));
        JButton applyButton = new JButton("apply");
        applyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int redNum = (int)Math.round(red.getValue() * 2.55);
                    int greenNum = (int)Math.round(green.getValue() * 2.55);
                    int blueNum = (int)Math.round(blue.getValue() * 2.55);
                    Color color = new Color(redNum,greenNum,blueNum);
                    if(type == "textColor"){
                        globalValues.textColor = color;
                    }else if(type == "buttonColor"){
                        globalValues.buttonColor = color;
                    }else if(type == "backgroundColor"){
                        globalValues.backgroundColor = color;
                    }
                    GuiManager.refreshAllGuis();
                }
            });
        applyPanel.add(applyButton);
        panel.add(applyPanel);
    }
}