package com.javaedge.ad.index;

/**
 * @author sss
 * @date 2019-02-11
 */
public interface IndexAware<K, V> {

    /**
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     *
     * @param key
     * @param value
     */
    void add(K key, V value);


    /**
     *
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     *
     * @param key
     * @param value
     */
    void delete(K key, V value);
}
