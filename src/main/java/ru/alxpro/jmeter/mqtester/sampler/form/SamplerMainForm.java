package ru.alxpro.jmeter.mqtester.sampler.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

public class SamplerMainForm extends JFrame {

  private static final long serialVersionUID = 1L;

  JPanel p_Form;
  JPanel p_MQ_TYPE;
  JTextArea ta_HEADERS;
  JTextField tf_KEY;
  JTextArea ta_MESSAGE;
  ButtonGroup bg_MQ_TYPE;
  JScrollPane sp_HEADERS;
  JScrollPane sp_MESSAGE;
  JToolBar tb_MESSAGE;

  private void initComponents() {
    addTbMessageListener();
  }

  private void addTbMessageListener() {
  }

  public SamplerMainForm() {
    initComponents();

    p_Form = new JPanel();
    p_Form.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION, null, null));
    p_Form.setLayout(new BoxLayout(p_Form, BoxLayout.X_AXIS));

    final JTabbedPane tabbedPane = new JTabbedPane();
    p_Form.add(tabbedPane);
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout(0, 0));
    tabbedPane.addTab("MESSAGE", panel1);
    final JPanel panel2 = new JPanel();
    panel2.setLayout(new GridBagLayout());
    panel1.add(panel2, BorderLayout.CENTER);
    panel2.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION, null, null));
    final JPanel panel3 = new JPanel();
    panel3.setLayout(new BorderLayout(0, 0));
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(2, 2, 2, 2);
    panel2.add(panel3, gbc);
    final JLabel label1 = new JLabel();
    label1.setText("   HEADERS:   ");
    panel3.add(label1, BorderLayout.NORTH);
    sp_HEADERS = new JScrollPane();
    panel3.add(sp_HEADERS, BorderLayout.CENTER);
    ta_HEADERS = new JTextArea();
    ta_HEADERS.setRows(5);
    sp_HEADERS.setViewportView(ta_HEADERS);
    final JPanel panel4 = new JPanel();
    panel4.setLayout(new BorderLayout(0, 0));
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(2, 2, 2, 2);
    panel2.add(panel4, gbc);
    final JLabel label2 = new JLabel();
    label2.setText("   KEY:   ");
    panel4.add(label2, BorderLayout.WEST);
    tf_KEY = new JTextField();
    panel4.add(tf_KEY, BorderLayout.CENTER);
    final JPanel panel5 = new JPanel();
    panel5.setLayout(new BorderLayout(0, 0));
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.weightx = 5.0;
    gbc.weighty = 4.0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(2, 2, 2, 2);
    panel2.add(panel5, gbc);
    final JLabel label3 = new JLabel();
    label3.setText("   BODY:   ");
    panel5.add(label3, BorderLayout.NORTH);
    final JPanel panel6 = new JPanel();
    panel6.setLayout(new BorderLayout(0, 0));
    panel5.add(panel6, BorderLayout.CENTER);
    tb_MESSAGE = new JToolBar();
    tb_MESSAGE.setFloatable(false);
    panel6.add(tb_MESSAGE, BorderLayout.NORTH);
    sp_MESSAGE = new JScrollPane();
    panel6.add(sp_MESSAGE, BorderLayout.CENTER);
    ta_MESSAGE = new JTextArea();
    ta_MESSAGE.setRows(9);
    sp_MESSAGE.setViewportView(ta_MESSAGE);
    final JPanel panel7 = new JPanel();
    panel7.setLayout(new BorderLayout(0, 0));
    tabbedPane.addTab("OPTIONS", panel7);
    final JPanel panel8 = new JPanel();
    panel8.setLayout(new BorderLayout(0, 0));
    panel7.add(panel8, BorderLayout.CENTER);
    p_MQ_TYPE = new JPanel();
    p_MQ_TYPE.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
    panel8.add(p_MQ_TYPE, BorderLayout.NORTH);

    bg_MQ_TYPE = new ButtonGroup();
  }
}
