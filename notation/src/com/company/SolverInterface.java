package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: art
 * Date: 18.07.13
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public interface SolverInterface {
    public void addDictionary(Dictionary Dictionary);
    public Integer solve() throws EmptyLineException;
}
