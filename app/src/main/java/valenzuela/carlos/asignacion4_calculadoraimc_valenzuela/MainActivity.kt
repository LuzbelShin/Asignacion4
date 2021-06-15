package valenzuela.carlos.asignacion4_calculadoraimc_valenzuela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val peso: EditText = findViewById(R.id.weight)
    val estatura: EditText = findViewById(R.id.height)
    val boton: Button = findViewById(R.id.button) as Button
    val imc: TextView = findViewById(R.id.imc) as TextView
    val rango: TextView = findViewById(R.id.range) as TextView

    fun calculaRango(imc: Float): String {
        if (imc < 18.5) {
            rango.setBackgroundResource(R.color.colorGreenish)
            return "Bajo peso"
        } else if (imc >= 18.5 && imc < 24.9) {
            rango.setBackgroundResource(R.color.colorGreen)
            return "Normal"
        } else if (imc > 25 && imc < 29.9) {
            rango.setBackgroundResource(R.color.colorYellow)
            return "Sobrepeso"
        } else if (imc > 30 && imc < 34.9) {
            rango.setBackgroundResource(R.color.colorOrange)
            return "Obesidad grado 1"
        } else if (imc > 35 && imc < 39.9) {
            rango.setBackgroundResource(R.color.colorRed)
            return "Obesidad grado 2"
        } else if (imc > 40) {
            rango.setBackgroundResource(R.color.colorBrown)
            return "Obesidad grado 3"
        }
        rango.setBackgroundResource(R.color.white)
        return ""
    }
    fun calculaIMC(view: View) {
        var pesoAux: Float = peso.text.toString().toFloat()
        var altura: Float = estatura.text.toString().toFloat()
        var estaturaAux = altura * altura
        var imcAux = pesoAux / estaturaAux

        imc.setText(imcAux.toString())
        rango.setText(calculaRango(imcAux))

    }
}
