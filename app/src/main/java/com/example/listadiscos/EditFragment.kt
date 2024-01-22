import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.listadiscos.R
import com.example.listadiscos.StartViewModel

class EditFragment : Fragment() {

    private val startViewModel: StartViewModel by activityViewModels()
    private lateinit var view: View

    private lateinit var editTextNuevoNombre: EditText
    private lateinit var editTextNuevaDescripcion: EditText
    private lateinit var botonGuardar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_edit, container, false)

        editTextNuevoNombre = view.findViewById(R.id.editTextNuevoNombre)
        editTextNuevaDescripcion = view.findViewById(R.id.editTextNuevaDescripcion)
        botonGuardar = view.findViewById(R.id.botonGuardar)

        // Obtener los datos actuales del ViewModel y mostrarlos en los EditText
        val discoActual = startViewModel.selectDisco
        editTextNuevoNombre.setText(discoActual?.nombre)
        editTextNuevaDescripcion.setText(discoActual?.descripcion)

        // Manejar el clic del botón "Guardar Cambios"
        botonGuardar.setOnClickListener {
            // Obtener los nuevos valores ingresados por el usuario
            val nuevoNombre = editTextNuevoNombre.text.toString()
            val nuevaDescripcion = editTextNuevaDescripcion.text.toString()

            // Aplicar los cambios al objeto Disco en el ViewModel
            discoActual?.nombre = nuevoNombre
            discoActual?.descripcion = nuevaDescripcion


            // Volver al fragmento anterior (DetailFragment)
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
}
