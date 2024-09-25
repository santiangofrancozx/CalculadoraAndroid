package com.example.superagenda;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Contacto> contactos = new ArrayList<>();
    private int nextCodigo = 0;

    private EditText etNombre, etApellido, etDocumento, etEdad, etTelefono, etDireccion, etNacimiento, etEmail, etPeliculaFavorita, etColorFavorito, etComidaFavorita, etLibroFavorito, etCancionFavorita, etDescripcionPersonal, etBuscarCodigo;
    private RadioGroup rgEstadoCivil, rgGenero;
    private CheckBox cbMusica, cbCine, cbDeporte, cbComida;
    private Spinner spEquipoFutbol;
    private Button  btnOpenCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Inicializar los EditText, RadioGroup, y Spinner
        etNombre = findViewById(R.id.et_nombre);
        etApellido = findViewById(R.id.et_apellido);
        etDocumento = findViewById(R.id.et_documento);
        etEdad = findViewById(R.id.et_edad);
        etTelefono = findViewById(R.id.et_telefono);
        etDireccion = findViewById(R.id.et_direccion);
        etNacimiento = findViewById(R.id.et_nacimiento);
        etEmail = findViewById(R.id.et_email);
        etPeliculaFavorita = findViewById(R.id.et_pelicula_favorita);
        etColorFavorito = findViewById(R.id.et_color_favorito);
        etComidaFavorita = findViewById(R.id.et_comida_favorita);
        etLibroFavorito = findViewById(R.id.et_libro_favorito);
        etCancionFavorita = findViewById(R.id.et_cancion_favorita);
        etDescripcionPersonal = findViewById(R.id.et_descripcion_personal);
        rgEstadoCivil = findViewById(R.id.rg_estado_civil);
        rgGenero = findViewById(R.id.rg_genero);
        spEquipoFutbol = findViewById(R.id.sp_equipo_futbol);
        etBuscarCodigo = findViewById(R.id.et_codigo);
        cbCine = findViewById(R.id.cb_cine);
        cbComida = findViewById(R.id.cb_comida);
        cbDeporte = findViewById(R.id.cb_deporte);
        cbMusica = findViewById(R.id.cb_musica);
        
        Button btnGuardar = findViewById(R.id.btn_guardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarContacto();
            }
        });
        Button verContactosButton = findViewById(R.id.buttonVerContactos);
            verContactosButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, VerContactosActivity.class);
                    intent.putParcelableArrayListExtra("contactos", new ArrayList<>(contactos));
                    startActivity(intent);
                }
            });
        Button btnBuscar = findViewById(R.id.btn_buscar_codigo); // Botón para buscar por código
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarContactoPorCodigo();
            }
        });
        btnOpenCalculator = findViewById(R.id.btn_calculadora);

        // Set OnClickListener to open Calculator
        btnOpenCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Crear el Intent explícito usando ComponentName
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.example.calculadora", "com.example.calculadora.MainActivity"));
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Calculadora abierta", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error al abrir la calculadora", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void guardarContacto() {
        // Validar campos
        if (etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() ||
                etDocumento.getText().toString().isEmpty() || etEdad.getText().toString().isEmpty() ||
                etTelefono.getText().toString().isEmpty() || etDireccion.getText().toString().isEmpty() ||
                etNacimiento.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos obligatorios", Toast.LENGTH_SHORT).show();
            return; // Salir del método si falta algún campo
        }

        // Validar que el RadioGroup tenga una selección
        if (rgEstadoCivil.getCheckedRadioButtonId() == -1 || rgGenero.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecciona el estado civil y el género", Toast.LENGTH_SHORT).show();
            return; // Salir del método si no hay selección
        }

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String documento = etDocumento.getText().toString();

        int edad;
        try {
            edad = Integer.parseInt(etEdad.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Edad inválida", Toast.LENGTH_SHORT).show();
            return; // Salir del método si la edad no es un número válido
        }

        String telefono = etTelefono.getText().toString();
        String direccion = etDireccion.getText().toString();
        String fechaNacimiento = etNacimiento.getText().toString();
        String email = etEmail.getText().toString();

        String estadoCivil = ((RadioButton) findViewById(rgEstadoCivil.getCheckedRadioButtonId())).getText().toString();
        String genero = ((RadioButton) findViewById(rgGenero.getCheckedRadioButtonId())).getText().toString();
        List<String> listaGustos = new ArrayList<>();

        if (cbCine.isChecked()) listaGustos.add("Cine");
        if (cbMusica.isChecked()) listaGustos.add("Musica");
        if (cbDeporte.isChecked()) listaGustos.add("Deporte");
        if (cbComida.isChecked()) listaGustos.add("Comida");

        // Convertir la lista en un String separado por punto y coma (;)
        String gustos = String.join("; ", listaGustos);
        String equipoFutbolFavorito = spEquipoFutbol.getSelectedItem().toString();
        String peliculaFavorita = etPeliculaFavorita.getText().toString();
        String colorFavorito = etColorFavorito.getText().toString();
        String comidaFavorita = etComidaFavorita.getText().toString();
        String libroFavorito = etLibroFavorito.getText().toString();
        String cancionFavorita = etCancionFavorita.getText().toString();
        String descripcionPersonal = etDescripcionPersonal.getText().toString();

        // Crear un nuevo contacto
        Contacto nuevoContacto = new Contacto(nombre, apellido, documento, edad, telefono, direccion,
                fechaNacimiento, email, estadoCivil, genero, gustos, equipoFutbolFavorito,
                peliculaFavorita, colorFavorito, comidaFavorita, libroFavorito, cancionFavorita, descripcionPersonal, nextCodigo++);

        // Agregar el contacto a la lista
        contactos.add(nuevoContacto);

        // Enviar a la nueva actividad
        Intent intent = new Intent(MainActivity.this, VerContactosActivity.class);
        intent.putParcelableArrayListExtra("contactos", new ArrayList<>(contactos));
        startActivity(intent);

        // Limpiar los campos después de guardar
        limpiarCampos();

        Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show();
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        etNombre.setText("");
        etApellido.setText("");
        etDocumento.setText("");
        etEdad.setText("");
        etTelefono.setText("");
        etDireccion.setText("");
        etNacimiento.setText("");
        etEmail.setText("");
        etPeliculaFavorita.setText("");
        etColorFavorito.setText("");
        etComidaFavorita.setText("");
        etLibroFavorito.setText("");
        etCancionFavorita.setText("");
        etDescripcionPersonal.setText("");
        rgEstadoCivil.clearCheck(); // Limpiar selección del RadioGroup
        rgGenero.clearCheck(); // Limpiar selección del RadioGroup
        spEquipoFutbol.setSelection(0); // Restablecer el Spinner a su valor por defecto
        cbComida.setChecked(false);
        cbCine.setChecked(false);
        cbDeporte.setChecked(false);
        cbMusica.setChecked(false);
    }

    private void buscarContactoPorCodigo() {
        String codigoStr = etBuscarCodigo.getText().toString();
        if (codigoStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un código", Toast.LENGTH_SHORT).show();
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Código inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Buscar el contacto por código
        for (Contacto contacto : contactos) {
            if (contacto.getCodigo() == codigo) {
                mostrarContacto(contacto);
                return;
            }
        }

        // Si no se encuentra el contacto
        Toast.makeText(this, "Contacto no encontrado", Toast.LENGTH_SHORT).show();
    }

    private void mostrarContacto(Contacto contacto) {
        // Mostrar los datos del contacto en los campos correspondientes
        etNombre.setText(contacto.getNombre());
        etApellido.setText(contacto.getApellido());
        etDocumento.setText(contacto.getDocumento());
        etEdad.setText(String.valueOf(contacto.getEdad()));
        etTelefono.setText(contacto.getTelefono());
        etDireccion.setText(contacto.getDireccion());
        etNacimiento.setText(contacto.getFechaNacimiento());
        etEmail.setText(contacto.getEmail());
        etPeliculaFavorita.setText(contacto.getPeliculaFavorita());
        etColorFavorito.setText(contacto.getColorFavorito());
        etComidaFavorita.setText(contacto.getComidaFavorita());
        etCancionFavorita.setText(contacto.getCancionFavorita());
        etDescripcionPersonal.setText(contacto.getDescripcionPersonal());
        if (contacto.getEstadoCivil().equalsIgnoreCase("Casado")) {
            rgEstadoCivil.check(R.id.rb_casado); // Reemplaza con el ID correcto de tu opción "Casado"
        } else if (contacto.getEstadoCivil().equalsIgnoreCase("Soltero")) {
            rgEstadoCivil.check(R.id.rb_soltero); // Reemplaza con el ID correcto de tu opción "Soltero"
        }

        // Seleccionar el género en el RadioGroup
        if (contacto.getGenero().equalsIgnoreCase("Masculino")) {
            rgGenero.check(R.id.rb_masculino); // Reemplaza con el ID correcto de tu opción "Masculino"
        } else if (contacto.getGenero().equalsIgnoreCase("Femenino")) {
            rgGenero.check(R.id.rb_femenino); // Reemplaza con el ID correcto de tu opción "Femenino"
        }
        String[] arrayGustos = contacto.getGustos().split(";\\s*");
        for (int i = 0; i < arrayGustos.length; i++){
            if (arrayGustos[i].equalsIgnoreCase("Musica")){
                cbMusica.setChecked(true);
            } else if (arrayGustos[i].equalsIgnoreCase("Deporte")) {
                cbDeporte.setChecked(true);
            }else if (arrayGustos[i].equalsIgnoreCase("Cine")) {
                cbCine.setChecked(true);
            }else if (arrayGustos[i].equalsIgnoreCase("Comida")) {
                cbComida.setChecked(true);
            }
        }

    }


}
