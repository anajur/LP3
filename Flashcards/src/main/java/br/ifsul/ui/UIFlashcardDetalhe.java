package br.ifsul.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.ifsul.dto.Flashcard;
import br.ifsul.repositories.FlashcardRepository;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class UIFlashcardDetalhe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;

	public UIFlashcardDetalhe(Flashcard flashcard, FlashcardRepository repositorio) {
		flashcard.setContador(flashcard.getContador()+1);
		repositorio.save(flashcard);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(74, 148, 272, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.disable();
		textField.setText(flashcard.getDescricao());

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 98, 139, 27);
		contentPane.add(textField_1);
		textField_1.disable();
		textField_1.setText(flashcard.getCategoria().getTitulo());

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 48, 139, 27);
		contentPane.add(textField_2);
		textField_2.disable();
		textField_2.setText(flashcard.getTitulo());

		JLabel lblNewLabel = new JLabel("Título");
		lblNewLabel.setBounds(74, 22, 68, 15);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(261, 51, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(flashcard.getContador().toString());
		
		lblNewLabel_1 = new JLabel("Contador");
		lblNewLabel_1.setBounds(261, 22, 46, 14);
		contentPane.add(lblNewLabel_1);

	

	}

}
