package by.subota.max.dao;

import java.io.Serializable;

/**
 * For identification entity
 * @param <PK> - type of primary key
 */
public interface Identified<PK extends Serializable> {
    /**
     * Get primary key
     * @return primary key
     */
    PK getId();
}
