package ru.geekbrains.lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class MainChatWindow extends JFrame {

    public MainChatWindow() {
        setTitle("Чат");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        DefaultListModel messListModel = new DefaultListModel();
        JList<String> messageslist = new JList(messListModel);
        messageslist.setVisibleRowCount(10);
        messageslist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane scroll = new JScrollPane(messageslist,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);


        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());

        JTextArea writeMesArea = new JTextArea();
        writeMesArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 100));
        writeMesArea.setFont(new Font("Serif", Font.ITALIC, 16));
        writeMesArea.setLineWrap(true);
        writeMesArea.setWrapStyleWord(true);
        Action enter = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                writeMesArea.append( writeMesArea.getText() + "\n" );
                writeMesArea.setText("");
            }
        };

        writeMesArea.getActionMap().put("insert-break", enter);
        writeMesArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    if(e.isShiftDown()) {
                        writeMesArea.append(" \n");
                    } else
                    {
                        messListModel.addElement(writeMesArea.getText());
                        int index = messListModel.size() - 1;
                        messageslist.setSelectedIndex(index);
                        messageslist.ensureIndexIsVisible(index);
                        writeMesArea.setText("");
                        if (writeMesArea.getCaretPosition() > 0)
                        {
                            writeMesArea.setCaretPosition(0);
                        }
                    }
            }
        });

        JButton sendButton = new JButton("Отправить");
       sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messListModel.addElement(writeMesArea.getText());
                int index = messListModel.size() - 1;
                messageslist.setSelectedIndex(index);
                messageslist.ensureIndexIsVisible(index);
                writeMesArea.setText("");
            }
        });



        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        sendMessagePanel.add(writeMesArea, BorderLayout.CENTER);

        add(sendMessagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
