package sen.tec.dk.multipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends ActionBarActivity implements View.OnClickListener {

    Button button_back;
    TextView textView_WriteUserInput;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button_back = (Button)findViewById(R.id.activity2_Button_Back);
        button_back.setOnClickListener(this);

        textView_WriteUserInput = (TextView)findViewById(R.id.activity2_textView_WriteUserInput);
        intent = getIntent();
        String userInput = intent.getStringExtra("userInput");
        textView_WriteUserInput.setText(userInput);
    }

    private void finishAction()
    {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        String time = String.format("The Time is\n%1$02d:%2$02d:%3$02d", hour, minutes, seconds);
        intent.putExtra("TextFromSecondActivity", time);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View v)
    {
        finishAction();
    }

    //overrides physical back button functionality
    @Override
    public void onBackPressed()
    {
        finishAction();
    }
}
