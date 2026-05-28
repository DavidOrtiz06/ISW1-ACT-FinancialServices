package co.edu.unbosque.isw1_act_dr_do_front.services.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceService<T>{

    T registrar(T t) throws JsonProcessingException;
    List<T> listar() throws JsonProcessingException;
}
