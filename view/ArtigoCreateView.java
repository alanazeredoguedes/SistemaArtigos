package view;

import javax.swing.*;

import bo.Artigo;

import java.awt.*;
import java.awt.event.*;
//import java.util.ArrayList;
//import java.util.List;

public class ArtigoCreateView implements ActionListener {
    private JFrame janela;
    private JPanel main;
    private JPanel painel1;
    private JPanel painel2;
     private JLabel autor;
     private JTextField txtnum2;
     private JLabel resultado;
     private JButton btnCr;

    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        main = new JPanel();
        painel1 = new JPanel();
        painel2 = new JPanel();
        
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets(9,9,9,9);
        c.gridx=0;
        c.gridy = 1;
        autor = new JLabel("CPF do Autor: ");
        painel1.add(autor);
        txtnum2 = new JTextField(" ");
        painel1.add(txtnum2);

        painel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel1.setLayout(new GridLayout(0,1));
        JLabel inicio = new JLabel("Data de Publicacao: (yyyy-MM-dd)");
        painel1.add(inicio);
        JTextField txtnum4 = new JTextField(" ");
        painel1.add(txtnum4);

        JLabel fim = new JLabel("Titulo: ");
        painel1.add(fim);
        JTextField txtnum5 = new JTextField(" ");
        painel1.add(txtnum5);

        Component hora = new JLabel("Texto: ");
        painel1.add(hora);
        JTextField txtnum6 = new JTextField(" ");
        painel1.add(txtnum6); 

        btnCr = new JButton("Cadastrar");
        resultado = new JLabel(" ");
        

        btnCr.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            		
              Artigo artigo = new Artigo();
              ArtigoView view = new ArtigoView();

              artigo.setAutor_cpf(txtnum2.getText().trim());
              artigo.setDt_publicacao(txtnum4.getText().trim());
              artigo.setTitulo(txtnum5.getText().trim());
              artigo.setTexto(txtnum6.getText().trim());

              view.create(artigo, resultado); 	

              }
            });

        
        painel2.add(resultado);
        painel1.add(btnCr);
        main.add(painel1);
        main.add(painel2);
        janela.add(main, BorderLayout.CENTER);
        janela.setTitle("Artigo");
        janela.setSize(350,450);
        janela.setLocation(940, 620);
        janela.setVisible(true);
    }   
}

	