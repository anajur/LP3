package br.ifsul.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.data.repository.support.Repositories;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import br.ifsul.dto.Categoria;
import br.ifsul.repositories.CategoriaRepository;
import java.awt.FlowLayout;

public class UICategoria extends JFrame {
	private JList<Categoria> listaCategoria = new JList();
	private DefaultListModel<Categoria> model = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	UICategoria frame = new UICategoria();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UICategoria() {
		// dentro do construtor CategoriaRepository repositorio

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		List<Categoria> listaCategorias = repositorio.findAll();

		}
	}

