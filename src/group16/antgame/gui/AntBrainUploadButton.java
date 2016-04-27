/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.antgame.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author dha23
 */
public class AntBrainUploadButton extends JButton {
    
    private int playerNumber;
    private File file;
    
    public AntBrainUploadButton(int playerNumber) {
        super("Upload Ant Brain...");
        this.file = null;
        this.playerNumber = playerNumber;
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
            
        });
    }
    
    public File getFile() {
        return file;
    }
    
    public int getPlayerNumber() {
        return playerNumber;
    }
    
    private void chooseFile() {
        JFileChooser jsf = new JFileChooser();
        jsf.setAcceptAllFileFilterUsed(false);
        jsf.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().endsWith(".ant");
            }

            @Override
            public String getDescription() {
                return "Ant Brain Files (*.ant)";
            }
            
        });
        if(jsf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = jsf.getSelectedFile();
            if(file != null) {
                this.setText("Ant Brain Uploaded");
                this.setForeground(Color.WHITE);
                this.setBackground(new Color(62, 171, 55));
            }
        }
    }
    
}
