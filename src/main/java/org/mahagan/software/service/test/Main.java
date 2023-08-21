package org.mahagan.software.service.test;

import org.mahagan.software.service.Dao.ProjectDao;
import org.mahagan.software.service.Domain.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        ProjectDao projectDao = applicationContext.getBean("projectDao", ProjectDao.class);
       // projectDao.getAllProjects();
         projectDao.getAllProjects();

    }
}