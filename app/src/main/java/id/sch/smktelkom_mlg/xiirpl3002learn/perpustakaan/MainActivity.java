package id.sch.smktelkom_mlg.xiirpl3002learn.perpustakaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHasil, tvHasil2, tvhasil3;
    EditText etinput;
    Button btOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textView2);
        tvhasil3 = (TextView) findViewById(R.id.textView3);
        etinput = (EditText) findViewById(R.id.editTextinput);
        btOk = (Button) findViewById(R.id.buttonOK);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHasil();
                etinput.setText("");
            }
        });
    }

    private void goHasil() {
        if (isValid()) ;
        String input = etinput.getText().toString();
        tvhasil3.setText("Komentar dan saran : " + input);
    }

    private boolean isValid() {
        boolean valid = true;

        String input = etinput.getText().toString();

        if (input.isEmpty()) {
            etinput.setError("Komentar Belum diisi");
        } else {
            etinput.setError(null);
        }
        return valid;
    }
}
