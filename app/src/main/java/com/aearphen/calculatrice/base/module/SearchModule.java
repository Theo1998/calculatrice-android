package com.aearphen.calculatrice.base.module;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by Aearphen on 04/04/18.
 */
public interface SearchModule<M, K> {
    /**
     * Search a Key contains in a list of Model, and return a new list Observer.
     *
     * @param source Source List
     * @param key    Key for tests
     * @return Observer of a new list with results
     */
    Observer<List<M>> search(List<M> source, K key);
}
