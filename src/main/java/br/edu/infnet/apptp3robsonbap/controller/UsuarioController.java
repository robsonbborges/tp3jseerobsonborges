package br.edu.infnet.apptp3robsonbap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.apptp3robsonbap.model.negocio.Usuario;
import br.edu.infnet.apptp3robsonbap.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	public UsuarioService ServiceUsuario;

	@GetMapping(value={"", "/", "index"})
	public String apresentar(Model model){

		model.addAttribute("nome","Robson Baptista");
		model.addAttribute("email","robson.borges@al.infnet.edu.br");
		model.addAttribute("git","https://github.com/robsonrob");
		return "index";
	}

	@GetMapping(value = "/usuario")
	public String cadastrar(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obterLista());
		usuarioService.obterLista();
		return "usuario/detalhe";
	}
	
	@PostMapping( value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		
		usuarioService.incluir(usuario);
		
		System.out.println(usuario.getNome());
		
		return "redirect:/usuario";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);
		
		return "redirect:/usuario";
	}
}