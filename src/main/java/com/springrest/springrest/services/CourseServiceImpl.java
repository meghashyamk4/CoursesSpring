package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
//	List<Course> list;
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(10,"Megha","This is Megha's course"));
//		list.add(new Course(42,"Chandu","This is Chandu's course"));
//		list.add(new Course(1042,"MAggie & Chandu","This is Maggie and Chandu's course"));
	}
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
//		for(Course c:list) {
//			if(c.getId()==course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//			}
//		}
		courseDao.save(course);
		return course;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long courseId) {
		//list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Course course = courseDao.getOne(courseId);
		courseDao.delete(course);
	}

}
