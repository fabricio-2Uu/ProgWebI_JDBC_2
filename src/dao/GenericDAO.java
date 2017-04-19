/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Silvia
 */
public interface GenericDAO <T> {
    public int insert(T obj);
    public int update(T obj);
    public int delete(T obj);
    public java.util.List<T> listAll();
//    public T findByID(int id);
}

