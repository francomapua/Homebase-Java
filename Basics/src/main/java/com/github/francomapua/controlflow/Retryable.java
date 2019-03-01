package com.github.francomapua.controlflow;
/**
 * Retryable v1.0.0
 */
public abstract class Retryable<T> {
    protected int maxAttempts;
    protected long retryIntervalMS;
    
    public Retryable(int maxAttempts, long retryIntervalMS){
        this.maxAttempts = maxAttempts;
        this.retryIntervalMS = retryIntervalMS;
    }

    public T execute() throws Exception{
        int retryAttempts = 1;
        Exception finalException = null;
        T result = null;
        while(retryAttempts <= maxAttempts){
            try{
                result = command();
                break;
            }catch(Exception ex){
                finalException = ex;
            } 
            retryAttempts++;
            Thread.sleep(retryIntervalMS);
        }
        onFinish();
        if(finalException != null){
            onFailure();
            throw finalException;
        }else{
            onSuccess();
        }
        return result;
    }

    protected abstract T command() throws Exception;
    protected abstract void onSuccess();
    protected abstract void onFailure();
    protected abstract void onFinish();

}