package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * @author Devlin Hamill
 * CS460
 * lab 1
 * Description: creating a calculator app through a mobile device
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     *  A textfield that will contain the result of the calculator to be displayed to the user
     *
     */
    TextView resultTV;
    /**
     * SolutionTV: contains users current inputs from the calculator to be displayed on the GUI
     */
    TextView solutionTV;
    /**
     * creates a button that allows the user to delete the most recent input on the calculator
     */
    MaterialButton buttonC;
    /**
     * creates a button that will attach a open bracket onto the solutionTV display later on
     */
    MaterialButton buttonBrackOpen;
    /**
     * creates a button that will attach a closed bracket onto the solutionTV display later on
     */
    MaterialButton buttonBrackClose;
    /**
     * creates a 0 button that will attach a 0 onto the solutionTV display to be calculated later on
     */
    MaterialButton button0;
    /**
     * creates a 1 button that will attach a 1 onto the solutionTV display to be calculated later on
     */
    MaterialButton button1;
    /**
     * creates a 2 button that will attach a 2 onto the solutionTV display to be calculated later on
     */
    MaterialButton button2;
    /**
     * creates a 3 button that will attach a 3 onto the solutionTV display to be calculated later on
     */
    MaterialButton button3;
    /**
     * creates a 4 button that will attach a 4 onto the solutionTV display to be calculated later on
     */
    MaterialButton button4;
    /**
     * creates a 5 button that will attach a 5 onto the solutionTV display to be calculated later on
     */
    MaterialButton button5;
    /**
     * creates a 6 button that will attach a 6 onto the solutionTV display to be calculated later on
     */
    MaterialButton button6;
    /**
     * creates a 7 button that will attach a 7 onto the solutionTV display to be calculated later on
     */
    MaterialButton button7;
    /**
     * creates a 8 button that will attach a 8 onto the solutionTV display to be calculated later on
     */
    MaterialButton button8;
    /**
     * creates a 9 button that will attach a 9 onto the solutionTV display to be calculated later on
     */
    MaterialButton button9;
    /**
     * multiply button that will attach the multiply operator onto the solutionTV
     */
    MaterialButton buttonMul;
    /**
     * plus button that will attach the plus operator onto the solutionTV
     */
    MaterialButton buttonPlus;
    /**
     * subtract button that will attach the subtraction operator onto the solutionTV
     */
    MaterialButton buttonSub;
    /**
     * divide button that will attach the division operator onto the solutionTV
     */
    MaterialButton buttonDivide;
    /**
     * equal button that will attach the equalivalance operator onto the solutionTV
     */
    MaterialButton buttonEquals;
    /**
     * creates a AC that will clear the entire display and reset the result back to 0 later on
     */
    MaterialButton buttonAC;
    /**
     * attaches a '.' onto the solution tv to be calculated as a decimal in the resultTV later on
     */
    MaterialButton buttonDot;

    /**
     * Intializes the GUI of the calculator
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultTV = findViewById(R.id.result_tv);

        solutionTV = findViewById(R.id.solution_tv);

        assignID(buttonC, R.id.button_c);
        assignID(buttonBrackOpen, R.id.button_open_bracket);
        assignID(buttonBrackClose, R.id.button_closed_bracket);
        assignID(button0, R.id.button_0);
        assignID(button1, R.id.button_1);
        assignID(button2, R.id.button_2);
        assignID(button3, R.id.button_3);
        assignID(button4, R.id.button_4);
        assignID(button5, R.id.button_5);
        assignID(button6, R.id.button_6);
        assignID(button7, R.id.button_7);
        assignID(button8, R.id.button_8);
        assignID(button9, R.id.button_9);

        assignID(buttonMul, R.id.button_mul);
        assignID(buttonPlus, R.id.button_plus);
        assignID(buttonSub, R.id.button_sub);
        assignID(buttonDivide, R.id.button_divide);

        assignID(buttonAC, R.id.button_ac);
        assignID(buttonDot, R.id.button_dot);
        assignID(buttonEquals, R.id.button_equals);

    }

    /**
     * connects the xml file buttons with the main java file buttons through its unique id
     * @param btn contains the main java file button
     * @param id contains the id of the xml file button
     */
    void assignID(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    /**
     * creates a psuedo click listener that will do a specific action based on which button was clicked
     * @param view The button that was clicked
     */
    @Override
    public void onClick(View view) {

        if(solutionTV.getText().equals("43760135") && resultTV.getText().equals("Devlin Hamill")){
            solutionTV.setText("0");
            resultTV.setText("0");
        }
        /**
         * saves the button that was clicked onto a button variable
         */
        MaterialButton button = (MaterialButton) view;
        /**
         * contains the text of the button that was clicked
         */
        String buttonText = button.getText().toString();
        /**
         * creates a string that holds the progress of the user inputs that has yet to be calcualated
         */
        String dataTocalculate = solutionTV.getText().toString();
        if(buttonText.equals("AC")){
            solutionTV.setText("");
            resultTV.setText("0");
            return;
        }

        if(buttonText.equals("=")){

            solutionTV.setText(resultTV.getText().toString());
            return;

        }
        if(buttonText.equals("C")){
            if(dataTocalculate.length()-1 == 0){
                solutionTV.setText("0");
                resultTV.setText("0");
                return;
            }else {
                dataTocalculate = dataTocalculate.substring(0, dataTocalculate.length() - 1);
            }
        }else{
            if(!dataTocalculate.equals("0")) {
                dataTocalculate = dataTocalculate + buttonText;
            }else{
                dataTocalculate = buttonText;
            }
        }
        solutionTV.setText(dataTocalculate);
        /**
         * saves the calculated data onto its own string variable to be displayed displayed on resultTV
         */
        String finalResult = getResults(dataTocalculate);
        if(!finalResult.equals("Err")){
            resultTV.setText(finalResult);
        }
    }

    /**
     * returns the calculated result of the users desired inputs from the calculator
     * @param data contains the equation that the user created with the calculator
     * @return returns the result of the equation that the user created
     */
    String getResults(String data){
        try{
            /**
             * saves the current thread onto a context variable that will be used to evaluate the string
             */
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            /**
             * intializes a object that will help with saving the evaluation
             */
            Scriptable scriptable = context.initStandardObjects();
            return context.evaluateString(scriptable, data, "Javascript",1,null).toString();

        }catch (Exception e){

           return "Err";
        }
    }
}