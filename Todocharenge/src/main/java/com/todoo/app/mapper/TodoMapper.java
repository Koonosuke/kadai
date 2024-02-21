package com.todoo.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todoo.app.entity.Todo;

@Mapper
public interface TodoMapper {

    List<Todo> selectAll();

    List<Todo> selectIncomplete();

    List<Todo> selectComplete();
    
    List<Todo> selectStudyIncomplete();

    List<Todo> selectStudyComplete();

    
    List<Todo> selectStudyedIncomplete();

    List<Todo> selectStudyedComplete();
    
    
    
    void add(Todo todo);
    void update(Todo todo);
    void delete();
   

    void addStudyTodo(Todo studyTodo);
    void updateStudy(Todo studyTodo);
    void deleteStudy();
    
    void addStudyed(Todo studyedTodo);
    void updateStudyed(Todo studyedTodo);
    void deleteStudyed();

}
