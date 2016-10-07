package view.navigation.ejemplo.petagram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {
    TextView tvNombre;
    TextView tvemail;
    TextView tvtelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre     = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono   = parametros.getString(getResources().getString(R.string.ptelefono));
        String email      = parametros.getString(getResources().getString(R.string.pemail));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvtelefono = (TextView) findViewById(R.id.tvtelefono);

        tvNombre.setText(nombre);
        tvemail.setText(email);
        tvtelefono.setText(telefono);


    }

    public void llamar(View v) {
        String telefono = tvtelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefono)));
    }

    public void enviarEmail(View v){
        String email= tvemail.getText().toString();
        Intent emailintent=new Intent((Intent.ACTION_SEND));
        emailintent.setData(Uri.parse("mailto"));
        emailintent.putExtra(Intent.EXTRA_EMAIL, email);
        startActivity(Intent.createChooser(emailintent, "Email"));


    }



}
