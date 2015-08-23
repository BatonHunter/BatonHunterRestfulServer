package org.batonhunter.server.restful.util;

import org.batonhunter.server.restful.model.user.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ianchiu on 2015/8/20.
 */
public class UserHelper {
    public static User removeInfinityReferenceForUser(User user){
        if(null == user || (user.getJobs().isEmpty() && user.getCards().isEmpty()))
            return user;

        user.setJobs(removeInfinityForeignObject(user.getJobs().iterator()));
        user.setCards(removeInfinityForeignObject(user.getCards().iterator()));
        return user;
    }

    private static Job removeInfinityJobFromTask(Job job){
        job.setTasks(removeInfinityForeignObject(job.getTasks().iterator()));
        return job;
    }

    private static <E extends ForeignObject> Collection<E> removeInfinityForeignObject(Iterator<E> iterator){
        Collection<ForeignObject> userForeignObjects = new ArrayList<>();
        while(iterator.hasNext()){
            ForeignObject userForeignObject = iterator.next();
            userForeignObject.setForeign(null);
            if(userForeignObject instanceof Job){
                userForeignObject = removeInfinityJobFromTask((Job) userForeignObject);
            }
            userForeignObjects.add(userForeignObject);
        }
        return (Collection<E>) userForeignObjects;
    }
}
