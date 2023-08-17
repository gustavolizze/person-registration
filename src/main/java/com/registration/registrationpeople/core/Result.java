package com.registration.registrationpeople.core;

public class Result<Success, Error> {

    private Success success;
    private Error error;
    private boolean _isSuccess;


    public Result(Success success, Error error) {
        this.success = success;
        this.error = error;
        this._isSuccess = error == null;
    }

    public boolean isSuccess() {
        return this._isSuccess;
    }

    public Error error() {
        return this.error;
    }

    public Success get() {
        return this.success;
    }

    public static <S, E> Result<S, E> ok(S success) {
        return new Result<>(success, null);
    }

    public static <S, E> Result<S, E> failure(E error) {
        return new Result<>(null, error);
    }



}
