package com.example.ticketreservationapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityAcceptanceTest {

    @Before
    public void setUp() {
        // Initialize Intents for tracking activity navigation
        Intents.init();
    }

    @After
    public void tearDown() {
        // Release Intents after the test finishes
        Intents.release();
    }

    @Test
    public void testSuccessfulRegistrationNavigatesToEventList() throws InterruptedException {
        // Launch the Registration Screen directly
        ActivityScenario.launch(RegisterActivity.class);

        // Generate a random email so Firebase accepts it every single time the test runs
        String randomEmail = "testuser_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        // Type the random email into the UI
        onView(withId(R.id.emailEditText))
                .perform(typeText(randomEmail), closeSoftKeyboard());

        // Type a valid password into the UI
        onView(withId(R.id.passwordEditText))
                .perform(typeText("validPassword123"), closeSoftKeyboard());

        // Click the Register button
        onView(withId(R.id.registerEmailButton)).perform(click());

        // Wait briefly for the Firebase network call to finish
        Thread.sleep(3000);

        // Verify the app successfully transitioned to the EventListActivity
        intended(hasComponent(EventListActivity.class.getName()));
    }
}