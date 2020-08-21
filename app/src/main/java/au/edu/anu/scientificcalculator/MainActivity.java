package au.edu.anu.scientificcalculator;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.FileOutputStream;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.List;

import au.edu.anu.scientificcalculator.file.FileUtil;
import au.edu.anu.scientificcalculator.parser.CalculateCore;
import au.edu.anu.scientificcalculator.parser.FunctionExp;
import au.edu.anu.scientificcalculator.parser.WrongExpressionException;





public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
//    TextView infoTextView;

    String userExpression = "";
    String outPutResult = "";

    int FLAG = 0;


    List<String> savingExpressions;
    FileUtil fileUtil;
    private AlertDialog loadingAlertDialog;


    @SuppressLint("ClickableViewAccessibility")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //disable the keyboard while editing textview
        //user can only use the in-app keyboard to edit
        EditText editText = (EditText) findViewById(R.id.editText);
        //editText.requestFocus();
        editText.setShowSoftInputOnFocus(false);

        //editText.setInputType(InputType.TYPE_NULL);
        //editText.setFocusable(true);

        fileUtil = new FileUtil(getApplicationContext());
        savingExpressions = fileUtil.loadFile();

    }

    //put input from EditText through moving cursors to the expression
    public static String insertEdit(String userExpression, String editInput, int index) {
        String expBegin = userExpression.substring(0,index);
        String expEnd = userExpression.substring(index);
        return expBegin + editInput + expEnd;
    }


    public void buttonPressSend0(View v){

        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();
        //System.out.println(cursorPosition);
        //System.out.println(userExpression);
        //System.out.println(userExpression.length());

//        if (cursorPosition == userExpression.length()){
//            userExpression = userExpression.concat("0");
//        }else {
//            userExpression = insertEdit(userExpression, "0", cursorPosition);
//        }
        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "0", cursorPosition);
        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);

    }

    public void buttonPressSend1(View v){

        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "1", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend2(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "2", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend3(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "3", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend4(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "4", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend5(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "5", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend6(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "6", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend7(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "7", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend8(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "8", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSend9(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "9", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendAdd(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "+", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendMinus(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "-", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendMultiply(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "*", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendDivide(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "/", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendEqual(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);
        TextView tvResult = (TextView) findViewById(R.id.resultTextView);

        //initialize result
        String result = null;

        //check if User edit the text through touch screen cursor
        if (userExpression != tv.getText().toString()){
            userExpression = tv.getText().toString();
        }

        //get result from parser
        result = CalculateCore.getInstance().getResultOf(userExpression);

        System.out.println(userExpression);

        //put result into TextView
        tvResult.setText(result);

        //update output result
        outPutResult = result;


        //tv.setInputType(InputType.TYPE_NULL);
        //int cursorPosition = tv.getSelectionStart();
        //Editable etext = tv.getText();
        //Selection.setSelection(etext, cursorPosition+1);
        //tv.setCursorVisible(false);
    }

    public void buttonPressSendDot(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, ".", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendDelete(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);
        if(userExpression.isEmpty()){
            userExpression = "";
        }
        else{
        userExpression = userExpression.substring(0, userExpression.length() - 1);
        }
        System.out.println(userExpression);
        tv.setText(userExpression);
    }

    public void buttonPressSendAC(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);
        TextView tvResult = (TextView) findViewById(R.id.resultTextView);
        userExpression = "";
        outPutResult = "";
        System.out.println(userExpression);
        tv.setText(userExpression);
        tvResult.setText((outPutResult));
    }

    public void buttonPressSendSin(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "sin(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendCos(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "cos(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendTan(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "tan(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendLeftBracket(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendRightBracket(View v) {
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, ")", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+1);
    }

    public void buttonPressSendRoot(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "^(1/2)", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+6);
    }

    public void buttonPressSendPower(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "^(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+2);
    }

    public void buttonPressSendLog(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "log()()", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendFactorial(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "fac(", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendPi(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "3.14", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendE(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "2.72", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendGold(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "1.62", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+4);
    }

    public void buttonPressSendLight(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "299792458", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+9);
    }

    public void buttonPressSendHistory(View v){
        final EditText tv = (EditText) findViewById(R.id.editText);
        String filename = "myfile";
        String fileContents = userExpression;
        //FileOutputStream outputStream;

//        Context ctx = getApplicationContext();
//        try {
//            FileInputStream fileInputStream = ctx.openFileInput(filename);
//        }
//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        String lineData = bufferedReader.readLine();

        savingExpressions = fileUtil.loadFile(); // load expressions from file
        String[] temp = new String[savingExpressions.size()];
        temp = savingExpressions.toArray(temp);
        final String[] items = temp;

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("saved expressions");

        alertBuilder.setItems(items, new DialogInterface.OnClickListener() { // pop out a dialog for user to choose an expression
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
                userExpression = items[i];
                tv.setText(userExpression);
                loadingAlertDialog.dismiss();
            }
        });
        loadingAlertDialog = alertBuilder.create();
        loadingAlertDialog.show();

        System.out.println(userExpression);
        tv.setText(userExpression);
    }


    public void buttonPressSendSaved(View v){
        EditText tv = (EditText) findViewById(R.id.editText);
//        String filename = "myfile";
//        String fileContents = userExpression;
//        FileOutputStream outputStream;
//
//        try {
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(fileContents.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // manage the expression list
        if (savingExpressions.size() == 0) {
            savingExpressions.add(userExpression);
        } else {
            if (savingExpressions.size() == 5) {
                savingExpressions.remove(4);
            }
            savingExpressions.add(savingExpressions.get(savingExpressions.size()-1));
            for (int i = savingExpressions.size()-1; i > 0; i--) {
                savingExpressions.set(i, savingExpressions.get(i-1));
            }
            savingExpressions.set(0, userExpression);
        }

        // save to file
        fileUtil.save(savingExpressions);
        Toast.makeText(MainActivity.this, "saved successfully", Toast.LENGTH_SHORT).show();

        System.out.println(userExpression);
        tv.setText(userExpression);
    }

    public void buttonPressSendLoad(View v){
        final EditText tv = (EditText) findViewById(R.id.editText);
        String filename = "myfile";
        String fileContents = userExpression;
        //FileOutputStream outputStream;

//        Context ctx = getApplicationContext();
//        try {
//            FileInputStream fileInputStream = ctx.openFileInput(filename);
//        }
//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        String lineData = bufferedReader.readLine();

        savingExpressions = fileUtil.loadFile(); // load expressions from file
        String[] temp = new String[savingExpressions.size()];
        temp = savingExpressions.toArray(temp);
        final String[] items = temp;

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("saved expressions");

        alertBuilder.setItems(items, new DialogInterface.OnClickListener() { // pop out a dialog for user to choose an expression
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_SHORT).show();
                userExpression = items[i];
                tv.setText(userExpression);
                loadingAlertDialog.dismiss();
            }
        });
        loadingAlertDialog = alertBuilder.create();
        loadingAlertDialog.show();

        System.out.println(userExpression);
        tv.setText(userExpression);
    }

    public void buttonPressSendFunc(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "f(x)=", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+5);
    }

    public void buttonPressSendX(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "x_1", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+3);
    }

    public void buttonPressSendY(View v){
        EditText tv = (EditText) findViewById(R.id.editText);

        //get current cursorPosition
        int cursorPosition = tv.getSelectionStart();

        //insert the edit input to original expression
        userExpression = insertEdit(userExpression, "x_2", cursorPosition);

        //update userExpression to editText view
        tv.setText(userExpression);

        //update cursor position
        Editable etext = tv.getText();
        Selection.setSelection(etext, cursorPosition+3);
        FLAG = 1;
    }

    public void buttonPressSendInput(View v){
        EditText tv = (EditText) findViewById(R.id.editText);
        int cursorPosition = tv.getSelectionStart();

        if (( userExpression.contains("x_1") == false) && ( userExpression.contains("x_2") == false)){
            return;
        }

        if (FLAG == 0){
            int index1 = userExpression.indexOf("x_1");
            userExpression = userExpression.replaceFirst("x_1", "");
            tv.setText(userExpression);
            Editable etext = tv.getText();
            Selection.setSelection(etext, index1);
        }
        else if (FLAG == 1) {
            int index1 = userExpression.indexOf("x_2");
            userExpression = userExpression.replaceFirst("x_2", "");
            tv.setText(userExpression);
            Editable etext = tv.getText();
            Selection.setSelection(etext, index1);
            if (userExpression.contains("x_2") != true){
                FLAG = 0;
            }
        }
    }

    public void buttonPressSendGraph(View v){
        //TextView tv = (TextView) findViewById(R.id.editText);
        //String filename = "myfile";
        //String fileContents = userExpression;
//        Intent intent = new Intent(MainActivity.this, DisplayDiagramActivity.class);
//        String message = "parameters";
//        intent.putExtra(EXTRA_MESSAGE, message);

        Boolean bool = CalculateCore.getInstance().checkFunctionExpressionValid(userExpression);
        if (bool == true){
//            try {
//                FunctionExp exp = CalculateCore.generateFunction(userExpression);
//            } catch ( WrongExpressionException e) {
//                e.printStackTrace();
//            }

            Intent intent = new Intent(MainActivity.this, DisplayDiagramActivity.class);
            String message = userExpression;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }


        //startActivity(intent);
        //System.out.println(userExpression);
        //tv.setText(userExpression);
    }

}
