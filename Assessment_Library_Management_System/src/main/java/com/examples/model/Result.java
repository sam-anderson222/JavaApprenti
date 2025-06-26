package com.examples.model;

public record Result<T>(T data, boolean isSuccess) {
}
