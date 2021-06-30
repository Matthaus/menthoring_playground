package br.com.matthaus.playground03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class TelaPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        //Buscando a referência ao botão que está no layout (XML)
        val buttonCliqueAqui = findViewById<Button>(R.id.button_clique_aqui)
        val campoDeTexto = findViewById<TextInputLayout>(R.id.campo_de_texto)
        val campoDeLabel = findViewById<TextView>(R.id.campo_de_label)

        buttonCliqueAqui.setOnClickListener {
            //Aqui dentro só acontece quando o usuário clicar no botão (lambda function)

            //Pegando texto digitado
            val conteudo = campoDeTexto.editText?.text.toString()

            //Exibindo mensagem de texto utilizando toast :)
            Toast.makeText(this, "Você digitou: " + conteudo, Toast.LENGTH_LONG).show()

            //Você consegue trocar o texto do textview assim :)
            campoDeLabel.text = "Alguma coisa"
        }

    }
}