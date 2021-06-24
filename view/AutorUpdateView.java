package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.Autor;

public class AutorUpdateView implements ActionListener {
	private JFrame janela; 
    private JPanel painel;
    private JLabel nome;
    private JLabel email;
    private JLabel senha;
    private JTextField txtnum2;
    private JTextField txtnum4;
    private JTextField txtnum6;
    private JLabel resultado;
    private JButton btnCd;
    
    private String cpf;
    public AutorUpdateView(String cpf) {
		this.cpf = cpf ;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
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

        
        btnCd = new JButton("Concluir");
        btnCd.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            		Autor autor = new Autor();
            		AutorView view = new AutorView();
                    autor.setNome(txtnum2.getText().trim());
                    autor.setCpf(cpf);
                    autor.setEmail(txtnum4.getText().trim());
                    autor.setSenha(txtnum6.getText().trim());
            		view.update(autor,resultado);
              }
            });
        painel.add(btnCd);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Atualizar Informações");
        janela.setSize(300,400);
        janela.setLocation(940, 620);
        janela.setVisible(true);
    }   
}
