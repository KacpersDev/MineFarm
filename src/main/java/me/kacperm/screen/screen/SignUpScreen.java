package me.kacperm.screen.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpScreen extends JPanel implements ActionListener {

    public SignUpScreen() {
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        JPanel form = new JPanel(new GridLayout(5, 1, 10, 10));
        form.setBackground(Color.BLACK);

        JTextField username = new JTextField(20);
        username.setBackground(Color.darkGray);
        username.setForeground(Color.white);
        username.setBorder(BorderFactory.createLineBorder(Color.gray));

        JTextField email = new JTextField(20);
        email.setBackground(Color.darkGray);
        email.setForeground(Color.white);
        email.setBorder(BorderFactory.createLineBorder(Color.gray));

        JPasswordField password = new JPasswordField(20);
        password.setBackground(Color.darkGray);
        password.setForeground(Color.white);
        password.setBorder(BorderFactory.createLineBorder(Color.gray));

        JButton signUp = new JButton("Sign Up");
        signUp.setActionCommand("signup");
        signUp.addActionListener(this);

        JButton signIn = new JButton("Already have an account sign in");
        signIn.setActionCommand("signin");
        signIn.addActionListener(this);

        form.add(username);
        form.add(email);
        form.add(password);
        form.add(signUp);
        form.add(signIn);

        add(form);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equalsIgnoreCase("signin")) {

        } else {
            // sign up...
        }
    }
}
