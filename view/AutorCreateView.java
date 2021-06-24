package view;

import javax.swing.*;

import bo.Autor;

import java.awt.*;
import java.awt.event.*;

public class AutorCreateView implements ActionListener {
    private JFrame janela;
    
    private JPanel painel;
    private JLabel autor;
    private JLabel nome;
    private JLabel email;
    private JLabel senha;
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JTextField txtnum4;
    private JTextField txtnum6;
    private JLabel resultado;
    private JButton btnCd;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();

        autor = new JLabel("Insira o CPF: ");
        painel.add(autor);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);

        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));

        nome = new JLabel("Insira o nome: ");
        painel.add(nome);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);

        email= new JLabel("Insira o E-mail: ");
        painel.add(email);
        txtnum4 = new JTextField(" ");
        painel.add(txtnum4);

        senha= new JLabel("Insira a senha: ");
        painel.add(senha);
        txtnum6 = new JTextField(" ");
        painel.add(txtnum6);
        
        resultado = new JLabel(" ");

        
        btnCd = new JButton("Finalizar");
        btnCd.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                    Autor autor = new Autor();
                    AutorView view = new AutorView();
            		autor.setCpf(txtnum1.getText().trim());
            		autor.setNome(txtnum2.getText().trim());
                    autor.setEmail(txtnum4.getText().trim());
                    autor.setSenha(txtnum6.getText().trim());
            		view.create(autor,resultado);
              }
            });

            
        painel.add(btnCd);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Cadastro");
        janela.setSize(300,400);
        janela.setLocation(940, 620);
        janela.setVisible(true);
    }   
}
