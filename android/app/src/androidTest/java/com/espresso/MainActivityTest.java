package com.espresso;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.is;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by gusta on 02/12/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        Thread.sleep(10_000);
    }

    @Test
    public void listGoesOverTheFold() throws InterruptedException {
        String typeString = "teste";

        ViewInteraction input = onView(withTagValue(is((Object) "input")));
        ViewInteraction button = onView(withTagValue(is((Object) "button")));
        ViewInteraction text = onView(withTagValue(is((Object) "result")));

        input.perform(click(), typeText(typeString));
        button.perform(click());
        text.check(matches(withText(typeString)));
    }

    @After
    public void tearDown() throws Exception {
    }

}