package br.ufpi.es.caronasufpi.visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpi.es.caronasufpi.controle.ControladorUsuarios;
import br.ufpi.es.caronasufpi.R;
import br.ufpi.es.caronasufpi.dados.Usuario;

public class Login extends AppCompatActivity {
    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //carrega o conteudo dos editText
        usuario = (EditText)findViewById(R.id.editTextEmail);
        senha = (EditText) findViewById(R.id.editTextSenha);
    }

    /**
     * Dadas informacoes de uma view executa o login
     * @param v view corrente
     */
    public void login(View v) {
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();

        //tratar excecao de erro de conexao ou qualquer outra excecao
        try {
            Usuario usuario = new ControladorUsuarios().carregaDadosUsuario(usuarioInformado);
            //verifica os dados do usuario
            if (usuario != null){
                if (usuarioInformado.equals(usuario.getEmail()) && senhaInformada.equals(usuario.getSenha())) {
                    //chama servico de verificacao de credenciais (checarCredenciais)
                    //cria um bundle para enviar informacoes das credenciais do usuario
                    Bundle bundle = new Bundle();
                    bundle.putString("nomeUsuario", usuario.getNome());
                    bundle.putString("emailUsuario", usuario.getEmail());
                    Intent intent = new Intent(this, Dashboard.class);
                    intent.putExtras(bundle);
                    //carrega a tela principal e passa dados do Usuario
                    startActivity(intent);
                }else {
                    //erro de autenticacao
                    String mensagemErroAutenticacao = "Erro de autenticação";
                    Toast toat = Toast.makeText(this, mensagemErroAutenticacao, Toast.LENGTH_LONG);
                    toat.show();
                    limpaCamposEntrada();
                }
            }else {
                //erro de autenticacao
                String mensagemErroAutenticacao = "Usuario não existe!";
                Toast toat = Toast.makeText(this, mensagemErroAutenticacao, Toast.LENGTH_LONG);
                toat.show();
                limpaCamposEntrada();
            }

        } catch (Exception ex) {
            Toast toast = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
            toast.show();
            limpaCamposEntrada();
        }
    }

    /**
     * Chama a tela e servico de recuperacao de senha
     * @param view
     */
    public void esqueciSenha(View view){
        //TODO: metodo nao implementado
        //sugestao: mostrar uma tela pedindo o e-mail e depois dispara um servico passando a senha para o e-mail passado.
        String mensagem = "Método não implementado";
        Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public void limpaCamposEntrada(){
        usuario.setText("");
        senha.setText("");
    }
}
