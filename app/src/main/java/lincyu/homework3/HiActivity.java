package lincyu.homework3;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HiActivity extends AppCompatActivity {
    TextView result;
    EditText input;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView)findViewById(R.id.tv_name);
        input = (EditText)findViewById(R.id.et_name);
        submit = (Button)findViewById(R.id.btn_back);
        submit.setOnClickListener(Hiresult);
    }

    View.OnClickListener Hiresult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            String name2 = input.getText().toString();
            intent.putExtra("Please input your name",name2);
            setResult(RESULT_OK,intent);
            finish();
        }
    };
}
