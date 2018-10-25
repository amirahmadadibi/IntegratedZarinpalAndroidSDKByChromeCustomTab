package leaning.test.amirahmadadibi.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class FactorActivity extends AppCompatActivity {
    EditText edt_name, edt_price, edt_product_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factor);
        initToolbar();
        initViews();
    }

    private void initViews() {
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_product_type = findViewById(R.id.edt_product_type);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void selectPaymentTerminal(View view) {
        Intent intent = new Intent(FactorActivity.this,MainActivity.class);
        intent.putExtra(Constants.Name,edt_name.getText().toString());
        intent.putExtra(Constants.PRICE,edt_price.getText().toString());
        intent.putExtra(Constants.PRODUCT_TYPE,edt_product_type.getText().toString());
        startActivity(intent);
        finish();
    }
}
