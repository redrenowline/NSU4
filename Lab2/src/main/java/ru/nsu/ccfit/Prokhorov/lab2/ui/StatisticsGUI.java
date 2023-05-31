package ru.nsu.ccfit.Prokhorov.lab2.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class StatisticsGUI extends JFrame {

    private Map<String, Long> list;
    private JLabel titleLabel;
    private JLabel dataLabel;
    private final Rectangle frameSize = new Rectangle(100,100,300,400);
    private final Rectangle titleLabelSize = new Rectangle(5,5,290,20);
    private final Rectangle dataLabelSize = new Rectangle(5, 25, 290, 370);
    private Locale locale;
    private ResourceBundle resourceBundle;
    public StatisticsGUI(Locale locale){
        this.locale = locale;
        this.resourceBundle = ResourceBundle.getBundle(UIResourcesNames.BUNDLE_NAME, this.locale);
        this.setBounds(frameSize);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(null);
        identTitleLabel();
        identDataLabel();
    }

    public void st(Map<String, Long> list){
        this.list = list;
        updateData();
        this.setVisible(true);
        this.setEnabled(true);
    }
    public void fn(){
        this.setVisible(false);
        this.setEnabled(false);
    }

    private void updateData(){
        String strl = "<html>";
        for(Map.Entry<String, Long> itr : list.entrySet()){
            strl += itr.getKey();
            strl += " ";
            strl += String.valueOf(itr.getValue());
            strl += "<br>";
        }
        strl+="</html>";
        dataLabel.setText(strl);
    }

    private void identTitleLabel(){
        titleLabel = new JLabel();
        titleLabel.setBounds(titleLabelSize);
        titleLabel.setText(resourceBundle.getString(UIResourcesNames.STATISTICS_LABEL));
        add(titleLabel);
    }

    private void identDataLabel(){
        dataLabel = new JLabel();
        dataLabel.setBounds(dataLabelSize);
        add(dataLabel);
    }
}
