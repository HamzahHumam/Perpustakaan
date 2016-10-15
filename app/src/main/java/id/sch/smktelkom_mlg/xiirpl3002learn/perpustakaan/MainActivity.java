package id.sch.smktelkom_mlg.xiirpl3002learn.perpustakaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHasil, tvHasil2, tvhasil3;
    EditText etinput;
    Button btOk;
    CheckBox cb1, cb2, cb3;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textView2);
        tvhasil3 = (TextView) findViewById(R.id.textView3);
        rg = (RadioGroup) findViewById(R.id.rgpilihan);
        etinput = (EditText) findViewById(R.id.editTextinput);
        btOk = (Button) findViewById(R.id.buttonOK);
        cb1 = (CheckBox) findViewById(R.id.checkBoxbk);
        cb2 = (CheckBox) findViewById(R.id.checkBoxkm);
        cb3 = (CheckBox) findViewById(R.id.checkBoxmj);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHasil();
                etinput.setText("");
            }
        });
    }

    private void goHasil() {
        String hasil = "Tidak ada Masukan";
        if (rg.getCheckedRadioButtonId() != -1) {
            RadioButton rB = (RadioButton)
                    findViewById(rg.getCheckedRadioButtonId());
            hasil = rB.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih ");
        } else {
            tvHasil.setText("Masukkan pilihan Anda : " + hasil);
        }

        String hasil2 = " \n\nTambah Masa Pinjam selama : \n";
        int startlen = hasil2.length();
        if (cb1.isChecked()) hasil2 += cb1.getText() + "\n";
        if (cb2.isChecked()) hasil2 += cb2.getText() + "\n";
        if (cb3.isChecked()) hasil2 += cb3.getText() + "\n";

        if (hasil2.length() == startlen) hasil2 += " Tidak ada ";

        if (isValid()) ;
        String input = etinput.getText().toString();
        tvHasil.setText("Layanan Buku : " + hasil + " " + hasil2);
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
