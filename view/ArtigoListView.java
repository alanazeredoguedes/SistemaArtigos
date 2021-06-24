package view;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import bo.Artigo;

import java.awt.*;
import java.awt.event.*;

public class ArtigoListView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JLabel list;
    private JLabel jt;
    private JButton btn1;

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	janela = new JFrame();
        painel = new JPanel();
        list = new JLabel("Lista de Artigos");
        painel.setLayout(new GridBagLayout());
        janela.setTitle("Tela de Artigos");
        janela.setSize(750,300);
        janela.setLocation(300, 320);
        janela.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets (10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        painel.add(list,c);
        c.gridx=0;
        c.gridy=2;
        btn1 = new JButton("Exibir");
        btn1.setBounds(20,30,50,30);
        painel.add(btn1,c);
        c.gridx=0;
        c.gridy=3;
        janela.add(painel);
        btn1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	ArtigoView leitura = new ArtigoView();
        		List<Artigo> lista = new ArrayList<Artigo>();
        		lista = leitura.read();
        		int x=3;
        		for(Artigo artigo:lista) 
        		{
        			c.gridx=0;
        			c.gridy=x;
        			x++;
        			System.out.println(artigo.getDt_publicacao());
        			painel.remove(btn1);
        			jt = new JLabel(" ");
        			jt.setText("Codigo: "+artigo.getCodigo()+" Titulo :"+artigo.getTitulo()+" Data Publicacao : "+ artigo.getDt_publicacao()+" Texto : "+artigo.getTexto()+" Autor: "+artigo.getNome());
        			painel.add(jt,c);
        			painel.revalidate();
        			painel.repaint();
        		}
              }
            });
    }   

}
