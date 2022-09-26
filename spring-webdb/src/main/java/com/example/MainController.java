package com.example;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private UserDao userDao;
	
	private String login_id;
	
	@GetMapping(value="/start")
	public String start(Model model) {
		return "start";
	}
	
	@RequestMapping("/user")
	public ModelAndView user(ModelAndView mav) 
	{
		mav.setViewName("user");
		return mav;
	}
	
	@RequestMapping("/manager")
	public ModelAndView manager(ModelAndView mav) 
	{
		mav.setViewName("manager");
		return mav;
	}
	
	@RequestMapping("/manager1")
	public String manager1(Model model) 
	{
		model.addAttribute("login_id", login_id);
		return "manager1";
	}
	
	@RequestMapping("/manager_ok")
	public String manager_ok(Model model,
			@RequestParam(value = "ID", required = false) String id,
			@RequestParam(value = "Pwd", required = false) String pwd) 
	{
		System.out.println("ID:"+id+" Pwd:"+pwd);
		
		List<Manager> managerList = managerDao.selectAll();
		System.out.println(managerList.size());
		
		for(int i = 0 ; i < managerList.size() ; i++)
		{
			System.out.println(managerList.get(i).getId());
			System.out.println(managerList.get(i).getPassword());
			if(id.equals(managerList.get(i).getId()) && pwd.equals(managerList.get(i).getPassword()))
			{
				login_id = id;
				model.addAttribute("login_id", login_id);
				return "manager1";
			}
		}
		
		//model.addAttribute("manager", managerList);
		return "login_error";
	}
	
	@RequestMapping("/add_manager")
	public ModelAndView add_manager(ModelAndView mav) 
	{
		mav.setViewName("add_manager");
		return mav;
	}
	
	@RequestMapping("/add_manager1")
	public ModelAndView add_manager1(ModelAndView mav,
			@RequestParam(value = "ID", required = false) String id,
			@RequestParam(value = "Pwd", required = false) String pwd) 
	{
		List<Manager> managerList = managerDao.selectAll();
		for(int i = 0 ; i < managerList.size() ; i++)
			if(id.equals(managerList.get(i).getId()))
			{
				mav.setViewName("add_manager_error");
				return mav;
			}
		Manager manager = new Manager(id,pwd);
		managerDao.insert(manager);
		mav.setViewName("add_manager1");
		return mav;
	}
	
	
	@RequestMapping("/book_update")
	public String book_update(Model model) 
	{
		List<Book> bookList = bookDao.selectAll();
		model.addAttribute("books", bookList);
		return "book_update";
	}
	
	@RequestMapping("/add_book")
	public String add_book(Model model) 
	{
		return "add_book";
	}
	
	@RequestMapping("/add_book_ok")
	public String add_book_ok(Model model,
			@RequestParam(value = "Number", required = false) String number,
			@RequestParam(value = "Name", required = false) String name) 
	{
		System.out.println(Long.parseLong(number)+name);
		List<Book> bookList = bookDao.selectAll();
		for(int i = 0 ; i < bookList.size() ; i++)
			if(Long.parseLong(number) == bookList.get(i).getNumber())
			{
				return "add_book_error";
			}
		Book book = new Book(Long.parseLong(number),name,"","");
		bookDao.insert(book);
		return "add_book1";
	}
	
	@RequestMapping("/add_book_error")
	public String add_book_error(Model model) 
	{
		return "add_book_error";
	}
	
	@RequestMapping("/add_book1")
	public String add_book1(Model model) 
	{
		return "add_book1";
	}
	
	@RequestMapping("/delete_book")
	public String delete_book(Model model) 
	{
		List<Book> bookList = bookDao.selectAll();
		model.addAttribute("books", bookList);
		return "delete_book";
	}
	
	@RequestMapping("/delete_book_ok")
	public String delete_book_ok(Model model,
			@RequestParam(value = "Number", required = false) String number) 
	{
		List<Book> bookList = bookDao.selectAll();
		for(int i = 0 ; i < bookList.size() ; i++)
			if(Long.parseLong(number) == bookList.get(i).getNumber())
			{
				bookDao.delete(number);
				return "add_book1";
				
			}
		return "add_book_error";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(ModelAndView mav) 
	{
		mav.setViewName("join");
		return mav;
	}
	
	@RequestMapping("/join1")
	public String join1(Model model,
			@RequestParam(value = "ID", required = false) String id,
			@RequestParam(value = "Pwd", required = false) String pwd,
			@RequestParam(value = "NAME", required = false) String name,
			@RequestParam(value = "PHONE", required = false) String phone,
			@RequestParam(value = "ADDRESS", required = false) String address) 
	{
		List<User> userList = userDao.selectAll();
		for(int i = 0 ; i < userList.size() ; i++)
			if(id.equals(userList.get(i).getId()))
			{
				return "join_error";
			}
		User user = new User(id,pwd,name,phone,address);
		userDao.insert(user);
		return "join_ok";
	}
	
	@RequestMapping("/join_ok")
	public ModelAndView join_ok(ModelAndView mav) 
	{
		mav.setViewName("join_ok");
		return mav;
	}
	@RequestMapping("/join_error")
	public ModelAndView join_error(ModelAndView mav) 
	{
		mav.setViewName("join_error");
		return mav;
	}
	@RequestMapping("/user_login")
	public ModelAndView user_login(ModelAndView mav) 
	{
		mav.setViewName("user_login");
		return mav;
	}
	@RequestMapping("/user_login_ok")
	public String user_login_ok(Model model) 
	{
		model.addAttribute("login_id",login_id);
		return "user_login_ok";
	}
	@RequestMapping("/user_login1")
	public String user_login1(Model model,
			@RequestParam(value = "ID", required = false) String id,
			@RequestParam(value = "Pwd", required = false) String pwd) 
	{
		List<User> userList = userDao.selectAll();
		
		for(int i = 0 ; i < userList.size() ; i++)
		{
			System.out.println(userList.get(i).getId());
			System.out.println(userList.get(i).getPwd());
			if(id.equals(userList.get(i).getId()) && pwd.equals(userList.get(i).getPwd()))
			{
				login_id = id;
				model.addAttribute("login_id", login_id);
				return "user_login_ok";
			}
		}
		return "login_error";
	}
	@RequestMapping("/user_info_change")
	public ModelAndView user_info_change(ModelAndView mav) 
	{
		mav.setViewName("user_info_change");
		return mav;
	}
	@RequestMapping("/user_info_change1")
	public String user_info_change1(Model model,
			@RequestParam(value = "Pwd", required = false) String pwd,
			@RequestParam(value = "NAME", required = false) String name,
			@RequestParam(value = "PHONE", required = false) String phone,
			@RequestParam(value = "ADDRESS", required = false) String address) 
	{
		User user = new User(login_id,pwd,name,phone,address);
		userDao.update(user);
		model.addAttribute("login_id", login_id);
		return "user_login_ok";
	}
	
	@RequestMapping("/book_rental")
	public String book_rental(Model model) 
	{
		List<Book> bookList = bookDao.selectAll();
		model.addAttribute("books", bookList);
		return "book_rental";
	}
	@RequestMapping("/book_rental1")
	public String book_rental1(Model model,
			@RequestParam(value = "Number", required = false) String number) 
	{
		List<Book> bookList = bookDao.selectAll();
		for(int i = 0 ; i < bookList.size() ; i++)
		{
			System.out.println();
			System.out.println(bookList.get(i).getNumber());
			System.out.println(number);
			if(bookList.get(i).getNumber() == Long.parseLong(number))
			{
				
				if(bookList.get(i).getBorrow().equals(""))
				{
					if(bookList.get(i).getReservation().equals(""))
					{
						bookDao.borrow(number, login_id);
						model.addAttribute("login_id", login_id);
						return "user_login_ok";
					}
					else if(bookList.get(i).getReservation().equals(login_id))
					{
						bookDao.reservation_to_borrow(number, login_id);
						model.addAttribute("login_id", login_id);
						return "user_login_ok";
					}

				}
			}
			
		}
		return "fail";
	}
	@RequestMapping("/fail")
	public ModelAndView fail(ModelAndView mav) 
	{
		mav.setViewName("fail");
		return mav;
	}
	@RequestMapping("/book_return")
	public String book_return(Model model) 
	{
		System.out.println(login_id);
		List<Book> bookList = bookDao.selectID(login_id);
		System.out.println(bookList.size());
		model.addAttribute("borrow_books", bookList);
		return "book_return";
	}
	@RequestMapping("/book_return1")
	public String book_return1(Model model,
			@RequestParam(value = "Number", required = false) String number) 
	{
		System.out.println(login_id);
		model.addAttribute("login_id", login_id);
		List<Book> bookList = bookDao.selectID(login_id);
		
		for(int i = 0 ; i < bookList.size() ; i++)
			if(bookList.get(i).getNumber() == Long.parseLong(number))
			{
				bookDao.borrow(number, "");
				return "user_login_ok";
			}
		return "fail";
	}
	
	@RequestMapping("/book_reservation")
	public String book_reservation(Model model) 
	{
		List<Book> bookList = bookDao.selectRE();
		model.addAttribute("reservation_books", bookList);
		return "book_reservation";
	}
	@RequestMapping("/book_reservation1")
	public String book_reservation(Model model,
			@RequestParam(value = "Number", required = false) String number) 
	{
		System.out.println(login_id);
		model.addAttribute("login_id", login_id);
		List<Book> bookList = bookDao.selectRE();
		
		for(int i = 0 ; i < bookList.size() ; i++)
			if(bookList.get(i).getNumber() == Long.parseLong(number))
			{
				bookDao.reservation(number, login_id);
				return "user_login_ok";
			}
		return "fail";
	}
	@RequestMapping("/book_search")
	public ModelAndView book_search(ModelAndView mav) 
	{
		mav.setViewName("book_search");
		return mav;
	}
	@RequestMapping("/book_search1")
	public String book_search1(Model model,
			@RequestParam(value = "NAME", required = false) String name) 
	{
		System.out.println(login_id);
		model.addAttribute("login_id", login_id);
		List<Book> bookList = bookDao.selectName(name);
		if (bookList.size() > 0)
		{
			model.addAttribute("search_books", bookList);
			return "book_search_ok";
		}
		return "fail";
	}
	@RequestMapping("/book_search_ok")
	public String book_search_ok(Model model) 
	{
		model.addAttribute("login_id", login_id);
		return "book_search_ok";
	}
	
	@RequestMapping("/quit")
	public ModelAndView quit(ModelAndView mav) 
	{
		mav.setViewName("quit");
		return mav;
	}
	
} 