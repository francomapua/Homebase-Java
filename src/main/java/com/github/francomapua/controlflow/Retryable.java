package com.github.francomapua.controlflow;

/**
 * Retryable v1.0.0
 */
public abstract class Retryable<T> {
    protected int maxRetry;
    protected long retryDelayInteral;
    
    public Retryable(int maxRetry, long retryDelayInteral){
        this.maxRetry = maxRetry;
        this.retryDelayInteral = retryDelayInteral;
    }

    public T execute() throws Exception{
        int retryAttempts = 0;
        Exception finalException = null;
        T result = null;
        while(retryAttempts <= maxRetry){
            try{
                result = command();
                break;
            }catch(Exception ex){
                finalException = ex;
            } 
            retryAttempts++;
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

    protected abstract T command();
    protected abstract void onSuccess();
    protected abstract void onFailure();
    protected abstract void onFinish();

}