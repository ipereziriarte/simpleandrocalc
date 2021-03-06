/*
 * Copyright 2012 Olhe Ingenieros SL.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.olheingenieros.simplecalc.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.olheingenieros.simplecalc.MainActivity;

/**
 * Class for testing validation
 * 
 * @author olheingenierossl
 * @since 1.0
 */
public class MathValidation extends ActivityInstrumentationTestCase2<MainActivity> {

    private TextView tvResult;

    /**
     * Test Class Constructor It uses the 1 argument constructor, since 2
     * arguments constructor is deprecated
     */
    public MathValidation() {
        super(MainActivity.class);
    }

    /* (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        final MainActivity mainActivity = getActivity();


        tvResult = (TextView) mainActivity
                .findViewById(com.olheingenieros.simplecalc.R.id.editText2);
    }

    private static final String NUMBER_24 = "2 4 ENTER ";
    private static final String NUMBER_74 = "7 4 ENTER ";
    private static final String ADD_RESULT = "98";
    private static final String NUMBER_5_DOT_5 = "5 . 5 ENTER ";
    private static final String ADD_DECIMAL_RESULT = "79.5";
    private static final String MULTIPLY_RESULT = "1776";

    /**
     * Public function for testing the add function
     */
    public void testAddValues() {
        // Send command to android terminal
        sendKeys(NUMBER_24);
        sendKeys(NUMBER_74);

        // Press ADD Button
        sendKeys("ENTER");

        // This could be compacted like this sendkeys(NUMBER_24 + NUMBER_74 +
        // "ENTER");

        // Get the result from the textview
        final String mathResult = tvResult.getText().toString();

        /*
         * Asserts true (Explicación: Para superar el test es necesario que el
         * resultado de la suma sea el indicado, en este caso 98. Si no lo es,
         * el test falla y por tanto hemos encontrado un bug!
         */
        assertTrue("Add result should be 98", mathResult.equals(ADD_RESULT));
    }

    /**
     * Other testing function for the add function. Notice that you can run all
     * the test in a row
     */
    public void testAddDecimalValues() {
        sendKeys(NUMBER_5_DOT_5 + NUMBER_74 + "ENTER");
        final String mathResult = tvResult.getText().toString();
        assertTrue("Add result should be " + ADD_DECIMAL_RESULT + "but was "
                + mathResult, mathResult.equals(ADD_DECIMAL_RESULT));
    }

    /**
     * Test for the multiply method. Notice the DPAD_RIGHT command to move the
     * pointer to the multiply button
     */
    public void testMultiplyValues() {
        sendKeys(NUMBER_24 + NUMBER_74 + " DPAD_RIGHT ENTER");

        final String mathResult = tvResult.getText().toString();
        assertTrue("Multiply result should be " + MULTIPLY_RESULT + " but was "
                + mathResult, mathResult.equals(MULTIPLY_RESULT));
    }


}
