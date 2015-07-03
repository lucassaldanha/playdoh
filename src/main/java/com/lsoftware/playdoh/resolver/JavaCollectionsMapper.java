package com.lsoftware.playdoh.resolver;

import java.util.*;

public class JavaCollectionsMapper extends AbstractInterfaceMapper {

    @Override
    protected Map<Class, Class> loadMap() {
        Map<Class, Class> classMap = new HashMap<Class, Class>();

        classMap.put(Iterable.class, HashSet.class);
        classMap.put(Collection.class, HashSet.class);
        classMap.put(Set.class, HashSet.class);
        classMap.put(List.class, LinkedList.class);
        classMap.put(Queue.class, LinkedList.class);
        classMap.put(Deque.class, LinkedList.class);
        classMap.put(Map.class, HashMap.class);

        return classMap;
    }
}
