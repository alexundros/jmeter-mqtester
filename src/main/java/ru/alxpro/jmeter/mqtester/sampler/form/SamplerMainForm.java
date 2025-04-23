package ru.alxpro.jmeter.mqtester.sampler.form;

import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
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

  JPanel mainPanel;
  JPanel p_MQ_TYPE;
  JTextArea ta_HEADERS;
  JTextField tf_KEY;
  JTextArea ta_MESSAGE;
  JScrollPane sp_HEADERS;
  JScrollPane sp_MESSAGE;
  JToolBar tb_MESSAGE;
  GridBagConstraints gbc_headersPanel;
  GridBagConstraints gbc_keyPanel;
  GridBagConstraints gbc_bodyPanel;

  private void initComponents() {
    addMessageListeners();
  }

  private void addMessageListeners() {
  }

  public SamplerMainForm() {
    initComponents();

    mainPanel = new JPanel();
    mainPanel.setBorder(
        createTitledBorder(createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION, null, null));
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

    final JTabbedPane mainTabs = new JTabbedPane();
    mainPanel.add(mainTabs);
    final JPanel messageTab = new JPanel();
    messageTab.setLayout(new BorderLayout(0, 0));
    mainTabs.addTab("MESSAGE", messageTab);
    final JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new GridBagLayout());
    messageTab.add(messagePanel, BorderLayout.CENTER);
    messagePanel.setBorder(
        createTitledBorder(createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION, null, null));
    final JPanel headersPanel = new JPanel();
    headersPanel.setLayout(new BorderLayout(0, 0));
    GridBagConstraints gbc;
    gbc_headersPanel = new GridBagConstraints();
    gbc_headersPanel.gridx = 0;
    gbc_headersPanel.gridy = 0;
    gbc_headersPanel.fill = GridBagConstraints.BOTH;
    gbc_headersPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(headersPanel, gbc_headersPanel);
    final JLabel headersLabel = new JLabel();
    headersLabel.setText("HEADERS:");
    headersPanel.add(headersLabel, BorderLayout.NORTH);
    sp_HEADERS = new JScrollPane();
    headersPanel.add(sp_HEADERS, BorderLayout.CENTER);
    ta_HEADERS = new JTextArea();
    ta_HEADERS.setRows(5);
    sp_HEADERS.setViewportView(ta_HEADERS);
    final JPanel keyPanel = new JPanel();
    keyPanel.setLayout(new BorderLayout(0, 0));
    gbc_keyPanel = new GridBagConstraints();
    gbc_keyPanel.gridx = 0;
    gbc_keyPanel.gridy = 1;
    gbc_keyPanel.fill = GridBagConstraints.BOTH;
    gbc_keyPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(keyPanel, gbc_keyPanel);
    final JLabel keyLabel = new JLabel();
    keyLabel.setText("KEY:");
    keyPanel.add(keyLabel, BorderLayout.WEST);
    tf_KEY = new JTextField();
    keyPanel.add(tf_KEY, BorderLayout.CENTER);
    final JPanel bodyPanel = new JPanel();
    bodyPanel.setLayout(new BorderLayout(0, 0));
    gbc_bodyPanel = new GridBagConstraints();
    gbc_bodyPanel.gridx = 0;
    gbc_bodyPanel.gridy = 2;
    gbc_bodyPanel.weightx = 5.0;
    gbc_bodyPanel.weighty = 4.0;
    gbc_bodyPanel.fill = GridBagConstraints.BOTH;
    gbc_bodyPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(bodyPanel, gbc_bodyPanel);
    final JLabel bodyLabel = new JLabel();
    bodyLabel.setText("BODY:");
    bodyPanel.add(bodyLabel, BorderLayout.NORTH);
    final JPanel bodyContent = new JPanel();
    bodyContent.setLayout(new BorderLayout(0, 0));
    bodyPanel.add(bodyContent, BorderLayout.CENTER);
    tb_MESSAGE = new JToolBar();
    tb_MESSAGE.setFloatable(false);
    bodyContent.add(tb_MESSAGE, BorderLayout.NORTH);
    sp_MESSAGE = new JScrollPane();
    bodyContent.add(sp_MESSAGE, BorderLayout.CENTER);
    ta_MESSAGE = new JTextArea();
    ta_MESSAGE.setRows(9);
    sp_MESSAGE.setViewportView(ta_MESSAGE);
    final JPanel optionsTab = new JPanel();
    optionsTab.setLayout(new BorderLayout(0, 0));
    mainTabs.addTab("OPTIONS", optionsTab);
    final JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new BorderLayout(0, 0));
    optionsTab.add(optionsPanel, BorderLayout.CENTER);
    p_MQ_TYPE = new JPanel();
    p_MQ_TYPE.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
    optionsPanel.add(p_MQ_TYPE, BorderLayout.NORTH);
  }
}
