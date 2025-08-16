package br.com.proway.granacerta.telas;

import javax.swing.*;
import java.awt.*;

public class BotaoComIconee extends JFrame {

    public BotaoComIconee() {
        // Configuração da janela
        setTitle("Botão com Ícone");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criar o botão
        JButton botao = new JButton();

        // Caminho da imagem (substitua pelo caminho correto)

        // Carregar e redimensionar a imagem
        
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons8-editar-48.png"));
        Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        botao.setIcon(new ImageIcon(img));

        // (Opcional) Ajustar tamanho do botão para o ícone
        botao.setPreferredSize(new Dimension(40, 40));
        botao.setFocusPainted(false); // Tira a borda de foco ao clicar

        // Adicionar o botão ao JFrame
        setLayout(new FlowLayout());
        add(botao);
    }

    public static void main(String[] args) {
        // Executar a interface gráfica na thread correta
        SwingUtilities.invokeLater(() -> {
            new BotaoComIconee().setVisible(true);
        });
    }
}
