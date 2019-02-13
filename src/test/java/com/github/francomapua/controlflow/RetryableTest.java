package com.github.francomapua.controlflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RetryableTest {

    // TEST VARIABLES
    int maxAttempts = 5;
    long retryIntervalMS = 50;
    boolean willSucceed;

    boolean result;
    int attempts;
    boolean successSuccessFlagRaised;
    boolean failSuccessFlagRaised;
    boolean finishSuccessFlagRaised;
    

    String exceptionMessage = "Something Happened";

    Retryable<Boolean> retryable = new Retryable<Boolean>(maxAttempts, retryIntervalMS) {
        @Override
        protected Boolean command() throws Exception{
            attempts++;
            if(willSucceed){
                return true;
            }
            else{
                throw new Exception(exceptionMessage);
            }
        }
        @Override
        protected void onFinish() {
            finishSuccessFlagRaised = true;
        }
        @Override
        protected void onSuccess() {
            successSuccessFlagRaised = true;
        }
        @Override
        protected void onFailure() {
            failSuccessFlagRaised = true;
        }
        
    };

    @Before
    public void initFlags() {
        result = false;
        attempts = 0;
        successSuccessFlagRaised = false;
        failSuccessFlagRaised = false;
        finishSuccessFlagRaised = false;
    }

    @Test
    public void checkDefaultValues() {
        assertNotNull(retryable);
    }


    @Test
    public void checkSuccess(){
        willSucceed = true;

        try{
            result = retryable.execute();
        }catch(Exception ex){

        }
        assertTrue(result);
        assertEquals(attempts, 1);
        assertTrue(finishSuccessFlagRaised);
        assertTrue(successSuccessFlagRaised);
        assertFalse(failSuccessFlagRaised);
    }

    @Test
    public void checkFailure(){
        willSucceed = false;
        try{
            result = retryable.execute();
        }catch(Exception ex){
            assert(ex.toString().equals(exceptionMessage));
        }
        assertFalse(result);
        assertEquals(attempts, maxAttempts);
        assertTrue(finishSuccessFlagRaised);
        assertFalse(successSuccessFlagRaised);
        assertTrue(failSuccessFlagRaised);
        
    }
}
