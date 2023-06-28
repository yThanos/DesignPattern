package br.ufsm.csi.pp.exercicio7;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.Annotation;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class GeradorJSON {

    public String geraJSON(Object objeto) {
        return geraJSON(objeto, "\t");
    }
    @SneakyThrows
    private String geraJSON(Object objeto, String indent) {
        StringBuffer sb = new StringBuffer();
        sb.append("{\n");
        for (Method metodo : objeto.getClass().getDeclaredMethods()) {
            if ((metodo.getName().startsWith("get") ||
                    metodo.getName().startsWith("is")) &&
                    metodo.getAnnotation(JSON.class) != null &&
                    Modifier.isPublic(metodo.getModifiers()))
            {
                String nome = null;
                if (metodo.getName().startsWith("is")) {
                    nome = metodo.getName().substring(2, 3).toLowerCase()
                            + metodo.getName().substring(3);
                } else {
                    nome = metodo.getName().substring(3, 4).toLowerCase()
                            + metodo.getName().substring(4);
                }
                String valor = getJSONValor(metodo.invoke(objeto), metodo.getAnnotation(JSON.class), indent);
                sb.append(indent).append("\"").append(nome).append("\"").append(": ").append(valor).append(",\n");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        indent = indent.substring(indent.length() -1);
        sb.append("\n").append(indent).append("}");
        return sb.toString();
    }

    @SneakyThrows
    private String getJSONValor(Object retVal, JSON annotation, String indent) {

        StringBuffer sb = new StringBuffer();
        String aspa = vaiAspas(retVal.getClass()) ? "\"" : "";
        //array
        if (Collection.class.isAssignableFrom(retVal.getClass())) {
            sb.append("[");
            for (Object listObj : (Collection) retVal) {
                sb.append(getJSONValor(listObj, annotation, indent)).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
        } else if (!retVal.getClass().getPackage().getName().startsWith("java")) {
            sb.append(geraJSON(retVal, indent + "\t"));
        } else if (Date.class.isAssignableFrom(retVal.getClass()))
        {
            String formato = annotation.formato();
            if (formato == null) {
                formato = "yyyy-MM-dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            sb.append(aspa).append(sdf.format(retVal)).append(aspa);
        } else {
            sb.append(aspa).append(retVal).append(aspa);
        }
        return sb.toString();
    }

    private boolean vaiAspas(Class classe) {
        return !classe.isArray() && (classe == String.class || classe == Date.class);
    }

}
