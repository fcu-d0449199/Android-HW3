package lincyu.homework3;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn_say_hello);
        btn.setOnClickListener(SayHello);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_web:
                Uri uri =Uri.parse("http://www.google.com.tw");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.action_settings:
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    private static final int EDIT = 1;
    View.OnClickListener SayHello = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,HiActivity.class);
            startActivityForResult(intent,EDIT);
        }
    };

    @Override
    protected void onActivityResult(int Code, int Code2, Intent data) {
        super.onActivityResult(Code, Code2, data);
        if(data == null)
            return;
        switch (Code){
            case EDIT:
                String name = data.getStringExtra("Please input your name");
                Toast.makeText(MainActivity.this,"Hello " + name,Toast.LENGTH_LONG).show();
                break;
        }
    }
}
