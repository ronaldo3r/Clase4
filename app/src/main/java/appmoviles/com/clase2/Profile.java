package appmoviles.com.clase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    private RelativeLayout root_profile;
    private Button btn_salir_profile;

    //Implementar el metodo de abajo en funciones landa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        root_profile = findViewById(R.id.profile_root);
        btn_salir_profile = findViewById(R.id.btn_salir_profile);

        root_profile.setOnTouchListener(new View.OnTouchListener() {
            float Xini=0;
            float Yini=0;
            float Xfin=0;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Xini=motionEvent.getX();
                        Yini=motionEvent.getY();
                        btn_salir_profile.setText("DOWN: " + motionEvent.getX() + ", " + motionEvent.getY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        btn_salir_profile.setText("MOVE: " + motionEvent.getX() + ", " + motionEvent.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        float deltaX = motionEvent.getX()-Xini;
                        if (deltaX > 500 ){
                            Intent i = new Intent(Profile.this, MainProfile.class);
                            startActivity(i);
                        }
                        if (deltaX < -500 ){
                            finish();
                        }
                        btn_salir_profile.setText("UP: " + motionEvent.getX() + ", " + motionEvent.getY());
                        break;
                }

                return true;
            }
        });

        Intent datos = getIntent();
        String nombre = datos.getExtras().getString("nombre");
        String contra = datos.getExtras().getString("contra");

        Toast.makeText(this, nombre + " " + contra, Toast.LENGTH_LONG).show();
    }
}
