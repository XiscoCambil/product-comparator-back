package com.esliceu.comparador.util;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JpaUtil {

    public JpaUtil(){

    }

/*
    public Query AddPredicatesAnd(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root, CriteriaQuery query){
        final List<Predicate> andPredicates = new ArrayList<>();

        for (Predicate predicate : predicates) {
            if (predicate != null) {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
            }
        }

        query.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
        query.select(count);
    }

*/
}