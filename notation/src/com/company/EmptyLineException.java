package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: art
 * Date: 18.07.13
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class EmptyLineException extends Exception {
    EmptyLineException() {
        super("Expression cannot be empty");
    }
}
