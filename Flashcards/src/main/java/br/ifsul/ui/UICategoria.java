package br.ifsul.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.repository.support.Repositories;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import br.ifsul.FlashcardsApplication;
import br.ifsul.dto.Categoria;
import br.ifsul.dto.Flashcard;
import br.ifsul.repositories.CategoriaRepository;
import br.ifsul.repositories.FlashcardRepository;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class UICategoria extends JFrame {

	private JList<Categoria> listaCategoria = new JList();
	private DefaultListModel<Categoria> model = new DefaultListModel();
	private JPanel contentPane;

	public UICategoria(CategoriaRepository repositorio, FlashcardRepository flashcardRepositorio) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		List<Categoria> categorias = repositorio.findAll();
		for (Categoria categoria : categorias) {

			JButton btnCategoria = new JButton(categoria.getTitulo());
			btnCategoria.setBounds(261, 281, 151, 20);
			List<Flashcard> flashcards = flashcardRepositorio.findByCategoria(categoria);

			contentPane.add(btnCategoria);
			btnCategoria.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					UIFlashcardLista flashCardLista = new UIFlashcardLista(flashcardRepositorio, categoria.getTitulo(),
							flashcards);
					flashCardLista.setVisible(true);

				}

			});
		}

	}
}
