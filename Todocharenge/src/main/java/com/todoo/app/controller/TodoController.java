package com.todoo.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todoo.app.entity.Todo;
import com.todoo.app.mapper.TodoMapper;

@Controller
public class TodoController {
    @Autowired
    TodoMapper todoMapper;

    @GetMapping("/getImage")
    public String getImage(Model model){
        // 画像を取得する処理
        return "image";
    }
    @RequestMapping(value="/")
    public String index5() {
    	return "index5";
    }

    @RequestMapping(value="/index")
    public String index(Model model) {
        List<Todo> list = todoMapper.selectIncomplete();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",list);
        model.addAttribute("doneTodos",doneList);
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("todayWithTime", dateTimeFormat.format(new Date()));
        return "index";
    }

    @RequestMapping(value="/index1")
    public String index1(Model model) {
        List<Todo> studyList = todoMapper.selectStudyIncomplete();
        List<Todo> doneStudyList = todoMapper.selectStudyComplete();
        model.addAttribute("studyTodos", studyList);
        model.addAttribute("doneStudyTodos", doneStudyList);
        model.addAttribute("studyTodo", new Todo()); // 新しいTodoオブジェクトを作成してモデルに追加
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("todayWithTime", dateTimeFormat.format(new Date()));
        return "index1";
    }
 
    @RequestMapping(value="/index2")
    public String index2(Model model) {
        List<Todo> studyList = todoMapper.selectStudyedIncomplete();
        List<Todo> doneStudyedList = todoMapper.selectStudyedComplete();
        model.addAttribute("studyedTodos", studyList);
        model.addAttribute("doneStudyedTodos", doneStudyedList);
        model.addAttribute("studyedTodo", new Todo()); // 新しいTodoオブジェクトを作成してモデルに追加
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("todayWithTime", dateTimeFormat.format(new Date()));
        return "index2";
    }
    
    

    @RequestMapping(value="/add")
    public String add(Todo todo) {
        todoMapper.add(todo);
        return "redirect:/";
    }

    @RequestMapping(value="/update")
    public String update(Todo todo) {
        todoMapper.update(todo);
        return "redirect:/";
    }

    @RequestMapping(value="/delete")
    public String delete() {
        todoMapper.delete();
        return "redirect:/";
    }
    
    
   
    
    
  
    
    
    @RequestMapping(value="/addStudyTodo")
    public String addStudyTodo(Todo studyTodo) {
        todoMapper.addStudyTodo(studyTodo);
        return "redirect:/index1";
    }

    @RequestMapping(value="/updateStudy")
    public String updateStudy(Todo studyTodo) {
        todoMapper.updateStudy(studyTodo);
        return "redirect:/index1";
    } 
   @RequestMapping(value="/deleteStudy")
public String deleteStudy() {
    todoMapper.deleteStudy();
    return "redirect:/index1";
}
   
   
   
   
   
   
   
   
   
   @RequestMapping(value="/addStudyed")
   public String addStudyed(Todo studyedTodo) {
       todoMapper.addStudyed(studyedTodo);
       return "redirect:/index2";
   }
   
   @RequestMapping(value="/updateStudyed")
   public String updateStudyed(Todo studyedTodo) {
       todoMapper.updateStudyed(studyedTodo);
       return "redirect:/index2";
   } 
   
   
   @RequestMapping(value="/deleteStudyed")
public String deleteStudyed() {
    todoMapper.deleteStudyed();
    return "redirect:/index2";
}
   
   
   
   
}