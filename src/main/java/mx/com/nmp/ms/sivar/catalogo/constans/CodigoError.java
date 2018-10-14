

/*
 *
 *
 *
 * <p><a href="https://wiki.quarksoft.net/display/NMPSIVARELOJES/Home">SIVA Relojes</a></p>
 *
 * <p><b><a href="https://quarksoft.net/">Quarksoft S.A.P.I. de C.V. Copyrigth © 2018</a></b></p>
 *
 *
 */


package mx.com.nmp.ms.sivar.catalogo.constans;


import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * Enumeración que enlista los codigos de error
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CodigoError {
    NMP_SRC_0001("Los parametros no son correctos", TipoError.CLIENTE, SeveridadError.BAJA),
    NMP_SRC_0002("La entidad que desea consultar no existe", TipoError.CLIENTE, SeveridadError.BAJA),
    NMP_SRC_0003("El catálogo que desea consultar no existe, o no esta configurado",
            TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_SRC_0004("El elemento de la matriz de coordenadas es una combinación no valida",
            TipoError.SERVIDOR, SeveridadError.MEDIA),
    NMP_SRC_9999("Error no esperado", TipoError.SERVIDOR, SeveridadError.ALTA);

    /**
     * Descripción del error
     */
    private String descripcion;

    /**
     * Tipo de error
     */
    private TipoError tipoError;

    /**
     * Severidad del error
     */
    private SeveridadError severidadError;

    /**
     * Constructor
     *
     * @param descripcion Descripción del error
     * @param tipoError Tipo de error
     * @param severidadError Severidad del error
     */
    CodigoError(String descripcion, TipoError tipoError, SeveridadError severidadError) {
        this.descripcion = descripcion;
        this.tipoError = tipoError;
        this.severidadError = severidadError;
    }

    /**
     * Recupera el valor de {@code codigo}
     *
     * @return Valor de {@code codigo}
     */
    public String getCodigo() {
        return name();
    }

    /**
     * Recupera el valor de {@code descripcion}
     *
     * @return Valor de {@code descripcion}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Recupera el valor de {@code tipoError}
     *
     * @return Valor de {@code tipoError}
     */
    public TipoError getTipoError() {
        return tipoError;
    }

    /**
     * Recupera el valor de {@code severidadError}
     *
     * @return Valor de {@code severidadError}
     */
    public SeveridadError getSeveridadError() {
        return severidadError;
    }
}
