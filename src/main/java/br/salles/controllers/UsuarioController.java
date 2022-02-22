package br.salles.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.salles.dao.UserDao;
import br.salles.model.Aluno;
import br.salles.model.usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UserDao UserRepo;

	@GetMapping("/")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("usuario", new usuario());
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	
	@GetMapping("/cadastro")
	public ModelAndView Cadastro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new usuario());
		mv.setViewName("Login/cadastro");
		return mv;
	}
		
	@PostMapping("/salvarUsuario")
	public ModelAndView cadastrar(usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserRepo.save(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(usuario useradm) {
		ModelAndView mv = new ModelAndView();
		usuario user = this.UserRepo.Logar(useradm.getUsername(), useradm.getSenha());
		if(user != null) {
			mv.setViewName("home/index");
		} else {
			mv.addObject("error", "Usuario ou senha invalida");
			mv.setViewName("Login/login");	
		}
		return mv;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return Login();
	}
	
}
