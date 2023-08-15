
package texteditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame implements ActionListener{
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner FontSizeSpinner;
    JLabel fontLabel;
    JButton fontButton;
    JComboBox fontBox;
    
    JMenuBar menuBar;
    JMenu menu;
    
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        
        
        
        textArea = new JTextArea();

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        fontLabel = new JLabel("Font: ");
        
        FontSizeSpinner = new JSpinner();
        FontSizeSpinner.setPreferredSize(new Dimension(50,25));
        FontSizeSpinner.setValue(20);
        FontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {   
               textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) FontSizeSpinner.getValue()));
       }
     });
        fontButton = new JButton("Color");
        fontButton.addActionListener(this);
        
        
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");
        
        
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        
        
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);

        
        menuBar.add(menu);
        
        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(FontSizeSpinner);
        this.add(fontButton);
        this.add(fontBox);
        this.add(scrollPane);
        
        this.setVisible(true);
        
        
    }

    
    public static void main(String[] args) {
        new TextEditor();
        
    }

      @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontButton) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Choose color", Color.black);
            textArea.setForeground(color);
        }
        if(e.getSource()==fontBox){
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
        
        if(e.getSource()==openItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("file text", "txt");
            fileChooser.setFileFilter(fileFilter);
            
            int response = fileChooser.showOpenDialog(null);
            
            if(response == fileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()){
                        while(fileIn.hasNextLine()){
                            String line = fileIn.nextLine()+"\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    fileIn.close();
                }
            }
            
        }
        if(e.getSource()==saveItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileout= null;
                
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                try{
                    fileout = new PrintWriter(file);
                    fileout.println(textArea.getText());
                }catch(FileNotFoundException e1){
                    e1.printStackTrace();
                    
                }finally{
                    fileout.close();
                }
            }
            
        }
        if(e.getSource()==exitItem){
            System.exit(0);
            
        }
    }
}
