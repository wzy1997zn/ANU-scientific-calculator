package au.edu.anu.scientificcalculator;
import au.edu.anu.scientificcalculator.grid.grid;
import au.edu.anu.scientificcalculator.parser.CalculateCore;
import au.edu.anu.scientificcalculator.parser.FunctionExp;
import au.edu.anu.scientificcalculator.parser.WrongExpressionException;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayDiagramActivity extends AppCompatActivity{
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_diagram);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_diagram);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //intent.putExtra(EXTRA_MESSAGE, "1");
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.textView);
        //textView.setText(message);
        //Context context = getApplicationContext();
        grid mygrid = findViewById(R.id.grad_id);
        mygrid.functionExp = message;

    }
}
