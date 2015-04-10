package sen.tec.dk.multipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button button_ChangeActivity;
    EditText editText_UserInput;

    static final int REQ_ACTIVITY2 = 0;
    static final int REQ_ACTIVITY3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_ChangeActivity = (Button)findViewById(R.id.button_ChangeActivity);
        button_ChangeActivity.setOnClickListener(this);

        editText_UserInput = (EditText)findViewById(R.id.editText_UserInput);
    }

    @Override
    public void onClick(View v)
    {
        String userInput = editText_UserInput.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("userInput", userInput);
        //this.startActivity(intent);
        startActivityForResult(intent, REQ_ACTIVITY2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_ACTIVITY2 && resultCode == Activity.RESULT_OK)
        {
            Toast.makeText(this, data.getStringExtra("TextFromSecondActivity"),Toast.LENGTH_SHORT).show();
        }
    }
}
