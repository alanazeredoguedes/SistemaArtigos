package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JButton btn1;
    private JLabel cr;
    private JButton btn2;
    private JLabel list;
    private JButton btn4;
    private JLabel at;
    private JButton at1;
    private JButton delPe;

     public HomeView(String cpf){

         janela = new JFrame();
         painel = new JPanel();
         painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
         painel.setLayout(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.insets=new Insets(9,9,9,9);
         c.gridx=0;
         c.gridy = 1;
         JLabel add = new JLabel("Adicionar um Artigo : ");
         painel.add(add,c);
         
         c.gridx=0;
         c.gridy = 2;
         JButton btnadd = new JButton("Criar um Artigo:");
         btnadd.addActionListener(new ArtigoCreateView());
         painel.add(btnadd,c);
         
         c.gridx=4;
         c.gridy = 1;
         JLabel del = new JLabel("Deletar Artigo : ");
         painel.add(del,c);
         c.gridx=4;
         c.gridy = 2;
         JButton btndel = new JButton("Deletar");
 		 btndel.addActionListener(new ArtigoDeleteView());
         painel.add(btndel,c);
         

         // Informaçõe Artigo
         c.gridx=0;
         c.gridy = 7;
         cr = new JLabel("Criar um Artigo: ");
         painel.add(cr,c);
         
         c.gridx=0;
         c.gridy = 8;
         btn1 = new JButton("Criar");
         btn1.addActionListener(new ArtigoCreateView());
         painel.add(btn1,c);
         
         c.gridx=4;
         c.gridy = 7;
         JLabel ed = new JLabel("Editar um Artigo: ");
         painel.add(ed,c);
         
         c.gridx=4;
         c.gridy = 8;
         JButton btned = new JButton("Editar");
         btned.addActionListener(new ArtigoUpdateView());
         painel.add(btned,c);
  
         c.gridx=0;
         c.gridy = 11;
         list = new JLabel("Listar Artigos: ");
         painel.add(list,c);
         
         c.gridx=0;
         c.gridy = 12;
         btn2 = new JButton("Listar");
         btn2.addActionListener(new ArtigoListView());
         painel.add(btn2,c);
         
         c.gridx=4;
         c.gridy = 11;
         del = new JLabel("Excluir Artigo: ");
         painel.add(del,c);
         
         c.gridx=4;
         c.gridy = 12;
         btn4 = new JButton("Excluir");
         btn4.addActionListener(new ArtigoDeleteView());
         painel.add(btn4,c);
         
         
         // Informações Autor
         c.gridx=0;
         c.gridy = 17;
         at = new JLabel("Atualizar Informações");
         painel.add(at,c);
         
         c.gridx=0;
         c.gridy = 18;
         at1 = new JButton ("Atualizar");
         at1.addActionListener(new AutorUpdateView(cpf));
         painel.add(at1,c);
         
         c.gridx=4;
         c.gridy = 18;
         delPe = new JButton ("Excluir Conta");
         delPe.addActionListener(new AutorDeleteView());
         painel.add(delPe,c);
         
         janela.add(painel, BorderLayout.CENTER);
         janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         janela.setTitle("Opcoes");
         janela.setSize(300,380);
         janela.setLocation(560, 320);
         janela.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
              
    }   
}
