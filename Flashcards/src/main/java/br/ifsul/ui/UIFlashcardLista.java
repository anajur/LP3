package br.ifsul.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.ifsul.dto.Categoria;
import br.ifsul.dto.Flashcard;
import br.ifsul.repositories.CategoriaRepository;
import br.ifsul.repositories.FlashcardRepository;

public class UIFlashcardLista extends JFrame {

	private JPanel contentPane;

	public UIFlashcardLista(FlashcardRepository repositorio, String titulo, List<Flashcard> flashcards) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (Flashcard i : flashcards) {

			JButton btnFlashcard = new JButton(i.getTitulo());
			btnFlashcard.setBounds(261, 281, 151, 20);

			contentPane.add(btnFlashcard);
			btnFlashcard.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Optional<Flashcard> flashcard = repositorio.findById(i.getId());

					UIFlashcardDetalhe flashcardDetalhe = new UIFlashcardDetalhe(flashcard.get(), repositorio);
					flashcardDetalhe.setVisible(true);

				}

			});
		}
	}

}
