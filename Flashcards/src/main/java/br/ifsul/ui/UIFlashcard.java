package br.ifsul.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.springframework.beans.factory.annotation.Autowired;
import br.ifsul.dto.Categoria;
import br.ifsul.dto.Flashcard;
import br.ifsul.repositories.CategoriaRepository;
import br.ifsul.repositories.FlashcardRepository;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class UIFlashcard extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = -5782972015790244479L;
	private JLabel tituloGeralTopo;
	private JTextField titulo;
	private JLabel lblNewLabel_3;
	private JTextField categoria;
	private JLabel lblNewLabel_2;
	private JTextField conteudo;
	private JLabel lblNewLabel;
	private JButton btnAleatorio;

	public UIFlashcard(CategoriaRepository categoriaRepository, FlashcardRepository repo) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tituloGeralTopo = new JLabel("CRIAR NOVO FLASHCARD");
		tituloGeralTopo.setBounds(151, 11, 246, 33);
		contentPane.add(tituloGeralTopo);

		lblNewLabel_3 = new JLabel("Título");
		lblNewLabel_3.setBounds(53, 62, 46, 14);
		contentPane.add(lblNewLabel_3);

		titulo = new JTextField();
		titulo.setBounds(53, 87, 151, 20);
		contentPane.add(titulo);
		titulo.setColumns(10);

		lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setBounds(53, 118, 67, 14);
		contentPane.add(lblNewLabel_2);

		categoria = new JTextField();
		categoria.setBounds(53, 143, 151, 20);
		contentPane.add(categoria);
		categoria.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descrição");
		lblNewLabel_1.setBounds(53, 174, 67, 14);
		contentPane.add(lblNewLabel_1);

		conteudo = new JTextField();
		conteudo.setBounds(53, 199, 359, 67);
		contentPane.add(conteudo);
		conteudo.setColumns(10);

		JButton btnCadastrarFlashcard = new JButton("Criar");
		btnCadastrarFlashcard.setBounds(261, 281, 151, 20);
		contentPane.add(btnCadastrarFlashcard);

		btnCadastrarFlashcard.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Flashcard flashcard = new Flashcard();

				Categoria newCategoria = new Categoria();

				newCategoria.setTitulo(categoria.getText());
				categoriaRepository.save(newCategoria);
				flashcard.setTitulo(titulo.getText());
				flashcard.setDescricao(conteudo.getText());
				flashcard.setCategoria(newCategoria);
				flashcard.setContador(0);

				repo.save(flashcard);

				JOptionPane.showMessageDialog(null, "Flashcard cadastrado!!");

			}

		});

		JButton btnVisualizarr = new JButton("Visualizar");
		btnVisualizarr = new JButton("Visualizar categorias");
		btnVisualizarr.setBounds(53, 281, 198, 20);
		contentPane.add(btnVisualizarr);

		btnVisualizarr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				UICategoria categoria = new UICategoria(categoriaRepository, repo);
				categoria.setVisible(true);

			}

		});
		btnAleatorio = new JButton("Escolher flashcard aleatoriamente");
		btnAleatorio.setBounds(151, 305, 206, 23);
		contentPane.add(btnAleatorio);
		Random gerador = new Random();
		btnAleatorio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				List<Flashcard> lista = repo.findAll();
				if (lista.size() != 0) {
					int item = gerador.nextInt(lista.size() - 1);
					Flashcard flashcard = lista.get(item);

					Optional<Flashcard> flashcardAleatorio = repo.findById(flashcard.getId());

					UIFlashcardDetalhe flashcardDetalhe = new UIFlashcardDetalhe(flashcardAleatorio.get(), repo);
					flashcardDetalhe.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "Não há flashcards cadastrados!");

				}
			}

		});

	}

}
