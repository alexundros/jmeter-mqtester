package ru.alxpro.jmeter.mqtester.sampler.form;

import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;

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

  public SamplerMainForm() {
    initComponents();

    mainPanel = createMainPanel();
    mainPanel.add(createMainTabs());

    addMessageListeners();
  }

  private void initComponents() {
  }

  private void addMessageListeners() {
  }

  private JPanel createMainPanel() {
    JPanel mainPanel = new JPanel();
    mainPanel.setBorder(createTitledBorder(createLineBorder(Color.black), null, DEFAULT_JUSTIFICATION,
        DEFAULT_POSITION, null, null));
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

    return mainPanel;
  }

  private JTabbedPane createMainTabs() {
    JTabbedPane mainTabs = new JTabbedPane();

    JPanel messageTab = createMessageTab();
    mainTabs.addTab("MESSAGE", messageTab);

    JPanel optionsTab = createOptionsTab();
    mainTabs.addTab("OPTIONS", optionsTab);

    return mainTabs;
  }

  private JPanel createMessageTab() {
    JPanel messageTab = new JPanel();
    messageTab.setLayout(new BorderLayout(0, 0));

    JPanel messagePanel = createMessagePanel();
    messageTab.add(messagePanel, BorderLayout.CENTER);

    return messageTab;
  }

  private JPanel createMessagePanel() {
    JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new GridBagLayout());
    messagePanel.setBorder(createTitledBorder(createLineBorder(Color.black), null, DEFAULT_JUSTIFICATION,
        DEFAULT_POSITION, null, null));

    JPanel headersPanel = createHeadersPanel();
    GridBagConstraints gbc_headersPanel = new GridBagConstraints();
    gbc_headersPanel.gridx = 0;
    gbc_headersPanel.gridy = 0;
    gbc_headersPanel.fill = GridBagConstraints.BOTH;
    gbc_headersPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(headersPanel, gbc_headersPanel);

    JPanel keyPanel = createKeyPanel();
    GridBagConstraints gbc_keyPanel = new GridBagConstraints();
    gbc_keyPanel.gridx = 0;
    gbc_keyPanel.gridy = 1;
    gbc_keyPanel.fill = GridBagConstraints.BOTH;
    gbc_keyPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(keyPanel, gbc_keyPanel);

    JPanel bodyPanel = createBodyPanel();
    GridBagConstraints gbc_bodyPanel = new GridBagConstraints();
    gbc_bodyPanel.gridx = 0;
    gbc_bodyPanel.gridy = 2;
    gbc_bodyPanel.weightx = 5.0;
    gbc_bodyPanel.weighty = 4.0;
    gbc_bodyPanel.fill = GridBagConstraints.BOTH;
    gbc_bodyPanel.insets = new Insets(2, 2, 2, 2);
    messagePanel.add(bodyPanel, gbc_bodyPanel);

    return messagePanel;
  }

  private JPanel createHeadersPanel() {
    JPanel headersPanel = new JPanel();
    headersPanel.setLayout(new BorderLayout(0, 0));

    JLabel headersLabel = new JLabel("HEADERS:");
    headersPanel.add(headersLabel, BorderLayout.NORTH);

    sp_HEADERS = new JScrollPane();
    ta_HEADERS = new JTextArea();
    ta_HEADERS.setRows(5);
    sp_HEADERS.setViewportView(ta_HEADERS);

    headersPanel.add(sp_HEADERS, BorderLayout.CENTER);

    return headersPanel;
  }

  private JPanel createKeyPanel() {
    JPanel keyPanel = new JPanel();
    keyPanel.setLayout(new BorderLayout(0, 0));

    JLabel keyLabel = new JLabel("KEY:");
    keyPanel.add(keyLabel, BorderLayout.WEST);

    tf_KEY = new JTextField();
    keyPanel.add(tf_KEY, BorderLayout.CENTER);

    return keyPanel;
  }

  private JPanel createBodyPanel() {
    JPanel bodyPanel = new JPanel();
    bodyPanel.setLayout(new BorderLayout(0, 0));

    JLabel bodyLabel = new JLabel("BODY:");
    bodyPanel.add(bodyLabel, BorderLayout.NORTH);

    JPanel bodyContent = new JPanel();
    bodyContent.setLayout(new BorderLayout(0, 0));

    tb_MESSAGE = new JToolBar();
    tb_MESSAGE.setFloatable(false);
    sp_MESSAGE = new JScrollPane();
    ta_MESSAGE = new JTextArea();
    ta_MESSAGE.setRows(9);
    sp_MESSAGE.setViewportView(ta_MESSAGE);

    bodyContent.add(tb_MESSAGE, BorderLayout.NORTH);
    bodyContent.add(sp_MESSAGE, BorderLayout.CENTER);
    bodyPanel.add(bodyContent, BorderLayout.CENTER);

    return bodyPanel;
  }

  private JPanel createOptionsTab() {
    JPanel optionsTab = new JPanel();
    optionsTab.setLayout(new BorderLayout(0, 0));

    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new BorderLayout(0, 0));

    p_MQ_TYPE = new JPanel();
    p_MQ_TYPE.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

    optionsPanel.add(p_MQ_TYPE, BorderLayout.NORTH);
    optionsTab.add(optionsPanel, BorderLayout.CENTER);

    return optionsTab;
  }
}
