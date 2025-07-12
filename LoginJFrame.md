    LoginJFrame
        Email
        Senha
        Botão Entrar => HomeJFrame
        Botão Esqueci minha Senha
        Botão Não tenho usuário => ProprietarioCadastroJFrame
    ProprietarioCadastroJFrame
        Nome
        CPF
        E-mail
        Senha
        Botão Cancelar
        Botão Cadastrar => Persistir os dados do proprietario no banco de dados e voltar para tela LoginJFrame
    HomeJFrame
        Botão Contas => ContaJFrame
    ProprietarioEsqueciSenhaJFrame
        CPF
        E-mail
        Botão Enviar => Enviar e-mail com código (html, css, js). Código com tempo de expiração
    ProprietarioEsqueciSenhaOTPJFrame
        Código
        Verificar Botão
    ProprietarioEsqueciSenhaRedefinirJFrame
        Senha
        ConfirmacaoSenha
        Redefinir Botão
    ContaJFrame (CRUD => Create, Read, Update, Delete)
        Lista das Contas JTable
        Nome
        Tipo
        Saldo
        
    Senha deve ser armazenda Criptografada