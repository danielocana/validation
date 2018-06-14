package com.validation.demo;

import java.util.List;

public class ErrorsOnDomain extends RuntimeException {

    private List<Error> collect;

    public ErrorsOnDomain(List<Error> collect) {
        this.collect = collect;
    }

    public List<Error> getCollect() {
        return collect;
    }
}
