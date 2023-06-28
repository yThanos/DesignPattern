package br.ufsm.csi.pp.av1;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class CopiaProfunda {


    @SneakyThrows
    public Object realizaCopiaProfunda(Object objeto) {
        if (isPrimitive(objeto.getClass())) {
            return objeto;
        } else if (Collection.class.isAssignableFrom(objeto.getClass())) {
            Collection colCopia = new ArrayList();
            for (Object oArr : (Collection) objeto) {
                Object copiaArr = realizaCopiaProfunda(oArr);
                colCopia.add(copiaArr);
            }
            return colCopia;
        } else {
            Object copia = objeto.getClass().newInstance();
            for (Field f : objeto.getClass().getDeclaredFields()) {
                if (!f.isAnnotationPresent(NoCopy.class)) {
                    f.setAccessible(true);
                    f.set(copia, realizaCopiaProfunda(f.get(objeto)));
                }
            }
            return copia;
        }
    }

    private boolean isPrimitive(Class tipo) {
        return tipo.isPrimitive() || tipo == Boolean.class ||
                tipo == String.class || Number.class.isAssignableFrom(tipo);
    }

}
