package com.jboss.dvd.seam;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammadghasemy
 */

@Name("taskManager")
@Scope(ScopeType.APPLICATION)
public class TaskManager {

    private ExecutorService executor;

    @PostConstruct
    public void init() {
        executor = Executors.newSingleThreadExecutor();
    }

    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    // Or just void submit(Runnable task) if you want fire-and-forget.

    
    @PreDestroy
    public void destroy() { 
    	 executor.shutdown();
    }
}
