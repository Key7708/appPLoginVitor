package br.ulbra.appploginvitor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastroUsuario {
    MainActivity act;
    EditText ednome, edendereco, edtelefone;
    Button btcadastrar, btcancelar_cadastro;
    TelaPrincipal tela_principal;

    public TelaCadastroUsuario(
            MainActivity act, TelaPrincipal tela_principal
    ) {
        this.act = act;
        this.tela_principal = tela_principal;

    }

    public void CarregarTela() {
        act.setContentView(R.layout.activity_cadastro);
        ednome = (EditText) act.findViewById(R.id.edtNome);
        edendereco = (EditText) act.findViewById(R.id.edtEndereco);
        edtelefone = (EditText) act.findViewById(R.id.edtNumero);
        btcadastrar = (Button) act.findViewById(R.id.btnCadastrar);
        btcancelar_cadastro = (Button) act.findViewById(R.id.btnCancelar);

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar Usuário?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = ednome.getText().toString();
                        String endereco = edendereco.getText().toString();
                        String telefone = edtelefone.getText().toString();
                        act.getRegistros().add(new Registro(nome, endereco, telefone));
                        act.ExibirMensagem("Cadastro efetuado com sucesso");
                        tela_principal.CarregarTela();
                    }
                });
                dialogo.show();
            }
        });
        btcancelar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tela_principal.CarregarTela();
                    }
                });
                dialogo.show();
            }
        });

    }


}
