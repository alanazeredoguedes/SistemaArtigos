package view;

import javax.swing.*;

import bo.Artigo;

import java.awt.*;
import java.awt.event.*;

public class ArtigoDeleteView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
     private JLabel sala;
     private JTextField txtnum1;
     private JButton btnDel;
     private JLabel resultado;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        sala = new JLabel("Codigo do Artigo ?");
        painel.add(sala);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);

        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));

        btnDel = new JButton("Desmarcar");
        resultado = new JLabel(" ");

        btnDel.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	Artigo artigo = new Artigo();
            	ArtigoView view = new ArtigoView();
                
            	artigo.setCodigo(txtnum1.getText().trim());

            	view.delete(artigo,resultado);
              }
            });

        painel.add(btnDel);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Deletar Artigo");
        janela.setSize(300,300);
        janela.setLocation(840, 220);
        janela.pack();
        janela.setVisible(true);
    }   
}