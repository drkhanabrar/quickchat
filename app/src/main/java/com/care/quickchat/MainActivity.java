
package com.care.quickchat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        TextInputEditText n = findViewById(R.id.number);
        MaterialButton btn = findViewById(R.id.button);
        CountryCodePicker ccp = findViewById(R.id.ccp);

        btn.setOnClickListener(v -> {
            String num = n.getText().toString().trim();

            if (num.length() < 6 || num.length() > 15) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
                return;
            }

            String full = ccp.getSelectedCountryCode() + num;

            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://wa.me/" + full)));
        });
    }
}
