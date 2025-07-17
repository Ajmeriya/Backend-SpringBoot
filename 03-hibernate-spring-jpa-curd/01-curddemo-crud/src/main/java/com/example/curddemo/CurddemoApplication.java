package com.example.curddemo;

import com.example.curddemo.dao.StudentDAO;
import com.example.curddemo.entity.Student;
import org.hibernate.sql.Update;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static com.example.curddemo.dao.StudentDAO.*;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CurddemoApplication.class, args);

	}

		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner -> {

//				CreatStudent(studentDAO);
				CreatStudents(studentDAO);
//				readstudent(studentDAO);
//				queryForStudent(studentDAO);
//				update(studentDAO);
//				deleteStudent(studentDAO);

			};
		}

	private void deleteStudent(StudentDAO studentDAO)
	{
			int studentId = 6;
			System.out.println("Deleting student with id: " + studentId);
			studentDAO.delete(studentId);

	}

	private void update(StudentDAO studentDAO) {
		int studentId = 4;
		// retrieve student based on the id: primary key
		Student mystudent= studentDAO.ReadbyId(studentId);

		// change first name to "Tirth"
		mystudent.setFirstName("chutiya");
		// change last name to "Rabara"
		studentDAO.Update(mystudent);

		System.out.println("Updated student: " + mystudent);
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAll();

		for(Student tempstudent:students)
		{
			System.out.println(tempstudent);
		}

		//display the students
	}


	private void CreatStudents(StudentDAO studentDAO) {
			// create the student object
			System.out.println("creating 3 student object");
			Student student1 = new Student("Rohit", "Sharma", "@Tirth.com");
			Student student2=new Student("virat", "Kohli", "@King.com");
			Student student3=new Student("Ms", "Dhoni", "@6.com");
//
			studentDAO.save(student1);
			studentDAO.save(student2);
			studentDAO.save(student3);


		}

		private void readstudent(StudentDAO studentDAO) {

		//create a new student object
		Student tempStudent=new Student("RABARA", "TIRTH", "@Tirth.com");

		//save the student object
		studentDAO.save(tempStudent);

		//get id of the saved student
		int studentId = tempStudent.getId();

		//retrieve student based on the id: primary key
		Student temp=studentDAO.ReadbyId(studentId);

		//display the student
		System.out.println("Student: " + studentId + temp) ;


		}

	private void CreatStudent(StudentDAO studentDAO)
	{
		System.out.println("creating new student object");
		// create the student object
		System.out.println("creating new student object");
		Student student= new Student("RABARA", "TIRTH", "rabara@Tirth.com");

		//save the student object
		studentDAO.save(student);
		//display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}
