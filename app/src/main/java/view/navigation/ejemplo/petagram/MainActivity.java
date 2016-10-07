package view.navigation.ejemplo.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Rafa", "811118", "perajim@gmail.com"));
        contactos.add(new Contacto("Mireya Pacheco", "222222", "jyeyitha@gmai.coml"));
        contactos.add(new Contacto("Alfo djfhd", "33333333", "alfo@itu.com"));
        contactos.add(new Contacto("Shimon Peres", "4444444", "Shimon@Isral.com"));
        ArrayList <String> nombresContacto = new ArrayList<>();
        for(Contacto  contacto : contactos) {
        nombresContacto.add(contacto.getNombre());
        }


        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombresContacto));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,  DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
            }
        });

    }
}
