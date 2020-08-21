package au.edu.anu.scientificcalculator;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UItest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickTest1() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonOne))
                .check(matches(withText("1")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("1")));
    }

    @Test
    public void clickTest2() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonTwo))
                .check(matches(withText("2")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("2")));
    }

    @Test
    public void clickTest3() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonThree))
                .check(matches(withText("3")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("3")));
    }

    @Test
    public void clickTest4() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonFour))
                .check(matches(withText("4")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("4")));
    }

    @Test
    public void clickTest5() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonFive))
                .check(matches(withText("5")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("5")));
    }

    @Test
    public void clickTest6() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonSix))
                .check(matches(withText("6")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("6")));
    }

    @Test
    public void clickTest7() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonSeven))
                .check(matches(withText("7")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("7")));
    }

    @Test
    public void clickTest8() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonEight))
                .check(matches(withText("8")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("8")));
    }

    @Test
    public void clickTest9() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonNine))
                .check(matches(withText("9")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("9")));
    }

    @Test
    public void clickTest0() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonZero))
                .check(matches(withText("0")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("0")));
    }

    @Test
    public void clickTestDot() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonDot))
                .check(matches(withText(".")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText(".")));
    }

    @Test
    public void clickTestPlus() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonAdd))
                .check(matches(withText("+")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("+")));
    }


    @Test
    public void clickTestMinus() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonMinus))
                .check(matches(withText("-")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("-")));
    }



    @Test
    public void clickTestLbracket() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonLeftBracket))
                .check(matches(withText("(")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText("(")));
    }

    @Test
    public void clickTestRbracket() {
        // check the text on the button is correct and push it
        onView(withId(R.id.buttonRightBracket))
                .check(matches(withText(")")))
                .perform(click());

        // check whether the result shown on the editText is correct
        onView(withId(R.id.editText))
                .check(matches(withText(")")));
    }





}